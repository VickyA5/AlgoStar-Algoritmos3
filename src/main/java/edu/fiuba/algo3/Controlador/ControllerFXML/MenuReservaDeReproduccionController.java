package edu.fiuba.algo3.Controlador.ControllerFXML;

import edu.fiuba.algo3.Controlador.OtrosHandlers.MostradorAlertas;
import edu.fiuba.algo3.Vista.Botones.BotonCeldaTablero;
import edu.fiuba.algo3.Vista.Botones.Construcciones.BotonReservaDeReproduccion;
import edu.fiuba.algo3.Vista.Botones.Unidades.BotonZangano;
import edu.fiuba.algo3.Vista.Botones.Unidades.BotonZerling;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Edificio.EdificioNoOperativoError;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Criadero;
import edu.fiuba.algo3.modelo.Edificio.Zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.Juego.Jugador;
import edu.fiuba.algo3.modelo.NoQuedanLarvasError;
import edu.fiuba.algo3.modelo.Raza.PoblacionExedidaError;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import edu.fiuba.algo3.modelo.Unidad.Larva;
import edu.fiuba.algo3.modelo.Unidad.Zangano;
import edu.fiuba.algo3.modelo.tablero.Coordenada;
import edu.fiuba.algo3.modelo.tablero.Mapa;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class MenuReservaDeReproduccionController extends EnContruccion{

    @FXML
    public Button btnEvolucionarLarvaAZerling;

    @FXML
    public AnchorPane contenerdorMenu;
    private ReservaDeReproduccion reservaDeReproduccion;
    private GridPane tablero;
    private JuegoModelo juegoModelo;

    @FXML
    public void onClickEvolucionarLarvaAZangano(MouseEvent mouseEvent) {
        Mapa mapa = juegoModelo.getMapa();
        Jugador jugador = juegoModelo.getJugadorActivo();
        try{
            reservaDeReproduccion.asignarRaza(jugador.getRaza());
            RazaZerg razaZerg;
            razaZerg = (RazaZerg) juegoModelo.getJugadorZerg().getRaza();
            Larva larva = razaZerg.getLarva();
            reservaDeReproduccion.crearZerling(larva);

            boolean agregado = false;

            for(int i = 0; i < mapa.getDimension() ; i++){
                for(int j = 0; j < mapa.getDimension(); j++){
                    Coordenada coordenada = new Coordenada(i,j);
                    Ubicacion ubicacion = mapa.buscar(coordenada);
                    if( ubicacion.ubicacionVacia() && !agregado ) {
                        ubicacion.asignarUnidad(jugador.getRaza().getUltimaUnidad());
                        System.out.println("Ubicacion actual Creacion Zerling");
                        System.out.println("horizontal: "+ String.valueOf(ubicacion.coordenada().horizontal() ) +
                                " vertical: "+ String.valueOf(ubicacion.coordenada().vertical()));
                        BotonCeldaTablero botonCeldaTablero = null;
                        for (Node node : tablero.getChildren()) {
                            BotonCeldaTablero boton = (BotonCeldaTablero) node;
                            if(boton.getUbicacion().equals(ubicacion)) {
                                botonCeldaTablero = (BotonCeldaTablero) node;
                                break;
                            }
                        }
                        botonCeldaTablero.borrarBotonDelTablero();
                        BotonZerling botonZerling = new BotonZerling(botonCeldaTablero);
                        tablero.add(botonZerling, i, j);
                        agregado = true;
                    }
                }
            }
        }catch (NoQuedanLarvasError e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No hay larvas en ningun criadero");
            alert.showAndWait();
        } catch (EdificioNoOperativoError | PoblacionExedidaError e){
            MostradorAlertas.mostrarAlerta(e);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setElements(ReservaDeReproduccion reservaDeReproduccion, GridPane tablero, JuegoModelo juegoModelo, BotonReservaDeReproduccion botonReservaDeReproduccion){
        this.reservaDeReproduccion = reservaDeReproduccion;
        this.juegoModelo = juegoModelo;
        this.tablero = tablero;

        if(!reservaDeReproduccion.estaOperativo()){
            int cantidadTurnosParaSerOperativo = reservaDeReproduccion.getTurnosRestantesParaSerOperativo();
            cargarMenuEnConstruccion(cantidadTurnosParaSerOperativo,contenerdorMenu);
        }
    }
}
