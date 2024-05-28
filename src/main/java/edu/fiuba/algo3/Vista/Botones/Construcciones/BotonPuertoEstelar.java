package edu.fiuba.algo3.Vista.Botones.Construcciones;

import edu.fiuba.algo3.Controlador.ControllerFXML.MenuAtacarEnemigoController;
import edu.fiuba.algo3.Controlador.ControllerFXML.MenuPuertoEstelarController;
import edu.fiuba.algo3.Controlador.OtrosHandlers.RUTAS_FXML;
import edu.fiuba.algo3.Vista.Botones.BotonCeldaTablero;
import edu.fiuba.algo3.modelo.ID_RAZA;
import edu.fiuba.algo3.modelo.Juego.Jugador;

public class BotonPuertoEstelar extends BotonCeldaTablero {
    public BotonPuertoEstelar(BotonCeldaTablero botonACopiar) {
        super(botonACopiar, "images/puertoEstelar.png", RUTAS_FXML.MENU_PUERTO_ESTELAR, RUTAS_FXML.MENU_ATACAR_ENEMIGO);
    }

    @Override
    public void setElmentsController() {
        Jugador jugadorActivo = juegoModelo.getJugadorActivo();
        ID_RAZA razaActiva = jugadorActivo.getRaza().getEntidad();
        if(razaActiva.equals(ID_RAZA.PROTOSS)){
            MenuPuertoEstelarController controller = vistaMenu.getController();
            controller.setElements(tablero,ubicacion,this, juegoModelo);
        }else{
            MenuAtacarEnemigoController controller = vistaMenu.getController();
        }
    }

}
