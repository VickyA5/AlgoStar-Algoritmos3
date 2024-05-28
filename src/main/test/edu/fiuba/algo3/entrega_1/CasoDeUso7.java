package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Edificio.EdificioNoOperativoError;
import edu.fiuba.algo3.modelo.Edificio.Protoss.NexoMineral;
import edu.fiuba.algo3.modelo.HitPoints.HPZerg;
import edu.fiuba.algo3.modelo.Recurso.NodoMineral;
import edu.fiuba.algo3.modelo.Unidad.Zangano;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import edu.fiuba.algo3.modelo.tablero.Coordenada;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso7 {
    @Test
    public void testUnZanganoTrabajandoEnUnMineralEnUnTurnoDeberiaExtraer10Minerales(){
        //Arrange
        Zangano zangano = new Zangano(new HPZerg(25));
        NodoMineral nodoMineral = new NodoMineral();

        //Act
        GestionRecurso cantidadMineral = zangano.extraer(nodoMineral);

        //Assert
        assertEquals(new GestionRecurso(10),cantidadMineral);
    }

    @Test
    public void testNexoMineralCuandoEstaOperativoDeberiaExtraer10MineralesDeUnNodoMineral(){
        //Arrange
        NodoMineral nodoMineral = new NodoMineral();
        Ubicacion ubicacion = new Ubicacion(new Coordenada(0,0));
        NexoMineral nexoMineral = new NexoMineral(nodoMineral,ubicacion);

        //Act
        // dejo operativo el nexoMineral
        nexoMineral.ejecutarTurno();
        nexoMineral.ejecutarTurno();
        nexoMineral.ejecutarTurno();
        nexoMineral.ejecutarTurno();
        GestionRecurso cantidadMineral = nexoMineral.extraer();

        //Assert
        assertEquals(new GestionRecurso(20),cantidadMineral);
    }

    @Test
    public void testNexoMineralNoDeberiaExtraerSiNoEstaOperativo(){
        //Arrange
        NodoMineral nodoMineral = new NodoMineral();
        Ubicacion ubicacion = new Ubicacion(new Coordenada(0,0));
        NexoMineral nexoMineral = new NexoMineral(nodoMineral,ubicacion);

        //Assert
        assertThrows(EdificioNoOperativoError.class, ()->{
            nexoMineral.extraer();
        });
    }
}
