package com.todocodeacademy.models;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Venta {
	 @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codigo_venta;
	private Date fechaVenta;
	private Double total;
	@ManyToMany
	private List<Producto>listaProducto;
	@OneToOne
	private Cliente cliente;
	
	public Venta() {
		super();
	}

	public Venta(Long codigo_venta, Date fechaVenta, Double total, List<Producto> listaProducto, Cliente cliente) {
		super();
		this.codigo_venta = codigo_venta;
		this.fechaVenta = fechaVenta;
		this.total = total;
		this.listaProducto = listaProducto;
		this.cliente = cliente;
	}

	public Long getCodigo_venta() {
		return codigo_venta;
	}

	public void setCodigo_venta(Long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<Producto> getListaProducto() {
		return listaProducto;
	}

	public void setListaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Venta [codigo_venta=" + codigo_venta + ", fechaVenta=" + fechaVenta + ", total=" + total
				+ ", listaProducto=" + listaProducto + ", cliente=" + cliente + "]";
	}
	
	
	

}
