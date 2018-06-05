package com.osornet.estudio.spring.pojo;


import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Size;

import com.osornet.estudio.spring.pojo.valid.PersistenceGroup;
import com.osornet.estudio.spring.pojo.valid.SpringFormGroup;

import org.hibernate.validator.constraints.NotEmpty;




/**
 * Usuario
 */
@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue
    private int idUsr;
    @NotEmpty(message=Constants.NOT_EMPTY,groups={PersistenceGroup.class, SpringFormGroup.class})
    private String usuario;
    @NotEmpty(message=Constants.NOT_EMPTY,groups={PersistenceGroup.class, SpringFormGroup.class})
    @Size(min=3, max=8, message=Constants.SIZE, groups={SpringFormGroup.class})
    private String clave;
    @NotEmpty(message=Constants.NOT_EMPTY,groups={PersistenceGroup.class, SpringFormGroup.class})
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
        return "Usuario=[idUsr="+this.idUsr+",usuario="+this.usuario+",clave="+this.clave+",permiso="+this.permiso+",fechaCreacion="+this.fechaCreacion.toString()+"]";
    }
}