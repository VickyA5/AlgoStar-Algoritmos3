package edu.fiuba.algo3.Vista.Botones.Construcciones;

import edu.fiuba.algo3.Controlador.ControllerFXML.MenuAccesoController;
import edu.fiuba.algo3.Controlador.ControllerFXML.MenuAtacarEnemigoController;
import edu.fiuba.algo3.Controlador.OtrosHandlers.RUTAS_FXML;
import edu.fiuba.algo3.Vista.Botones.BotonCeldaTablero;
import edu.fiuba.algo3.Vista.Botones.BotonTierra;
import edu.fiuba.algo3.modelo.ID_RAZA;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.Juego.Jugador;
import edu.fiuba.algo3.modelo.Raza.RazaProtoss;

public class BotonAcceso extends BotonCeldaTablero {


    public BotonAcceso(BotonTierra botonTierra) {
        super(botonTierra, "images/acceso.png", RUTAS_FXML.MENU_ACCESO,RUTAS_FXML.MENU_ATACAR_ENEMIGO);

    }

    @Override
    public void setElmentsController() {
        Jugador jugadorActivo = juegoModelo.getJugadorActivo();
        ID_RAZA razaActiva = jugadorActivo.getRaza().getEntidad();
        if(razaActiva.equals(ID_RAZA.PROTOSS)){
            MenuAccesoController controller = vistaMenu.getController();
            controller.setElements(tablero,ubicacion,(RazaProtoss) jugadorActivo.getRaza(),this, juegoModelo);
        }else{
            MenuAtacarEnemigoController controller = vistaMenu.getController();
        }
    }
}
