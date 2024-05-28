package edu.fiuba.algo3.Controlador.ControllerFXML;

import edu.fiuba.algo3.Controlador.OtrosHandlers.MostradorAlertas;
//import edu.fiuba.algo3.Vista.Botones.BotonZealot;
import edu.fiuba.algo3.Vista.Botones.BotonCeldaTablero;
import edu.fiuba.algo3.Vista.Botones.Construcciones.BotonAcceso;
import edu.fiuba.algo3.Vista.Botones.Unidades.BotonDragon;
import edu.fiuba.algo3.Vista.Botones.Unidades.BotonScout;
import edu.fiuba.algo3.Vista.Botones.Unidades.BotonZealot;
import edu.fiuba.algo3.modelo.Edificio.EdificioNoOperativoError;
import edu.fiuba.algo3.modelo.Edificio.Protoss.Acceso;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.Raza.PoblacionExedidaError;
import edu.fiuba.algo3.modelo.Raza.RazaProtoss;
import edu.fiuba.algo3.modelo.Unidad.Dragon;
import edu.fiuba.algo3.modelo.Unidad.InsuficientesRecursosParaCrearUnidadError;
import edu.fiuba.algo3.modelo.Unidad.Scout;
import edu.fiuba.algo3.modelo.Unidad.Zealot;
import edu.fiuba.algo3.modelo.tablero.Coordenada;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class MenuAccesoController extends EnContruccion{
    @FXML
    public AnchorPane contenerdorMenu;

    private GridPane tablero;
    private Ubicacion ubicacion;
    private RazaProtoss razaProtoss;
    BotonAcceso botonAcceso;
    private JuegoModelo juegoModelo;



    @FXML
    public void onClickedConstruirDragon(MouseEvent event) {
        ArrayList<Ubicacion> ubicacionesManhattan =  juegoModelo.getMapa().buscar( ubicacion.coordenada(), 2);
        Acceso acceso = (Acceso) ubicacion.getEdificio();
        for(Ubicacion ubicacionMah : ubicacionesManhattan){
            if(ubicacionMah.estaLibre()){
                agregarDragon(ubicacionMah,acceso);
                break;
            }
        }
    }

    @FXML
    public void onClickedConstruirZealot(MouseEvent event) {
        ArrayList<Ubicacion> ubicacionesManhattan =  juegoModelo.getMapa().buscar( ubicacion.coordenada(), 2);
        Acceso acceso = (Acceso) ubicacion.getEdificio();
        for(Ubicacion ubicacionMah : ubicacionesManhattan){
            if(ubicacionMah.estaLibre()){
                agregarZealot(ubicacionMah, acceso);
                break;
            }
        }
    }

    private void agregarDragon(Ubicacion ubicacionMah, Acceso acceso){
        Coordenada coordLibre = ubicacionMah.coordenada();
        try {
            ubicacionMah.asignarUnidad(acceso.crearDragon());
            BotonDragon botonDragon = new BotonDragon( eliminarBotonAntiguo(coordLibre) );
            tablero.add(botonDragon, coordLibre.horizontal() , coordLibre.vertical() );
        } catch ( PoblacionExedidaError e) {
            MostradorAlertas.mostrarAlerta(e, "Construya mas pilones");
        } catch ( InsuficientesRecursosParaCrearUnidadError e){
            MostradorAlertas.mostrarAlerta(e, "No se puede crear el Dragon");
        }catch (EdificioNoOperativoError e){
            MostradorAlertas.mostrarAlerta(e);
        }

    }
    private void agregarZealot(Ubicacion ubicacionMah, Acceso acceso) {
        Coordenada coordLibre = ubicacionMah.coordenada();
        try {
            ubicacionMah.asignarUnidad(acceso.crearZealot());

            BotonZealot botonZealot = new BotonZealot( eliminarBotonAntiguo(coordLibre) );
            tablero.add(botonZealot, coordLibre.horizontal() , coordLibre.vertical() );
        } catch ( PoblacionExedidaError e) {
            MostradorAlertas.mostrarAlerta(e, "Construya mas pilones");
        } catch ( InsuficientesRecursosParaCrearUnidadError e){
            MostradorAlertas.mostrarAlerta(e, "No se puede crear el Zealot");
        }catch (EdificioNoOperativoError e){
            MostradorAlertas.mostrarAlerta(e);
        }
    }



    BotonCeldaTablero eliminarBotonAntiguo(Coordenada coordLibre){
        BotonCeldaTablero botonAntiguo = (BotonCeldaTablero) findNodoDelGridPane(coordLibre.horizontal(), coordLibre.vertical() );
        botonAntiguo.borrarBotonDelTablero();
        return botonAntiguo;
    }


    public void setElements(GridPane tablero, Ubicacion ubicacion, RazaProtoss razaProtoss, BotonAcceso botonAcceso, JuegoModelo juegoModelo){
        this.tablero = tablero;
        this.ubicacion = ubicacion;
        this.razaProtoss = razaProtoss;
        this.botonAcceso = botonAcceso;
        this.juegoModelo = juegoModelo;
        Acceso acceso = (Acceso) ubicacion.getEdificio();
        if(!acceso.estaOperativo()){
            int cantidadTurnosParaSerOperativo = acceso.getTurnosRestantesParaSerOperativo();
            cargarMenuEnConstruccion(cantidadTurnosParaSerOperativo,contenerdorMenu);
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
