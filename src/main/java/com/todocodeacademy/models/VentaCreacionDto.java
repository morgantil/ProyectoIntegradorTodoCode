package com.todocodeacademy.models;

import java.sql.Date;
import java.util.List;

public class VentaCreacionDto {
	
	private Long codigo_venta;
	private Date fechaVenta;
	private Double total;
	private List<Long>listaIdsProductos;
	private Cliente cliente;
	public VentaCreacionDto() {
		super();
	}
	public VentaCreacionDto(Long codigo_venta, Date fechaVenta, Double total, List<Long> listaIdsProductos,
			Cliente cliente) {
		super();
		this.codigo_venta = codigo_venta;
		this.fechaVenta = fechaVenta;
		this.total = total;
		this.listaIdsProductos = listaIdsProductos;
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
	public List<Long> getListaIdsProductos() {
		return listaIdsProductos;
	}
	public void setListaIdsProductos(List<Long> listaIdsProductos) {
		this.listaIdsProductos = listaIdsProductos;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
		
		

}
