package servidor;


import java.io.Serializable;
import java.util.ArrayList;
import rmi.InterfaceCli;


public class Leilao implements Serializable{
    private String codigo;
    private String nome_prod;
    private String descricao;    
    private float preco;
    private float tempofinal;
    private InterfaceCli cliente;
    //private boolean ativo; sera que precisa dessa flag?
    //private ArrayList<Lance> lances; sera que precisamos de uma lista de lances para esse leilao??
    
    public Leilao(String codigo, String nome_prod, String descr, float preco, float tempofinal, InterfaceCli cliente){
        this.codigo = codigo;
        this.nome_prod = nome_prod;
        this.descricao = descr;
        this.preco = preco;
        this.tempofinal= tempofinal;
        this.cliente = cliente;
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
}