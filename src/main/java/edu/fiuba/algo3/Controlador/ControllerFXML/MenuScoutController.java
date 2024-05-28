package edu.fiuba.algo3.Controlador.ControllerFXML;

import edu.fiuba.algo3.Controlador.OtrosHandlers.MostradorAlertas;
import edu.fiuba.algo3.Vista.Botones.Unidades.BotonScout;
import edu.fiuba.algo3.modelo.Raza.RazaProtoss;
import edu.fiuba.algo3.modelo.Unidad.Scout;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class MenuScoutController {
    @FXML
    public AnchorPane contenerdorMenuScout;

    private GridPane tablero;
    private Ubicacion ubicacion;
    private RazaProtoss razaProtoss;
    BotonScout botonScout;
    public void onClickedConstruirScout(MouseEvent mouseEvent) {
        Scout scout = new Scout();
        try {
            razaProtoss.agregarUnidad(scout);
            botonScout.borrarBotonDelTablero();
            //tablero.add(new BotonScout(botonAcceso), ubicacion.coordenada().horizontal(), ubicacion.coordenada().vertical());
        }catch (Exception e){
            MostradorAlertas.mostrarAlerta(e);
        }


    }
    public void setElements(GridPane tablero, Ubicacion ubicacion, RazaProtoss razaProtoss, BotonScout botonScout){
        this.tablero = tablero;
        this.ubicacion = ubicacion;
        this.razaProtoss = razaProtoss;
        this.botonScout = botonScout;
    }
}