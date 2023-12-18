package app.service.cliente;

import model.*;

public interface ClienteService {

	void mostrarCuentas();
	
	Cliente crearCliente();

	void abrirCuenta(Double sobregiro, Double tasaInteres);
	
	void eliminarCuenta();

	void realizarDeposito();

	void retirarDinero();

}