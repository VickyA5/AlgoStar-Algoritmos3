package edu.fiuba.algo3.Vista.Botones.Unidades;

import edu.fiuba.algo3.Controlador.OtrosHandlers.RUTAS_FXML;
import edu.fiuba.algo3.Vista.Botones.BotonCeldaTablero;


public abstract class BotonUnidad extends BotonCeldaTablero {
    private BotonCeldaTablero botonSuperficie;

    public BotonUnidad(BotonCeldaTablero botonSuperficie, String rutaImagen, RUTAS_FXML menuParaProtoss, RUTAS_FXML menuParaZerg){
        super(botonSuperficie,rutaImagen,menuParaProtoss,menuParaZerg);
        this.botonSuperficie = botonSuperficie;
        if(botonSuperficie instanceof BotonUnidad){
            this.botonSuperficie = ((BotonUnidad) botonSuperficie).botonSuperficie;
        }
    }

    //Para evooluciones
    public BotonUnidad(BotonUnidad botonUnidad, String rutaImagen, RUTAS_FXML menuParaProtoss, RUTAS_FXML menuParaZerg){
        super(botonUnidad,rutaImagen,menuParaProtoss,menuParaZerg);
        this.botonSuperficie = botonUnidad.botonSuperficie;
    }

    public void colocarSuperficie(){
        this.borrarBotonDelTablero();
        juegoModelo.subscribirseJugadorActivo(botonSuperficie);
        botonSuperficie.actualizar(juegoModelo.getJugadorActivo());
        tablero.add(botonSuperficie,ubicacion.coordenada().horizontal(),ubicacion.coordenada().vertical());
    }

}
