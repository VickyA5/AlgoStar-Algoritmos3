package edu.fiuba.algo3.Controlador.OtrosHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class BotonLimpiarHandler implements EventHandler<ActionEvent> {
    private TextField textField;

    public BotonLimpiarHandler(TextField texto ){
        this.textField = texto;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        textField.setText("");
        textField.requestFocus();
    }

}
