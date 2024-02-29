package org.iesalandalus.programacion.reservashotel.Modelo.dominio;

public class Simple extends Habitacion{

    private static final int NUM_MAXIMO_PERSONAS=1;

    public Simple(int planta, int puerta, double precio,String identificador) {
        super(planta, puerta, precio);
    }

    public Simple(Simple habitacionSimple) {
        super(habitacionSimple.getPlanta(), habitacionSimple.getPuerta(), habitacionSimple.getPrecio());
    }

    @Override
    public int getNumeroMaximoPersonas() {
        return NUM_MAXIMO_PERSONAS;
    }

    public String toString(){
        return String.format("identificador=%s (%d-%d), precio habitación=%s, habitación simple, capacidad=%d personas",
                getIdentificador(),getPlanta(),getPuerta(),getPrecio(),getNumeroMaximoPersonas());
    }

}
