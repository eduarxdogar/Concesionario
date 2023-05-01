package com.Cristian.Concesionario.app.controlador;

import com.Cristian.Concesionario.app.dto.ClienteDto;
import com.Cristian.Concesionario.app.negocio.ClienteNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/Cliente")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.HEAD})

public class ClienteController {

    @Autowired
    private ClienteNegocio clienteNegocio;

    @Autowired
    private ClienteDto clienteDto;

   @GetMapping("/all")
   @ResponseBody
    public ResponseEntity<Map<String,Object>> all(){
        Map<String,Object> res=new HashMap<>();
        List<ClienteDto> listaClientes=this.clienteNegocio.encontrarTodos();
       System.out.println("@@@@!"+listaClientes.toString());

        res.put("status","ok");
        res.put("data",listaClientes);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> crearCliente(@RequestBody Map<String,Object> request){
        Map<String,Object> res=new HashMap<>();
        System.out.println("@@@@@"+request.toString());
        ClienteDto clienteDto=new ClienteDto();
        clienteDto.setId(0);
        clienteDto.setNombres(request.get("nombre").toString());
        clienteDto.setApellidos(request.get("apellido").toString());
        clienteDto.setTelefono(Integer.parseInt(request.get("telefono").toString()));
        clienteDto.setCorreo(request.get("correo").toString());


        String resp = this.clienteNegocio.guardarCliente(clienteDto);
        res.put("status","ok");
        res.put("data",resp);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/Actualizar")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> actualizarCliente(@RequestBody Map<String,Object> request){
        Map<String,Object> res=new HashMap<>();
        clienteDto.setId(Integer.parseInt(request.get("id").toString()));
        clienteDto.setNombres(request.get("nombres").toString());
        clienteDto.setApellidos(request.get("apellidos").toString());
        clienteDto.setTelefono(Integer.parseInt(request.get("telefono").toString()));
        clienteDto.setCorreo(request.get("correo").toString());
        String resp = this.clienteNegocio.guardarCliente(clienteDto);
        res.put("status","ok");
        res.put("data",resp);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
