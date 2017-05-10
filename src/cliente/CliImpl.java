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

    
    String nome;    
    public CliImpl(InterfaceServ server) throws RemoteException
    {
        server.chamar("cli hello", this);
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void echo(String s) throws RemoteException{
        System.out.println("Cliente recebeu: "+s);
        
    }
    
}
