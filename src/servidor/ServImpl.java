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
    
    public ArrayList<Leilao> lista_leiloes;
    private int contador_leiloes;
    
    public ServImpl() throws RemoteException {
        this.lista_leiloes = new ArrayList<Leilao>();
        this.contador_leiloes = 0;
    }
    
    public void chamar(String nome, InterfaceCli cliente) throws RemoteException  {
        cliente.echo(nome+" (serv)");
    }

    public void cadastrarLeilao(String nome_produto, String descricao, float preco, int tempo, InterfaceCli cliente) throws RemoteException {
        
        String cod_produto = (cliente.getNome_usuario().substring(0, 3) + "_"  + contador_leiloes);
        Leilao novo_leilao = new Leilao(cod_produto, nome_produto, descricao, preco, tempo, cliente);
        this.lista_leiloes.add(novo_leilao);
        contador_leiloes++;
        this.temporizador(cod_produto, tempo);
    }

    public ArrayList<Leilao> leiloes_ativos() throws RemoteException {
         return this.lista_leiloes;
    }
    
    public String registarLance(String codigo, float valor, InterfaceCli cliente) throws RemoteException{
        Lance lance;
        
        
        for (Leilao l : lista_leiloes){
            if(l.getCodigo().equals(codigo)){
                
                if(l.getTempofinal() == 0)
                    return "Lance não adicionado. O Leilão já foi encerrado!";
                else if(l.getValor() >= valor)
                    return "Lance não adicionado. Valor do lance menor do que o permitido!";
                
                lance = new Lance(cliente, valor);
                l.lances.add(lance);
                l.setValor(valor);
                return "Lance adicionado com sucesso!";
            }
        }
        return "";
    }
        
    public void cancelarLeilao(String codigo) throws RemoteException{
        for (Leilao l : lista_leiloes){
            if(l.getCodigo().equals(codigo)){
                for (Lance lance : l.lances){
                    lance.getUsuario();
                    l.setTempofinal(0);
                    lance.getCliente().leilaoEncerrado("\nUsuario vencedor: " + l.lances.get(l.lances.size()-1).getUsuario() +
                                                       "\nValor: "+ l.lances.get(l.lances.size()-1).getLance(), l.getNome());
                    //lista_leiloes.remove(l);
                    return;                   
                }                
            }
        }
    }
    private void temporizador(String codigo, int tempo){
        new java.util.Timer().schedule( 
        new java.util.TimerTask() {
            @Override
            public void run() {
                try {
                    cancelarLeilao(codigo);
                    System.out.println("ESGOTOU O TEMPO! " + codigo);
                } catch (RemoteException ex) {
                    Logger.getLogger(ServImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }, 
        tempo*1000 
        );
    }
    
}
