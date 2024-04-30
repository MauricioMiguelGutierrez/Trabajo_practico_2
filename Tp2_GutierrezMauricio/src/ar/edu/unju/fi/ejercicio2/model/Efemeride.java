package ar.edu.unju.fi.ejercicio2.model;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;

public class Efemeride {
	private int codigo;
	private Mes meses;
	private int dia;
	private String detalle;
	
	public Efemeride(int codigo, Mes meses, int dia, String detalle) {
		this.codigo = codigo;
		this.meses = meses;
		this.dia = dia;
		this.detalle = detalle;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Mes getMeses() {
		return meses;
	}

	public void setMeses(Mes meses) {
		this.meses = meses;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nCodigo: ").append(getCodigo());
		sb.append("\nMes: ").append(getMeses());
		sb.append("\nDia: ").append(getDia());
		sb.append("\nDetalle: ").append(getDetalle());
		return sb.toString();
	}
	
	
	
	
}