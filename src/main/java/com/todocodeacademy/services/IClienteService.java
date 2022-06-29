package com.todocodeacademy.services;

import java.util.List;

import com.todocodeacademy.models.Cliente;

public interface IClienteService {

    public List<Cliente> getClientes();

    public void saveCliente(Cliente cliente);

    public void deleteCliente(Long id_cliente);

    public Cliente findCliente(Long id_cliente);

    public void editCliente(Long  id_cliente_original, Long id_cliente_nuevo,
                            String nuevoNombre,
                            String nuevaApellido,
                            String dni);
	
    

}
