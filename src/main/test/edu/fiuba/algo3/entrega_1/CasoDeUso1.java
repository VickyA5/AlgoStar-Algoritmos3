package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Edificio.Zerg.Criadero;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import edu.fiuba.algo3.modelo.Unidad.Larva;
import edu.fiuba.algo3.modelo.Unidad.Zangano;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CasoDeUso1 {

    GestionRecurso mineral;
    GestionRecurso gas;
    Raza raza;

    @BeforeEach
    void setup() {
        //Arrange
        mineral = new GestionRecurso(500);
        gas = new GestionRecurso(500);
        raza = new RazaZerg(mineral, gas);
    }

    @Test
    public void testCriaderoSeIniciaCon3larvasSeConsumeUnaParaEngendrarUnzánganoLeDeberiaQuedarDos(){
        //arrange
        Criadero criaderoBajoPrueba = new Criadero(0);
        Criadero criaderoNormal = new Criadero(0);
        raza.agregarEdificio(criaderoBajoPrueba);
        //act
        criaderoBajoPrueba.evolucionarLarva();

        //assert
        assertFalse(criaderoBajoPrueba.equals(criaderoNormal));
    }

    @Test
    public void testCriaderoSeIniciaCon3larvasSeConsumeUnaParaEngendrarUnzánganoLeDeberiaQuedarDosYDeberiaTenerUnZangano(){
        //arrange
        Criadero criaderoBajoPrueba = new Criadero(0);
        Criadero criaderoNormal = new Criadero(0);
        raza.agregarEdificio(criaderoBajoPrueba);
        //act
        criaderoBajoPrueba.evolucionarLarva();
        criaderoBajoPrueba.ejecutarTurnoRegenerar();

        //assert
        assertTrue(  criaderoBajoPrueba.equals(criaderoNormal) );
    }
    @Test
    public void testCriaderoSeIniciaCon3larvasSeEvolucionanLasTresLarvasYNoDeberiaSerIgualAUnCriaderoSinEvolucionarLarvas(){
        Criadero criaderoBajoPrueba = new Criadero(0);
        Criadero criaderoNormal = new Criadero(0);
        raza.agregarEdificio(criaderoBajoPrueba);
        //act
        criaderoBajoPrueba.evolucionarLarva();
        criaderoBajoPrueba.evolucionarLarva();
        criaderoBajoPrueba.evolucionarLarva();
        criaderoBajoPrueba.ejecutarTurnoRegenerar();

        //assert
        assertFalse(  criaderoBajoPrueba.equals(criaderoNormal) );
    }



}
