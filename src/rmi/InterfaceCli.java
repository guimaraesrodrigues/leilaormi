/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author a1441990
 */
public interface InterfaceCli extends Remote{
    public void echo(String s) throws RemoteException;
    public void setNome_usuario(String nome) throws RemoteException;
    public String getNome_usuario() throws RemoteException;
}
