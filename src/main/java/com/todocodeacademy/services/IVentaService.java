package com.todocodeacademy.services;

import java.util.Date;
import java.util.List;

import com.todocodeacademy.models.Producto;
import com.todocodeacademy.models.TotalVentasDto;
import com.todocodeacademy.models.Venta;
import com.todocodeacademy.models.VentaDto;

public interface IVentaService {
	
	public List<Venta> getVentas();

    public void saveVenta(Venta venta);

    public void deleteVenta(Long codigo_venta);

    public Venta findVenta(Long codigo_venta);

    public void editVenta(Long  codigo_venta_original, Long codigo_venta_nuevo,
                            Date fecha_venta,
                            Double total);
    
    public List<Producto> obtenerProductosPorCodigoVenta(Long codigoVenta);
    
    public TotalVentasDto datosTotalVentaDiaria(Date fecha);
    
    public VentaDto datosVentaMasAlta();
   
}
