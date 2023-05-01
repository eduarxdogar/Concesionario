package com.Cristian.Concesionario.app.negocio;

import com.Cristian.Concesionario.app.dto.ClienteDto;
import com.Cristian.Concesionario.app.entity.Cliente;
import com.Cristian.Concesionario.app.implementacion.ClienteImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteNegocio {

    @Autowired
    ClienteImpl clienteImpl;

    private List<ClienteDto> listaDtoClientes=new ArrayList<>();

    public List<ClienteDto> encontrarTodos() {
        this.clienteImpl.encontrarTodos().forEach(cliente -> {
            ClienteDto clienteDto = new ClienteDto();
            clienteDto.setId(cliente.getId());
            clienteDto.setNombres(cliente.getNombres());
            clienteDto.setApellidos(cliente.getApellidos());
            clienteDto.setTelefono(cliente.getTelefono());
            clienteDto.setCorreo(cliente.getCorreo());
            this.listaDtoClientes.add(clienteDto);
        });
        return this.listaDtoClientes;
    }

    public String guardarCliente (ClienteDto clienteDto){
        Cliente cliente = new Cliente();

        try{
            if (clienteDto.getId()!=0){
                cliente.setId(clienteDto.getId());
                cliente.setNombres(clienteDto.getNombres());
                cliente.setApellidos(clienteDto.getApellidos());
                cliente.setTelefono(clienteDto.getTelefono());
                cliente.setCorreo(clienteDto.getCorreo());
                this.clienteImpl.actualizarCliente(cliente);
            }
            else {
                cliente.setId(clienteDto.getId());
                cliente.setNombres(clienteDto.getNombres());
                cliente.setApellidos(clienteDto.getApellidos());
                cliente.setTelefono(clienteDto.getTelefono());
                cliente.setCorreo(clienteDto.getCorreo());
                this.clienteImpl.crearCliente(cliente);
            }
            return "Registro Exitoso";
        }
        catch(Exception e){
            return "Registro Fallido";
        }
    }
}
