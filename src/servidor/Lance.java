package servidor;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.InterfaceCli;

public class Lance implements Serializable{

    private InterfaceCli cliente;
    private final float lance;
    private String usuario;
    
    public Lance(InterfaceCli cliente, float lance) {
        this.cliente = cliente;
        this.lance = lance;
        try {
            this.usuario = cliente.getNome_usuario();
        } catch (RemoteException ex) {
            Logger.getLogger(Lance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public InterfaceCli getCliente() {
        return cliente;
    }

    public float getLance() {
        return lance;
    }
    
     public String getUsuario() {
        return usuario;
    }
}
