package edu.fiuba.algo3.Vista.Botones;

import edu.fiuba.algo3.Controlador.ControllerFXML.CargadorFXML;
import edu.fiuba.algo3.Controlador.OtrosHandlers.RUTAS_FXML;
import edu.fiuba.algo3.modelo.ID_RAZA;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.Juego.Jugador;
import edu.fiuba.algo3.modelo.Observers.ObservadorJugadorActivo;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;

public abstract class BotonCeldaTablero extends BotonGenerico implements ObservadorJugadorActivo {

    protected VBox vBoxMenu;
    protected Ubicacion ubicacion;

    protected GridPane tablero;

    protected JuegoModelo juegoModelo;

    protected FXMLLoader vistaMenu;
    protected RUTAS_FXML menuParaProtoss;
    protected RUTAS_FXML menuParaZerg;


    public BotonCeldaTablero(int TAMANIO, String rutaImagen, Ubicacion ubicacion, VBox vBoxMenu, GridPane tablero, JuegoModelo juegoModelo, RUTAS_FXML menuParaProtoss, RUTAS_FXML menuParaZerg) {
        super(TAMANIO, rutaImagen, ubicacion);
        this.vBoxMenu = vBoxMenu;
        this.ubicacion = ubicacion;
        this.tablero = tablero;
        this.juegoModelo = juegoModelo;
        this.menuParaProtoss = menuParaProtoss;
        this.menuParaZerg = menuParaZerg;
        juegoModelo.subscribirseJugadorActivo(this);
        this.actualizar(juegoModelo.getJugadorActivo());
    }

    public BotonCeldaTablero(BotonCeldaTablero botonACopiar,  String rutaImagen, RUTAS_FXML menuParaProtoss, RUTAS_FXML menuParaZerg) {
        super(botonACopiar.getTAMANIO(), rutaImagen, botonACopiar.ubicacion);
        this.vBoxMenu = botonACopiar.vBoxMenu;
        this.ubicacion = botonACopiar.ubicacion;
        this.tablero = botonACopiar.tablero;
        this.juegoModelo = botonACopiar.juegoModelo;
        this.menuParaProtoss = menuParaProtoss;
        this.menuParaZerg = menuParaZerg;
        vistaMenu = new FXMLLoader();
        juegoModelo.subscribirseJugadorActivo(this);
        this.actualizar(juegoModelo.getJugadorActivo());
    }

    public void borrarBotonDelTablero(){
        juegoModelo.desubscribirseJugadorActivo(this);
        vBoxMenu.getChildren().clear();
        tablero.getChildren().remove(this);
    }

    @Override
    public void actualizar(Jugador jugadorActivo) {
        vistaMenu = new FXMLLoader();
        ID_RAZA raza = jugadorActivo.getRaza().getEntidad();
        RUTAS_FXML menuRutaKey = (raza.equals(ID_RAZA.PROTOSS)) ? menuParaProtoss :  menuParaZerg;
        URL url = this.getClass().getResource(CargadorFXML.MAP_RUTAS_FXML.get(menuRutaKey));
        vistaMenu.setLocation(url);
        Pane layoutVista = CargadorFXML.prepararLayout(vistaMenu);

        setElmentsController();

        Pane finalLayoutVista = layoutVista;
        this.setOnAction(event -> {
            vBoxMenu.getChildren().clear();
            vBoxMenu.getChildren().addAll(finalLayoutVista);
        });
    }


    public abstract void setElmentsController();

}
