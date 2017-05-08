/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CliImpl extends UnicastRemoteObject  implements InterfaceCli{

    InterfaceServ server;
    
    public CliImpl(InterfaceServ server) throws RemoteException
    {
        this.server = server;
        server.chamar("cli hello", this);
    }
    
    public void echo(String s) throws RemoteException{
        System.out.println("Cliente recebeu: "+s);
        
    }
    
}
