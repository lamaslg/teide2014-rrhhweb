package com.luis.modelo;

import java.io.Serializable;

public class Empleado implements Serializable{

	private static final long serialVersionUID = 1L;
	private String dni,nombre,telefono;
	private double salario;
	public Empleado() {
	}
	public Empleado(String dni, String nombre, String telefono, double salario) {
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
		this.salario = salario;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
	
}
