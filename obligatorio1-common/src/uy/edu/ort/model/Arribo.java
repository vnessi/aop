package uy.edu.ort.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Bruno Montanter - Victor Nessi Victor Nessi - Bruno Montaner
 */
@Table(name="Arribo")
@Entity
public class Arribo extends EntidadPersistente {
    
    @Column
    private String origen;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column
    private String descripcion;
    @OneToOne(cascade = CascadeType.ALL)
    private Barco barco;
    
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Contenedor> contenedores;

    /**
     * Get the value of contenedores
     *
     * @return the value of contenedores
     */
    public List getContenedores() {
        return contenedores;
    }

    /**
     * Set the value of contenedores
     *
     * @param contenedores new value of contenedores
     */
    public void setContenedores(List contenedores) {
        this.contenedores = contenedores;
    }


    /**
     * Get the value of barco
     *
     * @return the value of barco
     */
    public Barco getBarco() {
        return barco;
    }

    /**
     * Set the value of barco
     *
     * @param barco new value of barco
     */
    public void setBarco(Barco barco) {
        this.barco = barco;
    }


    /**
     * Get the value of descripcion
     *
     * @return the value of descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Set the value of descripcion
     *
     * @param descripcion new value of descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

    /**
     * Get the value of fecha
     *
     * @return the value of fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Set the value of fecha
     *
     * @param fecha new value of fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    /**
     * Get the value of origen
     *
     * @return the value of origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * Set the value of origen
     *
     * @param origen new value of origen
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

}
