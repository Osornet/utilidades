package com.osornet.estudio.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet004 extends HttpServlet{

	private static final long serialVersionUID = 1L;

    //variable compartida por todas las peticiones.
    private int peticiones;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       PrintWriter out = response.getWriter();
       out.println(this.peticiones);
       this.peticiones++;
       
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.peticiones = Integer.parseInt(config.getInitParameter("inicio"));
    }
}