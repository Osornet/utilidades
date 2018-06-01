package com.osornet.estudio.spring.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



/**
 * Direccion
 */
@Entity
@Table(name="direccion")
public class Direccion {
    @Id
    @GeneratedValue
    private int idDir;  
    private String calle;
    private String cp;
    @ManyToOne
    @JoinColumn(name="idAd")
    private Admin admin;

    public Direccion(){}

    public Direccion(String calle, String cp){
        this.calle = calle;
        this.cp = cp;
    }
    /**
     * @return the idDir
     */
    public int getIdDir() {
        return idDir;
    }
    /**
     * @param idDir the idDir to set
     */
    public void setIdDir(int idDir) {
        this.idDir = idDir;
    }
    /**
     * @return the calle
     */
    public String getCalle() {
        return calle;
    }
    /**
     * @param calle the calle to set
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }
    /**
     * @return the cp
     */
    public String getCp() {
        return cp;
    }
    /**
     * @param cp the cp to set
     */
    public void setCp(String cp) {
        this.cp = cp;
    }

    /**
     * @return the admin
     */
    public Admin getAdmin() {
        return admin;
    }
    /**
     * @param admin the admin to set
     */
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    @Override
    public String toString() {
        return "Direccion=[idDir="+this.idDir+", calle="+this.calle+", cp="+this.cp+"]";
    }
   
}