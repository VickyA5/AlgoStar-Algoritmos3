package edu.fiuba.algo3.Controlador.OtrosHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class BotonRazaHandler implements EventHandler<ActionEvent> {
    String razaSeleccionada;
    Label labelRazaResult;
    public BotonRazaHandler(String zerg, Label razaResulHBox) {
        this.razaSeleccionada = zerg;
        this.labelRazaResult = razaResulHBox;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(razaSeleccionada == "ZERG"){
           labelRazaResult.setText( "ZERG");
        }
        else{
            labelRazaResult.setText( "PROTOSS");
        }

    }
}
