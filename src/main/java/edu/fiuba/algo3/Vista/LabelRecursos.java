package edu.fiuba.algo3.Vista;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.layout.*;
import javafx.geometry.Insets;

import java.io.File;

public class LabelRecursos {
    private Label label;

    public LabelRecursos(String path){
        label = new Label("prueba");
        File recurso = new File(path);
        Image imagen = new Image(recurso.toURI().toString(),20,20,true,true);
        ImageView view = new ImageView(imagen);
        label.setGraphic(view);
        label.setFont(new Font(20));
        label.setTextFill(Color.RED);
        label.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 80, 0.7), new CornerRadii(5.0), new Insets(-5.0))));
    }

    public Label getLabel(){
        return label;
    }
}
