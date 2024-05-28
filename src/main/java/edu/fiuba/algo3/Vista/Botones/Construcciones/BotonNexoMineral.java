package edu.fiuba.algo3.Vista.Botones.Construcciones;


import edu.fiuba.algo3.Controlador.ControllerFXML.MenuAtacarEnemigoController;
import edu.fiuba.algo3.Controlador.ControllerFXML.MenuEnConstruccionController;
import edu.fiuba.algo3.Controlador.ControllerFXML.MenuNexoMineraController;
import edu.fiuba.algo3.Vista.Botones.BotonCeldaTablero;
import edu.fiuba.algo3.modelo.Edificio.Protoss.NexoMineral;
import edu.fiuba.algo3.modelo.ID_RAZA;
import edu.fiuba.algo3.modelo.Juego.Jugador;
import edu.fiuba.algo3.modelo.Raza.RazaProtoss;
import edu.fiuba.algo3.modelo.Recurso.NodoMineral;

import edu.fiuba.algo3.Controlador.ControllerFXML.MenuAtacarEnemigoController;
import edu.fiuba.algo3.Controlador.OtrosHandlers.RUTAS_FXML;
import edu.fiuba.algo3.Vista.Botones.BotonCeldaTablero;
import edu.fiuba.algo3.modelo.ID_RAZA;
import edu.fiuba.algo3.modelo.Juego.Jugador;

public class BotonNexoMineral extends BotonCeldaTablero {

    public BotonNexoMineral(BotonCeldaTablero botonCeldaTablero) {
        super(botonCeldaTablero, "images/nexo.png", RUTAS_FXML.MENU_NEXO_MINERAL,RUTAS_FXML.MENU_ATACAR_ENEMIGO);
    }


    @Override
    public void setElmentsController() {
        Jugador jugadorActivo = juegoModelo.getJugadorActivo();
        ID_RAZA razaActiva = jugadorActivo.getRaza().getEntidad();
        if(razaActiva.equals(ID_RAZA.PROTOSS)){
            MenuNexoMineraController controller = vistaMenu.getController();
            controller.setElements((NexoMineral) ubicacion.getEdificio(),(RazaProtoss) jugadorActivo.getRaza());
        }else{
            MenuAtacarEnemigoController controller = vistaMenu.getController();
        }
    }
}
