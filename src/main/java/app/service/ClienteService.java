package app.service;

import java.util.Scanner;

import model.*;

public class ClienteService {
	private Cliente cliente;
	private static String div = "-".repeat(30);
	
	public ClienteService(Cliente cliente) {
		this.cliente = cliente;
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

	public Long consultarNroCuenta() {
		Scanner scan = InputService.getScanner();
		Long nroCuenta;
		while (true) {
			System.out.println("Ingrese el numero de la cuenta.");
			System.out.print("> ");
			try {
				nroCuenta = Long.parseLong(scan.nextLine().trim());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Formato inválido, vuelva a intentarlo.");
			}
			System.out.println(div);
		}
		return nroCuenta;
	}
	
	public Double consultarMonto() {
		Scanner scan = InputService.getScanner();
		Double monto;
		while (true) {
			System.out.println("Ingrese un monto.");
			System.out.print("> ");
			try {
				monto = Double.parseDouble(scan.nextLine().trim());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Formato inválido, vuelva a intentarlo.");
			}
			System.out.println(div);
		}
		return monto;
	}
	
	public void abrirCuenta(Double sobregiro, Double tasaInteres) {
		Scanner scan = InputService.getScanner();
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
		Long nroCuenta = consultarNroCuenta();
		if (!cliente.cuentaExiste(nroCuenta)) {
			System.out.println("La cuenta que usted quiere eliminar no existe!");
			return;
		}
		cliente.eliminarCuenta(nroCuenta);
		System.out.println("Cuenta eliminada correctamente!");
	}
	
	public void realizarDeposito() {
		Long nroCuenta = consultarNroCuenta();
		if (!cliente.cuentaExiste(nroCuenta)) {
			System.out.println("La cuenta a la que usted quiere depositar no existe!");
			return;
		}
		
		Double monto = consultarMonto();
		if (monto <= 0.0d) {
			System.out.println("Debe depositar una cantidad positiva de dinero.");
			return;
		}
		
		Cuenta c = cliente.getCuentaById(nroCuenta);
		c.depositarSaldo(monto);
		System.out.println("Deposito completado correctamente!");
	}
	
	public void retirarDinero() {
		Long nroCuenta = consultarNroCuenta();
		if (!cliente.cuentaExiste(nroCuenta)) {
			System.out.println("La cuenta que está solicitando no existe!");
			return;
		}
		
		Double monto = consultarMonto();
		if (monto <= 0.0d) {
			System.out.println("Debe retirar una cantidad positiva de dinero.");
			return;
		}
		
		Cuenta c = cliente.getCuentaById(nroCuenta);
		if (!c.puedeRetirar(monto)) {
			System.out.println("No se pudo retirar la cantidad de dinero solicitada, revise su saldo.");
			return;
		}
		cliente.getCuentaById(nroCuenta).retirarSaldo(monto);
		System.out.println("Retiro realizado correctamente!");
	}
}
