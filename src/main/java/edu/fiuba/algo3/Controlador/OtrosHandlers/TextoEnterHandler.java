package edu.fiuba.algo3.Controlador.OtrosHandlers;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class TextoEnterHandler implements EventHandler<KeyEvent> {
    Button botonEnviarNombre;

    public TextoEnterHandler(Button botonEnviarNombre) {
        this.botonEnviarNombre = botonEnviarNombre;

    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if( keyEvent.getCode() == KeyCode.ENTER ){
            Event.fireEvent(botonEnviarNombre, new ActionEvent() );
        }

    }
}
