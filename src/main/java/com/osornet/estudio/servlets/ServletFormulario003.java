package com.osornet.estudio.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletFormulario003", urlPatterns = {"/ServletFormulario003"})
public class ServletFormulario003 extends HttpServlet{

	private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String java = req.getParameter("java");
        String net = req.getParameter("net");

        if(java != null)
            out.print("<p>has escogido "+java+"</p>");
        if(net != null)
            out.print("<p>has escogido "+net+"</p>");

        
    }
}