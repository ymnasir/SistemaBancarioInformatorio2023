package app.service.csv;

public class RegistroCSV {
	Long dni;
	String nombre;
	Double saldo;
	String tipo;
	public RegistroCSV(Long dni, String nombre, Double saldo, String tipo) {
		this.dni = dni;
		this.nombre = nombre;
		this.saldo = saldo;
		this.tipo = tipo;
	}
	public String[] convertir() {
		String[] res = {dni.toString(), nombre, saldo.toString(), tipo};
		return res;
	}
}
