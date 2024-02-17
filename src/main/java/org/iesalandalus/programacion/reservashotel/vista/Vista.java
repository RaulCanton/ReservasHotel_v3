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
    public Vista(){}
    public void setControlador(Controlador controlador) {
        if (controlador == null) {
            throw new NullPointerException("ERROR: El controlador no puede ser nulo.");
        }
        this.controlador = controlador;
    }
    public void comenzar(){

        do {

            Consola.mostrarMenu();
            ejecutarOpcion(Consola.elegirOpcion());
        }while (Consola.elegirOpcion() !=Opcion.SALIR);

    }

    public void terminar(){
        System.out.println("El programa ha terminado.");;
    }

    private void ejecutarOpcion(Opcion opcion){

        switch (opcion) {
            case SALIR:
                terminar();
                break;
            case INSERTAR_HUESPED:
                insertarHuesped();
                break;
            case BUSCAR_HUESPED:
                buscarHuesped();
                break;
            case BORRAR_HUESPED:
                borrarHuesped();
                break;
            case MOSTRAR_HUESPEDES:
                mostrarHuespedes();
                break;
            case INSERTAR_HABITACION:
                insertarHabitacion();
                break;
            case BUSCAR_HABITACION:
                buscarHabitacion();
                break;
            case BORRAR_HABITACION:
                borrarHabitacion();
                break;
            case MOSTRAR_HABITACIONES:
                mostrarHabitaciones();
                break;
            case INSERTAR_RESERVA:
                insertarReserva();
                break;
            case ANULAR_RESERVA:
                anularReserva();
                break;
            case MOSTRAR_RESERVAS:
                mostrarReservas();
                break;
            case CONSULTAR_DISPONIBILIDAD:
                //consultarDisponibilidad();
                break;
            case REALIZAR_CHECKIN:
                realizarCheckIn();
                break;
            case REALIZAR_CHECKOUT:
                realizarCheckOut();
                break;

        }

    }

    private void insertarHuesped(){
        try {
            Huesped huesped = Consola.leerHuesped();
            controlador.insertar(huesped);

        } catch (OperationNotSupportedException e){
            System.out.println("No se puede insertar el cliente.");

        }

    }


    private Huesped buscarHuesped() {

        Huesped huesped1;
        do {
            huesped1 = new Huesped(Consola.leerClientePorDni());
        } while (huesped1 == null);

        Huesped huesped2 = controlador.buscar(huesped1);

        return huesped2;

    }

    private void borrarHuesped(){

        Huesped huesped=new Huesped(Consola.leerClientePorDni());
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
    private void mostrarHuespedes() {
            List<Huesped> muestraHuespedes = controlador.getHuesped();

            if (muestraHuespedes.size() > 0) {
                Comparator<Huesped> comparadorNombre =
                        Comparator.comparing(Huesped::getNombre);
                Collections.sort(muestraHuespedes,comparadorNombre);

                for (Huesped huesped : muestraHuespedes) {
                    System.out.println("Listado de habitaciones:");
                    System.out.println(huesped);
                }
            } else {
                    throw new IllegalArgumentException("No hay hu�spedes que mostrar.");
                }
    }
    private void insertarHabitacion(){
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

    private Habitacion buscarHabitacion() {
        Habitacion habitacion1;
        do {
            habitacion1 = new Habitacion(Consola.leerHabitacionPorIdentificador());
        } while (habitacion1 == null);

        Habitacion habitacion2 = controlador.buscar(habitacion1);
        return habitacion2;

    }

    private void borrarHabitacion(){
        try {

            Habitacion habitacion1;
            do {
                habitacion1 = new Habitacion(Consola.leerHabitacionPorIdentificador());
            } while (habitacion1 == null);
            Habitacion habitacion2 = controlador.buscar(habitacion1);

            controlador.borrar(habitacion2);
            System.out.println("Se ha borrado la habitaci�n.");
        }catch (OperationNotSupportedException e){
            System.out.println("No se puede borrar la habitaci�n.");
        }catch (NullPointerException e){
            System.out.println("Datos nulos.");
        }catch (IllegalArgumentException e){
            System.out.println("ERROR: Par�metro no valido");
        }
    }

    private void mostrarHabitaciones() {
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

    private void insertarReserva(){

        try {
            Reserva reserva1 = Consola.leerReserva();
            controlador.insertar(reserva1);

        } catch (OperationNotSupportedException e) {
            System.out.println("No se puede crear la reserva");
        }catch (NullPointerException e){
            System.out.println("Datos nulos.");
        }catch (IllegalArgumentException e){
            System.out.println("ERROR: Par�metro no valido");
        }
    }

    private void listarReservas(Huesped huesped) {

        huesped = buscarHuesped();
        List<Reserva> reservaHuesped = controlador.getReservas(huesped);

        Comparator<Reserva> comparadorHuesped=
                Comparator.comparing(Reserva::getFechaInicioReserva).reversed();
        /*Comparator<Habitacion> comparadorPorPlantaYPuerta=
                Comparator.comparing(Habitacion::getPlanta)
                        .thenComparing(Habitacion::getPuerta);;*/
        Collections.sort(reservaHuesped,comparadorHuesped);

        if (reservaHuesped.size() > 0) {


            for (Reserva reserva : reservaHuesped) {
                System.out.println("Las reservas para el hu�sped " + huesped + " son " + reserva);
            }
        } else {
            System.out.println("Este hu�sped no tiene n�nguna reserva.");
        }
    }
    private void listarReservas(TipoHabitacion tipoHabitacion){
        tipoHabitacion=Consola.leerTipoHabitacion();
        List<Reserva> reservaTipoHabitacion=controlador.getReservas();
        if (reservaTipoHabitacion.size()>0) {

            Comparator<Reserva>comparadorTipoHabitacion=
                    Comparator.comparing(Reserva::getFechaInicioReserva);

           /*Comparator<Huesped> comparadorNombre =
                    Comparator.comparing(Huesped::getNombre);*/

            Collections.sort(reservaTipoHabitacion,comparadorTipoHabitacion);

            for( Reserva reserva:reservaTipoHabitacion) {
                System.out.println("Las reservas para el tipo de habitaci�n " + tipoHabitacion + " son " + reservaTipoHabitacion);
            }
        } else {
            System.out.println("Este tipo de habitaci�n no tiene n�nguna reserva.");
        }
    }


    private void mostrarReservas() {
        List<Reserva> muestraReserva = controlador.getReservas();
        if (muestraReserva.size() > 0) {
            Comparator<Reserva> comparadorReserva=
                    Comparator.comparing(Reserva::getFechaInicioReserva).reversed();
            /* Comparator<Habitacion> comparadorPlantaYPuerta =
                    Comparator.comparing(Habitacion::getPlanta)
                    .thenComparing(Habitacion::getPuerta);*/

            Collections.sort(muestraReserva,comparadorReserva);

            System.out.println("Listado de habitaciones:");
            for (Reserva reserva : muestraReserva) {
                System.out.println(reserva);
            }
        } else {
            throw new IllegalArgumentException ("No hay reservas que mostrar.");
        }
    }
    private void anularReserva() {

        Huesped huesped=new Huesped(Consola.leerClientePorDni());

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

    private List<Reserva> getReservasAnulables(List<Reserva>reservasAAnular) {

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


    private Habitacion consultarDisponibilidad (TipoHabitacion tipoHabitacion,LocalDate fechaInicioReserva,LocalDate fechaFinReserva) {
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

    private void realizarCheckIn(){
        try {

            Huesped huesped=new Huesped(Consola.leerClientePorDni());
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
                    controlador.realizarCheckIn(reservaSeleccionada, fechaCheckin);
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


    private void realizarCheckOut(){

        try {
        Huesped huesped=new Huesped(Consola.leerClientePorDni());
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
                    controlador.realizarCheckOut(reservaSeleccionada, fechaCheckOut);
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
