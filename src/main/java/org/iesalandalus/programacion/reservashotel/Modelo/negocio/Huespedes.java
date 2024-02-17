package org.iesalandalus.programacion.reservashotel.Modelo.negocio;

import org.iesalandalus.programacion.reservashotel.Modelo.dominio.Huesped;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class Huespedes {

    private List<Huesped> coleccionHuesped;


    public Huespedes () {
       coleccionHuesped = new ArrayList<>();
    }

    public List<Huesped> get(){
       return copiaProfundaHuesped(coleccionHuesped);
    }List<Huesped> copiaProfundaHuesped(List <Huesped> huespeds){

        List<Huesped> otrosHuesped = new ArrayList<>();
        for (Huesped huesped: huespeds){
            otrosHuesped.add(new Huesped(huesped));
        }
        return otrosHuesped;
    }
    public int getTamano() {
        return coleccionHuesped.size();
    }


    public void insertar (Huesped huesped) throws OperationNotSupportedException{
        if (huesped == null) {
            throw new NullPointerException("ERROR: No se puede insertar un huésped nulo.");
        }
        int indice=coleccionHuesped.indexOf(huesped);
        if (indice==-1){
            coleccionHuesped.add(new Huesped(huesped));
        } else {
            throw new OperationNotSupportedException("ERROR:Y existe un huésped con esos datos.");
        }
    }
    public Huesped buscar (Huesped huesped){
        Huesped huespedEncontrado= null;
        if (huesped == null) {
            throw new NullPointerException("ERROR: No se puede buscar un huésped nulo.");
        }

        if (coleccionHuesped.contains(huesped)){
            huespedEncontrado=new Huesped(coleccionHuesped.get(coleccionHuesped.indexOf(huesped)));
        }
            return huespedEncontrado;
    }

    public void borrar (Huesped huesped) throws OperationNotSupportedException {
        if (huesped == null) {
            throw new NullPointerException("ERROR: No se puede borrar un huésped nulo.");
        }

        if (coleccionHuesped.contains(huesped)) {
            coleccionHuesped.remove(huesped);
        } else {
            throw new OperationNotSupportedException("ERROR:No existe el huésped a borrar.");
        }
    }
}
