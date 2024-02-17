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
    CONSULTAR_DISPONIBILIDAD("Consulta disponibilidad."),
    REALIZAR_CHECKIN("Realiza el Checin"),
    REALIZAR_CHECKOUT("Realiza el checkout");

    private  String mensajeAMostrar;
    private Opcion(String mensajeAMostrar){
        this.mensajeAMostrar=mensajeAMostrar;
    }




    public static Opcion getOpcionSegunOrdinal(int ordinal) {
        if ((ordinal >= 0 && ordinal <= values().length - 1))
            return values()[ordinal];
        else
            throw new IllegalArgumentException("Ordinal de la opción no válida");
    }
    @Override
    public String toString() {
        return String.format("%d.- %s", ordinal(), mensajeAMostrar);
    }
}
