package model;

public class CuentaAhorro extends Cuenta {
	private Double tasaInteres;
	
	public CuentaAhorro(Double tasaInteres) {
		this.tasaInteres = tasaInteres;
	}

	public Boolean puedeRetirar(Double monto) {
		return monto <= this.saldo;
	}

	public double getTasaInteres() {
		return tasaInteres;
	}

	public void setTasaInteres(Double tasaInteres) {
		this.tasaInteres = tasaInteres;
	}

	public double calcularInteres() {
		return this.saldo * this.tasaInteres/100;
	}
	
	public void agregarInteres() {
		this.saldo += this.saldo * this.tasaInteres/100;
	}
	
	public String toString() {
		return "[ Titular " + dniTitular.toString() + "; Cuenta " + nroCuenta.toString() + "; $" + saldo.toString() + "; Ahorro ]";
	}
}