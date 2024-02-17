package org.iesalandalus.programacion.reservashotel.vista;

public enum Opcion {

    SALIR("Salir"),
    INSERTAR_HUESPED("Inserte un hu�sped."),
    BUSCAR_HUESPED("Busca hu�sped."),
    BORRAR_HUESPED("Borra hu�sped."),
    MOSTRAR_HUESPEDES("Muestra hu�sped."),
    INSERTAR_HABITACION("Inserta habitaci�n."),
    BUSCAR_HABITACION("Busca habitaci�n."),
    BORRAR_HABITACION("Borra habitaci�n."),
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
            throw new IllegalArgumentException("Ordinal de la opci�n no v�lida");
    }
    @Override
    public String toString() {
        return String.format("%d.- %s", ordinal(), mensajeAMostrar);
    }
}
