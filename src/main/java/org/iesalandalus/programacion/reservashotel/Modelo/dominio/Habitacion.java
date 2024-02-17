package org.iesalandalus.programacion.reservashotel.Modelo.dominio;

import java.util.Objects;

public class Habitacion {

    public static final double MIN_PRECIO_HABITACION= 40;
    public static final double MAX_PRECIO_HABITACION = 150;
    public static final int MIN_NUMERO_PUERTA=0;
    public static final int MAX_NUMERO_PUERTA=14;
    public static final int MIN_NUMERO_PLANTA=1;
    public static final int MAX_NUMERO_PLANTA=3;

    private String identificador;
    private int planta;
    private int puerta;
    private double precio;
    private TipoHabitacion tipoHabitacion;


    public Habitacion(int planta, int puerta, double precio, TipoHabitacion tipoHabitacion,String identificador){


        setPlanta(planta);
        setPrecio(precio);
        setPuerta(puerta);
        setTipoHabitacion(tipoHabitacion);
        setIdentificador(String.format("%d%d",getPlanta(),getPuerta()));
    }

    public Habitacion(Habitacion habitacion){

        if (habitacion==null) {
            throw new NullPointerException("ERROR: No es posible copiar una habitación nula.");
        }
        setPlanta(habitacion.getPlanta());
        setPrecio(habitacion.getPrecio());
        setPuerta(habitacion.getPuerta());
        setTipoHabitacion(habitacion.getTipoHabitacion());
        setIdentificador(habitacion.getIdentificador());
    }


    public String getIdentificador(){
       return identificador;
    }
    public void setIdentificador(String identificador){
        if (identificador==null){
            throw new IllegalArgumentException("El identificador no es correcto.");
        }
      this.identificador=identificador;
    }

    public int getPlanta(){
        return planta;
    }

    private void setPlanta(int planta){

        if (planta<MIN_NUMERO_PLANTA || planta>MAX_NUMERO_PLANTA){
            throw new IllegalArgumentException("ERROR: No se puede establecer como planta de una habitación un valor menor que 1 ni mayor que 3.");
        }
        else {
            this.planta = planta;
        }
    }

    public int getPuerta(){
        return puerta;
    }

    private void setPuerta(int puerta) {

        if (puerta < MIN_NUMERO_PUERTA || puerta > MAX_NUMERO_PUERTA) {
            throw new IllegalArgumentException("ERROR: No se puede establecer como puerta de una habitación un valor menor que 0 ni mayor que 14.");
        }
            this.puerta = puerta;
    }

    public double getPrecio(){
        return precio;
    }

    public void setPrecio(double precio) {

            if (precio < MIN_PRECIO_HABITACION || precio > MAX_PRECIO_HABITACION) {
                throw new IllegalArgumentException("ERROR: No se puede establecer como precio de una habitación un valor menor que 40.0 ni mayor que 150.0.");
            }
        this.precio=precio;
    }

    public TipoHabitacion getTipoHabitacion(){
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion){
        Objects.requireNonNull(tipoHabitacion,"ERROR: No se puede establecer un tipo de habitación nula.");
        this.tipoHabitacion=tipoHabitacion;


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habitacion that = (Habitacion) o;
        return Objects.equals(identificador, that.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

    public String toString (){
        return String.format("identificador=%s (%d-%d), precio habitación=%s, tipo habitación=%s",
                getIdentificador(),getPlanta(), getPuerta(), getPrecio(), getTipoHabitacion());
    }

}


