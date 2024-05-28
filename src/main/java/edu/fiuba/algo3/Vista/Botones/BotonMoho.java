package edu.fiuba.algo3.Vista.Botones;

import edu.fiuba.algo3.Controlador.OtrosHandlers.RUTAS_FXML;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class BotonMoho extends BotonCeldaTablero {

    public BotonMoho(BotonCeldaTablero botonCeldaTablero) {
        super(botonCeldaTablero, "images/moho.png",RUTAS_FXML.MENU_VACIO,RUTAS_FXML.MENU_VACIO);
        juegoModelo.subscribirseJugadorActivo(this);
    }

    public BotonMoho(int TAMANIO, Ubicacion ubicacion, VBox vBoxMenu, GridPane tablero, JuegoModelo juegoModelo) {
        super(TAMANIO, "images/moho.png", ubicacion,vBoxMenu,tablero,juegoModelo,RUTAS_FXML.MENU_VACIO,RUTAS_FXML.MENU_VACIO);
    }

    @Override
    public void setElmentsController() {
        //Es menu vacio en ambos
    }


}
