package edu.fiuba.algo3.Controlador.OtrosHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonContinuarHandler implements EventHandler<ActionEvent> {

    private Button botonContinuar;

    private  Scene escenaRegistro;

    private Stage stage;

    public BotonContinuarHandler(Button botonContinuar, Scene escenaRegistro, Stage stage) {
        this.botonContinuar = botonContinuar;
        this.escenaRegistro = escenaRegistro;
        this.stage = stage;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(escenaRegistro);
    }

}



