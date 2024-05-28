package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Edificio.Protoss.Pilon;
import edu.fiuba.algo3.modelo.tablero.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso14 {
    @Test
    public void testNoPuedenHaberConstruccionesProtossEnELMoho(){

        Ubicacion ubicacion= new Ubicacion(new Coordenada(5,5));
        ubicacion.darTipo(new Moho());

        assertThrows( ConstruccionProtoEnMohoError.class, ()-> {
            ubicacion.ubicar(new Pilon());;
        });

    }
    @Test
    public void testElMohoNOPuedeInvadirConstrucciones(){
        Mapa mapa = new Mapa(12,12);
        Ubicacion ubicacion1 = mapa.buscar(new Coordenada(6,6));
        Ubicacion ubicacion2 = mapa.buscar(new Coordenada(5,5));
        ubicacion1.darTipo(new Moho());
        ubicacion2.ubicar(new Pilon());

        ubicacion1.crecer(5,mapa);
        ubicacion2.desalojar();

        assertDoesNotThrow( ()-> {
            ubicacion2.ubicar(new Pilon());
        });

    }


}
