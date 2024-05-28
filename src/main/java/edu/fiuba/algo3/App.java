package edu.fiuba.algo3;

import edu.fiuba.algo3.Vista.ContenedorPantallaInicio;
import edu.fiuba.algo3.Vista.ContenedorRegistro;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage){
        JuegoModelo algoStart = new JuegoModelo();
        ContenedorRegistro contenedorRegistro = new ContenedorRegistro(stage,algoStart);
        Scene escenaRegistro = new Scene(contenedorRegistro, 1200, 750);

        ContenedorPantallaInicio contenedorPantallaInicio = new ContenedorPantallaInicio(stage, escenaRegistro);
        Scene escenaInicial = new Scene(contenedorPantallaInicio, 1200, 675); // (posx, posy)

        stage.setScene(escenaInicial);
        stage.show();



    }

    public static void main(String[] args) {
        launch();
    }

}