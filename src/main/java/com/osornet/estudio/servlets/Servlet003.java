package com.osornet.estudio.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Servlet003", urlPatterns={"/Servlet003"})
public class Servlet003 extends HttpServlet{

	private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        out.print("<p>"+request.getParameter("nombre")+"</p>");
        out.print("<p>"+request.getParameter("edad")+"</p>");
        out.close();
    }
    
}