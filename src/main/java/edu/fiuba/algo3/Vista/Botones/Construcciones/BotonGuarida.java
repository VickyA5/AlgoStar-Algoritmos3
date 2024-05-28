package edu.fiuba.algo3.Vista.Botones.Construcciones;

import edu.fiuba.algo3.Controlador.ControllerFXML.MenuAtacarEnemigoController;
import edu.fiuba.algo3.Controlador.ControllerFXML.MenuGuaridaController;
import edu.fiuba.algo3.Controlador.OtrosHandlers.RUTAS_FXML;
import edu.fiuba.algo3.Vista.Botones.BotonCeldaTablero;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Guarida;
import edu.fiuba.algo3.modelo.ID_RAZA;
import edu.fiuba.algo3.modelo.Juego.Jugador;

public class BotonGuarida extends BotonCeldaTablero {

    public BotonGuarida(BotonCeldaTablero botonACopiar){
        super(botonACopiar, "images/guarida.png", RUTAS_FXML.MENU_ATACAR_ENEMIGO,RUTAS_FXML.MENU_GUARIDA);
    }

    @Override
    public void setElmentsController() {
        Jugador jugadorActivo = juegoModelo.getJugadorActivo();
        ID_RAZA razaActiva = jugadorActivo.getRaza().getEntidad();
        if(razaActiva.equals(ID_RAZA.ZERG)){
            MenuGuaridaController controller = vistaMenu.getController();
            controller.setElements((Guarida) ubicacion.getEdificio(),tablero, juegoModelo, this);
        }else{
            MenuAtacarEnemigoController controller = vistaMenu.getController();
        }
    }

}
