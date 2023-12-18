package model;

import java.util.Map;
import java.util.HashMap;

public class Banco {
	private String nombre;
	private Double interes;
	private Double sobregiro;
	private Map<Long, Cliente> clientes;
	
	public Banco(String nombre, Double interes, Double sobregiro) {
		this.nombre    = nombre;
		this.interes   = interes;
		this.sobregiro = sobregiro;
		this.clientes  = new HashMap<Long, Cliente>();
	}

	public Boolean clienteExiste(Long dni) {
		return clientes.containsKey(dni);
	}
	
	public void registrarCliente(Cliente c) {
		if (clienteExiste(c.getDni())) {
			return;
		}
		clientes.put(c.getDni(), c);
	}
	
	public void abrirCuenta(Long dni, Cuenta c) {
		if (clienteExiste(dni)) {
			clientes.get(dni).agregarCuenta(c);
		}
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Map<Long, Cliente> getClientes() {
		return this.clientes;
	}
	
	public Cliente getClienteByDni(Long dni) {
		return this.clientes.get(dni);
	}

	public double getSobregiro() {
		return sobregiro;
	}

	public void setSobregiro(double sobregiro) {
		this.sobregiro = sobregiro;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}
}