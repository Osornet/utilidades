package com.osornet.estudio.documentacion;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApp{
    public static void main(String[] args) {
        /*
        se pude agregar mas archivos de contexto de Aplicaicion agragando mas parametros la instancia
        de ApplicacionContext
        ApplicationContext contenedor = new ClassPathXmlApplicationContext("spring/AppContex.xml", 
        "spring/AppContex2.xml");
        */
        ApplicationContext contenedor = new ClassPathXmlApplicationContext("documentacion/AppContex.xml");
        
        MiValorDeCalculadora vcal = contenedor.getBean("MiValorDeCalculadora",MiValorDeCalculadora.class);

        System.out.println(vcal.computarValor("ejemplo"));

        ((ClassPathXmlApplicationContext)contenedor).close();

    }
}
