package com.osornet.estudio.documentacion;

import java.beans.ConstructorProperties;

public class CImp implements C{

    private A a;
    private B b;
    private int entero;
    private String cadena;
    private float flotante;
    private AImpv2 av2;
 
    /* Si ud no quiere que se compile su codigo con la bandera de debug ( que lo hace srping por defecto 
    para ver el nombre de los parametros de su constructor) puede usar la etiqueta @ConstructorProperties
    como se muestra a continuación*/

    @ConstructorProperties({"a","b","entero","cadena","flot1", "flot2", "av2", "flot3"})
    public CImp(A a, B b, int entero, String cadena, float flot1, float flot2, AImpv2 av2, float flot3){ 
        this.a = a;
        this.b = b;
        this.entero = entero;
        this.cadena = cadena;
        this.flotante = flot1 * flot2 * flot3;
        this.av2 = av2;
    }
    public void metodoC() {
        System.out.println("Metodo C");
        System.out.println(this.entero); 
        System.out.println(this.cadena); 
        System.out.println(this.flotante);
    }
    /**
     * @return the a
     */
    public A getA() {
        return a;
    }
    /**
     * @return the b
     */
    public B getB() {
        return b;
    }
    /**
     * @return the entero
     */
    public int getEntero() {
        return entero;
    }
    /**
     * @return the cadena
     */
    public String getCadena() {
        return cadena;
    }
    /**
     * @return the av2
     */
    public AImpv2 getAv2() {
        return av2;
    }
    /**
     * @param entero the entero to set
     */
    public void setEntero(int entero) {
        this.entero = entero;
    }
}