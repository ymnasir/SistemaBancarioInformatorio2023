package app.service.cuenta;

public interface CuentaService {

	void abrirCuenta(Double sobregiro, Double tasaInteres);

	void eliminarCuenta();

	void realizarDeposito();

	void retirarDinero();

}