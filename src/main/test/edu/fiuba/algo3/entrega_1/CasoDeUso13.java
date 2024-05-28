package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Edificio.Zerg.Criadero;
import edu.fiuba.algo3.modelo.tablero.Coordenada;
import edu.fiuba.algo3.modelo.tablero.Mapa;
import edu.fiuba.algo3.modelo.tablero.Moho;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso13 {
    @Test
    public void SePuedeConstruirSobreElMohoQueDejoUnCriaderoDestruido(){
        Mapa mapa = new Mapa(10,10);
        Ubicacion ubicacion1 = mapa.buscar(new Coordenada(5,5));
        ubicacion1.darTipo(new Moho());
        ubicacion1.ubicar(new Criadero());
        ubicacion1.crecer(5,mapa);
        Ubicacion ubicacion2 = mapa.buscar(new Coordenada(3,3));

        //act
        ubicacion1.desalojar();
        //assert
        assertDoesNotThrow( ()-> {
            ubicacion2.ubicar(new Criadero());
        });

    }

}
