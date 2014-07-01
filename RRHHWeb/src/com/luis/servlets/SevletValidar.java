package com.luis.servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.luis.modelo.Empleado;

@WebServlet("/validar.html")
public class SevletValidar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, Empleado> empleados=
		(HashMap<String, Empleado>)getServletContext().getAttribute("empleados");
		String login=request.getParameter("txtLogin");
		String pwd=request.getParameter("txtPassword");
		
		if(empleados.containsKey(login)){
			Empleado empleado=empleados.get(login);
			if(empleado.getTelefono().equals(pwd)){
				HttpSession sesion=request.getSession();
				sesion.setAttribute("empleado", empleado);
				
				RequestDispatcher dsp=request.getRequestDispatcher("/privado/ver.html");
				dsp.forward(request, response);
				return;
				
				
			}
		}
		RequestDispatcher dsp=request.getRequestDispatcher("/error.jsp");
		dsp.forward(request, response);
	
	
	}

}
