package edu.fiuba.algo3.Controlador.OtrosHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonSalirHandler implements EventHandler<ActionEvent> {

    private Button boton;

    public BotonSalirHandler(Button boton) {
        this.boton = boton;
        boton.setText("Salir");
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        System.exit(0);

    }
}
