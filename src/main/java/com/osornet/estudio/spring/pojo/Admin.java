package com.osornet.estudio.spring.pojo;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name ="admin")
public class Admin {

    @Id
    @GeneratedValue
    private int idAd;
    //@Column(name = "nombre")
    private String nombre;
    private String cargo;
    private Timestamp fechaCreacion;
    @OneToMany(mappedBy="admin")
    private Set<Direccion> direcciones;

    public Admin(){}

    public Admin(int idAd, String nombre, String cargo, Timestamp fechaCreacion){
        this.idAd = idAd;
        this.nombre = nombre;
        this.cargo = cargo;
        this.fechaCreacion = fechaCreacion;
    }
    public Admin(String nombre, String cargo, Timestamp fechaCreacion){
        this.nombre = nombre;
        this.cargo = cargo;
        this.fechaCreacion = fechaCreacion;
    }
    
    //GETTERS
    /**
     * @return the idAd
     */
    public int getIdAd() {
        return idAd;
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }
    /**
     * @return the fechaCreacion
     */
    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }
    //SETTERS
    /**
     * @param idAd the idAd to set
     */
    public void setIdAd(int idAd) {
        this.idAd = idAd;
    }
    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    /**
     * @return the direcciones
     */
    public Set<Direccion> getDirecciones() {
        return direcciones;
    }
    /**
     * @param direcciones the direcciones to set
     */
    public void setDirecciones(Set<Direccion> direcciones) {
        this.direcciones = direcciones;
    }
    @Override
    public String toString() {
        return "Admin[idAd= "+this.idAd+", nombre= "+this.nombre+", cargo= "+this.cargo+", fechaCreacion= "+this.fechaCreacion.toString()+"]";
    }
}