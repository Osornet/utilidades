package com.osornet.estudio.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletFormulario006", urlPatterns = {"/ServletFormulario006"})
public class ServletFormulario006 extends HttpServlet{

	private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String[] listaDeCursos = req.getParameterValues("curso");
      
        for(String curso: listaDeCursos)
            out.print("<p>"+curso+"</p>");

        
    }
}