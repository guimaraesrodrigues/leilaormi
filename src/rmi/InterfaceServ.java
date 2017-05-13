/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import servidor.Leilao;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface InterfaceServ extends Remote  {
    public void chamar(String nome, InterfaceCli cliente)throws RemoteException;
    public void cadastrarLeilao(String cod_produto, String nome_produto, String descricao, float preco, float tempo, InterfaceCli cliente) throws RemoteException;
    public ArrayList<Leilao> leiloes_ativos() throws RemoteException;
}
