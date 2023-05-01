package com.Cristian.Concesionario.app.servicio;

import com.Cristian.Concesionario.app.entity.Concesionario;

import java.util.List;

public interface ConcesionarioServicio {

    public List<Concesionario> encontrarTodos();
    public Concesionario encontrarporId(int id);
    public void actualizarConcesionario(Concesionario concesionario);
    public void crearConcesionario(Concesionario concesionario);
    public void eliminarConcesionario(int id);
}
