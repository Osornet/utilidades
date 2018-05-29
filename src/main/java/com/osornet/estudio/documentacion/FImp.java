package com.osornet.estudio.documentacion;

import java.util.List;



/**
 * Fimp
 */
public class FImp implements F{

    private String cadena;
    private int entero;
    private float flotante;
    private B b;
    private List<Integer> listaDeEnteros;
    private List<A> listaDeA;
    private String valorNulo;

    public void metodoF() {
        System.out.println("estas son las depencias de F: "+this.cadena+", "+this.entero+", "+this.flotante);
        System.out.println("+++++++++EJECUCION DEL METODO B+++++++++++++");
        this.b.metodoB();
        System.out.println("+++++++++LISTA DE ENTEROS+++++++++++++");
        for(int entero : this.listaDeEnteros)
            System.out.println("el entero es: "+entero);
        System.out.println("+++++++++METODOS DE LAS CLASES DE A+++++++++++++");
        for(A aux : this.listaDeA){
            aux.metodoA();
        }
        if(this.valorNulo == null)
            System.out.println("es nulo ... puto");
            
    }
    /**
     * @param cadena the cadena to set
     */
    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    /**
     * @param entero the entero to set
     */
    public void setEntero(int entero) {
        this.entero = entero;
    }
    /**
     * @param flotante the flotante to set
     */
    public void setFlotante(float flotante) {
        this.flotante = flotante;
    }
    /**
     * @param b the b to set
     */
    public void setB(B b) {
        this.b = b;
    }
    /**
     * @param listaDeEnteros the listaDeEnteros to set
     */
    public void setListaDeEnteros(List<Integer> listaDeEnteros) {
        this.listaDeEnteros = listaDeEnteros;
    }
    /**
     * @param listaDeA the listaDeA to set
     */
    public void setListaDeA(List<A> listaDeA) {
        this.listaDeA = listaDeA;
    }
    /**
     * @param valorNulo the valorNulo to set
     */
    public void setValorNulo(String valorNulo) {
        this.valorNulo = valorNulo;
    }

}