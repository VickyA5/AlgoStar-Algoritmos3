package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Vista.Botones.BotonCeldaTablero;
import edu.fiuba.algo3.Vista.Botones.BotonTierra;
import edu.fiuba.algo3.Vista.Botones.Unidades.BotonUnidad;
import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Atacante;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class BotonAtacableHandler implements EventHandler<ActionEvent> {


    private  VBox vBoxMenu;
    private  JuegoModelo juegoModelo;
    private GridPane tablero;
    private Ubicacion ubicacionAtacable;
    private  Atacante atacante;
    private  Atacable atacable;

    public BotonAtacableHandler(Atacable atacable, Atacante atacante, Ubicacion ubicacionAtacable, GridPane tablero, VBox vBoxMenu, JuegoModelo juegoModelo){
        this.atacante = atacante;
        this.atacable = atacable;
        this.ubicacionAtacable = ubicacionAtacable;
        this.tablero = tablero;
        this.vBoxMenu = vBoxMenu;
        this.juegoModelo = juegoModelo;
    }
    
    @Override
    public void handle(ActionEvent actionEvent) {
        atacante.atacar(atacable);
        if(atacable.ubicacion().existeEdificio() ){
            System.out.println( "Vida: " + atacable.ubicacion().getEdificio().getVida()
                    + "Escudo : " + atacable.ubicacion().getEdificio().getEscudo() );
            if (atacable.ubicacion().getEdificio().getVida() <= 0){
                ubicacionAtacable.quitarEdificio();
                BotonCeldaTablero botonCeldaTablero = (BotonCeldaTablero) findNodoDelGridPane(ubicacionAtacable.coordenada().horizontal(), ubicacionAtacable.coordenada().vertical() );
                botonCeldaTablero.borrarBotonDelTablero();
                BotonCeldaTablero botonNuevo = new BotonTierra( botonCeldaTablero.getTAMANIO(), atacable.ubicacion(), vBoxMenu, tablero, juegoModelo   );
                tablero.add(botonNuevo, atacable.ubicacion().coordenada().horizontal(), atacable.ubicacion().coordenada().vertical() );
            }

        }
        if( atacable.ubicacion().existeUnidad()){
            System.out.println( "Vida: " + atacable.ubicacion().getUnidad().getVida()
                    + "Escudo : " + atacable.ubicacion().getUnidad().getEscudo() );
            if (atacable.ubicacion().getUnidad().getVida() <= 0){
                ubicacionAtacable.quitarUnidad();
                BotonUnidad botonUnidad = (BotonUnidad) findNodoDelGridPane(ubicacionAtacable.coordenada().horizontal(), ubicacionAtacable.coordenada().vertical() );
                botonUnidad.colocarSuperficie();
            }
        }

    }


    private Node findNodoDelGridPane(int posX, int posY) {
        for (Node node : tablero.getChildren()) {
            if (GridPane.getColumnIndex(node) == posX && GridPane.getRowIndex(node) == posY) {
                return node;
            }
        }
        return null;
    }
}
