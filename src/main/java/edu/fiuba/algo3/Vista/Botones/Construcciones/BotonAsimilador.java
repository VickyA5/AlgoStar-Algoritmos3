package edu.fiuba.algo3.Vista.Botones.Construcciones;

import edu.fiuba.algo3.Controlador.ControllerFXML.MenuAsimiladorController;
import edu.fiuba.algo3.Controlador.ControllerFXML.MenuAtacarEnemigoController;
import edu.fiuba.algo3.Controlador.OtrosHandlers.RUTAS_FXML;
import edu.fiuba.algo3.Vista.Botones.BotonCeldaTablero;
import edu.fiuba.algo3.modelo.Edificio.Protoss.Asimilador;
import edu.fiuba.algo3.modelo.ID_RAZA;
import edu.fiuba.algo3.modelo.Juego.Jugador;
import edu.fiuba.algo3.modelo.Raza.RazaProtoss;

public class BotonAsimilador extends BotonCeldaTablero {
    public BotonAsimilador(BotonCeldaTablero botonCeldaTablero) {
        super(botonCeldaTablero, "images/asimilador.png",RUTAS_FXML.MENU_ASIMILADOR,RUTAS_FXML.MENU_ATACAR_ENEMIGO);
    }


    @Override
    public void setElmentsController() {
        Jugador jugadorActivo = juegoModelo.getJugadorActivo();
        ID_RAZA razaActiva = jugadorActivo.getRaza().getEntidad();
        if(razaActiva.equals(ID_RAZA.PROTOSS)){
            MenuAsimiladorController controller = vistaMenu.getController();
            controller.setElements(tablero,(Asimilador) ubicacion.getEdificio() ,(RazaProtoss) jugadorActivo.getRaza(),this);
        }else{
            MenuAtacarEnemigoController controller = vistaMenu.getController();
        }
    }
}
