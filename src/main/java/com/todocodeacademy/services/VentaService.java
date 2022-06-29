package com.todocodeacademy.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodeacademy.models.Producto;
import com.todocodeacademy.models.TotalVentasDto;
import com.todocodeacademy.models.Venta;
import com.todocodeacademy.models.VentaDto;
import com.todocodeacademy.repositories.VentaRepository;

@Service
public class VentaService implements IVentaService {

	@Autowired
	private VentaRepository ventaRepository;
	
	@Override
	public List<Venta> getVentas() {
		return ventaRepository.findAll();
	}

	@Override
	public void saveVenta(Venta venta) {
		this.calcularTotal(venta);
		ventaRepository.save(venta);
		
	}

	@Override
	public void deleteVenta(Long codigo_venta) {
		ventaRepository.deleteById(codigo_venta);

	}

	@Override
	public Venta findVenta(Long codigo_venta) {
		return ventaRepository.findById(codigo_venta).orElse(null);
	}

	@Override
	public void editVenta(Long codigo_venta_original, Long codigo_venta_nuevo, Date fechaVenta, Double total) {
		Venta ventaAEditar = this.findVenta(codigo_venta_original);
		ventaAEditar.setCodigo_venta(codigo_venta_nuevo);
		ventaAEditar.setFechaVenta(fechaVenta);
		ventaAEditar.setTotal(total);
		this.saveVenta(ventaAEditar);

	}

	@Override
	public TotalVentasDto datosTotalVentaDiaria(Date fecha) {
		System.out.println("la fecha que recibo es" + fecha);
		List<Venta> listaTotalVentas = ventaRepository.findByFechaVenta(fecha);

		Long cantidadDeVentasDiarias = listaTotalVentas.stream().count();
		Double totalVentasDiaria = listaTotalVentas.stream().mapToDouble(x -> x.getTotal()).sum();

		TotalVentasDto total = new TotalVentasDto(totalVentasDiaria, cantidadDeVentasDiarias);

		return total;
	}

	@Override
	public VentaDto datosVentaMasAlta() {

		List<Venta> listaVentas = ventaRepository.findAll();

		Optional<Venta> ventaMayor = listaVentas.stream().max(Comparator.comparing(Venta::getTotal));
		Long cantidadDeProductos = ventaMayor.get().getListaProducto().stream().count();
		if (!ventaMayor.isPresent()) {
			new AccountNotFoundException("No existe ventas");
		}

		VentaDto dto = new VentaDto(ventaMayor.get().getCodigo_venta(), ventaMayor.get().getTotal(),
				cantidadDeProductos, ventaMayor.get().getCliente().getNombre(),
				ventaMayor.get().getCliente().getApellido());

		return dto;
	}

	public void calcularTotal(Venta venta) {

		Double total = 0.0;

		for (Producto producto : venta.getListaProducto()) {
			total = total + producto.getCosto();
		}

		venta.setTotal(total);

	}

	@Override
	public List<Producto> obtenerProductosPorCodigoVenta(Long codigoVenta) {

		Venta venta = this.findVenta(codigoVenta);
		List<Producto> listaDeProductos = new ArrayList<>();

		listaDeProductos = venta.getListaProducto().stream().toList();

		return listaDeProductos;
	}
	
}
