package app.service.banco;

import app.MenuCliente;
import app.input.InputHelper;
import app.service.cliente.ClienteServiceImpl;
import app.service.csv.CSVServiceImpl;
import model.*;

public class BancoServiceImpl implements BancoService {
	private Banco banco;
	
	public BancoServiceImpl(Banco banco) {
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
	
	public void registrarCliente() {
		Cliente c = new ClienteServiceImpl(null).crearCliente();
		if (banco.clienteExiste(c.getDni())) {
			System.out.println("El cliente que está tratando de registrar ya existe!");
			return;
		}
		
		banco.registrarCliente(c);
	}
	
	// llama a la clase de MenuCliente, que trabaja con un ClienteService.
	public void gestionarCliente() {
		Long dni = InputHelper.leerLong("Ingrese el DNI del cliente");
		if (!banco.clienteExiste(dni)) {
			System.out.println("Cliente inexistente.");
			return;
		}
		new MenuCliente(banco, dni).run();
	}
	
	public void exportarCSV() {
		new CSVServiceImpl(banco).exportar();
	}
}
