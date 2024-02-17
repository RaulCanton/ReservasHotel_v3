package org.iesalandalus.programacion.reservashotel.Controlador;

import org.iesalandalus.programacion.reservashotel.Modelo.Modelo;
import org.iesalandalus.programacion.reservashotel.Modelo.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.Modelo.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.Modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.Modelo.dominio.TipoHabitacion;
import org.iesalandalus.programacion.reservashotel.vista.Vista;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;
import java.util.List;

public class Controlador {

    private Vista vista;

    private Modelo modelo;


    public Controlador(Modelo modelo, Vista vista){

        if (modelo==null){
            throw new IllegalArgumentException("ErRRor el modelo no puede ser nulo.");
        }

        if (vista==null){
            throw new IllegalArgumentException("La vista no puede ser nula");
        }

        this.modelo=modelo;
        this.vista=vista;
        this.vista.setControlador(this);
    }

    public void comenzar(){
        modelo.comenzar();
        vista.comenzar();
    }
    public void terminar(){
        modelo.terminar();
        vista.terminar();
    }

    public void insertar(Huesped huesped)throws OperationNotSupportedException{
        modelo.insertarHuesped();
    }
    public Huesped buscar(Huesped huesped){
       return huesped=modelo.buscarHuesped();
    }

    public void borrar(Huesped huesped) throws OperationNotSupportedException {
        modelo.borrarHuesped();
    }

    public List<Huesped> getHuesped(){
        return modelo.getHuespedes();
    }

    public void insertar(Habitacion habitacion)throws OperationNotSupportedException{
        modelo.insertarHabitacion();

    }
    public Habitacion buscar(Habitacion habitacion){
        return habitacion=modelo.buscarHabitacion();
    }

    public void borrar(Habitacion habitacion) throws OperationNotSupportedException {
        modelo.borrarHabitacion();
    }

    public List<Habitacion> getHabitaciones (){
        return modelo.getHabitaciones();
    }

    public List<Habitacion> getHabitaciones(TipoHabitacion tipoHabitacion){
        return modelo.getHabitaciones();
    }

    public void insertar (Reserva reserva) throws OperationNotSupportedException{
        modelo.insertarReserva();
    }

    public void borrar (Reserva reserva)throws OperationNotSupportedException{
        modelo.borrarReserva();
    }
    public Reserva buscar(Reserva reserva){
        return modelo.buscarReserva(reserva);

    }

    public List<Reserva> getReservas(){
        return modelo.getReservas();
    }
    public List<Reserva> getReservas(Huesped huesped){
        return modelo.getReservas();
    }

    public List<Reserva> getResevas(TipoHabitacion tipoHabitacion){
        return modelo.getReservas();
    }

    public List<Reserva> getReservasFuturas(Habitacion habitacion){
        return modelo.getReservasFuturas(habitacion);
    }

    public void realizarCheckIn(Reserva reserva, LocalDate fecha)throws OperationNotSupportedException{
        modelo.realizarCheckin(reserva,fecha);
    }
    public void realizarCheckOut(Reserva reserva,LocalDate fecha)throws OperationNotSupportedException{
        modelo.realizarCheckout(reserva,fecha);
    }

}
