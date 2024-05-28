package edu.fiuba.algo3.Controlador.OtrosHandlers;

import edu.fiuba.algo3.Controlador.ControllerFXML.InterfazJuegoControlador;
import edu.fiuba.algo3.Vista.ContenedorRegistro;
import edu.fiuba.algo3.modelo.Juego.*;
import edu.fiuba.algo3.modelo.Raza.RazaProtoss;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class BotonContinuarRegistroHandler implements EventHandler<ActionEvent> {

    Stage stage;
    ContenedorRegistro contenedorRegistro;
    Label labelNombre;
    Label labelColorIngresado;
    Label labelRaza;

    JuegoModelo juegoModelo;

    public BotonContinuarRegistroHandler(Stage stage, ContenedorRegistro contenedorRegistro, Label nombreIngresado, Label colorIngresado, Label razaIngresada, JuegoModelo algoStart) {
        this.stage = stage;
        this.contenedorRegistro = contenedorRegistro;
        this.labelNombre = nombreIngresado;
        this.labelColorIngresado = colorIngresado;
        this.labelRaza = razaIngresada;
        this.juegoModelo = algoStart;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Jugador jugadorNuevo = null;
        RazaZerg zerg = null;
        RazaProtoss protoss = null;
        jugadorNuevo = crearJugador();

        if(jugadorNuevo != null){
            capturadorDeErroresJugador(jugadorNuevo);
        }
        if(juegoModelo.jugadoresCompletos() ){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/VistaFxml/InterfazJuego.fxml"));
                Parent variableCargando = fxmlLoader.load();
                InterfazJuegoControlador interfazJuegoControlador = fxmlLoader.getController();
                interfazJuegoControlador.setJuego(juegoModelo);
                interfazJuegoControlador.inicializar();
                Scene scene = new Scene(variableCargando);
                stage.setScene(scene);
            }catch (IOException err){
                err.printStackTrace();
            }

        }
        else{
            ContenedorRegistro nuevoContenedorRegistro = new ContenedorRegistro(stage, juegoModelo);
            Scene escenaDeRegistro = new Scene( nuevoContenedorRegistro, 1060, 650);
            stage.setScene(escenaDeRegistro);
        }
    }

    private Jugador crearJugador(){
        RazaZerg zerg = null;
        RazaProtoss protoss = null;
        Jugador jugadorNuevo = null;

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");

        if( labelRaza.getText().equals("ZERG") ){
            zerg = new RazaZerg();
            try{
                jugadorNuevo = new Jugador(labelNombre.getText(), labelColorIngresado.getText(), zerg );
            } catch(JugadorNombreError e){
                alert.setContentText("El nombre del jugador tiene que tener mas de 6 caracteres");
                alert.showAndWait();
                resetearScena();
            }
        }

        if ( labelRaza.getText().equals("PROTOSS") ){
            protoss = new RazaProtoss();
            try{
                jugadorNuevo = new Jugador(labelNombre.getText(), labelColorIngresado.getText(), protoss);
            } catch( JugadorNombreError e){
                alert.setContentText("El nombre del jugador tiene que tener mas de 6 caracteres");
                alert.showAndWait();
                resetearScena();
            }
        }

        return jugadorNuevo;
    }

    private void resetearScena(){
        ContenedorRegistro nuevoContenedorRegistro = new ContenedorRegistro(stage, juegoModelo);
        Scene escenaDeRegistro = new Scene( nuevoContenedorRegistro, 1200 ,900);
        stage.setScene(escenaDeRegistro);
    }

    private void capturadorDeErroresJugador(Jugador jugadorNuevo){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        try{
            juegoModelo.agregarJugador(jugadorNuevo);
        } catch ( JugadorMismaRazaError e){
            alert.setContentText("Error el Jugador 1 Tiene la misma raza");
            alert.showAndWait();
            resetearScena();
        } catch ( JugadorMismoNombreError e){
            alert.setContentText("Error el Jugador 1 Tiene el mismo nombre");
            alert.showAndWait();
            resetearScena();
        } catch (JugadorMismoColorError e){
            alert.setContentText("Error el Jugador 1 Tiene el mismo color");
            alert.showAndWait();
            resetearScena();
        } catch (JugadorNombreError e){
            alert.setContentText("El nombre del jugador tiene que tener mas de 6 caracteres");
            alert.showAndWait();
            resetearScena();
        }

    }
}
