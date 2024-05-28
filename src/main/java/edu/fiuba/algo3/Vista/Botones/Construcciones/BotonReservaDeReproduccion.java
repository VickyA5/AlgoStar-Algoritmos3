package edu.fiuba.algo3.Vista.Botones.Construcciones;

import edu.fiuba.algo3.Controlador.ControllerFXML.MenuAtacarEnemigoController;
import edu.fiuba.algo3.Controlador.ControllerFXML.MenuReservaDeReproduccionController;
import edu.fiuba.algo3.Controlador.OtrosHandlers.RUTAS_FXML;
import edu.fiuba.algo3.Vista.Botones.BotonCeldaTablero;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Criadero;
import edu.fiuba.algo3.modelo.Edificio.Zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.ID_RAZA;
import edu.fiuba.algo3.modelo.Juego.Jugador;

public class BotonReservaDeReproduccion extends BotonCeldaTablero {

    public BotonReservaDeReproduccion(BotonCeldaTablero botonACopiar){

        super(botonACopiar, "images/reservaDeReproduccion.png", RUTAS_FXML.MENU_ATACAR_ENEMIGO,RUTAS_FXML.MENU_RESERVA_DE_REPRODUCCION);

    }
    @Override
    public void setElmentsController() {
        Jugador jugadorActivo = juegoModelo.getJugadorActivo();
        ID_RAZA razaActiva = jugadorActivo.getRaza().getEntidad();

        if(razaActiva.equals(ID_RAZA.ZERG)){
            MenuReservaDeReproduccionController controller = vistaMenu.getController();
            controller.setElements((ReservaDeReproduccion) ubicacion.getEdificio(),tablero, juegoModelo,this);
        }else{
            MenuAtacarEnemigoController controller = vistaMenu.getController();
        }
    }
}
