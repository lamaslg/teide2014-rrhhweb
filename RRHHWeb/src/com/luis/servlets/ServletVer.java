package com.luis.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luis.modelo.Empleado;

/**
 * Servlet implementation class ServletVer
 */
@WebServlet("/ver.html")
public class ServletVer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ArrayList<Empleado> empleados;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		empleados=new ArrayList<>();
		empleados.add(new Empleado("1234A", "Pepe Gomez", "1234", 35000));
		empleados.add( new Empleado("5678A", "Eva perez", "9987", 45000));
		empleados.add(new Empleado("9012A", "Maria Jimenez", "5534", 15000));
		empleados.add(new Empleado("3456A", "Juan Palomo", "1222", 10000));
		empleados.add(new Empleado("7890A", "Natalia Martinez", "6643", 8000));
	
	
	}
    
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PrintWriter salida=response.getWriter();
		
		salida.print("<html><head></head><body>");
		salida.print("<table><tr><th>Nombre</th></tr>");
		for (Empleado emple : empleados) {
			salida.print("<tr><td>"+emple.getNombre()+"</td></tr>");
		}
		salida.print("</table></body></html>");
		
	}

}
