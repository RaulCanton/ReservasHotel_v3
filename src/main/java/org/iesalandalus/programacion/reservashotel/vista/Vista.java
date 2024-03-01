package org.iesalandalus.programacion.reservashotel.vista;

import org.iesalandalus.programacion.reservashotel.Controlador.Controlador;
import org.iesalandalus.programacion.reservashotel.Modelo.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.Modelo.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.Modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.Modelo.dominio.TipoHabitacion;
import org.iesalandalus.programacion.utilidades.Entrada;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Vista {

    private Controlador controlador;
    public Vista(){


    }
    public void setControlador(Controlador controlador) {
        if (controlador == null) {
            throw new NullPointerException("ERROR: El controlador no puede ser nulo.");
        }
        this.controlador = controlador;
        Opcion.setVista(this);
    }
    public void comenzar(){
        Opcion opcion;
        do {

            Consola.mostrarMenu();
            opcion=Consola.elegirOpcion();
            ejecutarOpcion(opcion);
        }while (opcion !=Opcion.SALIR);

    }

    public void terminar(){
        System.out.println("El programa ha terminado.");;
    }

    private void ejecutarOpcion(Opcion opcion){

            opcion.ejecutar();
    }

    public void insertarHuesped(){
        try {
            Huesped huesped = Consola.leerHuesped();
            controlador.insertar(huesped);

        } catch (OperationNotSupportedException e){
            System.out.println("No se puede insertar el cliente.");

        }

    }


    public void buscarHuesped() {

       controlador.getReservas(Consola.getHuespedPorDni());

    }

    public void borrarHuesped(){

        Huesped huesped=new Huesped(Consola.getHuespedPorDni());
    try {
        controlador.borrar(huesped);
    }catch (OperationNotSupportedException e){
        System.out.println("No se pudo realizar la acci�n deseada.");
    }catch (NullPointerException e){
        System.out.println("Datos nulos.");
    }catch (IllegalArgumentException e){
        System.out.println("ERROR: Par�metro no valido");
    }

    }
    public void mostrarHuespedes() {
            List<Huesped> muestraHuespedes = controlador.getHuespedes();

            if (muestraHuespedes.size() > 0) {
                Comparator<Huesped> comparadorNombre =
                        Comparator.comparing(Huesped::getNombre);
                Collections.sort(muestraHuespedes,comparadorNombre);

                for (Huesped huesped : muestraHuespedes) {
                    System.out.println("Listado de hu�spedes:");
                    System.out.println(huesped);
                }
            } else {
                    throw new IllegalArgumentException("No hay hu�spedes que mostrar.");
                }
    }
    public void insertarHabitacion(){
        try {
            Habitacion habitacion1 = Consola.leerHabitacion();
            controlador.insertar(habitacion1);

        } catch (OperationNotSupportedException e){
            System.out.println("No se puede insertar la habitaci�n.");
        }catch (NullPointerException e){
            System.out.println("Datos nulos.");
        }catch (IllegalArgumentException e){
            System.out.println("ERROR: Par�metro no valido");
        }

    }

    public void buscarHabitacion() {
        controlador.buscar(Consola.leerHabitacionPorIdentificador());

    }

    public void borrarHabitacion(){
        try {
            controlador.borrar(Consola.leerHabitacionPorIdentificador());
            System.out.println("Se ha borrado la habitaci�n.");

        }catch (OperationNotSupportedException e){
            System.out.println("No se puede borrar la habitaci�n.");
        }catch (NullPointerException e){
            System.out.println("Datos nulos.");
        }catch (IllegalArgumentException e){
            System.out.println("ERROR: Par�metro no valido");
        }
    }

    public void mostrarHabitaciones() {
        List<Habitacion> muestraHabitaciones = controlador.getHabitaciones();
        if (muestraHabitaciones.size() > 0) {
            Comparator<Habitacion> comparadorPlantaYPuerta =
                    Comparator.comparing(Habitacion::getPlanta)
                    .thenComparing(Habitacion::getPuerta);

            Collections.sort(muestraHabitaciones, comparadorPlantaYPuerta);

            for (Habitacion habitacion : muestraHabitaciones) {
                System.out.println("Listado de habitaciones:");
                System.out.println(habitacion);
            }
        } else {
            throw new IllegalArgumentException ("No hay habitaciones que mostrar.");
        }
    }

    public void insertarReserva(){

        try {
            controlador.insertar(Consola.leerReserva());

        } catch (OperationNotSupportedException e) {
            System.out.println("No se puede crear la reserva");
        }catch (NullPointerException e){
            System.out.println("Datos nulos.");
        }catch (IllegalArgumentException e){
            System.out.println("ERROR: Par�metro no valido");
        }
    }

    public void mostrarReservaHuesped(){
        listarReservas(Consola.getHuespedPorDni());

    }

    public void listarReservas(Huesped huesped) {


        List<Reserva> reservaHuesped = controlador.getReservas(huesped);

        Comparator<Reserva> comparadorHuesped=
                Comparator.comparing(Reserva::getFechaInicioReserva).reversed();

        comparadorHuesped = comparadorHuesped
                .thenComparing(Comparator.comparing(reserva -> reserva.getHabitacion().getPlanta()))
                .thenComparing(Comparator.comparing(reserva -> reserva.getHabitacion().getPuerta()));

        Collections.sort(reservaHuesped, comparadorHuesped);

        if (reservaHuesped.size() > 0) {


            for (Reserva reserva : reservaHuesped) {
                System.out.println("Las reservas para el hu�sped " + huesped + " son " + reserva);
            }
        } else {
            System.out.println("Este hu�sped no tiene n�nguna reserva.");
        }
    }

    public void mostrarReservasTipoHabitacion(){

       // listarReservas(Consola.leerHabitacionPorIdentificador());
    }

    public void comprobarDisponibilidad(){
        consultarDisponibilidad(Consola.leerTipoHabitacion(),Consola.leerFecha("Introduce fecha de inicio"),
                Consola.leerFecha("Introduce la fecha de fin."));

    }


    public void listarReservas(TipoHabitacion tipoHabitacion){

        List<Reserva> reservaTipoHabitacion=controlador.getResevas(tipoHabitacion);
        if (reservaTipoHabitacion.size()>0) {

            Comparator<Reserva>comparadorTipoHabitacion=
                    Comparator.comparing(Reserva::getFechaInicioReserva).reversed();

           comparadorTipoHabitacion = comparadorTipoHabitacion
             .thenComparing(Comparator.comparing(reserva -> reserva.getHuesped().getNombre()));


            Collections.sort(reservaTipoHabitacion,comparadorTipoHabitacion);

            for( Reserva reserva:reservaTipoHabitacion) {
                System.out.println("Las reservas para el tipo de habitaci�n " + tipoHabitacion + " son " + reservaTipoHabitacion);
            }
        } else {
            System.out.println("Este tipo de habitaci�n no tiene n�nguna reserva.");
        }
    }


    public void mostrarReservas() {
        List<Reserva> muestraReserva = controlador.getReservas();
        if (muestraReserva.size() > 0) {
            Comparator<Reserva> comparadorReserva=
                    Comparator.comparing(Reserva::getFechaInicioReserva).reversed();
            comparadorReserva = comparadorReserva
                    .thenComparing(Comparator.comparing(reserva -> reserva.getHabitacion().getPlanta()))
                    .thenComparing(Comparator.comparing(reserva -> reserva.getHabitacion().getPuerta()));

            Collections.sort(muestraReserva,comparadorReserva);

            System.out.println("Listado de habitaciones:");
            for (Reserva reserva : muestraReserva) {
                System.out.println(reserva);
            }
        } else {
            throw new IllegalArgumentException ("No hay reservas que mostrar.");
        }
    }
    public void anularReserva() {

        Huesped huesped=new Huesped(Consola.getHuespedPorDni());

        List<Reserva> reservasHuesped = getReservasAnulables(controlador.getReservas(huesped));

        if (reservasHuesped.isEmpty()) {
            System.out.println("El hu�sped no tiene reservas anulables.");
        } else if (reservasHuesped.size() == 1) {
            // Si solo tiene una reserva anulable, confirmar la anulaci�n
            System.out.println("El hu�sped tiene una reserva anulable:");
            getReservasAnulables(controlador.getReservas(huesped));
            System.out.print("�Quieres anular esta reserva? (S/N): ");
            char respuesta = Entrada.caracter();
            if (respuesta == 'S' || respuesta == 's') {
                reservasHuesped.remove(1);
                System.out.println("Reserva anulada.");
            } else {
                System.out.println("No se ha anulado la reserva.");
            }
        } else {
            System.out.println("Se encontraron varias reservas anulables:");
            for (int i = 0; i < reservasHuesped.size(); i++) {
                System.out.println((i + 1) + ". ");
                getReservasAnulables(controlador.getReservas(huesped));
            }

            System.out.print("Introduce el n�mero de la reserva que deseas anular: ");
            int opcion = Entrada.entero();

            if (opcion >= 1 && opcion <= reservasHuesped.size()) {
                reservasHuesped.remove(reservasHuesped.get(opcion - 1));
                System.out.println("Reserva anulada.");
            } else {
                System.out.println("No se ha anulado la reserva.");
            }
        }

    }

    public List<Reserva> getReservasAnulables(List<Reserva>reservasAAnular) {

        if (reservasAAnular == null) {
            throw new NullPointerException("ERROR: La lista de reservas no puede ser nula.");
        }

        List<Reserva> reservasAnulables = new ArrayList<>();

        for (Reserva reserva : reservasAAnular) {
            if (reserva.getFechaInicioReserva().isAfter(LocalDate.now())) {
                reservasAnulables.add(new Reserva(reserva));
            }
        }

        return reservasAnulables;
    }


    public Habitacion consultarDisponibilidad (TipoHabitacion tipoHabitacion,LocalDate fechaInicioReserva,LocalDate fechaFinReserva) {
        if (tipoHabitacion == null || fechaInicioReserva == null || fechaFinReserva == null) {
            throw new NullPointerException("ERROR: Los par�metros no pueden ser nulos.");
        }

        if (fechaInicioReserva.isAfter(fechaFinReserva)) {
            throw new IllegalArgumentException("ERROR: La fecha de inicio no puede ser posterior a la fecha de fin.");
        }

        List<Reserva> reservasTipoHabitacion = controlador.getResevas(tipoHabitacion);

        for (Reserva reserva : reservasTipoHabitacion) {
            LocalDate inicioReserva = reserva.getFechaInicioReserva();
            LocalDate finReserva = reserva.getFechaFinReserva();

            if ((fechaFinReserva.isAfter(finReserva) || fechaInicioReserva.isEqual(finReserva)) &&
                    (fechaFinReserva.isBefore(inicioReserva) || fechaFinReserva.isEqual(inicioReserva))) {

                return reserva.getHabitacion();
            }
        }

        return null;

    }

    public void realizarCheckIn(){
        try {

            Huesped huesped=new Huesped(Consola.getHuespedPorDni());
            List<Reserva> reservasHuesped = controlador.getReservas(huesped);

            if (reservasHuesped.isEmpty()) {
                System.out.println("El hu�sped no tiene reservas para realizar el checkin.");
            } else {
                System.out.println("Reservas del hu�sped:");
                controlador.getReservas(huesped);

                System.out.print("Introduce el n�mero de la reserva para realizar el checkin: ");
                int opcion = Entrada.entero();

                if (opcion >= 1 && opcion <= reservasHuesped.size()) {

                    Reserva reservaSeleccionada = reservasHuesped.get(opcion - 1);
                    LocalDate fechaCheckin = LocalDate.now();
                    controlador.realizarCheckIn(reservaSeleccionada, fechaCheckin.atStartOfDay());
                    System.out.println("Se ha hecho el CheckIn.");
                } else {
                    System.out.println("La reserva introducida no es valida..");
                }
            }
        } catch (OperationNotSupportedException e) {
            System.out.println("Error al realizar el checkin: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Datos nulos.");
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: Par�metro no v�lido");
        }
    }


    public void realizarCheckOut(){

        try {
        Huesped huesped=new Huesped(Consola.getHuespedPorDni());
        List<Reserva> reservasHuesped = controlador.getReservas(huesped);

        if (reservasHuesped.isEmpty()) {
            System.out.println("El hu�sped no tiene reservas para realizar el checkOut.");
        } else {

            System.out.println("Reservas del hu�sped:");
            controlador.getReservas(huesped);

            System.out.print("Introduce el n�mero de la reserva para realizar el checkOut: ");
            int opcion = Entrada.entero();

            if (opcion >= 1 && opcion <= reservasHuesped.size()) {

                Reserva reservaSeleccionada = reservasHuesped.get(opcion - 1);
                if (reservaSeleccionada.getCheckIn() == null) {
                    System.out.println("ERROR: Primero debe realizar el check-in antes de hacer el check-out.");
                } else {
                    LocalDate fechaCheckOut = LocalDate.now();
                    controlador.realizarCheckOut(reservaSeleccionada, fechaCheckOut.atStartOfDay());
                    System.out.println("Se ha hecho el Checkout.");
                }
            }else{
                    System.out.println("La reserva introducida no es valida..");
                }
        }
    } catch (OperationNotSupportedException e) {
        System.out.println("Error al realizar el checkin: " + e.getMessage());
    } catch (NullPointerException e) {
        System.out.println("Datos nulos.");
    } catch (IllegalArgumentException e) {
        System.out.println("ERROR: Par�metro no v�lido");
    }
    }

}
