package edu.fiuba.algo3.Controlador.OtrosHandlers;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.util.Objects;

public class Ejemplo2 {

    public Ejemplo2(){
    }
    public void ejecutar(Stage stage){

        stage.setTitle("AlgoStar");
        Label labelJugador = new Label();
        labelJugador.setText("Jugador 1");
        labelJugador.setFont(Font.font(40));
        labelJugador.setTextFill(Color.rgb(67, 227, 255, 1));

        Label labelIngreseNombre = new Label();
        labelIngreseNombre.setText("Nombre: ");
        labelIngreseNombre.setFont(Font.font(25));
        labelJugador.setTextFill(Color.rgb(67, 227, 255, 1));

        TextField campoNombre = new TextField();
        campoNombre.setPromptText("Ingrese Su Nombre Aqui");

        Button botonEnviarNombre = new Button();
        botonEnviarNombre.setText("Enviar");

        HBox contHorizNombre = new HBox(labelIngreseNombre, campoNombre, botonEnviarNombre);
        contHorizNombre.setSpacing(50);
        contHorizNombre.setPadding(new Insets(20) );
        contHorizNombre.setAlignment(Pos.BASELINE_CENTER);       //para centrarlo al medio

        Label labelColor = new Label();
        labelColor.setText("Seleccione un color: ");
        labelColor.setFont(Font.font(30));
        labelColor.setTextFill(Color.rgb(67, 227, 255, 1));


        Button botonColorRojo = new Button();
        botonColorRojo.setText("Rojo");

        Button botonColorAzul = new Button();
        botonColorAzul.setText("Azul");

        Button botonColorVerde = new Button();
        botonColorVerde.setText("Verde");

        Button botonColorAmarillo = new Button();
        botonColorAmarillo.setText("Amarillo");

        Button botonColorCeleste = new Button();
        botonColorCeleste.setText("Celeste");

        HBox contHorzColores = new HBox(botonColorRojo, botonColorAzul, botonColorVerde, botonColorAmarillo, botonColorCeleste );
        contHorzColores.setSpacing(40);
        contHorzColores.setAlignment(Pos.BASELINE_CENTER);

        VBox contVertColores = new VBox(labelColor,contHorzColores);
        contVertColores.setSpacing(20);
        contVertColores.setPadding(new Insets(10));
        contVertColores.setAlignment(Pos.BASELINE_CENTER);


        Label seleccionRaza = new Label();
        seleccionRaza.setText("Seleccione su raza: ");
        seleccionRaza.setFont(Font.font(30));
        seleccionRaza.setPadding(new Insets(10));
        seleccionRaza.setTextFill(Color.rgb(67, 227, 255, 1));

        Label labelImgZerg = new Label();
        Button botonZerg = new Button();
        VBox contVertZerg = obtenerContVer("ZERG", labelImgZerg, botonZerg);
        contVertZerg.setAlignment(Pos.CENTER);


        Label labelImgProtoss = new Label();
        Button botonProtoss = new Button();
        VBox contVertProtoss = obtenerContVer("PROTOSS", labelImgProtoss, botonProtoss);
        contVertProtoss.setAlignment(Pos.CENTER);


        HBox contHorzRazas = new HBox(contVertZerg, contVertProtoss);
        contHorzRazas.setSpacing(30);
        contHorzRazas.setAlignment(Pos.CENTER);

        Label nombreIngresado = new Label();
        nombreIngresado.setText("");
        nombreIngresado.setFont(Font.font(20));

        Label colorIngresado = new Label();
        colorIngresado.setText("");
        colorIngresado.setFont(Font.font(20));


        Label razaIngresada = new Label();
        razaIngresada.setText("");
        razaIngresada.setFont(Font.font(20));


        HBox resultadoFinal = new HBox(nombreIngresado, colorIngresado, razaIngresada );
        resultadoFinal.setSpacing(15);
        resultadoFinal.setAlignment(Pos.CENTER);

        BotonEnviar2Handler botonEnviar2Handler = new BotonEnviar2Handler(campoNombre, nombreIngresado);
        botonEnviarNombre.setOnAction(botonEnviar2Handler);

        BotonColorHandler botonColorHandlerRojo = new BotonColorHandler( Color.rgb(255,0,0) , colorIngresado, "Rojo");
        botonColorRojo.setOnAction(botonColorHandlerRojo);

        BotonColorHandler botonColorHandlerAzul = new BotonColorHandler( Color.rgb(0,0,255) , colorIngresado, "Rojo");
        botonColorAzul.setOnAction(botonColorHandlerAzul);

        BotonColorHandler botonColorHandlerVerde = new BotonColorHandler(Color.rgb(94,255,0), colorIngresado, "Rojo");
        botonColorVerde.setOnAction(botonColorHandlerVerde);

        BotonColorHandler botonColorHandlerAmarillo = new BotonColorHandler(Color.rgb(255,244,0), colorIngresado, "Rojo");
        botonColorAmarillo.setOnAction(botonColorHandlerAmarillo);

        BotonColorHandler botonColorHandlerCeleste = new BotonColorHandler(Color.rgb(0,255,180), colorIngresado, "Rojo");
        botonColorCeleste.setOnAction(botonColorHandlerCeleste);


        BotonRazaHandler botonRazaHandlerZerg = new BotonRazaHandler("ZERG", razaIngresada);
        botonZerg.setOnAction(botonRazaHandlerZerg);

        BotonRazaHandler botonRazaHandlerProt = new BotonRazaHandler("PROTOSS", razaIngresada);
        botonProtoss.setOnAction(botonRazaHandlerProt);

        TextoEnterHandler textoEnterHandler = new TextoEnterHandler(botonEnviarNombre);
        campoNombre.setOnKeyPressed(textoEnterHandler);

        File fileFondo = new File("images/fondoFinal.png");
        BackgroundImage primerBackGro = new BackgroundImage(new Image(fileFondo.toURI().toString(),
                1200,2500,true,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        Button botonContinuar = new Button();
        botonContinuar.setText("Continuar");

        VBox contendPrincipal = new VBox(labelJugador, contHorizNombre, contVertColores, seleccionRaza, contHorzRazas,  resultadoFinal,botonContinuar);
        contendPrincipal.setSpacing(10);
        contendPrincipal.setPadding(new Insets(20) );
        contendPrincipal.setAlignment(Pos.TOP_CENTER);
        contendPrincipal.setBackground(new Background(primerBackGro) );

        Scene escena = new Scene(contendPrincipal, 1200, 900);

        stage.setScene(escena);

        stage.show();


    }

    private VBox obtenerContVer(String nombreRaza, Label labelRaza, Button botonRaza) {
        File fileRaza = null;
        if(Objects.equals(nombreRaza, "ZERG")){
            fileRaza = new File("images/zerg.png");
            botonRaza.setText("RAZA ZERG");
        }
        else{
            fileRaza = new File("images/protoss.png");
            botonRaza.setText("RAZA PROTOSS");
        }

        Image imagenRaza = new Image(fileRaza.toURI().toString(),400, 400, true, true );
        labelRaza.setGraphic(new ImageView(imagenRaza) );
        return new VBox(labelRaza, botonRaza);
    }

}
