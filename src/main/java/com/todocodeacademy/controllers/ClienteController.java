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

import com.todocodeacademy.models.Cliente;
import com.todocodeacademy.services.IClienteService;
@RestController
public class ClienteController {

	@Autowired
	private IClienteService iClienteService;
	
	@GetMapping("/clientes")
	public List<Cliente>treaerClientes(){
		return iClienteService.getClientes();
	}
	
	@PostMapping("/clientes/crear")
	public String crearClientes(@RequestBody Cliente cliente) {
		iClienteService.saveCliente(cliente);
		return "Cliente Creado";
	}
	
	@GetMapping("/clientes/{idCliente}")
	public Cliente clienteById(@PathVariable Long idCliente) {
		return iClienteService.findCliente(idCliente);
	}
	
	@DeleteMapping("/clientes/eliminar/{idCliente}")
		public String eliminarCliente(@PathVariable Long idCliente) {
		iClienteService.deleteCliente(idCliente);
			return "Cliente eliminado";
	}
	
	 @PutMapping ("/clientes/editar/{idCliente}")
	    public Cliente editCliente (@PathVariable Long idCliente,
	            @RequestParam(required = false, name = "id_cliente") Long idClienteNuevo,
	            @RequestParam(required = false, name = "nombre") String nombre,
	            @RequestParam(required = false, name = "apellido") String apellido,
	            @RequestParam(required = false, name = "dni") String dni)
	             {
	            
		 iClienteService.editCliente(idCliente, idClienteNuevo, nombre,apellido,dni);
	        
	        Cliente cliente = iClienteService.findCliente(idClienteNuevo);
	        
	        return cliente;

	    }
	
}
