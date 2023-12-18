package app.service.csv;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

import model.Banco;
import model.Cliente;
import model.Cuenta;

public class CSVServiceImpl implements CSVService {
	List<RegistroCSV> datos;

	public CSVServiceImpl(Banco banco) {
		this.datos = extraerDatos(banco);
	}
	
	public void exportar() {
		try {
			String[] headers = {"DNI", "Nombre", "Saldo", "Tipo"};
			String path = new File("").getAbsolutePath() + "\\salida.csv";
			CSVWriter csvWriter = new CSVWriter(new FileWriter(path));
			csvWriter.writeNext(headers, false);
			for (RegistroCSV reg : datos) {
				csvWriter.writeNext(reg.convertir(), false);
			}
			System.out.println("Archivo generado correctamente!");
		} catch (IOException e) {
			System.out.println("Error creando el archivo.");
		} catch (Exception e) {
			System.out.println("Error desconocido.");
		}

	}
	
	private List<RegistroCSV> extraerDatos(Banco banco) {
		List<RegistroCSV> dat = new ArrayList<RegistroCSV>();

		for (Cliente cliente : banco.getClientes().values()) {
			for (Cuenta cuenta : cliente.getCuentas().values()) {
				RegistroCSV reg = new RegistroCSV(
						cliente.getDni(), 
						cliente.getNombre(),
						cuenta.getSaldo(),
						cuenta.getClass().getName()
				);
				dat.add(reg);
			}
		}
		dat.sort(new RegistroComparator());
		
		return dat;
	}
}
