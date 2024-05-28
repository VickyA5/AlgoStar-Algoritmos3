package edu.fiuba.algo3.Controlador.ControllerFXML;

import edu.fiuba.algo3.Controlador.OtrosHandlers.MostradorAlertas;
import edu.fiuba.algo3.Vista.Botones.Construcciones.BotonNexoMineral;
import edu.fiuba.algo3.Vista.Botones.BotonRecursoMineral;
import edu.fiuba.algo3.modelo.ConstruccionProtoEnMohoError;
import edu.fiuba.algo3.modelo.Edificio.Protoss.NexoMineral;
import edu.fiuba.algo3.modelo.Raza.RazaProtoss;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class MenuNodoMineralProtossController {

    @FXML
    public AnchorPane contenerdorMenu;

    private GridPane tablero;
    private Ubicacion ubicacion;
    private RazaProtoss razaProtoss;
    private BotonRecursoMineral botonRecursoMineral;

    @FXML
    public void onClickedConstruirNexoMineral(MouseEvent event) {
        try {
            NexoMineral nexoMineral = new NexoMineral(ubicacion.getNodoMineral(),ubicacion);
            razaProtoss.agregarEdificio(nexoMineral);
            botonRecursoMineral.borrarBotonDelTablero();
            BotonNexoMineral botonNexoMineral = new BotonNexoMineral(botonRecursoMineral);
            botonNexoMineral.fire();
            tablero.add(botonNexoMineral,ubicacion.coordenada().horizontal(),ubicacion.coordenada().vertical());
        }catch (ConstruccionProtoEnMohoError e){
            MostradorAlertas.mostrarAlerta(e);
        }
        catch (Exception e){
            MostradorAlertas.mostrarAlerta(e);
        }


    }

    public void setElements(GridPane tablero, Ubicacion ubicacion, RazaProtoss razaProtoss, BotonRecursoMineral botonRecursoMineral){
        this.tablero = tablero;
        this.ubicacion = ubicacion;
        this.razaProtoss = razaProtoss;
        this.botonRecursoMineral = botonRecursoMineral;
    }


}
