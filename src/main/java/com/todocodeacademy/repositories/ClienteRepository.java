package com.todocodeacademy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todocodeacademy.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long>{

}
