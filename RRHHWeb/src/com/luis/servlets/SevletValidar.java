package com.luis.servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luis.modelo.Empleado;

@WebServlet("/validar.html")
public class SevletValidar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HashMap<String, Empleado> empleados;
	@Override
	public void init() throws ServletException {
		super.init();
		
		empleados=new HashMap<>();
		
		empleados.put("1234A", new Empleado("1234A", "Pepe Gomez", "1234", 35000));
		empleados.put("5678A", new Empleado("5678A", "Eva perez", "9987", 45000));
		empleados.put("9012A", new Empleado("9012A", "Maria Jimenez", "5534", 15000));
		empleados.put("3456A", new Empleado("3456A", "Juan Palomo", "1222", 10000));
		empleados.put("7890A", new Empleado("7890A", "Natalia Martinez", "6643", 8000));
	
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login=request.getParameter("txtLogin");
		String pwd=request.getParameter("txtPassword");
		
		if(empleados.containsKey(login)){
			Empleado empleado=empleados.get(login);
			if(empleado.getTelefono().equals(pwd)){
				
				request.setAttribute("empleado", empleado);
				
				RequestDispatcher dsp=request.getRequestDispatcher("/ver.html");
				dsp.forward(request, response);
				return;
				
				
			}
		}
		RequestDispatcher dsp=request.getRequestDispatcher("/error.jsp");
		dsp.forward(request, response);
	
	
	}

}
