package com.osornet.estudio.jstl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ControladorArticulos
 */
@WebServlet(name = "ControladorArticulos", urlPatterns = {"*.do"})
public class ControladorArticulos extends HttpServlet{

	private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        List<String> listaDeElementos = new ArrayList<String>();

        listaDeElementos.add("hola");
        listaDeElementos.add("perros");
        listaDeElementos.add("commo");
        listaDeElementos.add("estan");

        session.setAttribute("listaDeElementos", listaDeElementos);
        session.setAttribute("mierda", "esto es una mierda");

        resp.sendRedirect("EjemploJstl.jsp?");

        
    }
}