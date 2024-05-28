package edu.fiuba.algo3.Controlador.ControllerFXML;

import edu.fiuba.algo3.Controlador.OtrosHandlers.MostradorAlertas;
import edu.fiuba.algo3.Vista.Botones.BotonCeldaTablero;
import edu.fiuba.algo3.Vista.Botones.Construcciones.BotonAcceso;
import edu.fiuba.algo3.Vista.Botones.Construcciones.BotonPuertoEstelar;
import edu.fiuba.algo3.Vista.Botones.Unidades.BotonScout;
import edu.fiuba.algo3.modelo.Edificio.EdificioNoOperativoError;
import edu.fiuba.algo3.modelo.Edificio.Protoss.Acceso;
import edu.fiuba.algo3.modelo.Edificio.Protoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.Raza.PoblacionExedidaError;
import edu.fiuba.algo3.modelo.Raza.RazaProtoss;
import edu.fiuba.algo3.modelo.Unidad.InsuficientesRecursosParaCrearUnidadError;
import edu.fiuba.algo3.modelo.tablero.Coordenada;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class MenuPuertoEstelarController extends EnContruccion{
    
    @FXML
    public AnchorPane contenerdorMenu;
    private GridPane tablero;
    private Ubicacion ubicacion;

    private BotonPuertoEstelar botonPuertoEstelar;
    private JuegoModelo juegoModelo;


    @FXML
    public void onClickedConstruirScout(MouseEvent mouseEvent) {
        ArrayList<Ubicacion> ubicacionesManhattan =  juegoModelo.getMapa().buscar( ubicacion.coordenada(), 2);
        PuertoEstelar puertoEstelar = (PuertoEstelar) ubicacion.getEdificio();
        for(Ubicacion ubicacionMah : ubicacionesManhattan){
            if(ubicacionMah.estaLibre()){
                agregarScout(ubicacionMah, puertoEstelar);
                break;
            }
        }


    }

    private void agregarScout(Ubicacion ubicacionMah, PuertoEstelar puertoEstelar) {
        Coordenada coordLibre = ubicacionMah.coordenada();
        try {
            ubicacionMah.asignarUnidad( puertoEstelar.crearScout() );
            BotonScout botonScout = new BotonScout( eliminarBotonAntiguo(coordLibre) );
            tablero.add(botonScout, coordLibre.horizontal() , coordLibre.vertical() );
        } catch ( PoblacionExedidaError e) {
            MostradorAlertas.mostrarAlerta(e, "Construya mas pilones");
        } catch ( InsuficientesRecursosParaCrearUnidadError e){
            MostradorAlertas.mostrarAlerta(e, "No se puede crear el scout");
        } catch (EdificioNoOperativoError e){
            MostradorAlertas.mostrarAlerta(e);
        }

    }

    BotonCeldaTablero eliminarBotonAntiguo(Coordenada coordLibre){
        BotonCeldaTablero botonAntiguo = (BotonCeldaTablero) findNodoDelGridPane(coordLibre.horizontal(), coordLibre.vertical() );
        botonAntiguo.borrarBotonDelTablero();
        return botonAntiguo;
    }


    public void setElements(GridPane tablero, Ubicacion ubicacion, BotonPuertoEstelar botonPuertoEstelar, JuegoModelo juegoModelo){
        this.tablero = tablero;
        this.ubicacion = ubicacion;
        this.botonPuertoEstelar = botonPuertoEstelar;
        this.juegoModelo = juegoModelo;
        PuertoEstelar puertoEstelar = (PuertoEstelar) ubicacion.getEdificio();
        if(!puertoEstelar.estaOperativo()){
            int cantidadTurnosParaSerOperativo = puertoEstelar.getTurnosRestantesParaSerOperativo();
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
