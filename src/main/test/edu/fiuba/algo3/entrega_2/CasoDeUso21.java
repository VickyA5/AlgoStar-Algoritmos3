package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.HitPoints.HPZerg;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import edu.fiuba.algo3.modelo.Recurso.RecursosInsuficientesError;
import edu.fiuba.algo3.modelo.Unidad.InsuficientesRecursosParaCrearUnidadError;
import edu.fiuba.algo3.modelo.Unidad.Mutalisco;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso21 {

    @Test
    public void testMutaliscoNoPuedeEvolucionarAGuardianSiNoHayRecursosSuficientes(){
        RazaZerg raza = new RazaZerg(); // se crea con 200 mineral y 0 gas.
        Mutalisco mutalisco =  new Mutalisco();

        assertThrows( InsuficientesRecursosParaCrearUnidadError.class, ()-> {
            mutalisco.evolucionarAGuardian(raza) ;
        });

        // Dos posibles maneras de hacerlo.
        //raza.agregarUnidad(mutalisco); o como esta dentro de la excepcion
        // de esta manera evitamos que la raza busque en su lista de individuos sino directamos el mutalisco
        // ya sabe evolucionar y le pasamos la raza.
    }

    @Test
    public void testMutaliscoSiPuedeEvolucionarAGuardianPorqueoHayRecursosSuficientes(){
        RazaZerg raza = new RazaZerg(); // se crea con 200 mineral y 0 gas.
        raza.aumentarMineral(new GestionRecurso(500));
        raza.aumentarGas(new GestionRecurso(500));
        Mutalisco mutalisco =  new Mutalisco();


        assertDoesNotThrow(  ()-> {
            mutalisco.evolucionarAGuardian(raza) ; //busca un mutalisco y lo hace evolucionar .
        });

        // Dos posibles maneras de hacerlo.
        //raza.agregarUnidad(mutalisco); o como esta dentro de la excepcion
        // de esta manera evitamos que la raza busque en su lista de individuos sino directamos el mutalisco
        // ya sabe evolucionar y le pasamos la raza.
    }

}