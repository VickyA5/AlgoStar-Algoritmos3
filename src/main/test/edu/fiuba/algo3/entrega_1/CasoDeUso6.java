package edu.fiuba.algo3.entrega_1;


import edu.fiuba.algo3.modelo. *;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Criadero;
import edu.fiuba.algo3.modelo.tablero. *;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso6 {

    @Test
    public void testElMohoCreceEnUno(){
        Mapa mapa = new Mapa(10,10);
        Ubicacion ubicacion1 = mapa.buscar(new Coordenada(5,5));
        ubicacion1.darTipo(new Moho());

        //act
        ubicacion1.crecer(1,mapa);
        Ubicacion ubicacion2 = mapa.buscar(new Coordenada(4,5));
        Ubicacion ubicacion3 = mapa.buscar(new Coordenada(4,4));
        //assert
        assertDoesNotThrow( ()-> {
            ubicacion2.ubicar(new Criadero());
        });
        assertThrows( ConstruccionFueraDelMohoError.class, ()-> {
            ubicacion3.ubicar(new Criadero());;
        });

    }
    @Test
    public void testElMohoCreceEn2Turnos(){
        Mapa mapa = new Mapa(10,10);
        Ubicacion ubicacion1 = mapa.buscar(new Coordenada(5,5));
        ubicacion1.darTipo(new Moho());

        //act
        ubicacion1.crecer(2,mapa);
        Ubicacion ubicacion2 = mapa.buscar(new Coordenada(4,5));
        Ubicacion ubicacion3 = mapa.buscar(new Coordenada(4,4));
        //assert
        assertDoesNotThrow( ()-> {
            ubicacion2.ubicar(new Criadero());
        });
        assertDoesNotThrow( ()-> {
            ubicacion3.ubicar(new Criadero());
        });

    }


}
