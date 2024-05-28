package edu.fiuba.algo3.Controlador.OtrosHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class BotonEnviarHandler implements EventHandler<ActionEvent> {
    TextField textField;
    Label label;

    public BotonEnviarHandler(TextField texto, Label etiqueta){
        textField = texto;
        label = etiqueta;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        if(this.textField.getText().trim().equals("") ){
            this.label.setText("Debe ingresar un texto");
            this.label.setTextFill( Color.rgb(255,64,64));
            this.label.requestFocus();
        }

        else{
            this.label.setText(this.textField.getText());
            this.label.setTextFill( Color.rgb(0,200,20) );
        }

    }
}
