package edu.fiuba.algo3.Vista.Botones.Unidades;

import edu.fiuba.algo3.Controlador.ControllerFXML.MenuAtacarEnemigoController;
import edu.fiuba.algo3.Controlador.ControllerFXML.MenuUnidadController;
import edu.fiuba.algo3.Controlador.ControllerFXML.MenuZealotController;
import edu.fiuba.algo3.Controlador.OtrosHandlers.RUTAS_FXML;
import edu.fiuba.algo3.Vista.Botones.BotonCeldaTablero;
import edu.fiuba.algo3.modelo.ID_RAZA;
import edu.fiuba.algo3.modelo.Juego.Jugador;
import edu.fiuba.algo3.modelo.Raza.RazaProtoss;

public class BotonZealot extends BotonUnidad {


    public BotonZealot(BotonCeldaTablero botonCeldaTablero) {
        super(botonCeldaTablero, "images/zealot.png",RUTAS_FXML.MENU_UNIDAD,RUTAS_FXML.MENU_ATACAR_ENEMIGO);

    }

    @Override
    public void setElmentsController() {
        Jugador jugadorActivo = juegoModelo.getJugadorActivo();
        ID_RAZA razaActiva = jugadorActivo.getRaza().getEntidad();
        if(razaActiva.equals(ID_RAZA.PROTOSS)){
            MenuUnidadController controller = vistaMenu.getController();
            controller.setElements(tablero,vBoxMenu,ubicacion,this,juegoModelo);
        }else{
            MenuAtacarEnemigoController controller = vistaMenu.getController();
        }
    }
}