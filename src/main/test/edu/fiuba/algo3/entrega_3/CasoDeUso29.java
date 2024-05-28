package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Edificio.Protoss.Pilon;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Criadero;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import edu.fiuba.algo3.modelo.Unidad.*;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso29 {


    @Test
    public void testLaCapacidadLlegaA200Con40AmosSupremos() {
        Raza razaZerg = new RazaZerg();
        razaZerg.aumentarMineral(new GestionRecurso(2050));
        for (int i =0 ;i<40;i++) {
            razaZerg.agregarUnidad(new AmoSupremo());
        }

        assertEquals(200,razaZerg.capacidadReal());
    }
    @Test
    public void testLaCapacidadNoAumentaAlTener200() {
        Raza razaZerg = new RazaZerg();
        razaZerg.aumentarMineral(new GestionRecurso(2050));
        for (int i =0 ;i<41;i++) {
            razaZerg.agregarUnidad(new AmoSupremo());
        }

        assertEquals(200,razaZerg.capacidadReal());
    }

    @Test
    public void testLaCapacidadLlegaA200Con40Pilones() {
        Raza razaProtos = new RazaZerg();
        razaProtos.aumentarMineral(new GestionRecurso(10000));
        for (int i =0 ;i<40;i++) {
            razaProtos.agregarEdificio(new Pilon());
        }

        assertEquals(200,razaProtos.capacidadReal());
    }
    @Test
    public void testLaCapacidadLlegaA200Con40Criaderos() {
        Raza razaZerg = new RazaZerg();
        razaZerg.aumentarMineral(new GestionRecurso(10000));
        for (int i =0 ;i<40;i++) {
            razaZerg.agregarEdificio(new Criadero());
        }

        assertEquals(200,razaZerg.capacidadReal());
    }
}