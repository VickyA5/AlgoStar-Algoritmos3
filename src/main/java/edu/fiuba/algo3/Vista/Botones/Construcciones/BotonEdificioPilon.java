package edu.fiuba.algo3.Vista.Botones.Construcciones;

import edu.fiuba.algo3.Controlador.ControllerFXML.*;
import edu.fiuba.algo3.Controlador.OtrosHandlers.RUTAS_FXML;
import edu.fiuba.algo3.Vista.Botones.BotonCeldaTablero;
import edu.fiuba.algo3.Vista.Botones.BotonTierra;
import edu.fiuba.algo3.modelo.Edificio.Protoss.Pilon;
import edu.fiuba.algo3.modelo.ID_RAZA;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.Juego.Jugador;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class BotonEdificioPilon extends BotonCeldaTablero {

    public BotonEdificioPilon(int tamanio, Ubicacion ubicacion, VBox vBoxMenu, GridPane tablero, JuegoModelo juegoModelo) {
        super(tamanio, "images/pilon.png",ubicacion,vBoxMenu,tablero,juegoModelo,RUTAS_FXML.MENU_PILON,RUTAS_FXML.MENU_ATACAR_ENEMIGO);
        //this.setOnAction(new BotonPilonHandler((Pilon) ubicacion.getEdificio(), vBoxMenu));
    }

    public BotonEdificioPilon(BotonTierra botonTierra) {
        super(botonTierra, "images/pilon.png",RUTAS_FXML.MENU_PILON,RUTAS_FXML.MENU_ATACAR_ENEMIGO);
        //this.setOnAction(new BotonPilonHandler((Pilon) ubicacion.getEdificio(), vBoxMenu));
    }


    @Override
    public void setElmentsController() {
        Jugador jugadorActivo = juegoModelo.getJugadorActivo();
        ID_RAZA razaActiva = jugadorActivo.getRaza().getEntidad();
        if(razaActiva.equals(ID_RAZA.PROTOSS)){
            MenuPilonController controller = vistaMenu.getController();
            controller.setElements((Pilon) ubicacion.getEdificio());
        }else{
            MenuAtacarEnemigoController controller = vistaMenu.getController();
        }
    }
}
