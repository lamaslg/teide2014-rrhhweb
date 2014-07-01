package com.luis.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luis.modelo.Empleado;

/**
 * Servlet implementation class ServletVer
 */
@WebServlet("/privado/ver.html")
public class ServletVer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HashMap<String, Empleado> empleados=
		  (HashMap<String, Empleado>) getServletContext().getAttribute("empleados");
		PrintWriter salida=response.getWriter();
		
		salida.print("<html><head></head><body>");
		salida.print("<table><tr><th>Nombre</th></tr>");
		for (Empleado emple : empleados.values()) {
			salida.print("<tr><td>"+emple.getNombre()+"</td></tr>");
		}
		salida.print("</table></body></html>");
		
	}

}
