package cliente;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;
import rmi.InterfaceCli;
import rmi.InterfaceServ;

public class CliImpl extends UnicastRemoteObject  implements InterfaceCli{

    InterfaceServ server;    
    private String nome_usuario;//um nome de usuario para identificar o cliente
    
    //construtor recebe a referencia de objeto remoto
    public CliImpl(InterfaceServ server) throws RemoteException
    {   
        this.server = server;        
    }
    
    public void echo(String s) throws RemoteException{
        System.out.println("Cliente recebeu: "+s);
        
    }
    /**
     * Getter and setter para o nome do usuario
     **/
    public void setNome_usuario(String nome)throws RemoteException{
        this.nome_usuario = nome;
    }    
    
     public String getNome_usuario()throws RemoteException{
        return nome_usuario;
    }
    
     /**
      * metodo remoto que notifica o cliente sobre o encerramento do leilao
      **/
    public void leilaoEncerrado(String mensagem, String nome_produto) throws RemoteException{
        
        Thread t = new Thread(new Runnable(){
        public void run(){
            JOptionPane.showMessageDialog(null, mensagem, "Leilão do produo "+nome_produto + " encerrado!", JOptionPane.INFORMATION_MESSAGE);
        }
        });
        t.start();        
    }
    /**
     * método remoto para notificar o cliente sobre um novo lance em um produto que ele esta interessado
     **/
    public void novoLance(String mensagem, String nome_produto) throws RemoteException{
        System.out.println("msg: " + mensagem);
   
        Thread t = new Thread(new Runnable(){
        public void run(){
            JOptionPane.showMessageDialog(null, mensagem, "Novo lance para o produto "+nome_produto, JOptionPane.INFORMATION_MESSAGE);
        }
        });
        t.start();        
    }
    
}
