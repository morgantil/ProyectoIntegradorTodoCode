package com.todocodeacademy.models;

public class TotalVentasDto {
	
	private Double sumaDeTodasLasVentas;
	private Long cantidadDeVenta;
	
	public TotalVentasDto() {
		super();
	}
	
	public TotalVentasDto(Double sumaDeTodasLasVentas, Long cantidadDeVenta) {
		super();
		this.sumaDeTodasLasVentas = sumaDeTodasLasVentas;
		this.cantidadDeVenta = cantidadDeVenta;
	}

	public Double getSumaDeTodasLasVentas() {
		return sumaDeTodasLasVentas;
	}

	public void setSumaDeTodasLasVentas(Double sumaDeTodasLasVentas) {
		this.sumaDeTodasLasVentas = sumaDeTodasLasVentas;
	}

	public Long getCantidadDeVenta() {
		return cantidadDeVenta;
	}

	public void setCantidadDeVenta(Long cantidadDeVenta) {
		this.cantidadDeVenta = cantidadDeVenta;
	}
		
}
