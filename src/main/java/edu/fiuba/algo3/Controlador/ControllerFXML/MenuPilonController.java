package edu.fiuba.algo3.Controlador.ControllerFXML;

import edu.fiuba.algo3.modelo.Edificio.Protoss.NexoMineral;
import edu.fiuba.algo3.modelo.Edificio.Protoss.Pilon;
import edu.fiuba.algo3.modelo.Raza.RazaProtoss;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class MenuPilonController extends  EnContruccion {

    @FXML
    public AnchorPane contenerdorMenuPilon;

    private Pilon pilon;


    public void setElements(Pilon pilon) {
        if(pilon == null) throw new IllegalArgumentException("The argument cannot be null");
        this.pilon = pilon;

        if(!pilon.estaOperativo()){
            int cantidadTurnosParaSerOperativo = pilon.getTurnosRestantesParaSerOperativo();
            cargarMenuEnConstruccion(cantidadTurnosParaSerOperativo,contenerdorMenuPilon);
        }

    }

}
