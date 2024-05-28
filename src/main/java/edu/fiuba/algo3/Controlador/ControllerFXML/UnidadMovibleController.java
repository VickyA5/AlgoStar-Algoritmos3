package edu.fiuba.algo3.Controlador.ControllerFXML;

import edu.fiuba.algo3.Controlador.OtrosHandlers.MostradorAlertas;
import edu.fiuba.algo3.Vista.Botones.BotonCeldaTablero;
import edu.fiuba.algo3.Vista.Botones.Unidades.BotonUnidad;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Unidad.UnidadNoOperativaError;
import edu.fiuba.algo3.modelo.tablero.Coordenada;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import edu.fiuba.algo3.modelo.tablero.UbicacionOcupadaError;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class UnidadMovibleController <TBotonUnidad extends BotonUnidad> extends EnContruccion{
    protected JuegoModelo juegoModelo;
    protected GridPane tablero;
    protected VBox vBoxMenu;
    protected Ubicacion ubicacion;
    protected TBotonUnidad botonUnidad;


    public void setElements(GridPane tablero, VBox vBoxMenu ,Ubicacion ubicacion, TBotonUnidad botonUnidad, JuegoModelo juegoModelo) {
        this.juegoModelo = juegoModelo;
        this.tablero = tablero;
        this.ubicacion = ubicacion;
        this.vBoxMenu = vBoxMenu;
        this.botonUnidad = botonUnidad;
    }

    public void activarMovimientoPorTeclado(){
        botonUnidad.setOnKeyPressed(keyEvent -> {
            Unidad unidad = ubicacion.getUnidad();
            try {
                if (keyEvent.getCode() == KeyCode.UP || keyEvent.getCode() == KeyCode.W){
                    unidad.moverseArriba();
                }
                if (keyEvent.getCode() == KeyCode.DOWN || keyEvent.getCode() == KeyCode.S){
                    unidad.moverseAbajo();
                }
                if (keyEvent.getCode() == KeyCode.RIGHT || keyEvent.getCode() == KeyCode.D){
                    unidad.moverseDerecha();
                }
                if (keyEvent.getCode() == KeyCode.LEFT || keyEvent.getCode() == KeyCode.A){
                    unidad.moverseIzquierda();
                }
                Coordenada nuevaCoordenada = unidad.ubicacion().coordenada();
                moverUnidadGraficamente(nuevaCoordenada);
            } catch (UnidadNoOperativaError | UbicacionOcupadaError e ){
                MostradorAlertas.mostrarAlerta(e);
                botonUnidad.requestFocus();
            } catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    public void desactivarMovimientoPorTeclado(){
        botonUnidad.setOnKeyPressed(keyEvent -> {});
    }

    public  TBotonUnidad obtenerNuevaInstanciaBotonUnidad(BotonCeldaTablero botonAReemplazar ) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        int i = 0;
        List<Object> args = new ArrayList<>();
        args.add(0,botonAReemplazar);
        Constructor<?>[] c = botonUnidad.getClass().getConstructors();
        //Arrays.stream(c).forEach(constructor -> System.out.println(constructor) );
        //if(botonAReemplazar instanceof  BotonUnidad) i = 1;
        TBotonUnidad nuevoBotonUnidad = (TBotonUnidad)botonUnidad.getClass().getConstructors()[i].newInstance(args.toArray());
        return nuevoBotonUnidad;
    }


    protected void moverUnidadGraficamente(Coordenada nuevaCoordenada){

        try {
            BotonCeldaTablero botonNuevaCordenada = (BotonCeldaTablero) findNodoDelGridPane(nuevaCoordenada.horizontal(),nuevaCoordenada.vertical());
            if(botonUnidad.equals(botonNuevaCordenada)){
                botonUnidad.requestFocus();
                return;
            }
            TBotonUnidad nuevoBotonUnidad = obtenerNuevaInstanciaBotonUnidad(botonNuevaCordenada);
            botonUnidad.colocarSuperficie();
            botonNuevaCordenada.borrarBotonDelTablero();
            tablero.add(nuevoBotonUnidad,nuevaCoordenada.horizontal(), nuevaCoordenada.vertical());
            nuevoBotonUnidad.fire();
            nuevoBotonUnidad.requestFocus();
        }catch (IllegalArgumentException e){
            e.printStackTrace();

        } catch (Exception e){
            e.printStackTrace();
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
