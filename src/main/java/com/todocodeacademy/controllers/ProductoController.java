package com.todocodeacademy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todocodeacademy.models.Producto;
import com.todocodeacademy.services.IProductoService;
@RestController
public class ProductoController {
	
	@Autowired
	private IProductoService iProductoService;
	
	@GetMapping("/productos")
	public List<Producto>treaerProductos(){
		return iProductoService.getProductos();
	}
	
	@PostMapping("/productos/crear")
	public String crearProductos(@RequestBody Producto producto) {
		iProductoService.saveProducto(producto);
		return "Producto Creado";
	}
	
	@GetMapping("/productos/{codigoProducto}")
	public Producto productoById(@PathVariable Long codigoProducto) {
		return iProductoService.findProducto(codigoProducto);
	}
	
	
	@GetMapping("/productos/cantidadMenorA5")
	public List<Producto> productoCantidadMenorA5() {
		return iProductoService.listarProductosCantidadDispnibleMenorA5();
	}
	
	
	@DeleteMapping("/productos/eliminar/{codigoProducto}")
		public String eliminarProducto(@PathVariable Long codigoProducto) {
		iProductoService.deleteProducto(codigoProducto);
			return "Producto eliminado";
	}
	
	 @PutMapping ("/productos/editar/{codigoProducto}")
	    public Producto editProducto (@PathVariable Long codigoProducto,
	            @RequestParam(required = false, name = "codigo_producto") Long codigoProductoNuevo,
	            @RequestParam(required = false, name = "nombre") String nombre,
	            @RequestParam(required = false, name = "marca") String marca,
	            @RequestParam(required = false, name = "costo") Double costo,
	            @RequestParam(required = false, name = "cantidad_disponible") Double cantidad_disponible)
	             {
	            
		 
		 iProductoService.editProducto(codigoProducto, codigoProductoNuevo, nombre, marca, costo,cantidad_disponible);   
	        Producto producto = iProductoService.findProducto(codigoProductoNuevo);
	        
	        return producto;

	    }

}
