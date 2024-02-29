package org.iesalandalus.programacion.reservashotel.vista;

public enum Opcion {

    SALIR("Salir"),
    INSERTAR_HUESPED("Inserte un huésped."),
    BUSCAR_HUESPED("Busca huésped."),
    BORRAR_HUESPED("Borra huésped."),
    MOSTRAR_HUESPEDES("Muestra huésped."),
    INSERTAR_HABITACION("Inserta habitación."),
    BUSCAR_HABITACION("Busca habitación."),
    BORRAR_HABITACION("Borra habitación."),
    MOSTRAR_HABITACIONES("Muestra habitaciones."),
    INSERTAR_RESERVA("Inserta reserva."),
    ANULAR_RESERVA("Anula reserva."),
    MOSTRAR_RESERVAS("Muestra reserva."),
    LISTAR_RESERVAS_HUESPED("Lista las reservas de un huésped"),
    LISTAR_RESERVAS_TIPO_HABITACION("Lista reservas por tipo de habitación"),
    CONSULTAR_DISPONIBILIDAD("Consulta disponibilidad."),
    REALIZAR_CHECKIN("Realiza el CheckIn"),
    REALIZAR_CHECKOUT("Realiza el CheckOut");

    private  String mensajeAMostrar;
    private Opcion(String mensajeAMostrar){
        this.mensajeAMostrar=mensajeAMostrar;
    }




    private static Opcion getOpcionSegunOrdinal(int ordinal) {
        if ((ordinal >= 0 && ordinal <= values().length - 1))
            return values()[ordinal];
        else
            throw new IllegalArgumentException("Ordinal de la opción no válida");
    }

    static setVista(Vista vista){

        vista=vista;
    }

    @Override
    public String toString() {
        return String.format("%d.- %s", ordinal(), mensajeAMostrar);
    }
}
