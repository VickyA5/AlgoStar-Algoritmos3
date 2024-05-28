package edu.fiuba.algo3.Controlador.ControllerFXML;

import edu.fiuba.algo3.modelo.Recurso.NodoMineral;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuNodoMineralZergController {

    @FXML
    public AnchorPane contenerdorMenu;

    @FXML
    public Label lblCantidadMineral;

    public void setElements(NodoMineral nodoMineral){
        lblCantidadMineral.setText(String.valueOf(nodoMineral.cantidadRecurso()));
    }
}
