package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Edificio.*;
import edu.fiuba.algo3.modelo.Edificio.Zerg.*;
import edu.fiuba.algo3.modelo.HitPoints.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso10 {

    @Test
    public void UnCriaderoReciBeDañoYUsaElMetodoRecibirDañoDeHitPoints(){
        //HitPoints HPmock = mock(HitPoints.class);
        HitPoints HP = new HPZerg(500);
        Edificio edificio = new Criadero(); //podría ser cualquier edificio
        edificio.asignarHP(HP);
        edificio.recibirDaño(30);

        //verify(HP,times(1)).recibirDaño(30);
        assertEquals(470, edificio.vidaActual());
    }

    @Test
    public void UnCriaderoRecibeDañoySeRegeneraPorTurno(){

        //HitPoints HPmock = mock(HitPoints.class);
        HitPoints HP = new HPZerg(500);
        Edificio edificio = new Criadero(); //podría ser cualquier edificio
        edificio.asignarHP(HP);
        edificio.recibirDaño(30);
        //when(HPmock.vida()).thenReturn(500);
        for(int i=0; i<10;i++){
            edificio.regeneracionFinDeTurno();
        }

        //verify(HPmock,times(10)).regenerar() ;

        assertEquals(500,edificio.vidaActual());
    }
    @Test
    public void UnaReservaReciBeDañoYUsaElMetodoRecibirDañoDeHitPoints(){
        //HitPoints HPmock = mock(HitPoints.class);
        HitPoints HP = new HPZerg(1000);
        Edificio edificio = new ReservaDeReproduccion(); //podría ser cualquier edificio
        edificio.asignarHP(HP);
        edificio.recibirDaño(30);

        //verify(HPmock,times(1)).recibirDaño(30);
        assertEquals(970,edificio.vidaActual());
    }

    @Test
    public void UnaReservaRecibeDañoySeRegeneraPorTurno(){

        //HitPoints HPmock = mock(HitPoints.class);
        HitPoints HP = new HPZerg(1000);
        Edificio edificio = new ReservaDeReproduccion(); //podría ser cualquier edificio
        edificio.asignarHP(HP);
        edificio.recibirDaño(30);
        //when(HPmock.vida()).thenReturn(1000);
        for(int i=0; i<10;i++){
            edificio.regeneracionFinDeTurno();
        }

        //verify(HPmock,times(10)).regenerar();

        assertEquals(1000,edificio.vidaActual());
    }

    @Test
    public void UnExtractorReciBeDañoYUsaElMetodoRecibirDañoDeHitPoints(){
        //HitPoints HPmock = mock(HitPoints.class);
        HitPoints HP = new HPZerg(750);
        Edificio edificio = new Extractor(); //podría ser cualquier edificio
        edificio.asignarHP(HP);
        edificio.recibirDaño(30);

        //verify(HPmock,times(1)).recibirDaño(30);
        assertEquals(720,edificio.vidaActual());
    }

    @Test
    public void UnExtractorRecibeDañoySeRegeneraPorTurno(){

        //HitPoints HPmock = mock(HitPoints.class);
        HitPoints HP = new HPZerg(750);
        Edificio edificio = new Extractor(); //podría ser cualquier edificio
        edificio.asignarHP(HP);
        edificio.recibirDaño(30);
        // when(HPmock.vida()).thenReturn(750);
        for(int i=0; i<10;i++){
            edificio.regeneracionFinDeTurno();
        }

        //verify(HPmock,times(10)).regenerar();

        assertEquals(750,edificio.vidaActual());
    }
    @Test
    public void UnaGuaridaReciBeDañoYUsaElMetodoRecibirDañoDeHitPoints(){
        //HitPoints HPmock = mock(HitPoints.class);
        HitPoints HP = new HPZerg(1250);
        Edificio edificio = new Guarida(); //podría ser cualquier edificio
        edificio.asignarHP(HP);
        edificio.recibirDaño(30);

        //verify(HPmock,times(1)).recibirDaño(30);
        assertEquals(1220,edificio.vidaActual());
    }

    @Test
    public void UnaGuaridaRecibeDañoySeRegeneraPorTurno(){

        //HitPoints HPmock = mock(HitPoints.class);
        HitPoints HP = new HPZerg(1250);
        Edificio edificio = new Guarida(); //podría ser cualquier edificio
        edificio.asignarHP(HP);
        edificio.recibirDaño(30);
        //when(HPmock.vida()).thenReturn(1250);
        for(int i=0; i<10;i++){
            edificio.regeneracionFinDeTurno();
        }

        //verify(HPmock,times(10)).regenerar();

        assertEquals(1250,edificio.vidaActual());
    }
    @Test
    public void UnaEspiralReciBeDañoYUsaElMetodoRecibirDañoDeHitPoints(){
        //HitPoints HPmock = mock(HitPoints.class);
        HitPoints HP = new HPZerg(1300);
        Edificio edificio = new Espiral(); //podría ser cualquier edificio
        edificio.asignarHP(HP);
        edificio.recibirDaño(30);

        //verify(HPmock,times(1)).recibirDaño(30);
        assertEquals(1270,edificio.vidaActual());
    }

    @Test
    public void UnaEspiralRecibeDañoySeRegeneraPorTurno(){

        //HitPoints HPmock = mock(HitPoints.class);
        HitPoints HP = new HPZerg(1300);
        Edificio edificio = new Espiral(); //podría ser cualquier edificio
        edificio.asignarHP(HP);
        edificio.recibirDaño(30);
        //when(HPmock.vida()).thenReturn(1300);
        for(int i=0; i<10;i++){
            edificio.regeneracionFinDeTurno();
        }

        //verify(HPmock,times(10)).regenerar();

        assertEquals(1300,edificio.vidaActual());
    }
}