package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Edificio.Protoss.*;
import edu.fiuba.algo3.modelo.Edificio.Zerg.*;
import edu.fiuba.algo3.modelo.Raza.RazaProtoss;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import edu.fiuba.algo3.modelo.Recurso.NodoMineral;
import edu.fiuba.algo3.modelo.Recurso.RecursosInsuficientesError;
import edu.fiuba.algo3.modelo.Recurso.Volcan;
import edu.fiuba.algo3.modelo.tablero.Coordenada;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso8 {

    //Verificar que sino se tienen los recursos no se pueden construir los edificios (Para cada
    //edificio para cada raza). Ambas razas arrancan con 200 de mineral y 0 gas.

    @Test
    public void testRazaZergQuiereConstruirseUnCriaderoDeberiaPoderConstruirlo(){

        //Arrange
        RazaZerg razaZerg = new RazaZerg();
        Criadero criadero = new Criadero();

        //Act y assert
        assertDoesNotThrow( ()-> {
            razaZerg.agregarEdificio(criadero);
        });
    }

    @Test
    public void testRazaZergQuiereConstruirseUnaReservaDeReproduccionDeberiaPoderConstruirlo(){

        //Arrange
        RazaZerg razaZerg = new RazaZerg();
        ReservaDeReproduccion reserva = new ReservaDeReproduccion();

        //Act y assert
        assertDoesNotThrow(  ()-> {
            razaZerg.agregarEdificio(reserva);
        });
    }

    @Test
    public void testRazaZergQuiereConstruirseUnExtractorDeberiaPoderConstruirlo(){

        //Arrange
        RazaZerg razaZerg = new RazaZerg();
        Extractor extractor = new Extractor();

        //Act y assert
        assertDoesNotThrow( ()-> {
            razaZerg.agregarEdificio(extractor);
        });
    }
    @Test
    public void testRazaZergQuiereConstruirseUnaGuaridaPeroComoNoTieneLosRecursosNoDeberiaPoder(){

        //Arrange
        RazaZerg razaZerg = new RazaZerg();
        Guarida guarida = new Guarida();
        razaZerg.agregarEdificio(new ReservaDeReproduccion());

        //Act y assert
        assertThrows( RecursosInsuficientesError.class, ()-> {
            razaZerg.agregarEdificio(guarida);
        });
    }
    @Test
    public void testRazaZergQuiereConstruirseUnEspiralPeroComoNoTieneLosRecursosNoDeberiaPoder(){

        //Arrange
        RazaZerg razaZerg = new RazaZerg();
        Espiral espiral = new Espiral();
        razaZerg.agregarEdificio(new Extractor());
        razaZerg.agregarEdificio(new Extractor());

        //Act y assert
        assertThrows( RecursosInsuficientesError.class, ()-> {
            razaZerg.agregarEdificio(espiral);
        });
    }

    @Test
    public void testRazaProtossQuiereConstruirseUnNexoMineralDeberiaPoderConstruirlo(){

        //Arrange
        RazaProtoss razaProtoss = new RazaProtoss();
        Ubicacion ubicacion = new Ubicacion(new Coordenada(0,0));
        NexoMineral nexoMineral = new NexoMineral( new NodoMineral(),ubicacion );

        //Act y assert
        assertDoesNotThrow(  ()-> {
            razaProtoss.agregarEdificio(nexoMineral);
        });
    }

    @Test
    public void testRazaProtossQuiereConstruirseUnPilonDeberiaPoderConstruirlo(){

        //Arrange
        RazaProtoss razaProtoss = new RazaProtoss();
        Pilon pilon = new Pilon();

        //Act y assert
        assertDoesNotThrow( ()-> {
            razaProtoss.agregarEdificio(pilon);
        });
    }

    @Test
    public void testRazaProtossQuiereConstruirseUnAsimiladorDeberiaPoderConstruirlo(){

        //Arrange
        RazaProtoss razaProtoss = new RazaProtoss();
        Volcan volcan = new Volcan();
        Ubicacion ubicacion = new Ubicacion(new Coordenada(0,0));
        ubicacion.ubicarRecurso(volcan);
        Asimilador asimilador = new Asimilador(ubicacion);

        //Act y assert
        assertDoesNotThrow(  ()-> {
            razaProtoss.agregarEdificio(asimilador);
        });
    }

    @Test
    public void testRazaProtossQuiereConstruirseUnAccesoDeberiaPoderConstruirlo(){

        //Arrange
        Ubicacion ubicacion = new Ubicacion(new Coordenada(0,0));
        ubicacion.energizar();
        RazaProtoss razaProtoss = new RazaProtoss();
        Acceso acceso = new Acceso(ubicacion);

        //Act y assert
        assertDoesNotThrow(  ()-> {
            razaProtoss.agregarEdificio(acceso);
        });
    }

    @Test
    public void testRazaProtossQuiereConstruirseUnPuertoEstelarPeroComoNoTieneLosRecursosNoDeberiaPoder(){

        //Arrange
        RazaProtoss razaProtoss = new RazaProtoss();
        PuertoEstelar puertoEstelar = new PuertoEstelar();
        Ubicacion ubicacion = new Ubicacion(new Coordenada(0,0));
        ubicacion.energizar();
        razaProtoss.agregarEdificio(new Pilon());
        razaProtoss.agregarEdificio(new Pilon());

        //Act y assert
        assertThrows( RecursosInsuficientesError.class, ()-> {
            razaProtoss.agregarEdificio(puertoEstelar);
        });
    }

    @Test
    public void testRazaZergSeCreaUnCriaderoDespuesNoSeDeberiaPoderCrearUnCriaderoMas(){
        //Arrange
        RazaZerg razaZerg = new RazaZerg();
        Criadero criadero = new Criadero();
        Criadero criaderoExtra = new Criadero();

        //Act
        razaZerg.agregarEdificio(criadero); // gasto 200 de mineral

        //se quedo sin mineral lanza excepcion al intentar crear sin mineral un criadero.

        //assert
        assertThrows( RecursosInsuficientesError.class, ()-> {
            razaZerg.agregarEdificio(criaderoExtra);
        });

    }

    @Test
    public void testRazaProtosSeCreaUnPilonYUnAsimiladorDespuesNoSeDeberiaPoderCrearUnNexoMineral(){
        //Arrange
        RazaProtoss razaProtoss = new RazaProtoss();
        Pilon pilon = new Pilon();
        Volcan volcan = new Volcan();
        Ubicacion ubicacion = new Ubicacion(new Coordenada(0,0));
        Ubicacion ubicacionVolcan = new Ubicacion(new Coordenada(0,1));
        ubicacionVolcan.ubicarRecurso(volcan);
        Asimilador asimilador = new Asimilador(ubicacionVolcan);
        NexoMineral nexoMineral = new NexoMineral( new NodoMineral(),ubicacion);

        //Act
        razaProtoss.agregarEdificio(pilon); // gasto 100 de mineral
        razaProtoss.agregarEdificio(asimilador); //gasta 100 de minerla

        //se quedo sin mineral lanza excepcion al intentar crear sin mineral un nexoMineral.

        //assert
        assertThrows( RecursosInsuficientesError.class, ()-> {
            razaProtoss.agregarEdificio(nexoMineral);
        });

    }

}
