package com.todocodeacademy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodeacademy.models.Cliente;
import com.todocodeacademy.repositories.ClienteRepository;
@Service
public class ClienteService implements IClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> getClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public void saveCliente(Cliente cliente) {
		clienteRepository.save(cliente);
		
	}

	@Override
	public void deleteCliente(Long id_cliente) {
		clienteRepository.deleteById(id_cliente);
		
	}

	@Override
	public Cliente findCliente(Long id_cliente) {
		return clienteRepository.findById(id_cliente).orElse(null);
	}

	@Override
	public void editCliente(Long id_cliente_original, Long id_cliente_nuevo, String nuevoNombre, String nuevaApellido,
			String dni) {
		Cliente clienteAEditar=this.findCliente(id_cliente_original);
		clienteAEditar.setId_cliente(id_cliente_nuevo);
		clienteAEditar.setNombre(nuevoNombre);
		clienteAEditar.setApellido(nuevaApellido);
		clienteAEditar.setDni(dni);
		this.saveCliente(clienteAEditar);
		
	}

}
