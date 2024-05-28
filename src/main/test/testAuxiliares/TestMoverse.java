package testAuxiliares;

import edu.fiuba.algo3.modelo.Edificio.Protoss.Pilon;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Criadero;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.Raza.*;
import edu.fiuba.algo3.modelo.Unidad.Dragon;
import edu.fiuba.algo3.modelo.Unidad.Hidralisco;
import edu.fiuba.algo3.modelo.Unidad.*;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import edu.fiuba.algo3.modelo.tablero.Coordenada;
import edu.fiuba.algo3.modelo.tablero.Mapa;
import edu.fiuba.algo3.modelo.tablero.UbicacionOcupadaError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestMoverse {

    @Test
    public void EnUnMapaUnaUnidadSeMueveEnVariasDireccionesSinCausarError(){
        Mapa mapa = new Mapa(20,20);
        Unidad zangano = new Zangano();
        mapa.buscar(new Coordenada(10,10)).asignarUnidad(zangano);

        assertDoesNotThrow(() -> {
            zangano.moverseAbajo();;
        });
        assertDoesNotThrow(() -> {
            zangano.moverseDerecha();;
        });
        assertDoesNotThrow(() -> {
            zangano.moverseArriba();;
        });
        assertDoesNotThrow(() -> {
            zangano.moverseDerecha();;
        });


    }

    @Test
    public void UnaUnidadSeMueveAVariasUbicacionesDeberianSerEquivalentesConLasEsperadas(){
        Mapa mapa = new Mapa(20,20);
        Unidad zangano = new Zangano();
        mapa.buscar(new Coordenada(10,10)).asignarUnidad(zangano);

        zangano.moverseAbajo();
        assertEquals( zangano.ubicacion().coordenada().horizontal(), 10  );
        assertEquals( zangano.ubicacion().coordenada().vertical(), 11  );

        zangano.moverseDerecha();
        assertEquals( zangano.ubicacion().coordenada().horizontal(), 11  );
        assertEquals( zangano.ubicacion().coordenada().vertical(), 11  );

        zangano.moverseArriba();
        assertEquals( zangano.ubicacion().coordenada().horizontal(), 11  );
        assertEquals( zangano.ubicacion().coordenada().vertical(), 10  );

        zangano.moverseIzquierda();
        assertEquals( zangano.ubicacion().coordenada().horizontal(), 10  );
        assertEquals( zangano.ubicacion().coordenada().vertical(), 10  );
    }

    @Test
    public void UnaUnidadSeMueveALaIzquierdaDeLaPoscion0EnXy4EnYEnYDeberiaQuedarseEnEseLugar(){
        Mapa mapa = new Mapa(10,10);
        Unidad zangano = new Zangano();
        mapa.buscar(new Coordenada(0,4)).asignarUnidad(zangano);

        zangano.moverseIzquierda();
        assertEquals( zangano.ubicacion().coordenada().horizontal(), 0);
        assertEquals( zangano.ubicacion().coordenada().vertical(), 4  );

        zangano.moverseIzquierda();
        assertEquals( zangano.ubicacion().coordenada().horizontal(), 0);
        assertEquals( zangano.ubicacion().coordenada().vertical(), 4  );
    }

    @Test
    public void UnaUnidadSeMueveHaciArribaDeLaPoscion4EnXy0EnYEnYDeberiaQuedarseEnEseLugar(){
        Mapa mapa = new Mapa(10,10);
        Unidad zangano = new Zangano();
        mapa.buscar(new Coordenada(4,0)).asignarUnidad(zangano);

        zangano.moverseArriba();
        assertEquals( zangano.ubicacion().coordenada().horizontal(), 4);
        assertEquals( zangano.ubicacion().coordenada().vertical(), 0);

        zangano.moverseArriba();
        assertEquals( zangano.ubicacion().coordenada().horizontal(), 4);
        assertEquals( zangano.ubicacion().coordenada().vertical(), 0);
    }

    @Test
    public void UnaUnidadSeMueveHaciaAbajoDeLaPoscion4EnXy10EnYEnYDeberiaQuedarseEnEseLugar(){
        Mapa mapa = new Mapa(9,9); // mapa de 9-9  al final sale un tablero de 10x10. (maxima valor es 9)
        Unidad zangano = new Zangano();
        mapa.buscar(new Coordenada(4,9)).asignarUnidad(zangano);

        zangano.moverseAbajo();
        assertEquals( zangano.ubicacion().coordenada().horizontal(), 4);
        assertEquals( zangano.ubicacion().coordenada().vertical(), 9);

        zangano.moverseAbajo();
        assertEquals( zangano.ubicacion().coordenada().horizontal(), 4);
        assertEquals( zangano.ubicacion().coordenada().vertical(), 9);
    }

    @Test
    public void UnaUnidadSeMueveHaciaDerechaDeLaPoscion9EnXy3EnYEnYDeberiaQuedarseEnEseLugar(){
        Mapa mapa = new Mapa(9,9); // mapa de 9-9  al final sale un tablero de 10x10. (maxima valor es 9)
        Unidad zangano = new Zangano();
        mapa.buscar(new Coordenada(9,3)).asignarUnidad(zangano);

        zangano.moverseDerecha();
        assertEquals( zangano.ubicacion().coordenada().horizontal(), 9);
        assertEquals( zangano.ubicacion().coordenada().vertical(), 3);

        zangano.moverseDerecha();
        assertEquals( zangano.ubicacion().coordenada().horizontal(), 9);
        assertEquals( zangano.ubicacion().coordenada().vertical(), 3);
    }







}
