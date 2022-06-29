package com.todocodeacademy.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodeacademy.models.Producto;
import com.todocodeacademy.repositories.ProductoRepository;
@Service
public class ProductoService implements IProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public List<Producto> getProductos() {
		return productoRepository.findAll();
		
	}

	@Override
	public void saveProducto(Producto producto) {
		productoRepository.save(producto);
		
	}

	@Override
	public void deleteProducto(Long codigo_producto) {
		productoRepository.deleteById(codigo_producto);
		
	}

	@Override
	public Producto findProducto(Long codigo_producto) {
		return productoRepository.findById(codigo_producto).orElse(null);
		
	}

	@Override
	public void editProducto(Long codigo_producto_original, Long codigo_producto_nuevo, String nombre, String marca,
			Double costo, Double cantidad_disponible) {
			
			Producto productoAEditar=this.findProducto(codigo_producto_original);
			productoAEditar.setCodigo_producto(codigo_producto_nuevo);
			productoAEditar.setNombre(nombre);
			productoAEditar.setMarca(marca);
			productoAEditar.setCosto(costo);
			productoAEditar.setCantidadDisponible(cantidad_disponible);
			this.saveProducto(productoAEditar);
		
	}
	
	

	@Override
	public List<Producto> listarProductosCantidadDispnibleMenorA5() {
		List<Producto>listaProductosCantidadMenorA5=new ArrayList<>();
		List<Producto>listaProductos=this.getProductos();
		
		listaProductosCantidadMenorA5=listaProductos.stream().filter(x->x.getCantidadDisponible()<5).toList();
		
		return listaProductosCantidadMenorA5;
	}



	
}
