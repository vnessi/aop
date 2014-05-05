package uy.edu.ort.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Victor Nessi - Bruno Montaner
 */
public class Arribo {
    
    private String origen;
    private Date fecha;
    private String descripcion;
    private Barco barco;
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
