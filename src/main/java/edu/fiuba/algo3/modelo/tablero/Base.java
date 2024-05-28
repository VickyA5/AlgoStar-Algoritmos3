package edu.fiuba.algo3.modelo.tablero;

import java.util.HashMap;

public class Base {
    private  Integer factor;
    private HashMap<Integer,Mapa> mapas;

    public Base() {
        factor = (int) (Math.random()*3) + 1;
        inicializarHasMap();
    }

    public Base(int factor) {
        this.factor = factor;
        inicializarHasMap();
    }

    private void inicializarHasMap(){
        mapas = new HashMap<>();
        mapas.put(1,new Mapa(9,9)); // como va del 0 al 9 -> son 10 posiciones
        mapas.put(2,new Mapa(14,14)); // idem
        mapas.put(3,new Mapa(17,17)); // idem
    }


    public Mapa getMapa(){
        return mapas.get(factor);
    }
}
