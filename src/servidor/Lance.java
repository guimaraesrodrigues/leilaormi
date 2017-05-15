package servidor;

import java.io.Serializable;
import rmi.InterfaceCli;

public class Lance implements Serializable{

    private InterfaceCli cliente;
    private final float lance;
    
    public Lance(InterfaceCli cliente, float lance) {
        this.cliente = cliente;
        this.lance = lance;
    }
    
    public InterfaceCli getUsuario() {
        return cliente;
    }

    public float getLance() {
        return lance;
    }
}
