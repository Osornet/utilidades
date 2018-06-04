package com.osornet.estudio.spring.pojo;


import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Usuario
 */
@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue
    private int idUsr;
    private String usuario;
    private String clave;
    private String permiso;
    private Timestamp fechaCreacion;
    

    /**
     * @return the idUsr
     */
    public int getIdUsr() {
        return idUsr;
    }
    /**
     * @param idUsr the idUsr to set
     */
    public void setIdUsr(int idUsr) {
        this.idUsr = idUsr;
    }
    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }
    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }
    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
    /**
     * @return the permiso
     */
    public String getPermiso() {
        return permiso;
    }
    /**
     * @param permiso the permiso to set
     */
    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }
    /**
     * @return the fechaCreacion
     */
    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }
    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}