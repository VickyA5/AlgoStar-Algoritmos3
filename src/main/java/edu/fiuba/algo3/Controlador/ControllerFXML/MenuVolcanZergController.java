package edu.fiuba.algo3.Controlador.ControllerFXML;

import edu.fiuba.algo3.Vista.Botones.BotonCeldaTablero;
import edu.fiuba.algo3.Vista.Botones.Construcciones.BotonExtractor;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class MenuVolcanZergController {
    @FXML
    public AnchorPane contenerdorMenu;

    private BotonCeldaTablero botonCeldaTablero;

    private GridPane tablero;

    private Ubicacion ubicacion;
    private JuegoModelo juegoModelo;

    public void setElements(GridPane tablero, Ubicacion ubicacion, BotonCeldaTablero botonCeldaTablero, JuegoModelo juegoModelo){
        this.botonCeldaTablero = botonCeldaTablero;
        this.tablero = tablero;
        this.ubicacion = ubicacion;
        this.juegoModelo = juegoModelo;


    }

    @FXML
    public void onClickedMutarZanganoAExtractor(MouseEvent event) {
        botonCeldaTablero.borrarBotonDelTablero();
        BotonExtractor botonExtractor = new BotonExtractor(botonCeldaTablero);
        //Ex
        tablero.add(botonExtractor, ubicacion.coordenada().horizontal(), ubicacion.coordenada().vertical() );
    }

}

