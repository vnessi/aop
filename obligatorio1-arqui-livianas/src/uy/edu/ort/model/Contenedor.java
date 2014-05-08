package uy.edu.ort.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Victor Nessi - Bruno Montaner
 */
@Entity
public class Contenedor extends EntidadPersistente {
    
    @Column
    private String codigo;
    @Column
    private String marca;
    @Column
    private String modelo;
    @Column
    private int capacidad;

    public Contenedor() {
    }

    public Contenedor(String codigo, String marca, String modelo, int capacidad) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }
    
    /**
     * Capacidad en Kg.
     *
     * @return the value of capacidad
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Set the value of capacidad
     *
     * @param capacidad new value of capacidad
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }


    /**
     * Get the value of modelo
     *
     * @return the value of modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Set the value of modelo
     *
     * @param modelo new value of modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    /**
     * Get the value of marca
     *
     * @return the value of marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Set the value of marca
     *
     * @param marca new value of marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }


    /**
     * Get the value of codigo
     *
     * @return the value of codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Set the value of codigo
     *
     * @param codigo new value of codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
}
