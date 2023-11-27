package app;

import java.util.Scanner;

import app.service.*;
import model.*;

public class MenuCliente {
	private Double sobregiroBanco;
	private Double tasaInteresBanco;
	private ClienteService clienteSrv;
	private static String div = "-".repeat(30);
	
	public MenuCliente(Banco banco, Long dni) {
		this.clienteSrv = new ClienteService(banco.getClienteByDni(dni));
		this.sobregiroBanco = banco.getSobregiro();
		this.tasaInteresBanco = banco.getInteres();
	}

	public void run() {
		Boolean cerrar = false;
		Scanner scan = InputService.getScanner();
		while (!cerrar) {
			System.out.println(div);
			System.out.println("¿Qué quiere hacer?");
			System.out.println("1. Mostrar cuentas.");
			System.out.println("2. Abrir una cuenta.");
			System.out.println("3. Eliminar una cuenta.");
			System.out.println("4. Realizar un deposito.");
			System.out.println("5. Retirar dinero.");
			System.out.println("0. Salir");
			System.out.print("> ");
			String opcion = scan.nextLine().trim();
			System.out.println(div);
			switch (opcion) {
				case "0": 
					cerrar = true;
					break;
				case "1":
					clienteSrv.mostrarCuentas();
					break;
				case "2":
					clienteSrv.abrirCuenta(sobregiroBanco, tasaInteresBanco);
					break;
				case "3":
					clienteSrv.eliminarCuenta();
					break;
				case "4":
					clienteSrv.realizarDeposito();
					break;
				case "5":
					clienteSrv.retirarDinero();
					break;
				default:
					System.out.println("Opción inválida, intentelo de nuevo.");
				
			
			}
		}
		
	}
}
