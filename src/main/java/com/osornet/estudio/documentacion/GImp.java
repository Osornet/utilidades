package com.osornet.estudio.documentacion;



/**
 * GImp
 */
public class GImp implements G{
    private String cadena;
    private int entero;
    private A a;

public GImp(String cadena, int entero, A a){
    this.cadena = cadena;
    this.entero = entero;
    this.a = a;
}

public void metodoG(){
    System.out.println("++++++++++++++DEPENDENCIAS PRIMITIVAS++++++++++++++++++");
    System.out.println(this.cadena+", "+this.entero);
    System.out.println("++++++++++++++METODO DE A++++++++++++++++++");
    this.a.metodoA();
}

    

    
}