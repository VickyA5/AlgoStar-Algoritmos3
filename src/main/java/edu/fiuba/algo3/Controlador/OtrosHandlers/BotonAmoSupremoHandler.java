package edu.fiuba.algo3.Controlador.OtrosHandlers;

import edu.fiuba.algo3.modelo.Unidad.AmoSupremo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class BotonAmoSupremoHandler implements EventHandler<ActionEvent> {

    private AmoSupremo amo;
    private VBox vbox;



    public BotonAmoSupremoHandler(AmoSupremo unidad, VBox cajita){
        amo = unidad;
        vbox = cajita;

    }

    public void handle(ActionEvent actionEvent){
        vbox.getChildren().clear();
        Button boton6 = new Button("Moverse A");
        vbox.getChildren().addAll(boton6);

    }
}
