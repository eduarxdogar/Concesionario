package com.Cristian.Concesionario.app.servicio;

import com.Cristian.Concesionario.app.entity.Empleado;

import java.util.List;

public interface EmpleadoServicio {
    public List<Empleado> encontrarTodos();
    public Empleado encontrarporId(int id);
    public void actualizarEmpleado(Empleado empleado);
    public void crearEmpleado(Empleado empleado);
    public void eliminarCEmpleado(int id);
}
