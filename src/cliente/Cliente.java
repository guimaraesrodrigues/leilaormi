/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.InterfaceCli;
import rmi.InterfaceServ;

/**
 *
 * @author a1441990
 */
public class Cliente {
    public static void main(String[] args) {
        try{
            Registry referenciaServicoNomes = LocateRegistry.getRegistry("localhost", 1099);
            InterfaceServ server = (InterfaceServ) referenciaServicoNomes.lookup("Servidor");
            InterfaceCli client = new CliImpl(server);
            //client.echo("echo - cliente");
            //server.chamar("chamar - cliente", client);
            TelaLogin login = new TelaLogin(server,client);
            //new TelaNovoProduto(server, client);

        }
        catch (Exception ex) {
            System.out.println("Cliente main:");
            ex.printStackTrace();
        }
        
    }
}
