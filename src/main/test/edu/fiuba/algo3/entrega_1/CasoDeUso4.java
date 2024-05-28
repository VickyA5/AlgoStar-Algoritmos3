package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Edificio.EdificioNoOperativoError;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Extractor;
import edu.fiuba.algo3.modelo.Edificio.ExtractorCantidadMaximaDeZanganosError;
import edu.fiuba.algo3.modelo.HitPoints.HPZerg;
import edu.fiuba.algo3.modelo.Recurso.Volcan;
import edu.fiuba.algo3.modelo.Unidad.Zangano;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso4 {

    @Test
    public void testUnExtractorTiene0ZanganosDeberiaExtraer0DeGas(){

        //Arrange
        Volcan volcan = new Volcan();
        Extractor extractor = new Extractor();
        GestionRecurso resultadoEsperado = new GestionRecurso();

        // dejo el Extrractor operrable en 6 turnos
        for(int i = 0; i < 6; i++ ){
            extractor.ejecutarTurno();
        }

        //Act
        GestionRecurso cantidadGas = extractor.extraer(volcan);

        //Assert
        assertEquals(resultadoEsperado, cantidadGas);

    }

    @Test
    public void testUnExtractorTiene1ZanganoDeberiaExtraer10DeGas(){

        //Arrange
        Volcan volcan = new Volcan();
        Extractor extractor = new Extractor();
        GestionRecurso resultadoEsperado = new GestionRecurso(10);

        // dejo el Extrractor operrable en 6 turnos
        for(int i = 0; i < 6; i++ ){
            extractor.ejecutarTurno();
        }

        extractor.agregarZangano(new Zangano());

        //Act
        GestionRecurso cantidadGas = extractor.extraer(volcan);

        //Assert
        assertEquals(resultadoEsperado, cantidadGas);
    }

    @Test
    public void testUnExtractorTiene2ZanganoDeberiaExtraer20DeGas(){

        //Arrange
        Volcan volcan = new Volcan();
        Extractor extractor = new Extractor();
        GestionRecurso resultadoEsperado = new GestionRecurso(20);

        // dejo el Extrractor operrable en 6 turnos
        for(int i = 0; i < 6; i++ ){
            extractor.ejecutarTurno();
        }

        extractor.agregarZangano(new Zangano(new HPZerg(25)));
        extractor.agregarZangano(new Zangano(new HPZerg(25)));

        //Act
        GestionRecurso cantidadGas = extractor.extraer(volcan);

        //Assert
        assertEquals(resultadoEsperado, cantidadGas);
    }

    @Test
    public void testUnExtractorTiene3ZanganoDeberiaExtraer30DeGas(){

        //Arrange
        Volcan volcan = new Volcan();
        Extractor extractor = new Extractor();
        GestionRecurso resultadoEsperado = new GestionRecurso(30);

        // dejo el Extrractor operrable en 6 turnos
        for(int i = 0; i < 6; i++ ){
            extractor.ejecutarTurno();
        }

        extractor.agregarZangano(new Zangano(new HPZerg(25)));
        extractor.agregarZangano(new Zangano(new HPZerg(25)));
        extractor.agregarZangano(new Zangano(new HPZerg(25)));

        //Act
        GestionRecurso cantidadGas =  extractor.extraer(volcan);

        //Assert
        assertEquals(resultadoEsperado, cantidadGas);
    }

    @Test
    public void testSeQuiereAgregar4ZanganosAUnExtractorNoSeDeberiaPoder(){

        //Arrange
        Volcan volcan = new Volcan();
        Extractor extractor = new Extractor();
        // dejo el Extrractor operrable en 6 turnos
        for(int i = 0; i < 6; i++ ){
            extractor.ejecutarTurno();
        }

        //Act
        extractor.agregarZangano(new Zangano(new HPZerg(25)));
        extractor.agregarZangano(new Zangano(new HPZerg(25)));
        extractor.agregarZangano(new Zangano(new HPZerg(25)));

        //Assert
        assertThrows( ExtractorCantidadMaximaDeZanganosError.class, ()-> {
            extractor.agregarZangano(new Zangano(new HPZerg(25)));
        });
    }

    @Test
    public void testExtractorNoDeberiaExtraerSiNoEstaOperable(){

        //Arrange
        Volcan volcan = new Volcan();
        Extractor extractor = new Extractor();

        //Act y assert
        assertThrows( EdificioNoOperativoError.class, ()-> {
            extractor.extraer(volcan);
        });
    }
}

