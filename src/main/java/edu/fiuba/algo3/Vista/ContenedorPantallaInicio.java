package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.OtrosHandlers.BotonContinuarHandler;
import edu.fiuba.algo3.Controlador.OtrosHandlers.BotonSalirHandler;
import edu.fiuba.algo3.Controlador.ControllerFXML.InterfazJuegoControlador;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.Juego.Jugador;
import edu.fiuba.algo3.modelo.Raza.RazaProtoss;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;


public class ContenedorPantallaInicio extends VBox {
    public ContenedorPantallaInicio(Stage stage, Scene escenaRegistro) {
        stage.setTitle("Inicio");
        Label inicioJuego = new Label();
        inicioJuego.setText("Bienvenido a AlgoStar");
        inicioJuego.setFont(Font.font(40));
        inicioJuego.setTextFill(Color.rgb(255, 255, 255, 1));
        inicioJuego.setAlignment(Pos.CENTER);
        inicioJuego.setBackground(new Background(new BackgroundFill(Color.rgb(0,0,0,0.5), new CornerRadii(5.0), new Insets(-5.0))));

        Button botonContinuar = new Button();
        botonContinuar.setText("Continuar");
        botonContinuar.setMaxSize(200,100); //  (posx, posy?? no funciona)
        Button botonSalir = new Button();
        botonSalir.setOnAction(new BotonSalirHandler(botonSalir));
        BotonContinuarHandler botonContinuarEH = new BotonContinuarHandler(botonContinuar, escenaRegistro, stage); //refactor boton al pedo al handler
        botonContinuar.setOnAction(botonContinuarEH);
        /*botonContinuar.setOnAction(e -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/VistaFxml/RegistroJugador.fxml"));

                Scene scene = new Scene(fxmlLoader.load());
                RegistroJugadorControlador controlador = fxmlLoader.getController();
                controlador.setearJuego(new Juego());

                stage.setScene(scene);
                stage.show();
            }catch (IOException err){
                err.printStackTrace();
            }
        });*/

        File fileFondo = new File("images/fondoInicioFin.png");

        BackgroundImage primerBackGro = new BackgroundImage(new Image(fileFondo.toURI().toString(),
                1200, 675,true,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);


        this.getChildren().addAll( inicioJuego, botonContinuar,botonSalir);
        this.setBackground( new Background(primerBackGro) );
        this.setSpacing(100);
        this.setAlignment(Pos.CENTER);
    }

}
