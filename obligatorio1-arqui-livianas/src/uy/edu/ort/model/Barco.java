package uy.edu.ort.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Victor Nessi - Bruno Montaner
 */
@Entity
public class Barco extends EntidadPersistente{
    
    @Column
    private String codigo;
    @Column
    private String nombre;
    @Column
    private String bandera;
    @Column
    private int capacidadTransporte;
    @Column
    private int anioFabricacion;
    @Column
    private int cantidadTripulantes;

    public Barco() {
    }

    public Barco(String codigo, String nombre, String bandera, int capacidadTransporte, int anioFabricacion, int cantidadTripulantes) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.bandera = bandera;
        this.capacidadTransporte = capacidadTransporte;
        this.anioFabricacion = anioFabricacion;
        this.cantidadTripulantes = cantidadTripulantes;
    }

    
    
    /**
     * Get the value of cantidadTripulantes
     *
     * @return the value of cantidadTripulantes
     */
    public int getCantidadTripulantes() {
        return cantidadTripulantes;
    }

    /**
     * Set the value of cantidadTripulantes
     *
     * @param cantidadTripulantes new value of cantidadTripulantes
     */
    public void setCantidadTripulantes(int cantidadTripulantes) {
        this.cantidadTripulantes = cantidadTripulantes;
    }


    /**
     * Get the value of anioFabricacion
     *
     * @return the value of anioFabricacion
     */
    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    /**
     * Set the value of anioFabricacion
     *
     * @param anioFabricacion new value of anioFabricacion
     */
    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    

    /**
     * Get the value of capacidadTransporte
     *
     * @return the value of capacidadTransporte
     */
    public int getCapacidadTransporte() {
        return capacidadTransporte;
    }

    /**
     * Set the value of capacidadTransporte
     *
     * @param capacidadTransporte new value of capacidadTransporte
     */
    public void setCapacidadTransporte(int capacidadTransporte) {
        this.capacidadTransporte = capacidadTransporte;
    }


    /**
     * Get the value of bandera
     *
     * @return the value of bandera
     */
    public String getBandera() {
        return bandera;
    }

    /**
     * Set the value of bandera
     *
     * @param bandera new value of bandera
     */
    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
