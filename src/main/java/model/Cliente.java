package model;

import java.util.Map;
import java.util.HashMap;

public class Cliente {
	private Long dni;
	private String nombre;
	private String direccion;
	private Map<Long, Cuenta> cuentas;
	private Long contadorCuentaId = 1l;
	
	public Cliente(Long dni, String nombre, String direccion) {
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.cuentas = new HashMap<Long, Cuenta>();
	}

	public Double consultarSaldoTotal() {
		Double saldoTotal = 0.0d;
		for (Cuenta c : this.cuentas.values()) {
			saldoTotal += c.getSaldo();
		}
		return saldoTotal;
	}
	
	public Double consultarSaldo(Long nroCuenta) {
		if (this.cuentas.containsKey(nroCuenta)) {
			return this.cuentas.get(nroCuenta).getSaldo();
		}
		return null;
	}
	
	public void agregarCuenta(Cuenta c) {
		c.dniTitular = this.dni;
		c.nroCuenta  = contadorCuentaId++;
		cuentas.put(c.nroCuenta, c);
	}
	
	public Boolean cuentaExiste(Long nroCuenta) {
		return cuentas.containsKey(nroCuenta);
	}
	
	public void eliminarCuenta(Long nroCuenta) {
		if (nroCuenta == null) {
			return;
		}
		if (cuentaExiste(nroCuenta)) {
			cuentas.remove(nroCuenta);
		}
	}

	public Long getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String toString() {
		return "[ " + dni.toString() + ": " + nombre + " - " + direccion + " ]";
	}
	
	public Cuenta getCuentaById(Long nroCuenta) {
		if (nroCuenta == null) {
			return null;
		}
		return cuentas.get(nroCuenta);
	}
	
	public Map<Long, Cuenta> getCuentas() {
		return cuentas;
	}
}
