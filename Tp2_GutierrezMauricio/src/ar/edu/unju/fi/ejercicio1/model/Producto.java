package ar.edu.unju.fi.ejercicio1.model;



public class Producto {
	private String codigo;
    private String descripcion;
    private float precioUnitario;
    private OrigenFabricacion origendeFabricacion;
    private Categoria categoria;

    public Producto() {
		// TODO Auto-generated constructor stub
	}
    

	public Producto(String codigo, String descripcion, float precioUnitario, OrigenFabricacion origendeFabricacion,
			Categoria categoria) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origendeFabricacion = origendeFabricacion;
		this.categoria = categoria;
	}


	public enum Categoria {
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}
	public enum OrigenFabricacion {

		ARGENTINA , CHINA , BRASIL , URUGUAY 
	}
	public final String getCodigo() {
		return codigo;
	}


	public final void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public final String getDescripcion() {
		return descripcion;
	}


	public final void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public final float getPrecioUnitario() {
		return precioUnitario;
	}


	public final void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}


	public final OrigenFabricacion getOrigendeFabricacion() {
		return origendeFabricacion;
	}


	public final void setOrigendeFabricacion(OrigenFabricacion origendeFabricacion) {
		this.origendeFabricacion = origendeFabricacion;
	}


	public final Categoria getCategoria() {
		return categoria;
	}


	public final void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario
				+ ", origendeFabricacion=" + origendeFabricacion + ", categoria=" + categoria + "]";
	}

	
}
