package edu.fiuba.algo3.Vista.Botones.Construcciones;

import edu.fiuba.algo3.Controlador.ControllerFXML.*;
import edu.fiuba.algo3.Controlador.OtrosHandlers.RUTAS_FXML;
import edu.fiuba.algo3.Vista.Botones.BotonCeldaTablero;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Criadero;
import edu.fiuba.algo3.modelo.ID_RAZA;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.Juego.Jugador;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import javafx.event.EventHandler;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

public class BotonCriadero extends BotonCeldaTablero {

    public BotonCriadero(int TAMANIO, Ubicacion ubicacion, VBox vBoxMenu, Jugador jugador, GridPane tablero , JuegoModelo juegoModelo) {
        super(TAMANIO,"images/criadero.png",ubicacion,vBoxMenu, tablero,juegoModelo, RUTAS_FXML.MENU_ATACAR_ENEMIGO,RUTAS_FXML.MENU_CRIADERO);
    }

    public BotonCriadero(BotonCeldaTablero botonACopiar){
        super(botonACopiar, "images/criadero.png", RUTAS_FXML.MENU_ATACAR_ENEMIGO,RUTAS_FXML.MENU_CRIADERO);
    }

    @Override
    public void setElmentsController() {
        Jugador jugadorActivo = juegoModelo.getJugadorActivo();
        ID_RAZA razaActiva = jugadorActivo.getRaza().getEntidad();
        Criadero criadero = (Criadero) ubicacion.getEdificio();
        if(razaActiva.equals(ID_RAZA.ZERG)){
            MenuCriaderoController controller = vistaMenu.getController();
            controller.setElements(criadero ,vBoxMenu, tablero,juegoModelo,this);
        }else{
            MenuAtacarEnemigoController controller = vistaMenu.getController();
        }
    }
    public void setTooltipLarvasRestantes(){
        Criadero criadero = (Criadero) ubicacion.getEdificio();
        BotonCriadero boton = this;
        boton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                boton.setTooltip(new Tooltip("Larvas restantes: " + criadero.getCantidadLarvas()));
            }
        }
        );
    }

}

