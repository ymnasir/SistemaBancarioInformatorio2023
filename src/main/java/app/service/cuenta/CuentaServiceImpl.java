package app.service.cuenta;

import java.util.Scanner;

import app.input.InputHelper;
import app.input.InputSingleton;
import model.*;

public class CuentaServiceImpl implements CuentaService {
	private static String div = "-".repeat(30);
	private Cliente cliente;
	
	public CuentaServiceImpl(Cliente cliente) {
		this.cliente = cliente;
	}

	private Long buscarCuentaId() {
		Long nroCuenta = InputHelper.leerLong("Ingrese el número de la cuenta.");
		if (!cliente.cuentaExiste(nroCuenta)) {
			System.out.println("La cuenta que usted quiere eliminar no existe!");
			return null;
		}
		return nroCuenta;
	}
	
	private Cuenta buscarCuenta() {
		Long nroCuenta = this.buscarCuentaId();
		Cuenta c = cliente.getCuentaById(nroCuenta);
		return c;
	}
	
	private Double leerMonto(String msg) {
		Double monto = InputHelper.leerDouble(msg);
		if (monto <= 0.0d) {
			System.out.println("Debe ingresar una cantidad positiva de dinero.");
			return null;
		}
		return monto;
	}
	
	public void abrirCuenta(Double sobregiro, Double tasaInteres) {
		Scanner scan = InputSingleton.getScanner();
		Cuenta c = null;
		Boolean cerrar = false;
		while (!cerrar) {
			System.out.println("¿Qué tipo de cuenta desea crear?");
			System.out.println("1. Cuenta Corriente.");
			System.out.println("2. Cuenta de Ahorro.");
			System.out.print("> ");
			String opcion = scan.nextLine();
			System.out.println(div);
			switch (opcion) {
				case "1":
					c = new CuentaCorriente(sobregiro);
					cerrar = true;
					break;
				case "2":
					c = new CuentaAhorro(tasaInteres);
					cerrar = true;
					break;
				default: 
					System.out.println("Opción invalida, intentelo de nuevo");
			}
		}
		cliente.agregarCuenta(c);
		System.out.println("Cuenta creada correctamente!");
	}

	public void eliminarCuenta() {
		Long nroCuenta = this.buscarCuentaId();
		cliente.eliminarCuenta(nroCuenta);
		System.out.println("Cuenta eliminada correctamente!");
	}
	
	public void realizarDeposito() {
		Cuenta c = this.buscarCuenta();
		if (c == null) {
			return;
		}
		
		Double monto = this.leerMonto("Ingrese el monto a depositar.");
		if (monto == null) {
			return;
		}
		
		c.depositarSaldo(monto);
		System.out.println("Deposito completado correctamente!");
	}
	
	public void retirarDinero() {
		Cuenta c = this.buscarCuenta();
		if (c == null) {
			return;
		}
		
		Double monto = this.leerMonto("Ingrese el monto a retirar.");
		if (monto == null) {
			return;
		}

		if (!c.puedeRetirar(monto)) {
			System.out.println("No se pudo retirar la cantidad de dinero solicitada, revise su saldo.");
			return;
		}
		c.retirarSaldo(monto);
		System.out.println("Retiro realizado correctamente!");
	}

	
	
}
