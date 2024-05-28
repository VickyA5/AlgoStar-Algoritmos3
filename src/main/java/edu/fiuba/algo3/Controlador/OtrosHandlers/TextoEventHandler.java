package edu.fiuba.algo3.Controlador.OtrosHandlers;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class TextoEventHandler implements EventHandler<KeyEvent> {
    Button botonEnviar;

    public TextoEventHandler(Button botonEnviar) {
        this.botonEnviar = botonEnviar;
    }

    // cuando toquen enter quiero hacer de cuenta que se hizo click en el boton enviar. se podra simular eso?
    // si con Event.fireEvenet lo que hace es que al botonEnviar le dispara el evneto actionEvent().
    @Override
    public void handle(KeyEvent keyEvent) {
        if( keyEvent.getCode() == KeyCode.ENTER ){
            Event.fireEvent(botonEnviar, new ActionEvent() );
        }

    }


}
