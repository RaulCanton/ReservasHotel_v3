package org.iesalandalus.programacion.reservashotel.Modelo.negocio;

import org.iesalandalus.programacion.reservashotel.Modelo.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.Modelo.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.Modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.Modelo.dominio.TipoHabitacion;
import org.iesalandalus.programacion.utilidades.Entrada;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reservas {

    private List<Reserva> coleccionReserva;



    public Reservas ()         {
         coleccionReserva= new ArrayList<>();
    }

    public List <Reserva> get(){
        return copiaProfundaReserva(coleccionReserva);
    }
    private List <Reserva> copiaProfundaReserva(List <Reserva> reserv){
        List <Reserva> otrasReserva = new ArrayList<>();
        for (Reserva reserva : reserv){
            otrasReserva.add(new Reserva(reserva));
        }
        return otrasReserva;
    }
    public int getTamano() {
        return coleccionReserva.size();
    }

    public void insertar (Reserva reserva) throws OperationNotSupportedException {
        if (reserva == null) {
            throw new NullPointerException("ERROR: No se puede insertar una reserva nula.");
        }
        if (!coleccionReserva.contains(reserva)){
            coleccionReserva.add(new Reserva(reserva));
        }else {
            throw new OperationNotSupportedException("ERROR:Y existe una reserva con esos datos.");
        }
    }

    public Reserva buscar (Reserva reserva){
        Reserva reservaEncontrada=null;
        if (reserva == null) {
            throw new NullPointerException("ERROR: No se puede buscar un huésped nulo.");
        }

        if (coleccionReserva.contains(reserva)){
            reservaEncontrada= new Reserva(coleccionReserva.get(coleccionReserva.indexOf(reserva)));
        }
          return reservaEncontrada;
    }



    public void borrar (Reserva reserva) throws OperationNotSupportedException {
        if (reserva == null) {
            throw new NullPointerException("ERROR: No se puede borrar una reserva nula.");
        }

        if (coleccionReserva.contains(reserva)){
            coleccionReserva.remove(reserva);
        } else {
            throw new OperationNotSupportedException("ERROR:No existe ningúna reserva con ese nombre.");
        }
    }


    public List <Reserva> getReservas (Huesped huesped){
        if (huesped == null) {
            throw new NullPointerException("ERROR: No se pueden buscar reservas de un huésped nulo.");
        }
        List <Reserva> reservasHuesped = new ArrayList<>();

        for (Reserva reserva : coleccionReserva) {
            if (reserva.getHuesped().equals(huesped)) {
                reservasHuesped.add(new Reserva(reserva));
            }
        }
        return reservasHuesped;

    }
    public List<Reserva> getReservas(TipoHabitacion tipoHabitacion){
        if (tipoHabitacion == null) {
            throw new NullPointerException("ERROR: No se pueden buscar reservas de un aula nula.");
        }
        List <Reserva> reservasTipoHabitacion = new ArrayList<>();

        for (Reserva reserva : coleccionReserva) {
            if (reserva.getHabitacion().equals(tipoHabitacion)) {
                reservasTipoHabitacion.add(new Reserva(reserva));
            }
        }
        return reservasTipoHabitacion;
    }
    public List<Reserva> getReservasFuturas (Habitacion habitacion){
        if (habitacion == null) {
            throw new NullPointerException("ERROR: No se pueden buscar reservas de una habitación nula.");
        }
        List<Reserva> reservasHabitacion = new ArrayList<>();

        for (Reserva reserva : reservasHabitacion) {
            if (reserva.getHabitacion().equals(habitacion)
            && reserva.getFechaInicioReserva().isAfter(LocalDate.now())) {
                reservasHabitacion.add(new Reserva(reserva));
            }
        }
        return reservasHabitacion;
    }

    public void realizarCheckin (Reserva reserva, LocalDate fecha)throws OperationNotSupportedException{
        if (reserva == null) {
            throw new NullPointerException("ERROR: La reserva no puede ser nula.");
        }

        System.out.print("Introduce la fecha de checkIn.");
        String fechaCheckIn= Entrada.cadena();
        fecha=LocalDate.parse(fechaCheckIn);
        reserva.setCheckIn(fecha);
    }
    public void realizarCheckout (Reserva reserva, LocalDate fecha)throws OperationNotSupportedException{
        if (reserva == null) {
            throw new NullPointerException("ERROR: La reserva no puede ser nula.");
        }

        System.out.print("Introduce la fecha de checkOut.");
        String fechaCheckOut= Entrada.cadena();
        fecha=LocalDate.parse(fechaCheckOut);
        reserva.setCheckOut(fecha);
    }
}
