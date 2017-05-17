/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;
import servidor.Leilao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.InterfaceCli;
import rmi.InterfaceServ;

public class ServImpl extends UnicastRemoteObject  implements InterfaceServ{
    
    public ArrayList<Leilao> lista_leiloes;//lista para guardar os leiloes dos clientes
    private int contador_leiloes;//contador utilizado para gerar codigo do produto
    public static Object lock;
    
    //O construtor instancia a lista de leiloes e inicializa o contador
    public ServImpl() throws RemoteException {
        this.lista_leiloes = new ArrayList<Leilao>();
        this.contador_leiloes = 0;
    }
    
    public void chamar(String nome, InterfaceCli cliente) throws RemoteException  {
        cliente.echo(nome+" (serv)");
    }
    
    /**
     * Esse metodo recebe os dados do leilao, insere na lista de leiloes
     * e inicializa o temporizador com o tempo de duracao para o leilao
     **/
    public void cadastrarLeilao(String nome_produto, String descricao, float preco, int tempo, InterfaceCli cliente) throws RemoteException {
        
        //chamamos um metodo remoto para obter o nome do usuario
        // e criamos o codigo do produto de acordo com o nome do usuario e contador de leiloes
        String cod_produto = (cliente.getNome_usuario().substring(0, 3) + "_"  + contador_leiloes);
        Leilao novo_leilao = new Leilao(cod_produto, nome_produto, descricao, preco, tempo, cliente);
        this.lista_leiloes.add(novo_leilao);
        contador_leiloes++;//incrementamos o contador para o proximo codigo de produto que venha a ser criado
        this.temporizador(cod_produto, tempo);//invocamos o metodo que inicia a thread do temporizador
    }
    
    //Metodo simples para retornar a lista de leiloes do sistema
    public ArrayList<Leilao> leiloes_ativos() throws RemoteException {
         return this.lista_leiloes;
    }
    
    /**
     * Este metodo registra o lance de um cliente em lista de lances presentes em cada objeto Leilao
     * As infos registradas sao o codigo do produto, valor do lance, e referencia do cliente que enviou o lance
     **/
    public synchronized String registarLance(String codigo, float valor, InterfaceCli cliente) throws RemoteException{
        Lance novo_lance;        
       
        //buscamos pelo leilao de acordo com o codigo do produto
        for (Leilao l : lista_leiloes){
            if(l.getCodigo().equals(codigo)){
                //se o leilao nao foi encerrado retornamos uma mensagem para o cliente
                if(l.getTempofinal() == 0)
                    return "Lance não adicionado. O Leilão já foi encerrado!";
                //se o lance é menor do que o permitido retornamos uma mensagem para o cliente
                else if(l.getValor() >= valor)
                    return "Lance não adicionado. Valor do lance menor do que o permitido!";
                
                novo_lance = new Lance(cliente, valor);
                l.lances.add(novo_lance);//adicionamos o novo lance na lista de lance do leilao corrente
                l.setValor(valor);
                
                //percorremos a lista de lances e invocamos de todos os clientes registrados
                //um metodo para notificar sobre o novo lance que foi registrado
                for (Lance lance : l.lances){
                    //if(!lance.equals(novo_lance))                       
                        lance.getCliente().novoLance("Valor do lance: " + l.getValor(), l.getNome());
                }
                return "Lance adicionado com sucesso!";//retornamos uma mensagem de sucesso
            }
       }
        return "Leilao não encontrado :(";
    }
    /** 
     Este método cancela o leilao de acordo com o seu codigo
     percorrendo todos os lances dados pelos usuarios e notificando todos sobre o encerramento
     **/
    public void cancelarLeilao(String codigo) throws RemoteException{
        for (Leilao l : lista_leiloes){
            if(l.getCodigo().equals(codigo)){
                l.setTempofinal(0);//setamos o tempo do leilao para zero para indicar que o leilao encerrou
                for (Lance lance : l.lances){                                        
                    lance.getCliente().leilaoEncerrado("\nUsuario vencedor: " + l.lances.get(l.lances.size()-1).getUsuario() +
                                                       "\nValor: "+ l.lances.get(l.lances.size()-1).getLance(), l.getNome());
                    //lista_leiloes.remove(l);                                      
                }
                return;
            }
        }
    }
    //esse método cria uma thread para executar o cancelemento de um leilao de acordo com o seu tempo de duração
    private void temporizador(String codigo, int tempo){
        new java.util.Timer().schedule( 
        new java.util.TimerTask() {
            @Override
            public void run() {
                try {
                    System.out.println("ESGOTOU O TEMPO! " + codigo);
                    for(Leilao l : lista_leiloes)//buscamos pelo leilao na lista de leiloes
                        if(l.getCodigo().equals(codigo) && l.getTempofinal() != 0)//se ele nao foi cancelado pelo usuario, invocamos o metodo cancerlarLeilao
                            cancelarLeilao(codigo);                    
                } catch (RemoteException ex) {
                    Logger.getLogger(ServImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }, 
        tempo*1000 //multiplcamos por 1000 pois a entrada é em segundos e a contagem ocorre em milisegundos
        );
    }
    /**
     * Método para listar lances de um usuário em um leilao selecionado
     **/
    public ArrayList<Lance> listarLances(String usuario, String cod_prod) throws RemoteException{
        ArrayList<Lance> lista_lances = new ArrayList<Lance>();
        
        for (Leilao leilao : this.lista_leiloes){
            if(leilao.getCodigo().equals(cod_prod))//se o leilao é o requerido pelo cliente
                for(Lance lance : leilao.lances)
                    lista_lances.add(lance);//adicionamos o lance na lista que sera retornada            
        }
        
        return lista_lances;
    }
    
}
