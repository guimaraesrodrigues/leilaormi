/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.rmi.RemoteException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
    
}
