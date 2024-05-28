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



public class BotonRecursoVolcan extends BotonCeldaTablero {

    public BotonRecursoVolcan(int TAMANIO, Ubicacion ubicacion, VBox vBoxMenu, GridPane tablero, JuegoModelo juegoModelo) {
        super(TAMANIO, "images/Volcan.png", ubicacion,vBoxMenu,tablero,juegoModelo,RUTAS_FXML.MENU_VOLCAN_PROTOSS,RUTAS_FXML.MENU_VACIO);
    }

    @Override
    public void setElmentsController() {
        Jugador jugadorActivo = juegoModelo.getJugadorActivo();
        ID_RAZA razaActiva = jugadorActivo.getRaza().getEntidad();
        if(razaActiva.equals(ID_RAZA.PROTOSS)){
            MenuVolcanProtossController controller = vistaMenu.getController();
            controller.setElements(tablero,ubicacion,(RazaProtoss) jugadorActivo.getRaza(),this);
        }else{

        }
    }
}

