package edu.fiuba.algo3.modelo.UnidadesRecurso;

import edu.fiuba.algo3.modelo.Raza.PoblacionExedidaError;

public class Poblacion {
    private int capcaidadMaxima;
    private int capacidadInstalada;

    private int poblacion;

    public Poblacion(int max){
        capcaidadMaxima = max;
        capacidadInstalada = 0;
        poblacion = 0;
    }

    public void aumentarCapacidad(int cap){
        capacidadInstalada = capacidadInstalada + cap;
    }
    public void disminuirCapacidad(int cap) {
        capacidadInstalada = capacidadInstalada - cap;
    }
    public void aumentarPoblacion(int pob){
        if(poblacion + pob <= capacidadReal())
            poblacion = poblacion + pob;
        else{
            throw new PoblacionExedidaError();
        }
    }
    public void disminuirPoblacion(int pob){
        if( poblacion - pob < 0){
            poblacion = 0;
        }
        else {
            poblacion = poblacion - pob;
        }
    }

    public int capacidadReal(){
        return Math.min(capcaidadMaxima, capacidadInstalada);
    }

    public int obtenerPoblacion(){
        return poblacion;
    }
}
