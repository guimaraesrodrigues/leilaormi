package servidor;


import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.InterfaceCli;


public class Leilao implements Serializable{
    private String codigo;
    private String nome_prod;
    private String descricao;    
    private float preco;
    private float tempofinal;
    private InterfaceCli cliente;

    private String nome_usuario;
    //private boolean ativo; sera que precisa dessa flag?
    public ArrayList<Lance> lances;
    
    public Leilao(String codigo, String nome_prod, String descr, float preco, float tempofinal, InterfaceCli cliente){
        this.codigo = codigo;
        this.nome_prod = nome_prod;
        this.descricao = descr;
        this.preco = preco;
        this.tempofinal= tempofinal;
        this.cliente = cliente;
        try {
            this.nome_usuario = cliente.getNome_usuario();
        } catch (RemoteException ex) {
            Logger.getLogger(Leilao.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.lances = new ArrayList<Lance>();
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome_prod;
    }

    public void setNome(String nome) {
        this.nome_prod = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return preco;
    }

    public void setValor(float precoin) {
        this.preco = precoin;
    }

    public float getTempofinal() {
        return tempofinal;
    }

    public void setTempofinal(float tempofinal) {
        this.tempofinal = tempofinal;
    }
    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }
}