package edu.fiuba.algo3.Controlador.ControllerFXML;

import edu.fiuba.algo3.Controlador.OtrosHandlers.MostradorAlertas;
import edu.fiuba.algo3.Vista.Botones.BotonCeldaTablero;
import edu.fiuba.algo3.Vista.Botones.Construcciones.BotonEspiral;
import edu.fiuba.algo3.Vista.Botones.Unidades.BotonMutalisco;
import edu.fiuba.algo3.modelo.Edificio.EdificioNoOperativoError;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Espiral;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.Juego.Jugador;
import edu.fiuba.algo3.modelo.Raza.PoblacionExedidaError;
import edu.fiuba.algo3.modelo.tablero.Coordenada;
import edu.fiuba.algo3.modelo.tablero.Mapa;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class MenuEspiralController extends EnContruccion{
    @FXML
    public AnchorPane contenedorMenu;
    @FXML
    public Button btnCrearMutalisco;
    private Espiral espiral;
    private JuegoModelo juegoModelo;
    private GridPane tablero;

    private BotonEspiral botonEspiral;

    @FXML
    public void onClickCrearMutalisco(MouseEvent mouseEvent) {
        Mapa mapa = juegoModelo.getMapa();
        Jugador jugador = juegoModelo.getJugadorActivo();
        try{
            espiral.asignarRaza(jugador.getRaza());
            espiral.crearMutalisco();
            boolean agregado = false;

            for(int i = 0; i < mapa.getDimension() ; i++){
                for(int j = 0; j < mapa.getDimension(); j++){
                    Coordenada coordenada = new Coordenada(i,j);
                    Ubicacion ubicacion = mapa.buscar(coordenada);
                    if( ubicacion.ubicacionVacia() && !agregado ) {
                        ubicacion.asignarUnidad(jugador.getRaza().getUltimaUnidad());
                        System.out.println("Ubicacion actual Creacion mutalisco");
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
                        BotonMutalisco botonMutalisco = new BotonMutalisco(botonCeldaTablero);
                        tablero.add(botonMutalisco, i, j);
                        agregado = true;
                    }
                }
            }
        } catch (EdificioNoOperativoError | PoblacionExedidaError  e){
            MostradorAlertas.mostrarAlerta(e);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setElements(Espiral espiral, GridPane tablero, JuegoModelo juegoModelo, BotonEspiral botonEspiral) {
        this.espiral = espiral;
        this.juegoModelo = juegoModelo;
        this.tablero = tablero;
        this.botonEspiral = botonEspiral;

        if( !espiral.estaOperativo() ){
            int cantidadTurnosParaSerOperativo = espiral.getTurnosRestantesParaSerOperativo();
            cargarMenuEnConstruccion(cantidadTurnosParaSerOperativo,contenedorMenu);
            return ;
        }
    }
}
