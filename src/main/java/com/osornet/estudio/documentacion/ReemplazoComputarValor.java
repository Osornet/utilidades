package com.osornet.estudio.documentacion;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

/**
 * ReemplazoComputarValor
 */
public class ReemplazoComputarValor implements MethodReplacer{

	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        String input = (String)args[0];
        return "Metodo reemplazado"+input;
	}

    
}