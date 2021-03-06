/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import servidor.Lance;
import servidor.Leilao;


public interface InterfaceServ extends Remote  {

    /**
     *
     */
    public Object lock= new Object();
    
    public void chamar(String nome, InterfaceCli cliente)throws RemoteException;
    public void cadastrarLeilao(String nome_produto, String descricao, float preco, int tempo, InterfaceCli cliente) throws RemoteException;
    public ArrayList<Leilao> leiloes_ativos() throws RemoteException;
    public String registarLance(String codigo, float valor, InterfaceCli cliente) throws RemoteException;
    public void cancelarLeilao(String codigo) throws RemoteException;
    public ArrayList<Lance> listarLances(String usuario, String cod_prod) throws RemoteException;
}
