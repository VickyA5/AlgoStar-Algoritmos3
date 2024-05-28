package edu.fiuba.algo3.Controlador.ControllerFXML;

import edu.fiuba.algo3.Controlador.OtrosHandlers.MostradorAlertas;
import edu.fiuba.algo3.Vista.Botones.Unidades.BotonZealot;
import edu.fiuba.algo3.modelo.Raza.RazaProtoss;
import edu.fiuba.algo3.modelo.Unidad.Zealot;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class MenuZealotController {
    @FXML
    public AnchorPane contenerdorMenuZealot;

    private GridPane tablero;
    private Ubicacion ubicacion;
    private RazaProtoss razaProtoss;
    BotonZealot botonZealot;
    public void onClickedConstruirZealot(MouseEvent mouseEvent) {
        Zealot zealot = new Zealot();
        try {
            razaProtoss.agregarUnidad(zealot);
            botonZealot.borrarBotonDelTablero();
            //tablero.add(new BotonZealot(botonAcceso), ubicacion.coordenada().horizontal(), ubicacion.coordenada().vertical());
        }catch (Exception e){
            MostradorAlertas.mostrarAlerta(e);
        }


    }
    public void setElements(GridPane tablero, Ubicacion ubicacion, RazaProtoss razaProtoss, BotonZealot botonZealot){
        this.tablero = tablero;
        this.ubicacion = ubicacion;
        this.razaProtoss = razaProtoss;
        this.botonZealot = botonZealot;
    }
}