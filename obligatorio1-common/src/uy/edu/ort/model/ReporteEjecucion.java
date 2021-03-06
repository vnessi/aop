package uy.edu.ort.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 */
@Entity
public class ReporteEjecucion extends EntidadPersistente implements Serializable{
    
    @Column
    private String servicio;
    
    @Column
    private long tiempo;
    
    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
    
     public long getTiempo() {
        return tiempo;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }
}
