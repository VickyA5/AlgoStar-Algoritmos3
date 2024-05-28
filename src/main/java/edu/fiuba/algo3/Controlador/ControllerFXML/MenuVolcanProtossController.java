package edu.fiuba.algo3.Controlador.ControllerFXML;

import edu.fiuba.algo3.Controlador.OtrosHandlers.MostradorAlertas;
import edu.fiuba.algo3.Vista.Botones.Construcciones.BotonAsimilador;
import edu.fiuba.algo3.Vista.Botones.BotonRecursoVolcan;
import edu.fiuba.algo3.modelo.Edificio.Protoss.Asimilador;
import edu.fiuba.algo3.modelo.Raza.RazaProtoss;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class MenuVolcanProtossController {

    @FXML
    public AnchorPane contenerdorMenu;

    private GridPane tablero;
    private Ubicacion ubicacion;
    private RazaProtoss razaProtoss;
    private BotonRecursoVolcan botonRecursoVolcan;

    @FXML
    public void onClickedConstruirAsimilador(MouseEvent event) {
        Asimilador asimilador = new Asimilador(ubicacion);
        try{
            razaProtoss.agregarEdificio(asimilador);
            botonRecursoVolcan.borrarBotonDelTablero();
            tablero.add(new BotonAsimilador(botonRecursoVolcan),ubicacion.coordenada().horizontal(),ubicacion.coordenada().vertical());
        }
        catch (Exception e){
            MostradorAlertas.mostrarAlerta(e);
        }

    }

    public void setElements(GridPane tablero,Ubicacion ubicacion,RazaProtoss razaProtoss,BotonRecursoVolcan botonRecursoVolcan){
        this.tablero = tablero;
        this.ubicacion = ubicacion;
        this.razaProtoss = razaProtoss;
        this.botonRecursoVolcan = botonRecursoVolcan;
    }
}
