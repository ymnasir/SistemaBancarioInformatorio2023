package app.service;

import java.util.Scanner;

import app.MenuCliente;
import app.service.csv.CSVService;
import model.*;

public class BancoService {
	private Banco banco;
	private static String div = "-".repeat(30);
	
	public BancoService(Banco banco) {
		this.banco = banco;
	}
	
	public void mostrarClientes() {
		if (banco.getClientes().size() == 0) {
			System.out.println("No hay clientes registrados!");
		}
		for (Cliente c : banco.getClientes().values()) {
			System.out.println(c);
		}
	}

	public Long consultarDni() {
		Scanner scan = InputService.getScanner();
		Long dni;
		while (true) {
			System.out.println("Ingrese el dni del cliente.");
			System.out.print("> ");
			try {
				dni = Long.parseLong(scan.nextLine().trim());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Formato de DNI inválido, vuelva a intentarlo.");
			}
			System.out.println(div);
		}
		return dni;
	}
	
	public void cargarCliente() {
		Scanner scan = InputService.getScanner();
		String nombre;
		String direccion;
		Long dni;
		
		System.out.println("Ingrese el nombre del cliente.");
		System.out.print("> ");
		nombre = scan.nextLine();
		System.out.println(div);

		System.out.println("Ingrese la direccion del cliente.");
		System.out.print("> ");
		direccion = scan.nextLine();
		System.out.println(div);
		
		dni = consultarDni();
		if (banco.clienteExiste(dni)) {
			System.out.println("Ese cliente ya existe!");
			return;
		}
		banco.registrarCliente(dni, nombre, direccion);
		
	}
	
	public void gestionCliente() {
		Long dni = consultarDni();
		if (!banco.clienteExiste(dni)) {
			System.out.println("Cliente inexistente.");
			return;
		}
		new MenuCliente(banco, dni).run();
	}
	
	public void exportarCSV() {
		new CSVService(banco).exportar();
	}
}
