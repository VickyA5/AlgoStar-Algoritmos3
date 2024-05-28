package edu.fiuba.algo3.modelo.Juego;


import edu.fiuba.algo3.modelo.Raza.Raza;

import java.util.Objects;


public class Jugador {
    private String nombre;
    private  String  color;
    private Raza raza;

    public Jugador(String nombre, String color, Raza raza){
        if(nombre.length() < 6) throw new JugadorNombreError();
        this.nombre = nombre;
        this.color = color;
        this.raza = raza;
    }


    public void compatibleCon(Jugador jugador) {
        if(Objects.equals(jugador.nombre, nombre)) throw  new JugadorMismoNombreError();
        if(Objects.equals(jugador.color, color)) throw new JugadorMismoColorError();
        if(jugador.raza.getClass() == raza.getClass()) throw new JugadorMismaRazaError();
    }
    public String getNombre(){
        return nombre;
    }

    public Raza getRaza(){
        return raza;
    }
}
