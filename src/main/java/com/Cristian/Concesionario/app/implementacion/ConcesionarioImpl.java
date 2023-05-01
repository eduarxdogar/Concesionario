package com.Cristian.Concesionario.app.implementacion;

import com.Cristian.Concesionario.app.entity.Concesionario;
import com.Cristian.Concesionario.app.repositorio.RepositoryConcesionario;
import com.Cristian.Concesionario.app.servicio.ConcesionarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcesionarioImpl implements ConcesionarioServicio {

    @Autowired
    RepositoryConcesionario repositoryConcesionario;
    @Override
    public List<Concesionario> encontrarTodos() {
        return this.repositoryConcesionario.findAll();
    }

    @Override
    public Concesionario encontrarporId(int id) {
        return this.repositoryConcesionario.encontrarporId(id);
    }

    @Override
    public void actualizarConcesionario(Concesionario concesionario) {
        this.repositoryConcesionario.save(concesionario);
    }

    @Override
    public void crearConcesionario(Concesionario concesionario) {
        this.repositoryConcesionario.save(concesionario);
    }

    @Override
    public void eliminarConcesionario(int id) {

    }
}