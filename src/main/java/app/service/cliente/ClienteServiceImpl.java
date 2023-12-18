package app.service.cliente;

import model.*;
import app.input.InputHelper;
import app.service.cuenta.CuentaServiceImpl;

public class ClienteServiceImpl implements ClienteService {
	private Cliente cliente;
	
	public ClienteServiceImpl(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cliente crearCliente() {
		String nombre = InputHelper.leerStr("Ingrese el nombre del cliente.");
		String direccion = InputHelper.leerStr("Ingrese la dirección del cliente.");
		Long dni = InputHelper.leerLong("Ingrese el DNI del cliente.");
		
		return new Cliente(dni, nombre, direccion);
	}
	
	public void mostrarCuentas() {
		if (cliente.getCuentas().size() == 0) {
			System.out.println("No tiene cuentas registradas!");
			return;
		}
		for (Cuenta c : cliente.getCuentas().values()) {
			System.out.println(c);
		}
	}

	public void abrirCuenta(Double sobregiro, Double tasaInteres) {
		new CuentaServiceImpl(cliente).abrirCuenta(sobregiro, tasaInteres);
	}

	public void eliminarCuenta() {
		new CuentaServiceImpl(cliente).eliminarCuenta();
	}

	public void realizarDeposito() {
		new CuentaServiceImpl(cliente).realizarDeposito();
	}

	public void retirarDinero() {
		new CuentaServiceImpl(cliente).retirarDinero();
	}
}
