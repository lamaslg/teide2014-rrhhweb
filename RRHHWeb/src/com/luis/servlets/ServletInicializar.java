package com.luis.servlets;

import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.luis.modelo.Empleado;

/**
 * Servlet implementation class ServletInicializar
 */
@WebServlet(value="/ServletInicializar",loadOnStartup=1)
public class ServletInicializar extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public void init() throws ServletException {
		HashMap<String, Empleado> empleados=new HashMap<>();
		
		empleados.put("1234A", new Empleado("1234A", "Pepe Gomez", "1234", 35000));
		empleados.put("5678A", new Empleado("5678A", "Eva perez", "9987", 45000));
		empleados.put("9012A", new Empleado("9012A", "Maria Jimenez", "5534", 15000));
		empleados.put("3456A", new Empleado("3456A", "Juan Palomo", "1222", 10000));
		empleados.put("7890A", new Empleado("7890A", "Natalia Martinez", "6643", 8000));
	
		getServletContext().setAttribute("empleados", empleados);
		
	}

}
