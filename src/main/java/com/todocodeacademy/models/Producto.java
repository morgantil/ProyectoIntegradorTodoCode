package com.todocodeacademy.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Producto {
	 @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codigo_producto;
	private String nombre;
	private String marca;
	private Double costo;
	private Double cantidadDisponible;
	
	public Producto() {
		super();
	}
	


	public Producto(Long codigo_producto, String nombre, String marca, Double costo, Double cantidadDisponible) {
		super();
		this.codigo_producto = codigo_producto;
		this.nombre = nombre;
		this.marca = marca;
		this.costo = costo;
		this.cantidadDisponible = cantidadDisponible;
	}



	public Long getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(Long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}



	public Double getCantidadDisponible() {
		return cantidadDisponible;
	}



	public void setCantidadDisponible(Double cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}


	
	
	
}
