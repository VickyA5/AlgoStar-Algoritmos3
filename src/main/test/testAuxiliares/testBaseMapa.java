package testAuxiliares;

import edu.fiuba.algo3.modelo.Edificio.Protoss.Acceso;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Criadero;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import edu.fiuba.algo3.modelo.tablero.Base;
import edu.fiuba.algo3.modelo.tablero.Coordenada;
import edu.fiuba.algo3.modelo.tablero.Mapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testBaseMapa {

    @Test
    public void testSeCreaUnaBaseConFactor1YLasDimencionesDelMapaDeberianSer10x10YYDeberiaHaberEnTotal2Bases() {

        //Average
        Base base = new Base(1);
        Mapa mapa = base.getMapa();
        mapa.inicializarMapa();

        //Act
        boolean resultado = mapa.buscar(new Coordenada(0,0)).existeEdificio();
        boolean resultado2 = mapa.buscar(new Coordenada(2,0)).existeRecurso();
        boolean resultado3 = mapa.buscar(new Coordenada(0,2)).existeRecurso();
        boolean resultado4 = mapa.buscar(new Coordenada(2,2)).existeRecurso();

        boolean resultado5 = mapa.buscar(new Coordenada(9,9)).existeEdificio();
        boolean resultado6 = mapa.buscar(new Coordenada(7,9)).existeRecurso();
        boolean resultado7 = mapa.buscar(new Coordenada(9,7)).existeRecurso();
        boolean resultado8 = mapa.buscar(new Coordenada(7,7)).existeRecurso();

        //Assert
        assertEquals(true, resultado);
        assertEquals(true, resultado2);
        assertEquals(true, resultado3);
        assertEquals(true, resultado4);
        assertEquals(true, resultado5);
        assertEquals(true, resultado6);
        assertEquals(true, resultado7);
        assertEquals(true, resultado8);
    }

    @Test
    public void testSeCreaUnaBaseConFactor2YLasDimencionesDelMapaDeberianSer15x15YYDeberiaHaberEnTotal4Bases() {

        //Average
        Base base = new Base(2);
        Mapa mapa = base.getMapa();
        mapa.inicializarMapa();
        //
        //Act
        boolean resultado0 = mapa.buscar(new Coordenada(0,0)).existeEdificio();
        boolean resultado1 = mapa.buscar(new Coordenada(0,14)).existeRecurso();
        boolean resultado2 = mapa.buscar(new Coordenada(2,14)).existeRecurso();
        boolean resultado3 = mapa.buscar(new Coordenada(0,12)).existeRecurso();

        boolean resultado4 = mapa.buscar(new Coordenada(14,0)).existeRecurso();
        boolean resultado5 = mapa.buscar(new Coordenada(14,2)).existeRecurso();
        boolean resultado6 = mapa.buscar(new Coordenada(12,0)).existeRecurso();
        boolean resultado7 = mapa.buscar(new Coordenada(14,14)).existeEdificio();

        boolean resultado8 = mapa.buscar(new Coordenada(0,0)).existeEdificio();
        boolean resultado9 = mapa.buscar(new Coordenada(2,0)).existeRecurso();
        boolean resultado10 = mapa.buscar(new Coordenada(0,2)).existeRecurso();
        boolean resultado11 = mapa.buscar(new Coordenada(2,2)).existeRecurso();

        boolean resultado12 = mapa.buscar(new Coordenada(14,12)).existeRecurso();
        boolean resultado13 = mapa.buscar(new Coordenada(12,14)).existeRecurso();
        boolean resultado14 = mapa.buscar(new Coordenada(12,12)).existeRecurso();

        //Assert
        assertEquals(true, resultado0);
        assertEquals(true, resultado1);
        assertEquals(true, resultado2);
        assertEquals(true, resultado3);
        assertEquals(true, resultado4);
        assertEquals(true, resultado5);
        assertEquals(true, resultado6);
        assertEquals(true, resultado7);
        assertEquals(true, resultado8);
        assertEquals(true, resultado9);
        assertEquals(true, resultado10);
        assertEquals(true, resultado11);
        assertEquals(true, resultado12);

        assertEquals(true, resultado13);
        assertEquals(true, resultado14);

    }

    @Test
    public void testSeCreaUnaBaseConFactor3YLasDimencionesDelMapaDeberianSer18x18YYDeberiaHaberEnTotal4Bases() {

        //Average
        Base base = new Base(3);
        Mapa mapa = base.getMapa();
        mapa.inicializarMapa();

        //Act
        boolean resultado0 = mapa.buscar(new Coordenada(0,0)).existeEdificio();
        boolean resultado1 = mapa.buscar(new Coordenada(0,8)).existeRecurso();
        boolean resultado2 = mapa.buscar(new Coordenada(2,9)).existeRecurso();
        boolean resultado3 = mapa.buscar(new Coordenada(2,7)).existeRecurso();

        boolean resultado4 = mapa.buscar(new Coordenada(17,8)).existeRecurso();
        boolean resultado5 = mapa.buscar(new Coordenada(15,7)).existeRecurso();
        boolean resultado6 = mapa.buscar(new Coordenada(15,9)).existeRecurso();
        boolean resultado7 = mapa.buscar(new Coordenada(17,17)).existeEdificio();

        boolean resultado8 = mapa.buscar(new Coordenada(17,0)).existeRecurso();
        boolean resultado9 = mapa.buscar(new Coordenada(15,0)).existeRecurso();
        boolean resultado10 = mapa.buscar(new Coordenada(17,2)).existeRecurso();

        boolean resultado11 = mapa.buscar(new Coordenada(0,15)).existeRecurso();
        boolean resultado12 = mapa.buscar(new Coordenada(0,17)).existeRecurso();
        boolean resultado13 = mapa.buscar(new Coordenada(2,17)).existeRecurso();

        boolean resultado14 = mapa.buscar(new Coordenada(2,0)).existeRecurso();
        boolean resultado15 = mapa.buscar(new Coordenada(0,2)).existeRecurso();
        boolean resultado16 = mapa.buscar(new Coordenada(2,2)).existeRecurso();

        boolean resultado17 = mapa.buscar(new Coordenada(17,15)).existeRecurso();
        boolean resultado18 = mapa.buscar(new Coordenada(15,15)).existeRecurso();
        boolean resultado19 = mapa.buscar(new Coordenada(15,17)).existeRecurso();


        //Assert
        assertEquals(true, resultado0);
        assertEquals(true, resultado1);
        assertEquals(true, resultado2);
        assertEquals(true, resultado3);
        assertEquals(true, resultado4);
        assertEquals(true, resultado5);
        assertEquals(true, resultado6);
        assertEquals(true, resultado7);
        assertEquals(true, resultado8);
        assertEquals(true, resultado9);
        assertEquals(true, resultado10);
        assertEquals(true, resultado11);
        assertEquals(true, resultado12);
        assertEquals(true, resultado13);
        assertEquals(true, resultado14);
        assertEquals(true, resultado15);
        assertEquals(true, resultado16);
        assertEquals(true, resultado17);
        assertEquals(true, resultado18);
        assertEquals(true, resultado19);

    }

}
