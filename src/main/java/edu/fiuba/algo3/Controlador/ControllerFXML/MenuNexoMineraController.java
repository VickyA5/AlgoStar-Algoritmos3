package edu.fiuba.algo3.Controlador.ControllerFXML;

import edu.fiuba.algo3.modelo.Edificio.Protoss.NexoMineral;
import edu.fiuba.algo3.modelo.Raza.RazaProtoss;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MenuNexoMineraController extends EnContruccion{

    @FXML
    public AnchorPane contenerdorMenu;

    @FXML
    public Label lblCantidadMineral;

    @FXML
    public Button btnExtraerMineral;

    private NexoMineral nexoMineral;
    private RazaProtoss razaProtoss;

    @FXML
    public void onClickedExtraerMineral(MouseEvent event) {
        GestionRecurso mineralExtraido = nexoMineral.extraer();
        razaProtoss.aumentarMineral(mineralExtraido);
        lblCantidadMineral.setText(String.valueOf(nexoMineral.mineralRestante()));
        btnExtraerMineral.setDisable(true);
    }


    public void setElements(NexoMineral nexoMineral, RazaProtoss razaProtoss) {
        if(nexoMineral == null) throw new IllegalArgumentException("The argument cannot be null");
        this.nexoMineral = nexoMineral;
        this.razaProtoss = razaProtoss;
        lblCantidadMineral.setText(String.valueOf(nexoMineral.mineralRestante()));

        if(!nexoMineral.estaOperativo()){
            int cantidadTurnosParaSerOperativo = nexoMineral.getTurnosRestantesParaSerOperativo();
            cargarMenuEnConstruccion(cantidadTurnosParaSerOperativo,contenerdorMenu);
        }

    }
}
