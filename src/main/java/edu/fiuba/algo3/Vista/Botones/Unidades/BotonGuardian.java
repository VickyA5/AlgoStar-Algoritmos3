package edu.fiuba.algo3.Vista.Botones.Unidades;

import edu.fiuba.algo3.Controlador.ControllerFXML.MenuAtacarEnemigoController;
import edu.fiuba.algo3.Controlador.ControllerFXML.MenuUnidadController;
import edu.fiuba.algo3.Controlador.OtrosHandlers.RUTAS_FXML;
import edu.fiuba.algo3.Vista.Botones.BotonCeldaTablero;
import edu.fiuba.algo3.modelo.ID_RAZA;
import edu.fiuba.algo3.modelo.Juego.Jugador;

public class BotonGuardian extends BotonUnidad{

    public BotonGuardian(BotonCeldaTablero botonCeldaTablero) {
        super(botonCeldaTablero, "images/guardian.png", RUTAS_FXML.MENU_ATACAR_ENEMIGO,RUTAS_FXML.MENU_UNIDAD);

    }

    @Override
    public void setElmentsController() {
        Jugador jugadorActivo = juegoModelo.getJugadorActivo();
        ID_RAZA razaActiva = jugadorActivo.getRaza().getEntidad();
        if(razaActiva.equals(ID_RAZA.ZERG)){
            MenuUnidadController controller = vistaMenu.getController();
            controller.setElements(tablero,vBoxMenu,ubicacion,this,juegoModelo);
        }else{
            MenuAtacarEnemigoController controller = vistaMenu.getController();
        }
    }
}
