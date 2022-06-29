package com.todocodeacademy.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todocodeacademy.models.Venta;

public interface VentaRepository extends JpaRepository<Venta,Long> {

	public List<Venta> findByFechaVenta(Date fecha);
	
	
}
