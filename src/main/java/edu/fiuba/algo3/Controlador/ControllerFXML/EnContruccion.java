package edu.fiuba.algo3.Controlador.ControllerFXML;

import edu.fiuba.algo3.Controlador.OtrosHandlers.RUTAS_FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;


public class EnContruccion {

    public void cargarMenuEnConstruccion(int turnosRestantes, Pane contedorMenu){
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource(CargadorFXML.MAP_RUTAS_FXML.get(RUTAS_FXML.MENU_EN_CONSTRUCCION)));
        Pane vistaFxml = CargadorFXML.prepararLayout(fxmlLoader);
        MenuEnConstruccionController menuEnConstruccionController = fxmlLoader.getController();
        menuEnConstruccionController.setElements(turnosRestantes);
        contedorMenu.getChildren().clear();
        contedorMenu.getChildren().addAll(vistaFxml);
    }
}
