package com.osornet.estudio.spring.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Direccion
 */
@Component
public class Direccion {

   
    //@Value("Encino") //puede utilizarse solo el @value
    private String calle;
    //@Value("99999")    
    private String cp;

    public Direccion(){}

    public Direccion(String calle, String cp){
        this.calle = calle;
        this.cp = cp;
    }
    @Override
    public String toString() {
        return "Direccion [ calle= "+this.calle+", cp= "+this.cp+" ]";
    }
    /**
     * @param calle the calle to set
     */
    //@Inject //tambien podemos usar @Inject en vez de @Autowired
    @Autowired
    public void setCalle(@Value("Encino") String calle) {
        this.calle = calle;
    }
    /**
     * @param cp the cp to set
     */
    @Autowired
    public void setCp(@Value("400") String cp) {
        this.cp = cp;
    }
}