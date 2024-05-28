package edu.fiuba.algo3.Controlador.OtrosHandlers;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ejemplo3 {
    public void ejecutar(Stage stage){

        File file = new File("images/dados.png");
        Image imagen = new Image(file.toURI().toString(),400,400,true,true);

        Label unLabel = new Label();
        unLabel.setGraphic( new ImageView(imagen) );

        Scene scenaConImagen = new Scene(unLabel);

        stage.setScene(scenaConImagen);
        stage.show();


    }
}
