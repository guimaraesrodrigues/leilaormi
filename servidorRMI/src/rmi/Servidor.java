/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Servidor {
    public static void main(String[] args) {
        try {
            Registry referenciaServicoNomes = LocateRegistry.createRegistry(1099);
            referenciaServicoNomes.bind("Servidor", new ServImpl());
            System.out.println("Server Ready!");
            while(true)
            {
            
            }
        } catch (Exception ex) {
            System.out.println("Hello World Server main: ");
            ex.printStackTrace();
        }
    }
}
