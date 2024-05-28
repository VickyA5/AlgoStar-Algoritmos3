package edu.fiuba.algo3.Vista.Botones;

import edu.fiuba.algo3.Controlador.ControllerFXML.*;
import edu.fiuba.algo3.Controlador.OtrosHandlers.RUTAS_FXML;
import edu.fiuba.algo3.modelo.ID_RAZA;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.Juego.Jugador;
import edu.fiuba.algo3.modelo.Raza.RazaProtoss;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class BotonRecursoMineral extends  BotonCeldaTablero {


    public BotonRecursoMineral(int TAMANIO, Ubicacion ubicacion, VBox vBoxMenu, GridPane tablero, JuegoModelo juegoModelo) {
        super(TAMANIO, "images/mineral.png", ubicacion, vBoxMenu, tablero,juegoModelo,RUTAS_FXML.MENU_NODO_MINERAL_PROTOSS,RUTAS_FXML.MENU_NODO_MINERAL_ZERG);
    }

    @Override
    public void setElmentsController() {
        Jugador jugadorActivo = juegoModelo.getJugadorActivo();
        ID_RAZA razaActiva = jugadorActivo.getRaza().getEntidad();
        if(razaActiva.equals(ID_RAZA.PROTOSS)){
            MenuNodoMineralProtossController controller = vistaMenu.getController();
            controller.setElements(tablero,ubicacion,(RazaProtoss) jugadorActivo.getRaza(),this);
        }else{
            MenuNodoMineralZergController controller = vistaMenu.getController();
            controller.setElements(ubicacion.getNodoMineral());
        }
    }
}
