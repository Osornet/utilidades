package com.osornet.estudio.documentacion;

public class ABFactory{

    private  A a = new AImp();
    private  B b = new BImp();

    public B getB(){
        return this.b;
    }

    public A getA(){
        return this.a;
    }
}