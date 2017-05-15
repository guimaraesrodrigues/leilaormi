/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.awt.Frame;
import java.rmi.RemoteException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import rmi.InterfaceCli;
import rmi.InterfaceServ;

public class CliImpl extends UnicastRemoteObject  implements InterfaceCli{

    InterfaceServ server;    
    private String nome_usuario;   
    
    public CliImpl(InterfaceServ server) throws RemoteException
    {   
        this.server = server;
        server.chamar("cli hello", this);
    }
    
    public void echo(String s) throws RemoteException{
        System.out.println("Cliente recebeu: "+s);
        
    }
    
    public void setNome_usuario(String nome)throws RemoteException{
        this.nome_usuario = nome;
    }    
    
     public String getNome_usuario()throws RemoteException{
        return nome_usuario;
    }
    
    public void leilaoEncerrado(String mensagem, String nome_produto) throws RemoteException{
        System.out.println("msg: " + mensagem);
        //JOptionPane dialog = new JOptionPane(mensagem,  JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION );
        //JOptionPane.showMessageDialog(null, mensagem, "Leilão encerrado!", JOptionPane.INFORMATION_MESSAGE);
        //JDialog dialog = new JDialog(new Frame() , "Leilão encerrado!", true);
        //dialog.setTitle();
        //dialog.setVisible(true);
         Thread t = new Thread(new Runnable(){
        public void run(){
            JOptionPane.showMessageDialog(null, mensagem, "Leilão do produo "+nome_produto + " encerrado!", JOptionPane.INFORMATION_MESSAGE);
        }
        });
        t.start();
        
    }
}
