package edu.fiuba.algo3.Vista.Botones;

import edu.fiuba.algo3.Controlador.ControllerFXML.*;
import edu.fiuba.algo3.Controlador.OtrosHandlers.RUTAS_FXML;
import edu.fiuba.algo3.modelo.ID_RAZA;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.Juego.Jugador;
import edu.fiuba.algo3.modelo.Raza.RazaProtoss;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class BotonTierra extends BotonCeldaTablero {

    public BotonTierra(int TAMANIO, Ubicacion ubicacion,VBox vBoxMenu, GridPane tablero, JuegoModelo juegoModelo) {
        super(TAMANIO, "images/tierra.png", ubicacion,vBoxMenu,tablero,juegoModelo,RUTAS_FXML.MENU_TIERRA_PROTOSS,RUTAS_FXML.MENU_VACIO);
    }

    public BotonTierra(BotonCeldaTablero botonCeldaTablero) {
        super(botonCeldaTablero, "images/tierra.png",RUTAS_FXML.MENU_TIERRA_PROTOSS,RUTAS_FXML.MENU_VACIO);
    }

    @Override
    public void setElmentsController() {
        Jugador jugadorActivo = juegoModelo.getJugadorActivo();
        ID_RAZA razaActiva = jugadorActivo.getRaza().getEntidad();
        if(razaActiva.equals(ID_RAZA.PROTOSS)){
            MenuTierraProtossController controller = vistaMenu.getController();
            controller.setElements(this.tablero,ubicacion,(RazaProtoss) jugadorActivo.getRaza(),this, juegoModelo.getMapa());
        } // Zerg menu vacio
    }


}
