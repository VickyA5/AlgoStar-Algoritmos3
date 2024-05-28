package edu.fiuba.algo3.Controlador.ControllerFXML;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class MenuEnConstruccionController {

    @FXML
    public AnchorPane contenerdorMenu;

    @FXML
    public Label lblCantidadTurnosRestantes;

    public void setElements(int turnosRestantesParaSerOperativo) {
        this.lblCantidadTurnosRestantes.setText(String.valueOf(turnosRestantesParaSerOperativo));
    }
}
