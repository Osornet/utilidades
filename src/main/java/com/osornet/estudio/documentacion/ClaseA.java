package com.osornet.estudio.documentacion;

import org.springframework.beans.factory.annotation.Lookup;

public abstract class ClaseA{

    public void ExecuteA(){
        this.createA().metodoA();
    }

    @Lookup("AImpPro")
    public abstract A createA();
}