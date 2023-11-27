package app;

import java.util.Scanner;

import app.service.*;
import model.*;

public class MenuPrincipal {
	private BancoService bancoSrv;
	private static String div = "-".repeat(30);
	
	public MenuPrincipal(Banco banco) {
		bancoSrv = new BancoService(banco);
	}
	
	public void run() {
		Scanner scan = InputService.getScanner();
		Boolean cerrar = false;
		System.out.println("Bienvenido al sistema bancario!");
		while (!cerrar) {
			System.out.println(div);
			System.out.println("¿En qué podemos ayudarle?");
			System.out.println("1. Mostrar clientes");
			System.out.println("2. Registrar un cliente");
			System.out.println("3. Gestionar cliente");
			System.out.println("4. Exportar a CSV");
			System.out.println("0. Salir");
			System.out.println(div);
			System.out.print("> ");
			String opcion = scan.nextLine().trim();
			System.out.println(div);
			switch (opcion) {
				case "0":
					cerrar = true;
					break;
				case "1":
					bancoSrv.mostrarClientes();
					break;
				case "2":
					bancoSrv.cargarCliente();
					break;
				case "3":
					bancoSrv.gestionCliente();
					break;
				case "4":
					bancoSrv.exportarCSV();
					break;
				default:
					System.out.println("Opción inválida, intentelo de nuevo.");
				
			}
		}
	}
}
