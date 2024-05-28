package edu.fiuba.algo3.Controlador.OtrosHandlers;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejemplo1 {


    public Ejemplo1(){}


    public void ejecutar(Stage stage ){
        stage.setTitle("El nombre de la ventana Inicial -**");

        TextField texto = new TextField();
        texto.setPromptText("Ingrese el texto deseado");

        Label etiqueta = new Label(); // para el mensajito de error o si esta bien .

        Button botonEnviar = new Button();
        botonEnviar.setText("Enviar");

        Button botonLimpiar = new Button();
        botonLimpiar.setText("LimpiarCuadroDeTexto");

        HBox contenedorHorizon = new HBox(botonLimpiar, botonEnviar); // Horizontal box., importante el  orden.
        contenedorHorizon.setSpacing(30); // les seteo un espacio entre los elementos de 10 pixeles.

        VBox contenedorPrincipal = new VBox(texto, contenedorHorizon, etiqueta );
        contenedorPrincipal.setSpacing(10);
        contenedorPrincipal.setPadding(new Insets(20) );

        BotonLimpiarHandler botonLimpiarEventHandler = new BotonLimpiarHandler(texto);
        botonLimpiar.setOnAction(botonLimpiarEventHandler);

        BotonEnviarHandler botonEnviarHandler = new BotonEnviarHandler(texto,etiqueta);
        botonEnviar.setOnAction(botonEnviarHandler);

        TextoEventHandler textoEventHandler = new TextoEventHandler(botonEnviar);
        texto.setOnKeyPressed(textoEventHandler);

        Scene escena = new Scene(contenedorPrincipal, 800, 800);

        stage.setScene(escena);

        stage.show();


    }

}
