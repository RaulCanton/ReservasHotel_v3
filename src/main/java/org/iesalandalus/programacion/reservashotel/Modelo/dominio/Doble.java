package org.iesalandalus.programacion.reservashotel.Modelo.dominio;

public class Doble extends Habitacion{

    private static final int NUM_MAXIMO_PERSONAS=2;

    final int MIN_NUM_CAMAS_INDIVIDUALES=1;
    final int MAX_NUM_CAMAS_INDIVIDUALES=2;
    final int MIN_NUM_CAMAS_DOBLES=1;
    final int MAX_NUM_CAMAS_DOBLES=1;

    private int numCamasIndividuales;
    private int numCamasDobles;

    public Doble(int planta, int puerta, double precio,String identificador, int numCamasIndividuales,int numCamasDobles) {
        super(planta, puerta, precio);
        setNumCamasIndividuales(numCamasIndividuales);
        setNumCamasDobles(numCamasDobles);
    }

    public Doble(Doble habitacionDoble) {
        super(habitacionDoble.getPlanta(), habitacionDoble.getPuerta(), habitacionDoble.getPrecio());
        setNumCamasIndividuales(habitacionDoble.getNumCamasIndividuales());
        setNumCamasDobles(habitacionDoble.getNumCamasDobles());

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
        if(numCamasIndividuales !=2 && (numCamasDobles<1 || numCamasDobles>2)){
            throw new IllegalArgumentException("El número de camas elegido no es correcto.");
        }
    }

    @Override
    public int getNumeroMaximoPersonas() {
        return NUM_MAXIMO_PERSONAS;
    }

    @Override
    public String toString() {
        return String.format("identificador=%s (%d-%d), precio habitación=%s, habitación doble, capacidad=%d personas, " +
                        "camas individuales=%d, camas dobles=%d",
                getIdentificador(), getPlanta(), getPuerta(), getPrecio(),
                getNumeroMaximoPersonas(),getNumCamasIndividuales(),getNumCamasDobles());
    }
}
