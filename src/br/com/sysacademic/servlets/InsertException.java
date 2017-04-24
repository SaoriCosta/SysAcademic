package br.com.sysacademic.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.WebdavServlet;


@WebServlet("/InsertException")
public class InsertException extends ServletException {
	private static final long serialVersionUID = 1L;
       
    
    public InsertException() {
        super("O objeto informado já existe!"); 
    }

	
}
