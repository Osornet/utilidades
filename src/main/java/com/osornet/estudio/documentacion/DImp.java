package com.osornet.estudio.documentacion;

/**
 * DImp
 */
public class DImp implements D{
    private A a;
    private String mensajeDeMetodo;

    public void metodoD() {
        System.out.println(this.mensajeDeMetodo);
    }

    /**
     * @param a the a to set
     */
    public void setA(A a) {
        this.a = a;
    }
    /**
     * @return the a
     */
    public A getA() {
        return a;
    }
    /**
     * @param mensajeDeMetodo the mensajeDeMetodo to set
     */
    public void setMensajeDeMetodo(String mensajeDeMetodo) {
        this.mensajeDeMetodo = mensajeDeMetodo;
    }
}