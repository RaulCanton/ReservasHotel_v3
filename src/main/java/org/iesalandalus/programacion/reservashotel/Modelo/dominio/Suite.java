package org.iesalandalus.programacion.reservashotel.Modelo.dominio;

public class Suite extends Habitacion{
    private static final int NUM_MAXIMO_PERSONAS=4;
    static final int MIN_NUM_BANOS=1;
    static final int MAX_NUM_BANOS=2;

    private int numBanos;
    private boolean tieneJacuzzi;

    @Override
    protected int getNumeroMaximoPersonas() {
        return NUM_MAXIMO_PERSONAS;
    }

    public Suite(int planta, int puerta, double precio, int numBanos, boolean tieneJacuzzi) {
        super(planta, puerta, precio);
        this.numBanos = numBanos;
        this.tieneJacuzzi = tieneJacuzzi;
    }

    public Suite(Suite habitacionSuite){
        super(habitacionSuite.getPlanta(), habitacionSuite.getPuerta(), habitacionSuite.getPrecio());
        getNumBanos();
        isTieneJacuzzi();
    }

    public int getNumBanos() {
        return numBanos;
    }

    public void setNumBanos(int numBanos) {
        this.numBanos = numBanos;
    }

    public boolean isTieneJacuzzi() {
        return tieneJacuzzi;
    }

    public void setTieneJacuzzi(boolean tieneJacuzzi) {
        this.tieneJacuzzi = tieneJacuzzi;
    }

    public String toString(){
        return String.format("identificador=%s (%d-%d), precio habitación=%s, habitación suite, capacidad=%d personas, " +
                        "baños=%d, sin Jacuzzi",
                getIdentificador(), getPlanta(), getPuerta(), getPrecio(),
                getNumeroMaximoPersonas(),getNumBanos());
    }
}
