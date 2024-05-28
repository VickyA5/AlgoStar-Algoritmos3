package edu.fiuba.algo3.Controlador.ControllerFXML;

import edu.fiuba.algo3.Controlador.OtrosHandlers.MostradorAlertas;
import edu.fiuba.algo3.modelo.ID_RAZA;
import edu.fiuba.algo3.Controlador.OtrosHandlers.JuegoVista;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.Juego.Jugador;
import edu.fiuba.algo3.modelo.Observers.ObservadorRazaRecursos;
import edu.fiuba.algo3.modelo.Raza.FinDelJuegoGanaronLosProtoss;
import edu.fiuba.algo3.modelo.Raza.FinDelJuegoGanaronLosZerg;
import edu.fiuba.algo3.modelo.Raza.Raza;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

public class InterfazJuegoControlador implements ObservadorRazaRecursos {

    @FXML
    public AnchorPane contenedorMapa;

    @FXML
    public VBox vBoxMenu;

    @FXML
    public Button btnTerminarTurno;
    @FXML
    public Label labelMenu;

    @FXML
    public Label lblCantidadGas;

    @FXML
    public Label lblCantidadMineral;

    @FXML
    public Label lblNombreJugador;

    @FXML
    public Pane paneInfoJugador;

    @FXML
    public Label lblCantidadPoblacion;

    @FXML
    public Label lblMaximaCantidadPoblacion;

    @FXML
    public Label lblNombreRaza;


    private JuegoModelo juegoModelo;

    private JuegoVista juegoVista;




    public void setJuego(JuegoModelo juegoModelo){
        this.juegoModelo = juegoModelo;
        juegoModelo.subscribirseRazaActiva(this);
    }

    public void inicializar(){
        JuegoVista juegoVista = new JuegoVista(juegoModelo, vBoxMenu);
        juegoVista.iniciar();
        juegoVista.agregarContenedor(contenedorMapa);
        this.juegoVista = juegoVista;
        actualizar();
        empezarTurno();
    }

    public void empezarTurno(){
        labelMenu.setText("Menu del juego");

        if(juegoModelo.getJugadorActivo().getRaza().getEntidad() == ID_RAZA.PROTOSS  ){
            System.out.println("Entro el turno para el jugador de protoss");

        }
        else{
            cambiarHandlerSuperficieActualZerg();
            System.out.println("Entro el turno para el jugador de ZERG");

        }
    }

    private void cambiarHandlerSuperficieActualZerg() {
        juegoVista.cambiarHandlerSuperficieActualZerg();
    }



    @FXML
    public void onClickTerminarTurno(MouseEvent event) {
        if(juegoModelo.protossNoPuedenJugarMas())
            juegoVista.ganaronLosZerg(btnTerminarTurno);
        else if (juegoModelo.zergsNoPuedenJugarMas())
            juegoVista.ganaronLosProtoss(btnTerminarTurno);
        else {
            juegoModelo.desubscribirseRazaActiva(this);
            juegoModelo.terminarTurno();
            juegoModelo.subscribirseRazaActiva(this);
            actualizar();
            empezarTurno();
            vBoxMenu.getChildren().clear();
        }


    }

    @Override
    public void actualizar() {
        Jugador jugadorActivo = juegoModelo.getJugadorActivo();
        Raza razaActiva = jugadorActivo.getRaza();
        lblNombreJugador.setText(jugadorActivo.getNombre());
        lblCantidadMineral.setText(razaActiva.getCantidadMineral());
        lblCantidadGas.setText(razaActiva.getCantidadGas());
        lblCantidadPoblacion.setText(String.valueOf(razaActiva.obtenerCantidadPoblacion()));
        lblMaximaCantidadPoblacion.setText(String.valueOf(razaActiva.capacidadReal()));
        lblNombreRaza.setText(razaActiva.getEntidad().toString());
    }


}
