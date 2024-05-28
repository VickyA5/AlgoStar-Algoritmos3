package edu.fiuba.algo3.Controlador.ControllerFXML;

import edu.fiuba.algo3.Controlador.OtrosHandlers.MostradorAlertas;
import edu.fiuba.algo3.Vista.Botones.Unidades.BotonDragon;
import edu.fiuba.algo3.modelo.Raza.RazaProtoss;
import edu.fiuba.algo3.modelo.Unidad.Dragon;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class MenuDragonController {
    @FXML
    public AnchorPane contenerdorMenuDragon;

    private GridPane tablero;
    private Ubicacion ubicacion;
    private RazaProtoss razaProtoss;
    BotonDragon botonDragon;
    public void onClickedConstruirDragon(MouseEvent mouseEvent) {
        Dragon dragon = new Dragon();
        try {
            razaProtoss.agregarUnidad(dragon);
            botonDragon.borrarBotonDelTablero();
            //tablero.add(new BotonDragon(botonAcceso), ubicacion.coordenada().horizontal(), ubicacion.coordenada().vertical());
        }catch (Exception e){
            MostradorAlertas.mostrarAlerta(e);
        }


    }
    public void setElements(GridPane tablero, Ubicacion ubicacion, RazaProtoss razaProtoss, BotonDragon botonDragon){
        this.tablero = tablero;
        this.ubicacion = ubicacion;
        this.razaProtoss = razaProtoss;
        this.botonDragon = botonDragon;
    }
}