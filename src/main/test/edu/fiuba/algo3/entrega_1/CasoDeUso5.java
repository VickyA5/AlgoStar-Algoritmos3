package edu.fiuba.algo3.entrega_1;


import edu.fiuba.algo3.modelo.*;

import edu.fiuba.algo3.modelo.Edificio.Protoss.Acceso;
import edu.fiuba.algo3.modelo.Edificio.Protoss.Pilon;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Criadero;
import edu.fiuba.algo3.modelo.tablero.Coordenada;
import edu.fiuba.algo3.modelo.tablero.Mapa;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import edu.fiuba.algo3.modelo.tablero.Tierra;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso5 {
    @Test
    public void testNoSePuedeConstruirFueraDelMoho(){
        //Mapa mapa = new Mapa();

        Ubicacion ubicacion = new Ubicacion(new Coordenada(0,0));

        //act
        ubicacion.darTipo(new Tierra());

        //assert

        assertThrows( ConstruccionFueraDelMohoError.class, ()-> {
            ubicacion.ubicar(new Criadero());
        });

    }
    @Test
    public void testNoSeDeberiaPoderConstruirFueraDelRangoDelPilon(){

        //arrange
        Mapa mapa = new Mapa(10,10);
        Ubicacion ubicacionPilon =  mapa.buscar(new Coordenada(1,1));
        Pilon unPilon = new Pilon();
        ubicacionPilon.ubicar(unPilon, mapa);

        //act
        Ubicacion ubicacionPuerto = mapa.buscar(new Coordenada(5,5));

        //assert
        assertThrows( ConstruccionFueraDelRangoPilonError.class, ()-> {
            Acceso acceso = new Acceso(ubicacionPuerto);
        });

    }

    @Test
    public void testSiSeDeberiaPoderConstruirDentroDelRangoDelPilon(){

        //arrange
        Mapa mapa = new Mapa(10,10);
        Ubicacion ubicacionPilon =  mapa.buscar(new Coordenada(4,4));
        Pilon unPilon = new Pilon();
        ubicacionPilon.ubicar(unPilon, mapa);

        //act
        Ubicacion ubicacionPuerto = mapa.buscar(new Coordenada(5,5));

        //assert
        assertDoesNotThrow( ()-> {
            Acceso acceso = new Acceso(ubicacionPuerto);
        });

    }

    @Test
    public void testNoSeDeberiaPoderConstruirFueraDelRangoDelVariosPilones() {
        //arrange
        Mapa mapa = new Mapa(20,20);
        Ubicacion ubicacionPilon1 =  mapa.buscar(new Coordenada(5,5));
        Pilon pilon1 = new Pilon();
        ubicacionPilon1.ubicar(pilon1, mapa);
        Ubicacion ubicacionPilon2 =  mapa.buscar(new Coordenada(15, 15));
        Pilon pilon2 = new Pilon();
        ubicacionPilon2.ubicar(pilon2, mapa);

        //act
        Ubicacion ubicacionPuerto = mapa.buscar(new Coordenada(10, 10));

        //assert
        assertThrows( ConstruccionFueraDelRangoPilonError.class, ()-> {
            Acceso acceso = new Acceso(ubicacionPuerto);
        });
    }

        @Test
        public void testSePuedeConstruirDentroDelRangoDelVariosPilones(){
            //arrange
            Mapa mapa = new Mapa(20,20);
            Ubicacion ubicacionPilon1 =  mapa.buscar(new Coordenada(5,5));
            Pilon pilon1 = new Pilon();
            ubicacionPilon1.ubicar(pilon1, mapa);
            Ubicacion ubicacionPilon2 =  mapa.buscar(new Coordenada(7, 7));
            Pilon pilon2 = new Pilon();
            ubicacionPilon2.ubicar(pilon2, mapa);

            //act
            Ubicacion ubicacionPuerto = mapa.buscar(new Coordenada(6, 6));

            //assert
            assertDoesNotThrow( ()-> {
                Acceso acceso = new Acceso(ubicacionPuerto);
            });
    }
}
