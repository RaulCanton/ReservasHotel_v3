package org.iesalandalus.programacion.reservashotel.Modelo.negocio;

import org.iesalandalus.programacion.reservashotel.Modelo.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.Modelo.dominio.TipoHabitacion;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;
public class Habitaciones {
    private List<Habitacion> coleccionHabitacion;

    public Habitaciones(){
        coleccionHabitacion=new ArrayList<>();
    }

    public List<Habitacion> get(){
        return copiaProfundaHabitacion(coleccionHabitacion);
    }

    public List<Habitacion> get(TipoHabitacion tipoHabitacion){
        if (tipoHabitacion == null) {
            throw new NullPointerException("ERROR: El tipo de habitación no puede ser nulo.");
        }

        List<Habitacion>habitacionTipoHabitacion = new ArrayList<>();
        for (Habitacion habitacion : coleccionHabitacion) {
            if (habitacion != null && habitacion.getTipoHabitacion().equals(tipoHabitacion)) {
                habitacionTipoHabitacion.add(new Habitacion(habitacion));//constructor copia
            }
        }
        return habitacionTipoHabitacion;
    }

    private List<Habitacion> copiaProfundaHabitacion(List<Habitacion> habitacions) {
        List<Habitacion> otrasHabitacion = new ArrayList<>();
        for (Habitacion habitacion : habitacions){
            otrasHabitacion.add(new Habitacion(habitacion));
        }
        return otrasHabitacion;
    }
    public int getTamano() {

        return coleccionHabitacion.size();
    }

    public void insertar (Habitacion habitacion) throws OperationNotSupportedException {
        if (habitacion == null) {
            throw new NullPointerException("ERROR: No se puede insertar una habitación nula.");
        }

        if (!coleccionHabitacion.contains(habitacion))
        {
            coleccionHabitacion.add(new Habitacion(habitacion));
        }
        else
        {
            throw new OperationNotSupportedException("ERROR:Ya existe una habitación con esos datos.");
        }
    }


    public Habitacion buscar (Habitacion habitacion){
        if (habitacion == null) {
            throw new NullPointerException("ERROR: No se puede buscar una habitación nula.");
        }

        int indice=coleccionHabitacion.lastIndexOf(habitacion);

        if (indice == -1){
            return null;
        }else{
            return new Habitacion(coleccionHabitacion.get(indice));
        }

    }

    public void borrar (Habitacion habitacion) throws OperationNotSupportedException {
        if (habitacion == null) {
            throw new NullPointerException("ERROR: No se puede borrar una habitación nula.");
        }


        int indice=coleccionHabitacion.lastIndexOf(habitacion);

        if (indice == -1){
            throw new OperationNotSupportedException("ERROR: No existe ningúna habitación con ese nombre.");
        }else{
            coleccionHabitacion.remove(indice);
        }
    }
}
