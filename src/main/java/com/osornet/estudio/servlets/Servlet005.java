package com.osornet.estudio.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet005", 
            urlPatterns = {"/Servlet005"},
            initParams = {@WebInitParam(name = "inicio",value = "5"),
                        @WebInitParam(name ="inicio2", value ="Hola mundo")}            
            )

public class Servlet005 extends HttpServlet{

	private static final long serialVersionUID = 1L;

    //variable compartida por todas las peticiones.
    private int peticiones;
    private String hola; 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       PrintWriter out = response.getWriter();
       out.println(this.peticiones+"<br/>");
       out.println(this.hola);
       
       this.peticiones++;
       
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.peticiones = Integer.parseInt(config.getInitParameter("inicio"));
        this.hola = config.getInitParameter("inicio2");
    }
}