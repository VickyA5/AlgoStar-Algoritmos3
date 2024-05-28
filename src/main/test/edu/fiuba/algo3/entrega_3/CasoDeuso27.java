package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.HitPoints.HPProtoss;
import edu.fiuba.algo3.modelo.HitPoints.HPZerg;
import edu.fiuba.algo3.modelo.HitPoints.HitPoints;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import edu.fiuba.algo3.modelo.Recurso.RecursosInsuficientesError;
import edu.fiuba.algo3.modelo.Unidad.*;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeuso27 {
    @Test
    public void testMutaliscoSiPuedeEvolucionarADevoradorPorqueoHayRecursosSuficientes() {
        //Arrange
        RazaZerg raza = new RazaZerg(); // se crea con 200 mineral y 0 gas.
        raza.aumentarMineral(new GestionRecurso(500));
        raza.aumentarGas(new GestionRecurso(500));
        Mutalisco mutalisco = new Mutalisco(new HPZerg(120));

        //Act y Assert
        assertDoesNotThrow(() -> {
            mutalisco.evolucionarDevorador(raza);
        });
    }
    @Test
    public void testMutaliscoNoPuedeEvolucionarADevoradorPorqueoNoHayRecursosSuficientes() {
        //Arrange
        RazaZerg raza = new RazaZerg(); // se crea con 200 mineral y 0 gas.
        Mutalisco mutalisco = new Mutalisco(new HPZerg(120));
        //Act y Assert
        assertThrows( InsuficientesRecursosParaCrearUnidadError.class, ()-> {
            mutalisco.evolucionarDevorador(raza) ;
        });
    }
    @Test
    public void testUnDevoradorAtacaAUnScoutQueEsUnaUnidadDeSuperficieTierrayLeDeberiaCausar15Danio(){
        //Arrange
        HitPoints hpScout = new HPProtoss(60,100);
        HitPoints hpEsperado = new HPProtoss(60,75);

        Unidad devorador = new Devorador();
        Atacable scout = new Scout(hpScout);


        for (int i = 0; i < 4; i++){
            devorador.ejecutarTurno();
        }

        //Act
        devorador.atacar(scout);

        //Assert
        assertEquals(hpEsperado,hpScout);
    }

    @Test
    public void testUnDevoradorAtacaAUnZealotQueEsUnaUnidadDeSuperficieTierraYNoLeDeberiaCausarDanio(){
        //Arrange
        HitPoints hpZealot = new HPProtoss(60,100);
        HitPoints hpEsperado = new HPProtoss(60,100);

        Unidad devorador = new Devorador();
        Atacable zealot = new Zealot(hpZealot);


        for (int i = 0; i < 4; i++){
            devorador.ejecutarTurno();
        }

        //Act
        devorador.atacar(zealot);//no le aplica danio Zealot es unidad terrestre

        //Assert
        assertEquals(hpEsperado,hpZealot);
    }

    @Test
    public void testUnMutaliscoEvolucionaADevoradorAtacaAUnScoutQueEsUnaUnidadDeSuperficieTierrayLeDeberiaCausar15Danio(){
        //Arrange
        HitPoints hpScout = new HPProtoss(60,100);
        HitPoints hpEsperado = new HPProtoss(60,75);
        Atacable scout = new Scout(hpScout);

        RazaZerg raza = new RazaZerg();
        raza.aumentarMineral(new GestionRecurso(500));
        raza.aumentarGas(new GestionRecurso(500));
        Mutalisco mutalisco = new Mutalisco(new HPZerg(120));
        mutalisco.evolucionarDevorador(raza);

        for (int i = 0; i < 4; i++){
            mutalisco.ejecutarTurno();
        }

        //Act
        mutalisco.atacar(scout);

        //Assert
        assertEquals(hpEsperado,hpScout);
    }

    @Test
    public void testUnMutaliscoEvolucionaADevoradorAtacaAUnZealotQueEsUnaUnidadDeSuperficieTierraYNoLeDeberiaCausarDanio(){
        //Arrange
        HitPoints hpZealot = new HPProtoss(60,100);
        HitPoints hpEsperado = new HPProtoss(60,100);
        Atacable zealot = new Zealot(hpZealot);

        RazaZerg raza = new RazaZerg();
        raza.aumentarMineral(new GestionRecurso(500));
        raza.aumentarGas(new GestionRecurso(500));
        Mutalisco mutalisco = new Mutalisco(new HPZerg(120));
        mutalisco.evolucionarDevorador(raza);

        for (int i = 0; i < 4; i++){
            mutalisco.ejecutarTurno();
        }

        //Act
        mutalisco.atacar(zealot);

        //Assert
        assertEquals(hpEsperado,hpZealot);
    }
}
