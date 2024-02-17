package org.iesalandalus.programacion.reservashotel.Modelo.dominio;

public enum TipoHabitacion {

SUITE("SUITE",4),SIMPLE("SIMPLE",1),DOBLE("MEDIANA",2),TRIPLE("TRIPLE",3);

    String descripcion;
    int numeroMaximoPersonas;

    private String cadenaAMostrar;

    private TipoHabitacion(String descripcion,int numeroMaximoPersonas){
      this.descripcion=descripcion;
      this.numeroMaximoPersonas=numeroMaximoPersonas;
    }

    private TipoHabitacion(String cadenaAMostrar){
        this.cadenaAMostrar=cadenaAMostrar;
    }
    public int getNumeroMaximoPersonas(){return this.numeroMaximoPersonas;}
     public String toString(){
        return cadenaAMostrar;
    }
}



