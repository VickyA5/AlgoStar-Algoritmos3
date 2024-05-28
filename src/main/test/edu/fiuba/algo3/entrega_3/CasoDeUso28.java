package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Ataque.ZealotNoPuedeSerAtacadaError;
import edu.fiuba.algo3.modelo.Edificio.Zerg.*;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import edu.fiuba.algo3.modelo.Unidad.AmoSupremo;
import edu.fiuba.algo3.modelo.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Unidad.Zealot;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import edu.fiuba.algo3.modelo.tablero.Coordenada;
import edu.fiuba.algo3.modelo.tablero.Mapa;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso28 {
    @Test
    public void testUnZealotInvisibleNoDeberiaPoderSerAtacado(){
        //Arrange
        Zealot zealot = new Zealot();
        Zangano zangano = new Zangano();

        //Dejo al zealot y al zealot operativos
        for(int i = 0; i < 4; i++){
            zealot.ejecutarTurno();
        }
        zangano.ejecutarTurno();

        //Hago que el zealot se vuelva invisible
        Zangano zangano1 = new Zangano();
        for (int i = 0 ; i < 4; i++){
            zealot.atacar(zangano1);    //se muere al cuarto ataque
        }

        Zangano zangano2 = new Zangano();
        for (int i = 0 ; i < 4; i++){
            zealot.atacar(zangano2);
        }

        Zangano zangano3 = new Zangano();
        for (int i = 0 ; i < 4; i++){
            zealot.atacar(zangano3);
        }

        //Assert y Act
        assertThrows( ZealotNoPuedeSerAtacadaError.class, ()-> {
            zangano.atacar(zealot);
        });

    }

    @Test
    public void testUnZealotVisibleSiDeberiaPoderSerAtacado(){
        //Arrange
        Zealot zealot = new Zealot();
        Zangano zangano = new Zangano();

        //Dejo al zealot y al zealot operativos
        for(int i = 0; i < 5; i++){
            zealot.ejecutarTurno();
        }
        zangano.ejecutarTurno();

        //Assert y Act
        assertDoesNotThrow( ()-> {
            zangano.atacar(zealot);
        });
    }

    @Test
    public void testUnZealotDestruye3EdificiosDeberiaVolverseInvisible(){
        RazaZerg unaRaza = new RazaZerg();
        unaRaza.aumentarMineral(new GestionRecurso(1000));
        unaRaza.aumentarGas(new GestionRecurso(1000));
        //Arrange
        Zealot zealot = new Zealot();
        Zangano zangano = new Zangano();

        //Dejo al zealot y al zealot operativos
        for(int i = 0; i < 4; i++){
            zealot.ejecutarTurno();
        }
        zangano.ejecutarTurno();

        //Hago que el zealot se vuelva invisible
        Espiral espiral = new Espiral();
        unaRaza.agregarEdificio(new ReservaDeReproduccion());
        unaRaza.agregarEdificio(new Guarida());
        unaRaza.agregarEdificio(espiral);

        for (int i = 0 ; i < 163; i++){
            zealot.atacar(espiral);
        }

        Criadero criadero = new Criadero();
        unaRaza.agregarEdificio(criadero);

        for (int i = 0 ; i < 63; i++){
            zealot.atacar(criadero);
        }

        Extractor extractor = new Extractor();
        unaRaza.agregarEdificio(extractor);

        for (int i = 0 ; i < 94; i++){
            zealot.atacar(extractor);
        }

        //Assert y Act
        assertThrows( ZealotNoPuedeSerAtacadaError.class, ()-> {
            zangano.atacar(zealot);
        });

    }

    @Test
    public void testUnZealotInvisiblePeroBajoElRangoDeUnAmoSupremoSiDeberiaSerAtacado(){
        Mapa mapa = new Mapa(10,10);
        Ubicacion ubicacion1 = mapa.buscar(new Coordenada(5,5));
        Ubicacion ubicacion2 = mapa.buscar(new Coordenada(4,5));
        AmoSupremo amoSupremo = new AmoSupremo();
        ubicacion1.asignarAmoSupremo(amoSupremo, mapa);
        Zangano zangano = new Zangano();
        Zealot zealot = new Zealot();
        ubicacion2.asignarUnidad(zealot);

        //Dejo al zealot y al zealot operativos
        for(int i = 0; i < 4; i++){
            zealot.ejecutarTurno();
        }
        zangano.ejecutarTurno();

        //Hago que el zealot mate a 3 unidades
        Zangano zangano1 = new Zangano();
        for (int i = 0 ; i < 4; i++){
            zealot.atacar(zangano1);
        }

        Zangano zangano2 = new Zangano();
        for (int i = 0 ; i < 4; i++){
            zealot.atacar(zangano2);
        }

        Zangano zangano3 = new Zangano();
        for (int i = 0 ; i < 4; i++){
            zealot.atacar(zangano3);
        }

        //Act
        zealot.actualizarVisibilidad();

        //assert
        assertDoesNotThrow( ()-> {
            zangano.atacar(zealot);
        });
    }

    @Test
    public void testUnZealotInvisibleYNoEstaBajoElRangoDeUnAmoSupremoSiDeberiaSerAtacado(){
        Mapa mapa = new Mapa(10,10);
        Ubicacion ubicacion1 = mapa.buscar(new Coordenada(1,1));
        Ubicacion ubicacion2 = mapa.buscar(new Coordenada(9,9));
        AmoSupremo amoSupremo = new AmoSupremo();
        ubicacion1.asignarAmoSupremo(amoSupremo, mapa);
        Zangano zangano = new Zangano();
        Zealot zealot = new Zealot();
        ubicacion2.asignarUnidad(zealot);

        //Dejo al zealot y al zealot operativos
        for(int i = 0; i < 4; i++){
            zealot.ejecutarTurno();
        }
        zangano.ejecutarTurno();

        //Hago que el zealot mate a 3 unidades
        Zangano zangano1 = new Zangano();
        for (int i = 0 ; i < 4; i++){
            zealot.atacar(zangano1);
        }

        Zangano zangano2 = new Zangano();
        for (int i = 0 ; i < 4; i++){
            zealot.atacar(zangano2);
        }

        Zangano zangano3 = new Zangano();
        for (int i = 0 ; i < 4; i++){
            zealot.atacar(zangano3);
        }

        //Act
        zealot.actualizarVisibilidad();

        //assert
        assertThrows( ZealotNoPuedeSerAtacadaError.class, ()-> {
            zangano.atacar(zealot);
        });
    }
}
