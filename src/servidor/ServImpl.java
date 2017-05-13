/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import rmi.InterfaceCli;
import rmi.InterfaceServ;

public class ServImpl extends UnicastRemoteObject  implements InterfaceServ{
    
    public ArrayList<Leilao> lista_leiloes;
    
    public ServImpl() throws RemoteException {
        this.lista_leiloes = new ArrayList<Leilao>();
    }
    
    public void chamar(String nome, InterfaceCli cliente) throws RemoteException  {
        cliente.echo(nome+" (serv)");
    }

    public void cadastrarLeilao(String cod_produto, String nome_produto, String descricao, float preco, float tempo, InterfaceCli cliente) throws RemoteException {
        
        Leilao novo_leilao = new Leilao(cod_produto, nome_produto, descricao, preco, tempo, cliente);
        this.lista_leiloes.add(novo_leilao); 
        
        for(Leilao l : lista_leiloes){
            System.out.println("nome_prod: "+ l.getNome());
            System.out.println("preco: "+ l.getValor());
        }
        
    }
    /*
    public ArrayList<Leilao> leiloes_ativos() {
         return this.lista_leiloes;
    }*/
    
}
