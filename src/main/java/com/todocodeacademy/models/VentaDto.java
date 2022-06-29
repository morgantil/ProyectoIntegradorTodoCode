package com.todocodeacademy.models;

public class VentaDto {

	private Long codigoVenta;
	private Double total;
	private Long cantidadProductos;
	private String nombre;
	private String apellido;
	
	public VentaDto() {
		super();
	}

	public VentaDto(Long codigoVenta, Double total, Long cantidadProductos, String nombre, String apellido) {
		super();
		this.codigoVenta = codigoVenta;
		this.total = total;
		this.cantidadProductos = cantidadProductos;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Long getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(Long codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Long getCantidadProductos() {
		return cantidadProductos;
	}

	public void setCantidadProductos(Long cantidadProductos) {
		this.cantidadProductos = cantidadProductos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}
