package com.osornet.estudio.documentacion;



/**
 * EImp
 */
public class EImp implements E{

    private String mensajeMetodoE;
    private B b;
    private EImp(String mensajeMetodoE, B b){
        
        this.mensajeMetodoE = mensajeMetodoE;
        this.b = b;
       
    }

    public static E getInstance(String mensajeMetodoE, B b) {
        return new EImp(mensajeMetodoE, b);
    }
    

    public void metodoE() {
        System.out.println(this.mensajeMetodoE);
    }
    
    /**
     * @return the b
     */
    public B getB() {
        return b;
    }
    /**
     * @param b the b to set
     */
    public void setB(B b) {
        this.b = b;
    }
}