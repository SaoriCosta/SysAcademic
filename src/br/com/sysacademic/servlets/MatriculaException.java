package br.com.sysacademic.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MatriculaException")
public class MatriculaException extends ServletException {
	private static final long serialVersionUID = 1L;
       
   
    public MatriculaException() {
        super("Matricula já Existe!");
       
    }

	
}
