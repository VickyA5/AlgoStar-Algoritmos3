package edu.fiuba.algo3.Controlador.OtrosHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class BotonEnviar2Handler implements EventHandler<ActionEvent> {
    TextField campoNombre;
    Label labelNombreResult;

    public BotonEnviar2Handler(TextField campoNombre, Label nombreIngresado) {
        labelNombreResult = nombreIngresado;
        this.campoNombre = campoNombre;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(campoNombre.getText().trim().equals("") ){
            this.labelNombreResult.setText("Error debe ingresar un nombre");
            this.labelNombreResult.setTextFill(Color.rgb(255,0,0));
            this.labelNombreResult.requestFocus();
        }

        else{
            labelNombreResult.setText(campoNombre.getText());
            this.labelNombreResult.requestFocus();
        }

    }

}
