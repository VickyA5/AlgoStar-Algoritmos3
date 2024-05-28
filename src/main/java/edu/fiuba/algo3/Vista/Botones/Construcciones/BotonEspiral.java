package edu.fiuba.algo3.Vista.Botones.Construcciones;

import edu.fiuba.algo3.Controlador.ControllerFXML.MenuAtacarEnemigoController;
import edu.fiuba.algo3.Controlador.ControllerFXML.MenuEspiralController;
import edu.fiuba.algo3.Controlador.OtrosHandlers.RUTAS_FXML;
import edu.fiuba.algo3.Vista.Botones.BotonCeldaTablero;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Espiral;
import edu.fiuba.algo3.modelo.ID_RAZA;
import edu.fiuba.algo3.modelo.Juego.Jugador;

public class BotonEspiral extends BotonCeldaTablero {

    public BotonEspiral(BotonCeldaTablero botonACopiar){
        super(botonACopiar, "images/espiral.png", RUTAS_FXML.MENU_ATACAR_ENEMIGO, RUTAS_FXML.MENU_ESPIRAL);
    }

    @Override
    public void setElmentsController() {
        Jugador jugadorActivo = juegoModelo.getJugadorActivo();
        ID_RAZA razaActiva = jugadorActivo.getRaza().getEntidad();
        if(razaActiva.equals(ID_RAZA.ZERG)){
            MenuEspiralController controller = vistaMenu.getController();
            controller.setElements((Espiral) ubicacion.getEdificio(),tablero, juegoModelo, this);
        }else{
            MenuAtacarEnemigoController controller = vistaMenu.getController();
        }
    }
}
