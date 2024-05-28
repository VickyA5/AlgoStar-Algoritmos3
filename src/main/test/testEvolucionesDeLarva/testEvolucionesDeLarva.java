package testEvolucionesDeLarva;

import edu.fiuba.algo3.modelo.Edificio.Zerg.Criadero;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Extractor;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Guarida;
import edu.fiuba.algo3.modelo.Edificio.Zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.HitPoints.HPProtoss;
import edu.fiuba.algo3.modelo.HitPoints.HitPoints;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import edu.fiuba.algo3.modelo.Recurso.NodoMineral;
import edu.fiuba.algo3.modelo.Recurso.Volcan;
import edu.fiuba.algo3.modelo.Unidad.Larva;
import edu.fiuba.algo3.modelo.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Unidad.Zealot;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testEvolucionesDeLarva {

    @Test
    public void testLarvaEvolucionaConReservaComoZerlingDeberiaPoderAtacarComoZerling(){
        //arrange
        RazaZerg raza = new RazaZerg(new GestionRecurso(1000), new GestionRecurso(1000));
        raza.agregarEdificio(new Criadero());
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion();
        raza.agregarEdificio(reservaDeReproduccion);
        Larva larva = new Larva();

        //Dejo operativo a la reserva
        for (int i = 0; i < 12 ; i++){
            reservaDeReproduccion.ejecutarTurno();
        }

        reservaDeReproduccion.crearZerling(larva);

        //Dejo operativo al nuevo Zerling
        for (int i = 0; i < 2 ; i++){
            larva.ejecutarTurno();
        }

        HitPoints hpZealot = new HPProtoss(60,100);
        HitPoints hpEsperado = new HPProtoss(60,96);
        Zealot zealot = new Zealot(hpZealot);

        //act
        larva.atacar(zealot);

        //assert
        assertEquals(hpEsperado,hpZealot);
    }

    @Test
    public void testLarvaEvolucionaComoZanganoDeberiaPoderExtraerComoZangano(){
        //arrange
        NodoMineral nodoMineral = new NodoMineral();
        RazaZerg raza = new RazaZerg(new GestionRecurso(1000), new GestionRecurso(1000));
        Criadero criadero = new Criadero();
        raza.agregarEdificio(criadero);
        Larva larva = new Larva();

        //Dejo operativo al criadero
        for (int i = 0; i < 4 ; i++){
            criadero.ejecutarTurno();
        }

        larva.evolucionar();

        //Dejo operativo al nuevo Zangano
        larva.ejecutarTurno();

        HitPoints hpZealot = new HPProtoss(60,100);
        HitPoints hpEsperado = new HPProtoss(60,96);
        Zealot zealot = new Zealot(hpZealot);
        //act
        GestionRecurso cantidadExtraida = larva.extraer(nodoMineral);

        //assert
        assertEquals(new GestionRecurso(10),cantidadExtraida);
    }

    @Test
    public void testLarvaEvolucionaComoHidraliscoDeberiaPoderAtacarComoHidralisco(){
        //arrange
        Larva larva = new Larva();
        larva.evolucionar(new Guarida());

        //Dejo operativo al nuevo Hidralisco
        for (int i = 0; i < 4 ; i++){
            larva.ejecutarTurno();
        }

        HitPoints hpZealot = new HPProtoss(60,100);
        HitPoints hpEsperado = new HPProtoss(60,90);
        Zealot zealot = new Zealot(hpZealot);

        //act
        larva.atacar(zealot);

        //assert
        assertEquals(hpEsperado,hpZealot);
    }

    @Test
    public void testLarvaEvolucionaComoZanganoDeberiaPoderTrabajarEnExtractor(){
        //arrange
        RazaZerg raza = new RazaZerg(new GestionRecurso(1000), new GestionRecurso(1000));
        raza.agregarEdificio(new Criadero());
        Larva larva = new Larva();

        larva.evolucionar();
        larva.ejecutarTurno();  //Dejo operativo al nuevo Zangano

        Volcan volcan = new Volcan();
        Extractor extractor = new Extractor();
        GestionRecurso resultadoEsperado = new GestionRecurso(10);

        // dejo el Extrractor operable en 6 turnos
        for(int i = 0; i < 6; i++ ){
            extractor.ejecutarTurno();
        }
        extractor.agregarZangano( larva);

        //act
        GestionRecurso cantidadGas = extractor.extraer(volcan);

        //assert
        assertEquals(resultadoEsperado, cantidadGas);
    }
}
