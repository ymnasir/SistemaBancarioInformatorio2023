package model;

public class CuentaCorriente extends Cuenta {
	private Double sobregiro;
	
	public CuentaCorriente(Double sobregiro) {
		this.sobregiro = sobregiro;
	}
	
	public Boolean puedeRetirar(Double monto) {
		return monto <= (this.saldo + this.sobregiro);
	}
	
	public double getSobregiro() {
		return sobregiro;
	}
	
	public void setSobregiro(Double sobregiro) {
		this.sobregiro = sobregiro;
	}

	public String toString() {
		return "[ Titular " + dniTitular.toString() + "; Cuenta " + nroCuenta.toString() + "; $" + saldo.toString() + "; Corriente ]";
	}	

}