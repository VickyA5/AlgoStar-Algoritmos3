package edu.fiuba.algo3.Controlador.ControllerFXML;

import edu.fiuba.algo3.Controlador.OtrosHandlers.MostradorAlertas;
import edu.fiuba.algo3.Vista.Botones.Construcciones.*;
import edu.fiuba.algo3.Vista.Botones.Unidades.BotonUnidad;
import edu.fiuba.algo3.modelo.Edificio.CorrelativaDeConstruccionIncumplidaError;
import edu.fiuba.algo3.modelo.Edificio.Zerg.*;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import edu.fiuba.algo3.modelo.Recurso.NodoMineral;
import edu.fiuba.algo3.modelo.Recurso.RecursosInsuficientesError;
import edu.fiuba.algo3.modelo.TIPOSUPERFICIE;
import edu.fiuba.algo3.modelo.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Unidad.UnidadNoOperativaError;
import edu.fiuba.algo3.modelo.Unidad.UnidadNoVuelaError;
import edu.fiuba.algo3.modelo.Unidad.Zangano;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import edu.fiuba.algo3.modelo.tablero.UbicacionOcupadaError;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MenuZanganoController extends UnidadMovibleController {
    @FXML
    public Pane paneMovimiento;

    @FXML
    public AnchorPane contenerdorMenu;

    @FXML
    public Button btnMutarExtractor;

    @FXML
    public Button btnMutarACriadero;

    @FXML
    public Button btnMutarAEspiral;

    @FXML
    public Button btnMutarAGuarida;

    @FXML
    public Button btnMutarAReserva;


    @FXML
    public Button btnEntrarEnExtractor;

    @FXML
    public Button btnExtraerMineral;

    @FXML
    public Label lblCantidadMineralNodo;

    @FXML
    public Label lblTextMineralRestante;

    private RazaZerg razaZerg;


    @FXML
    public void onClickedMoverArriba(MouseEvent event) {
        Unidad unidad = ubicacion.getUnidad();
        try {
            unidad.moverseArriba();
        } catch (UnidadNoOperativaError | UbicacionOcupadaError | UnidadNoVuelaError e){
            MostradorAlertas.mostrarAlerta(e);
        }
        moverUnidadGraficamente(unidad.ubicacion().coordenada());

    }
    @FXML
    public void onClickedMoverAbajo(MouseEvent event) {
        Unidad unidad = ubicacion.getUnidad();
        try{
            unidad.moverseAbajo();
        } catch (UnidadNoOperativaError | UbicacionOcupadaError | UnidadNoVuelaError e){
            MostradorAlertas.mostrarAlerta(e);
        }

        moverUnidadGraficamente(unidad.ubicacion().coordenada());
    }

    @FXML
    public void onClickedMoverDerecha(MouseEvent event) {
        Unidad unidad = ubicacion.getUnidad();
        try{
            unidad.moverseDerecha();
        } catch( UnidadNoOperativaError | UbicacionOcupadaError | UnidadNoVuelaError e ){
            MostradorAlertas.mostrarAlerta(e);
        }
        moverUnidadGraficamente(unidad.ubicacion().coordenada());
    }

    @FXML
    public void onClickedMoverIzquierda(MouseEvent event) {
        Unidad unidad = ubicacion.getUnidad();
        try {
            unidad.moverseIzquierda();
        } catch (UnidadNoOperativaError | UbicacionOcupadaError | UnidadNoVuelaError e){
            MostradorAlertas.mostrarAlerta(e);
        }

        moverUnidadGraficamente(unidad.ubicacion().coordenada());
    }
    //TODO: Con una zangano hay error al intentar construir un edificio que requieree una correlativva y luego se intenta construir esa correlativa sin cambiar de ubicacion
    @FXML
    public void onClickedMutarExtractor(MouseEvent event) {

        Zangano zangano = (Zangano) ubicacion.getUnidad();
        zangano.mutarExtractor(razaZerg);
        ubicacion.ubicar( (Extractor) zangano.getEstadoZangano() );
        ubicacion.quitarUnidad();

        botonUnidad.borrarBotonDelTablero();
        BotonExtractor botonExtractor = new BotonExtractor(botonUnidad);
        tablero.add(botonExtractor, ubicacion.coordenada().horizontal(), ubicacion.coordenada().vertical() );
        botonExtractor.fire();
    }

    @FXML
    public void onClickedMutarACriadero(MouseEvent event) {
        Zangano zangano = (Zangano) ubicacion.getUnidad();
        try {
            zangano.mutarCriadero(razaZerg);
            ubicacion.ubicar( (Criadero) zangano.getEstadoZangano() );
            ubicacion.quitarUnidad();
            // la ubicacion dejo de ter una unidad y ahora tiene un edificio que es el zangano
            //Criadero criadero = new Criadero();
            //razaZerg.agregarEdificio(criadero);
            //ubicacion.ubicar(criadero);
            //botonUnidad.borrarBotonDelTablero();
            BotonCriadero botonCriadero = new BotonCriadero(botonUnidad);
            botonCriadero.setTooltipLarvasRestantes();
            tablero.add(botonCriadero, ubicacion.coordenada().horizontal(),ubicacion.coordenada().vertical());
            botonCriadero.fire();
        }catch ( RecursosInsuficientesError e ) {
            MostradorAlertas.mostrarAlerta(e,"un Criadero");
            zangano.estadoZangano();
        } catch (Exception e){
            MostradorAlertas.mostrarAlerta(e);
        }


    }

    @FXML
    public void onClickedMutarAEspiral(MouseEvent event) {
        Zangano zangano = (Zangano) ubicacion.getUnidad();
        try {
            zangano.mutarEspiral(razaZerg);
            ubicacion.ubicar(  (Espiral) zangano.getEstadoZangano() );
            ubicacion.quitarUnidad();
            botonUnidad.borrarBotonDelTablero();
            BotonEspiral botonEspiral = new BotonEspiral(botonUnidad);
            tablero.add(botonEspiral,ubicacion.coordenada().horizontal(),ubicacion.coordenada().vertical());
            botonEspiral.fire();
        }catch ( RecursosInsuficientesError e ) {
            MostradorAlertas.mostrarAlerta(e,"un Espiral");
            zangano.estadoZangano();
        } catch (CorrelativaDeConstruccionIncumplidaError e){
            MostradorAlertas.mostrarAlerta(e,"Necesitas una Guarida para construir");
            zangano.estadoZangano();
        } catch (Exception e){
            MostradorAlertas.mostrarAlerta(e);
        }
    }

    @FXML
    public void onClickedMutarAGuarida(MouseEvent event) {
        Zangano zangano = (Zangano) ubicacion.getUnidad();
        try{
            zangano.mutarGuarida(razaZerg);
            ubicacion.ubicar(  (Guarida) zangano.getEstadoZangano() );
            ubicacion.quitarUnidad();
            botonUnidad.borrarBotonDelTablero();
            BotonGuarida botonGuarida = new BotonGuarida(botonUnidad);
            tablero.add(botonGuarida,ubicacion.coordenada().horizontal(),ubicacion.coordenada().vertical());
            botonGuarida.fire();

        } catch ( RecursosInsuficientesError e ){
            MostradorAlertas.mostrarAlerta(e,"una Guarida");
            zangano.estadoZangano();
        } catch (CorrelativaDeConstruccionIncumplidaError e){
            MostradorAlertas.mostrarAlerta(e,"Necesitas una Reserva de Reproduccion para construir");
            zangano.estadoZangano();
        } catch (Exception e){
            MostradorAlertas.mostrarAlerta(e);
        }
    }

    @FXML
    public void onClickedMutarAReservaDeReproduccion(MouseEvent event) {
        Zangano zangano = (Zangano) ubicacion.getUnidad();
        try{
            zangano.mutarReservaReproduccion(razaZerg);
            ubicacion.ubicar(  (ReservaDeReproduccion) zangano.getEstadoZangano() );
            ubicacion.quitarUnidad();
            botonUnidad.borrarBotonDelTablero();
            tablero.add(new BotonReservaDeReproduccion(botonUnidad),ubicacion.coordenada().horizontal(),ubicacion.coordenada().vertical());
        } catch (RecursosInsuficientesError e) {
            MostradorAlertas.mostrarAlerta(e,"una Reserva De Reproduccion");
            zangano.estadoZangano();
        } catch( Exception e){
            MostradorAlertas.mostrarAlerta(e);
        }
    }

    @FXML
    public void onClickedEntrarEnExtractor(MouseEvent event) {
        Extractor extractor = (Extractor) ubicacion.getEdificio();
        Zangano zangano = (Zangano) ubicacion.getUnidad();
        extractor.agregarZangano(zangano);
        botonUnidad.borrarBotonDelTablero();
    }

    @FXML
    public void onClickedExtraerMineral(MouseEvent event) {
        Zangano zangano = (Zangano) ubicacion.getUnidad();
        NodoMineral nodoMineral = ubicacion.getNodoMineral();
        GestionRecurso mineralExtraido = zangano.extraerMineral(nodoMineral);
        razaZerg.aumentarMineral(mineralExtraido);
        this.lblCantidadMineralNodo.setText(String.valueOf(nodoMineral.cantidadRecurso()));
        this.btnExtraerMineral.setDisable(true);
        this.paneMovimiento.setDisable(true);
        desactivarMovimientoPorTeclado();
    }


    private boolean ubicacionTieneMoho(){
        return ubicacion.getTipoSuperficie().equals(TIPOSUPERFICIE.MOHO);
    }

    @Override
    public void setElements(GridPane tablero, VBox vBoxMenu , Ubicacion ubicacion, BotonUnidad botonUnidad, JuegoModelo juegoModelo) {
        super.setElements(tablero,vBoxMenu,ubicacion,botonUnidad,juegoModelo);

        if( (ubicacion.getUnidad() != null) && !ubicacion.getUnidad().esOperativo() ){
            int cantidadTurnosParaSerOperativo = ubicacion.getUnidad().getTurnosRestantesParaSerOperativo();
            cargarMenuEnConstruccion(cantidadTurnosParaSerOperativo,contenerdorMenu);
            return;
        }
        activarMovimientoPorTeclado();
        this.razaZerg =  (RazaZerg) juegoModelo.getJugadorActivo().getRaza();
        if(ubicacionTieneMoho()){
            this.btnMutarACriadero.setDisable(false);
            this.btnMutarAEspiral.setDisable(false);
            this.btnMutarAGuarida.setDisable(false);
            this.btnMutarAReserva.setDisable(false);

            if(ubicacion.existeRecurso()){
                this.btnMutarACriadero.setDisable(true);
                this.btnMutarAEspiral.setDisable(true);
                this.btnMutarAGuarida.setDisable(true);
                this.btnMutarAReserva.setDisable(true);
            }
            if(ubicacion.getVolcan() != null){
                this.btnMutarExtractor.setDisable(false);
            }

        }
        NodoMineral nodoMineral = ubicacion.getNodoMineral();
        if(nodoMineral != null){
            this.btnExtraerMineral.setDisable(false);
            this.lblTextMineralRestante.setVisible(true);
            this.lblCantidadMineralNodo.setVisible(true);
            this.lblCantidadMineralNodo.setText(String.valueOf(nodoMineral.cantidadRecurso()));
        }

    }

}

