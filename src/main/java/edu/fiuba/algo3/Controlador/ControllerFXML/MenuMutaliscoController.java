package edu.fiuba.algo3.Controlador.ControllerFXML;

import edu.fiuba.algo3.Controlador.BotonAtacable;
import edu.fiuba.algo3.Controlador.BotonAtacableHandler;
import edu.fiuba.algo3.Controlador.OtrosHandlers.MostradorAlertas;
import edu.fiuba.algo3.Vista.Botones.Construcciones.BotonCriadero;
import edu.fiuba.algo3.Vista.Botones.Unidades.BotonDevorador;
import edu.fiuba.algo3.Vista.Botones.Unidades.BotonGuardian;
import edu.fiuba.algo3.Vista.Botones.Unidades.BotonUnidad;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Criadero;
import edu.fiuba.algo3.modelo.IDEDIFICIO;
import edu.fiuba.algo3.modelo.ID_UNIDAD;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.Raza.PoblacionExedidaError;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import edu.fiuba.algo3.modelo.Recurso.RecursosInsuficientesError;
import edu.fiuba.algo3.modelo.Unidad.*;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import edu.fiuba.algo3.modelo.tablero.UbicacionOcupadaError;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuMutaliscoController extends UnidadMovibleController{


    @FXML
    public AnchorPane contenerdorMenu;

    private  HashMap<IDEDIFICIO,String> imagenEdificio;

    private HashMap<ID_UNIDAD,String> imagenesUnidades;


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
        } catch( UnidadNoOperativaError | UbicacionOcupadaError | UnidadNoVuelaError  e ){
            MostradorAlertas.mostrarAlerta(e);
        }
        moverUnidadGraficamente(unidad.ubicacion().coordenada());
    }

    @FXML
    public void onClickedMoverIzquierda(MouseEvent event) {
        Unidad unidad = ubicacion.getUnidad();
        try {
            unidad.moverseIzquierda();
        } catch (UnidadNoOperativaError | UbicacionOcupadaError | UnidadNoVuelaError  e){
            MostradorAlertas.mostrarAlerta(e);
        }

        moverUnidadGraficamente(unidad.ubicacion().coordenada());
    }

    public  void setElements(GridPane tablero, VBox vBoxMenu , Ubicacion ubicacion, BotonUnidad botonUnidad, JuegoModelo juegoModelo) {
        super.setElements(tablero,vBoxMenu,ubicacion,botonUnidad,juegoModelo);
        if(!ubicacion.getUnidad().esOperativo()){
            int cantidadTurnosParaSerOperativo = ubicacion.getUnidad().getTurnosRestantesParaSerOperativo();
            cargarMenuEnConstruccion(cantidadTurnosParaSerOperativo,contenerdorMenu);
            return;
        }
        inicializarHashImagenes();
        activarMovimientoPorTeclado();
        completarEnemigosParaAtacar();

    }

    private void completarEnemigosParaAtacar(){
        int rangoAtaque = ubicacion.getUnidad().getRango();
        int i = 0;
        int j = 0;
        ArrayList<Ubicacion> ubicaciones = juegoModelo.getMapa().buscar(ubicacion.coordenada(), rangoAtaque );
        for(Ubicacion ubicacionAdy : ubicaciones){
            if( ubicacionAdy.existeUnidad() &&  ! ubicacionAdy.esIgual(ubicacion) ){
                System.out.println("Coord x " + ubicacionAdy.coordenada().horizontal() + "Coord y: " + ubicacionAdy.coordenada().vertical() );
                System.out.println("Existe unidad para atacar y esa es ");
                Unidad unidadAdy = ubicacionAdy.getUnidad();
                System.out.println(unidadAdy.getEntidad() );
                GridPane panelDeEnemigos =  (GridPane) contenerdorMenu.getChildren().get(4);
                BotonAtacable botonAtacable = new BotonAtacable(imagenesUnidades.get(unidadAdy.getEntidad() ), ubicacionAdy.getUnidad(), ubicacion.getUnidad() );
                botonAtacable.setTooltipVidaYEscudoRestante();
                botonAtacable.setOnAction(new BotonAtacableHandler(ubicacionAdy.getUnidad(), ubicacion.getUnidad() , ubicacionAdy, tablero, vBoxMenu, juegoModelo ) );
                panelDeEnemigos.add(  botonAtacable , i, j );
                i++;
                if ( i == 3 ){
                    i = 0;
                    j++;
                }
                if ( j == 3 ) break;
            }
            if( ubicacionAdy.existeEdificio() &&  ! ubicacionAdy.esIgual(ubicacion) ){
                System.out.println("Coord x " + ubicacionAdy.coordenada().horizontal() + "Coord y: " + ubicacionAdy.coordenada().vertical() );
                System.out.println("Existe Edificio para atacar y esa es ");
                Edificio edificio = ubicacionAdy.getEdificio();
                System.out.println(edificio.getEntidad() );
                GridPane panelDeEnemigos =  (GridPane) contenerdorMenu.getChildren().get(4);
                BotonAtacable botonAtacable = new BotonAtacable(imagenEdificio.get(edificio.getEntidad() ), ubicacionAdy.getEdificio(), ubicacion.getUnidad() );
                botonAtacable.setTooltipVidaYEscudoRestante();
                botonAtacable.setOnAction(new BotonAtacableHandler(ubicacionAdy.getEdificio(), ubicacion.getUnidad(), ubicacionAdy, tablero, vBoxMenu, juegoModelo) );
                panelDeEnemigos.add(  botonAtacable , i, j );
                i++;
                if ( i == 3 ){
                    i = 0;
                    j++;
                }
                if ( j == 3 ) break;
            }
        }

    }

    private void inicializarHashImagenes(){
        this.imagenEdificio = new HashMap<>();
        imagenEdificio.put(IDEDIFICIO.CRIADERO, "images/criadero.png");
        imagenEdificio.put(IDEDIFICIO.RESERVADEREPRODUCCION, "images/reservaDeReproduccion.png");
        imagenEdificio.put(IDEDIFICIO.GUARIDA, "images/guarida.png");
        imagenEdificio.put(IDEDIFICIO.ESPIRAL, "images/espiral.png");
        imagenEdificio.put(IDEDIFICIO.PUERTOESTELAR, "images/puertoEstelar.png");
        imagenEdificio.put(IDEDIFICIO.ACCESO, "images/acceso.png");
        imagenEdificio.put(IDEDIFICIO.NEXOMINERAL, "images/nexo.png");
        imagenEdificio.put(IDEDIFICIO.EXTRACTOR, "images/extractor.png");
        imagenEdificio.put(IDEDIFICIO.PILON, "images/pilon.png");
        imagenEdificio.put(IDEDIFICIO.ASIMILADOR, "images/asimilador.png");

        this.imagenesUnidades = new HashMap<>();
        imagenesUnidades.put(ID_UNIDAD.AMOSUPREMO, "images/amoSupremo.png");
        imagenesUnidades.put(ID_UNIDAD.HIDRALISCO, "images/hidralisco.png");
        imagenesUnidades.put(ID_UNIDAD.MUTALISCO, "images/mutalisco.png");
        imagenesUnidades.put(ID_UNIDAD.ZANGANO, "images/zangano.png");
        imagenesUnidades.put(ID_UNIDAD.ZERLING, "images/zerling.png");
        imagenesUnidades.put(ID_UNIDAD.GUARDIAN, "images/guardian.png");
        imagenesUnidades.put(ID_UNIDAD.SCOUT, "images/scout.png");
        imagenesUnidades.put(ID_UNIDAD.DEVORADOR, "images/devorador.png");
        imagenesUnidades.put(ID_UNIDAD.DRAGON, "images/dragon.png");
        imagenesUnidades.put(ID_UNIDAD.ZEALOT, "images/zealot.png");
    }



    @FXML
    public void onClickedGuardian(MouseEvent mouseEvent) {
        try {
            Mutalisco mutalisco = (Mutalisco) ubicacion.getUnidad();
            mutalisco.evolucionarAGuardian( (RazaZerg) juegoModelo.getJugadorZerg().getRaza());
            ubicacion.quitarUnidad();
            ubicacion.asignarUnidad( mutalisco.getTipoMutalisco() );
            botonUnidad.borrarBotonDelTablero();
            BotonGuardian botonGuardian = new BotonGuardian(botonUnidad);
            tablero.add(botonGuardian, ubicacion.coordenada().horizontal(),ubicacion.coordenada().vertical());
            botonGuardian.fire();
        }catch ( RecursosInsuficientesError e ) {
            MostradorAlertas.mostrarAlerta(e,"un Guardian");
        } catch ( PoblacionExedidaError e){
            MostradorAlertas.mostrarAlerta(e);
        } catch (Exception e){
            MostradorAlertas.mostrarAlerta(e);
        }
    }

    @FXML
    public void onClickedDevorador(MouseEvent mouseEvent) {
        try {
            Mutalisco mutalisco = (Mutalisco) ubicacion.getUnidad();
            mutalisco.evolucionarDevorador( (RazaZerg) juegoModelo.getJugadorZerg().getRaza());
            ubicacion.quitarUnidad();
            ubicacion.asignarUnidad( mutalisco.getTipoMutalisco() );
            botonUnidad.borrarBotonDelTablero();
            BotonDevorador botonDevorador = new BotonDevorador(botonUnidad);
            tablero.add(botonDevorador, ubicacion.coordenada().horizontal(),ubicacion.coordenada().vertical());
            botonDevorador.fire();
        }catch ( RecursosInsuficientesError e ) {
            MostradorAlertas.mostrarAlerta(e,"un Guardian");
        } catch ( PoblacionExedidaError e){
            MostradorAlertas.mostrarAlerta(e);
        } catch (Exception e){
            MostradorAlertas.mostrarAlerta(e);
        }
    }
}
