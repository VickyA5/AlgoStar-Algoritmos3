package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Edificio.*;
import edu.fiuba.algo3.modelo.Edificio.Protoss.*;
import edu.fiuba.algo3.modelo.Edificio.Zerg.*;
import edu.fiuba.algo3.modelo.Recurso.NodoMineral;
import edu.fiuba.algo3.modelo.Recurso.Volcan;
import edu.fiuba.algo3.modelo.tablero.Coordenada;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso3 {

    @Test
    public void testAsimiladorSoloSePuedeConstruirSobreElGas(){
        Volcan volcan = new Volcan();
        Ubicacion ubicacion = new Ubicacion(new Coordenada(0,0));
        ubicacion.ubicarRecurso(volcan);

        assertDoesNotThrow( ()-> {
            Edificio unEdificio = new Asimilador(ubicacion);
        });
    }

    @Test
    public void testExtractorSoloSePuedeConstruirSobreElGas(){
        Volcan volcan = new Volcan();

        Edificio unEdificio = new Extractor();

        assertDoesNotThrow( ()-> {
            unEdificio.construirEdificioEn(volcan);
        });
    }
    @Test
    public void testCriaderoNoSePuedeConstruirSobreElGas(){
        Volcan volcan = new Volcan();


        Edificio unEdificio = new Criadero();

        assertThrows( ConstruccionIncorrectaError.class, ()-> {
            unEdificio.construirEdificioEn(volcan);
        });
    }

    @Test
    public void testReservaDeProduccionNoSePuedeConstruirSobreElGas(){
        Volcan volcan = new Volcan();
        Edificio unEdificio = new ReservaDeReproduccion();

        assertThrows( ConstruccionIncorrectaError.class, ()-> {
            unEdificio.construirEdificioEn(volcan);
        });

    }
    @Test
    public void testGuaridaNoSePuedeConstruirSobreElGas(){
        Volcan volcan = new Volcan();
        Edificio unEdificio = new Guarida();

        assertThrows( ConstruccionIncorrectaError.class, ()-> {
            unEdificio.construirEdificioEn(volcan);
        });
    }

    @Test
    public void testEspiralNoSePuedeConstruirSobreElGas(){
        Volcan volcan = new Volcan();
        Edificio unEdificio = new Espiral();

        assertThrows( ConstruccionIncorrectaError.class, ()-> {
            unEdificio.construirEdificioEn(volcan);
        });
    }


    @Test //ACA
    public void testNexoMineralNoSePuedeConstruirSobreElGas(){
        Volcan volcan = new Volcan();
        Ubicacion ubicacion = new Ubicacion(new Coordenada(0,0));
        Edificio unEdificio = new NexoMineral( new NodoMineral(), ubicacion);

        assertThrows( ConstruccionIncorrectaError.class, ()-> {
            unEdificio.construirEdificioEn(volcan);
        });
    }
    @Test
    public void testPilonNoSePuedeConstruirSobreElGas(){
        Volcan volcan = new Volcan();
        Edificio unEdificio = new Pilon();

        assertThrows( ConstruccionIncorrectaError.class, ()-> {
            unEdificio.construirEdificioEn(volcan);
        });
    }
    @Test
    public void testAccesoNoSePuedeConstruirSobreElGas(){
        Volcan volcan = new Volcan();
        Ubicacion ubicacion = new Ubicacion(new Coordenada(0,0));
        ubicacion.energizar();
        Edificio unEdificio = new Acceso(ubicacion);

        assertThrows( ConstruccionIncorrectaError.class, ()-> {
            unEdificio.construirEdificioEn(volcan);
        });
    }
    @Test
    public void testPuertoEstelarNoSePuedeConstruirSobreElGas(){
        Volcan volcan = new Volcan();
        Edificio unEdificio = new PuertoEstelar();

        assertThrows( ConstruccionIncorrectaError.class, ()-> {
            unEdificio.construirEdificioEn(volcan);
        });
    }


}
