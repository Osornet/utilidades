package com.osornet.estudio.documentacion;

public class AFactory{

    //private static A a = new AImp();

    public static A getA(){
        return new AImpv2();
    }
}