package com.todocodeacademy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todocodeacademy.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	 public List<Producto> findByCantidadDisponible(Double cantidadDisponible);
	
}
