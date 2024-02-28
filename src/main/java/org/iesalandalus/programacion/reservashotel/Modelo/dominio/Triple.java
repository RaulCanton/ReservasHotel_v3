package org.iesalandalus.programacion.reservashotel.Modelo.dominio;

public class Triple extends Habitacion {

    private static final int NUM_MAXIMO_PERSONAS=3;
    final int MIN_NUM_BANOS=1;
    final int MAX_NUM_BANOS=2;

    final int MIN_NUM_CAMAS_INDIVIDUALES=2;
    final int MAX_NUM_CAMAS_INDIVIDUALES=3;
    final int MIN_NUM_CAMAS_DOBLES=1;
    final int MAX_NUM_CAMAS_DOBLES=1;

    private int numBanos;
    private int numCamasIndividuales;
    private int numCamasDobles;

    public Triple(int planta, int puerta, double precio, int numBanos, int numCamasIndividuales, int numCamasDobles) {
        super(planta, puerta, precio);
        setNumBanos(numBanos);
        setNumCamasIndividuales(numCamasIndividuales);
        setNumCamasDobles(numCamasDobles);
    }

    public Triple(Triple habitacionTriple) {
        super(habitacionTriple.getPlanta(), habitacionTriple.getPuerta(), habitacionTriple.getPrecio());
        setNumBanos(habitacionTriple.getNumBanos());
        setNumCamasIndividuales(habitacionTriple.getNumCamasIndividuales());
        setNumCamasDobles(getNumCamasDobles());
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
    public int getNumeroMaximoPersonas() {
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
