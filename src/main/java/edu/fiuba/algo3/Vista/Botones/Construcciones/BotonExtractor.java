package edu.fiuba.algo3.Vista.Botones.Construcciones;

import edu.fiuba.algo3.Controlador.ControllerFXML.*;
import edu.fiuba.algo3.Controlador.OtrosHandlers.RUTAS_FXML;
import edu.fiuba.algo3.Vista.Botones.BotonCeldaTablero;
import edu.fiuba.algo3.modelo.ID_RAZA;
import edu.fiuba.algo3.modelo.Juego.Jugador;

public class BotonExtractor extends BotonCeldaTablero{


    public BotonExtractor(BotonCeldaTablero botonACopiar ){
        super(botonACopiar, "images/extractor.png",RUTAS_FXML.MENU_ATACAR_ENEMIGO,RUTAS_FXML.MENU_EXTRACTOR);
    }

    @Override
    public void setElmentsController() {
        Jugador jugadorActivo = juegoModelo.getJugadorActivo();
        ID_RAZA razaActiva = jugadorActivo.getRaza().getEntidad();
        if(razaActiva.equals(ID_RAZA.ZERG)){
            MenuExtractorController controller = vistaMenu.getController();
            controller.setElements(tablero,ubicacion, this, juegoModelo);
        }else{
            MenuAtacarEnemigoController controller = vistaMenu.getController();
        }
    }
}
