package edu.fiuba.algo3.Controlador.OtrosHandlers;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import edu.fiuba.algo3.modelo.Unidad.*;
import javafx.scene.layout.VBox;

public class BotonUnidadesGenericaHandler implements EventHandler<ActionEvent> {

    private Unidad unidad;
    private VBox vbox;



    public BotonUnidadesGenericaHandler(Unidad unaUnidad, VBox cajita){
        unidad = unaUnidad;
        vbox = cajita;

    }

    public void handle(ActionEvent actionEvent){
        vbox.getChildren().clear();
        Button boton1 = new Button("Atacar A");
        Button boton6 = new Button("Moverse A");
        vbox.getChildren().addAll(boton1,boton6);

    }


}
