/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author rodrigo
 */
public class MainServidor {
    public static void main(String[] args) {        
        try {
            ServImpl servImpl = new ServImpl();
            Registry referenciaServicoNomes = LocateRegistry.createRegistry(1099);
            referenciaServicoNomes.bind("Servidor", servImpl);
            new TelaServidor(servImpl);
            System.out.println("Server Ready!");
            
        } catch (Exception ex) {
            System.out.println("Hello World Server main: ");
            ex.printStackTrace();
        }                
    }
}
