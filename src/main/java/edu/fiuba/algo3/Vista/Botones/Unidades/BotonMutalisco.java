package edu.fiuba.algo3.Vista.Botones.Unidades;

import edu.fiuba.algo3.Controlador.ControllerFXML.MenuAtacarEnemigoController;
import edu.fiuba.algo3.Controlador.ControllerFXML.MenuMutaliscoController;
import edu.fiuba.algo3.Controlador.ControllerFXML.MenuUnidadController;
import edu.fiuba.algo3.Controlador.ControllerFXML.MenuZanganoController;
import edu.fiuba.algo3.Controlador.OtrosHandlers.RUTAS_FXML;
import edu.fiuba.algo3.Vista.Botones.BotonCeldaTablero;
import edu.fiuba.algo3.modelo.ID_RAZA;
import edu.fiuba.algo3.modelo.Juego.Jugador;

public class BotonMutalisco extends BotonUnidad{

    public BotonMutalisco(BotonCeldaTablero botonCeldaTablero){
        super(botonCeldaTablero,"images/mutalisco.png", RUTAS_FXML.MENU_ATACAR_ENEMIGO,RUTAS_FXML.MENU_MUTALISCO);
    }

    @Override
    public void setElmentsController() {
        Jugador jugadorActivo = juegoModelo.getJugadorActivo();
        ID_RAZA razaActiva = jugadorActivo.getRaza().getEntidad();
        if(razaActiva.equals(ID_RAZA.ZERG)){
            MenuMutaliscoController controller = vistaMenu.getController();
            controller.setElements(tablero,vBoxMenu,ubicacion,this,juegoModelo);
        }else{
            MenuAtacarEnemigoController controller = vistaMenu.getController();
        }
    }
}
