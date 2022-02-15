package com.ejemplo.conexiones2;

public class Empleado {
	private String id;
	private String nombre;
	private String apellido;
	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Empleado(String id, String nombre, String apellido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
}
