package edu.fiuba.algo3.Controlador.ControllerFXML;

import edu.fiuba.algo3.Controlador.OtrosHandlers.MostradorAlertas;
import edu.fiuba.algo3.Vista.Botones.BotonCeldaTablero;
import edu.fiuba.algo3.Vista.Botones.BotonMoho;
import edu.fiuba.algo3.Vista.Botones.Construcciones.BotonExtractor;
import edu.fiuba.algo3.modelo.Edificio.EdificioNoOperativoError;
import edu.fiuba.algo3.modelo.Edificio.ExtractorCantidadMaximaDeZanganosError;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Extractor;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.Unidad.Zangano;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import edu.fiuba.algo3.modelo.tablero.Coordenada;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class MenuExtractorController extends  EnContruccion{
    @FXML
    public Button btnExtraerGas;


    @FXML
    public Label lblCantidadZanganos;

    @FXML
    public Label lblGasRestante;

    @FXML
    public AnchorPane contenerdorMenu;

    @FXML
    public Button btnAgregarZangano;

    private BotonCeldaTablero botonCeldaTablero;

    private GridPane tablero;

    private Ubicacion ubicacion;
    private JuegoModelo juegoModelo;

    public void setElements(GridPane tablero, Ubicacion ubicacion, BotonCeldaTablero botonCeldaTablero, JuegoModelo juegoModelo){
        this.botonCeldaTablero = botonCeldaTablero;
        this.tablero = tablero;
        this.ubicacion = ubicacion;
        this.juegoModelo = juegoModelo;
        Extractor extractor = (Extractor) ubicacion.getEdificio();

        if(!extractor.estaOperativo()){
            int cantidadTurnosParaSerOperativo = extractor.getTurnosRestantesParaSerOperativo();
            cargarMenuEnConstruccion(cantidadTurnosParaSerOperativo,contenerdorMenu);
        }
        int catidadZanganos = extractor.cantidadZanganosTrabajando();
        lblCantidadZanganos.setText(String.valueOf(catidadZanganos));
        btnExtraerGas.setDisable(catidadZanganos == 0);

        lblGasRestante.setText(String.valueOf(ubicacion.getVolcan().cantidadRecurso()));
        btnAgregarZangano.setDisable(!extractor.puedeAgregarZangano());
    }

    @FXML
    public void  onClickedExtraerGas(MouseEvent event) {
        Extractor extractorActual = (Extractor) ubicacion.getEdificio();
        GestionRecurso gestionRecurso = extractorActual.extraer( ubicacion.getVolcan() );
        juegoModelo.getJugadorActivo().getRaza().aumentarGas(gestionRecurso);
        lblGasRestante.setText(String.valueOf(ubicacion.getVolcan().cantidadRecurso()));
        btnExtraerGas.setDisable(true);
        btnAgregarZangano.setDisable(true);
    }

    @FXML
    public void onClickedAgregarZangano(MouseEvent event) {

        Extractor extractorActual = (Extractor) ubicacion.getEdificio();
        int contador = 0;
        ArrayList<Ubicacion>  ubicacionesManhattan =  juegoModelo.getMapa().buscar( this.ubicacion.coordenada(), 1);
        for(Ubicacion ubicacionAdy : ubicacionesManhattan){
            if( ubicacionAdy.existeZangano(this.ubicacion) ){
                agregarZangano(  (Zangano) ubicacionAdy.getUnidad(), extractorActual, ubicacionAdy );
                btnAgregarZangano.setDisable(!extractorActual.puedeAgregarZangano());
                contador++;
            }
        }
        if(contador == 0) System.out.println("No hay zanganos ");
        botonCeldaTablero.fire();

    }

    void agregarZangano(Zangano zanganoAdyacente, Extractor extractor, Ubicacion ubicacionAdy ){
        try{
            extractor.agregarZangano(zanganoAdyacente);
            Coordenada coordenadaAdy = ubicacionAdy.coordenada();
            BotonCeldaTablero botonCoordAntigua = (BotonCeldaTablero) findNodoDelGridPane(coordenadaAdy.horizontal(), coordenadaAdy.vertical());
            ubicacionAdy.quitarUnidad();
            BotonMoho botonMoho = new BotonMoho(botonCoordAntigua);
            botonCoordAntigua.borrarBotonDelTablero();
            tablero.add(botonMoho, coordenadaAdy.horizontal() , coordenadaAdy.vertical() );
            lblCantidadZanganos.setText(String.valueOf(extractor.cantidadZanganosTrabajando()));
            btnAgregarZangano.setDisable(!extractor.puedeAgregarZangano());
            //ver eliminar un zangano y poner moho o tierra segun corresponda
            // se queda ne n elbnaco el boton dodne estaba el zangano falta ponerle la superficie.
        } catch (EdificioNoOperativoError | ExtractorCantidadMaximaDeZanganosError e){
            MostradorAlertas.mostrarAlerta(e);
        }

    }


    private Node findNodoDelGridPane(int posHorizontal, int posVertical) {
        for (Node node : tablero.getChildren()) {
            if (GridPane.getColumnIndex(node) == posHorizontal && GridPane.getRowIndex(node) == posVertical) {
                return node;
            }
        }
        return null;
    }

}
