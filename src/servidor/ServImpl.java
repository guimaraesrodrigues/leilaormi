/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmi.InterfaceCli;

public class ServImpl extends UnicastRemoteObject  implements InterfaceServ{

    public ServImpl() throws RemoteException {}
    
    public void chamar(String nome, InterfaceCli cliente) throws RemoteException  {
        cliente.echo(nome+" (serv)");
    }
    
}
