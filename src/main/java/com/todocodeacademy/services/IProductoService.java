package com.todocodeacademy.services;

import java.util.List;

import com.todocodeacademy.models.Producto;


public interface IProductoService {

	public List<Producto> getProductos();

    public void saveProducto(Producto producto);

    public void deleteProducto(Long codigo_producto);

    public Producto findProducto(Long producto);

    public void editProducto(Long  codigo_producto_original, Long codigo_producto_nuevo,
                            String nombre,
                            String marca,
                            Double costo,
                            Double cantidad_disponible);
    
    public List<Producto> listarProductosCantidadDispnibleMenorA5();
    
 
	
}
