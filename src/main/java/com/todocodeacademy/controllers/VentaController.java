package com.todocodeacademy.controllers;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todocodeacademy.models.Producto;
import com.todocodeacademy.models.TotalVentasDto;
import com.todocodeacademy.models.Venta;
import com.todocodeacademy.models.VentaDto;
import com.todocodeacademy.services.IVentaService;

@RestController
public class VentaController {
	@Autowired
	private IVentaService iVentaService;

	
	@GetMapping("/ventas")
	public List<Venta>treaerVentas(){
		return iVentaService.getVentas();
	}
	
	@PostMapping("/ventas/crear")
	public String crearVenta(@RequestBody Venta venta) {
		iVentaService.saveVenta(venta);
		return "Venta creada";
	}
	
	@GetMapping("/ventas/{codigoVenta}")
	public Venta ventaById(@PathVariable Long codigoVenta) {
		return iVentaService.findVenta(codigoVenta);
	}
	
	@DeleteMapping("clientes/ventas/eliminar/{codigoVenta}")
		public String eliminarVenta(@PathVariable Long codigoVenta) {
			iVentaService.deleteVenta(codigoVenta);
			return "Venta eliminada";
	}
	
	 @PutMapping ("clientes/ventas/editar/{codigoVenta}")
	    public Venta editVenta (@PathVariable Long codigoVenta,
	            @RequestParam(required = false, name = "codigo_venta") Long nuevaCodigoVenta,
	            @RequestParam (required = false, name = "fechaVenta")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaVenta,
	            @RequestParam(required = false, name = "total") Double total)
	             {
	            
	        iVentaService.editVenta(codigoVenta, nuevaCodigoVenta, fechaVenta, total);
	        
	        Venta venta = iVentaService.findVenta(nuevaCodigoVenta);	        
	        return venta;
 
	    }
	 
	 @GetMapping("/ventas/productosporventas/{codigoVenta}")
		public List<Producto>treaerProductosPorCodigoDeVenta(@PathVariable Long codigoVenta){
		
			return iVentaService.obtenerProductosPorCodigoVenta(codigoVenta);
		
		}
	 
	 @GetMapping("/ventas/sumatoriaporventas/{fecha}")
		public TotalVentasDto sumatoriadetotalyventas(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha){
		 System.out.println("la fecha que recibo es"+fecha);
			return iVentaService.datosTotalVentaDiaria(fecha);
		
		}
	 	
	 @GetMapping("/ventas/datosventamasalta")
		public VentaDto ventaMasAlta(){
		
			return iVentaService.datosVentaMasAlta();
		
		}
	 
	
}

