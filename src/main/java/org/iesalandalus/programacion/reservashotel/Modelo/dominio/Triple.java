package org.iesalandalus.programacion.reservashotel.Modelo.dominio;

public class Triple extends Habitacion {

    private static final int NUM_MAXIMO_PERSONAS=3;
    static final int MIN_NUM_BANOS=1;
    static final int MAX_NUM_BANOS=2;

    static final int MIN_NUM_CAMAS_INDIVIDUALES=2;
    static final int MAX_NUM_CAMAS_INDIVIDUALES=3;
    static final int MIN_NUM_CAMAS_DOBLES=1;
    static final int MAX_NUM_CAMAS_DOBLES=1;

    private int numBanos;
    private int numCamasIndividuales;
    private int numCamasDobles;

    public Triple(int planta, int puerta, double precio, int numBanos, int numCamasIndividuales, int numCamasDobles) {
        super(planta, puerta, precio);
        this.numBanos = numBanos;
        this.numCamasIndividuales = numCamasIndividuales;
        this.numCamasDobles = numCamasDobles;
    }

    public Triple(Habitacion habitacionTriple) {
        super(habitacionTriple.getPlanta(), habitacionTriple.getPuerta(), habitacionTriple.getPrecio());
        getNumBanos();
        getNumCamasIndividuales();
        getNumCamasDobles();
    }

    public int getNumBanos() {
        return numBanos;
    }

    public void setNumBanos(int numBanos) {
        this.numBanos = numBanos;
    }

    public int getNumCamasIndividuales() {
        return numCamasIndividuales;
    }

    public void setNumCamasIndividuales(int numCamasIndividuales) {
        this.numCamasIndividuales = numCamasIndividuales;
    }

    public int getNumCamasDobles() {
        return numCamasDobles;
    }

    public void setNumCamasDobles(int numCamasDobles) {
        this.numCamasDobles = numCamasDobles;
    }

    private void validaNumCamas(){
        if(!((numCamasIndividuales==2 && numCamasDobles==1)|| (numCamasIndividuales==3))){
            throw new IllegalArgumentException("El número de camas elegido no es correcto.");
        }

    }
    @Override
    protected int getNumeroMaximoPersonas() {
        return NUM_MAXIMO_PERSONAS;
    }

    @Override
    public String toString() {
        return String.format("identificador=%s (%d-%d), precio habitación=%s, habitación triple, capacidad=%d personas, " +
                        "baños=%d, camas individuales=%d, camas dobles=%d",
                getIdentificador(), getPlanta(), getPuerta(), getPrecio(),
                getNumeroMaximoPersonas(),getNumBanos(),getNumCamasIndividuales(),getNumCamasDobles());
    }
}
