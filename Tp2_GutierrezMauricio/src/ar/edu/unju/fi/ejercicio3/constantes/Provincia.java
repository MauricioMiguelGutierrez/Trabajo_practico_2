package ar.edu.unju.fi.ejercicio3.constantes;


public enum Provincia {
	JUJUY(811611,53219), 
	SALTA(1441351,155488), 
	TUCUMAN(1731820,22524), 
	CATAMARCA(429562,102602), 
	LARIOJA(383865,89680), 
	SANTIAGODELESTERO(1060906,136351);
	
	private double cantidadPoblacion;
	private double superficie;
	
	private Provincia(double cantidadPoblacion, double superficie) {
		setCantidadPoblacion(cantidadPoblacion);
		setSuperficie(superficie);
	}

	public double getCantidadPoblacion() {
		return cantidadPoblacion;
	}

	public void setCantidadPoblacion(double cantidadPoblacion) {
		this.cantidadPoblacion = cantidadPoblacion;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	
	public double densidad() {
		return getCantidadPoblacion() / getSuperficie();
	}
	
}