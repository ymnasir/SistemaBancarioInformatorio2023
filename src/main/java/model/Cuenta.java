package model;

public abstract class Cuenta {
	protected Long nroCuenta;
	protected Long dniTitular;
	protected Double saldo;
	
	public Cuenta() {
		this.saldo = 0.0d;
	}

	public abstract Boolean puedeRetirar(Double monto);
	
	public void depositarSaldo(Double monto) {
		this.saldo += monto;
	}

	public void retirarSaldo(Double monto) {
		if (puedeRetirar(monto)) {
			this.saldo -= monto;
		}
	}

	public Double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	

	public Long getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(Long nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public Long getDniTitular() {
		return dniTitular;
	}

}
