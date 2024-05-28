package edu.fiuba.algo3.entrega_3;


import edu.fiuba.algo3.modelo.Edificio.Zerg.Criadero;
import edu.fiuba.algo3.modelo.HitPoints.HPZerg;
import edu.fiuba.algo3.modelo.Raza.PoblacionExedidaError;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import edu.fiuba.algo3.modelo.Recurso.RecursosInsuficientesError;
import edu.fiuba.algo3.modelo.Unidad.*;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso26 {
    @Test
    public void testSeIniciaElJuegoConUnCriaderoYAlAgregarZanganoNoDeberiaTirarError(){
        RazaZerg raza = new RazaZerg();
        Criadero criadero = new Criadero(0);
        Zangano zangano = new Zangano();
        raza.agregarEdificio(criadero);
        raza.aumentarMineral(new GestionRecurso(10000));
        raza.aumentarGas(new GestionRecurso(10000));

        assertDoesNotThrow(() -> {
            raza.agregarUnidad(zangano);
        });
    }
    @Test
    public void testSeIntentaAgregarUnZanganoSinCapacidadDeberiaTirarError(){
        RazaZerg raza = new RazaZerg();
        Zangano zangano = new Zangano();
        raza.aumentarMineral(new GestionRecurso(10000));
        raza.aumentarGas(new GestionRecurso(10000));

        assertThrows( PoblacionExedidaError.class, ()-> {
            raza.agregarUnidad(zangano);
        });
    }

    @Test
    public void testSeIniciaElJuegoConUnCriaderoYAlAgregarZerlingNoDeberiaTirarError(){
        RazaZerg raza = new RazaZerg();
        Criadero criadero = new Criadero(0);
        Zerling zerling = new Zerling();
        raza.agregarEdificio(criadero);
        raza.aumentarMineral(new GestionRecurso(10000));
        raza.aumentarGas(new GestionRecurso(10000));

        assertDoesNotThrow(() -> {
            raza.agregarUnidad(zerling);
        });
    }
    @Test
    public void testSeIntentaAgregarUnZerlingSinCapacidadDeberiaTirarError(){
        RazaZerg raza = new RazaZerg();
        Zerling zerling = new Zerling();
        raza.aumentarMineral(new GestionRecurso(10000));
        raza.aumentarGas(new GestionRecurso(10000));

        assertThrows( PoblacionExedidaError.class, ()-> {
            raza.agregarUnidad(zerling);
        });
    }

    @Test
    public void testSeIniciaElJuegoConUnCriaderoYAlAgregarZealotNoDeberiaTirarError(){
        RazaZerg raza = new RazaZerg();
        Criadero criadero = new Criadero(0);
        Zealot zealot = new Zealot();
        raza.agregarEdificio(criadero);
        raza.aumentarMineral(new GestionRecurso(10000));
        raza.aumentarGas(new GestionRecurso(10000));

        assertDoesNotThrow(() -> {
            raza.agregarUnidad(zealot);
        });
    }
    @Test
    public void testSeIntentaAgregarUnZealotSinCapacidadDeberiaTirarError(){
        RazaZerg raza = new RazaZerg();
        Zealot zealot = new Zealot();
        raza.aumentarMineral(new GestionRecurso(10000));
        raza.aumentarGas(new GestionRecurso(10000));

        assertThrows( PoblacionExedidaError.class, ()-> {
            raza.agregarUnidad(zealot);
        });
    }

    @Test
    public void testSeIniciaElJuegoConUnCriaderoYAlAgregarScoutNoDeberiaTirarError(){
        RazaZerg raza = new RazaZerg();
        Criadero criadero = new Criadero(0);
        Scout scout = new Scout();
        raza.agregarEdificio(criadero);
        raza.aumentarMineral(new GestionRecurso(10000));
        raza.aumentarGas(new GestionRecurso(10000));

        assertDoesNotThrow(() -> {
            raza.agregarUnidad(scout);
        });
    }
    @Test
    public void testSeIntentaAgregarUnScoutSinCapacidadDeberiaTirarError(){
        RazaZerg raza = new RazaZerg();
        Scout scout = new Scout();
        raza.aumentarMineral(new GestionRecurso(10000));
        raza.aumentarGas(new GestionRecurso(10000));

        assertThrows( PoblacionExedidaError.class, ()-> {
            raza.agregarUnidad(scout);
        });
    }
    @Test
    public void testSeIniciaElJuegoConUnCriaderoYAlAgregarMutaliscoNoDeberiaTirarError(){
        RazaZerg raza = new RazaZerg();
        Criadero criadero = new Criadero(0);
        Mutalisco mutalisco = new Mutalisco();
        raza.agregarEdificio(criadero);
        raza.aumentarMineral(new GestionRecurso(10000));
        raza.aumentarGas(new GestionRecurso(10000));

        assertDoesNotThrow(() -> {
            raza.agregarUnidad(mutalisco);
        });
    }
    @Test
    public void testSeIntentaAgregarUnMutaliscoSinCapacidadDeberiaTirarError(){
        RazaZerg raza = new RazaZerg();
        Mutalisco mutalisco = new Mutalisco();
        raza.aumentarMineral(new GestionRecurso(10000));
        raza.aumentarGas(new GestionRecurso(10000));

        assertThrows( PoblacionExedidaError.class, ()-> {
            raza.agregarUnidad(mutalisco);
        });
    }
    @Test
    public void testSeIniciaElJuegoConUnCriaderoYAlAgregarHidraliscoNoDeberiaTirarError(){
        RazaZerg raza = new RazaZerg();
        Criadero criadero = new Criadero(0);
        Hidralisco hidralisco = new Hidralisco();
        raza.agregarEdificio(criadero);
        raza.aumentarMineral(new GestionRecurso(10000));
        raza.aumentarGas(new GestionRecurso(10000));

        assertDoesNotThrow(() -> {
            raza.agregarUnidad(hidralisco);
        });
    }
    @Test
    public void testSeIntentaAgregarUnHidraliscoSinCapacidadDeberiaTirarError(){
        RazaZerg raza = new RazaZerg();
        Hidralisco hidralisco = new Hidralisco();
        raza.aumentarMineral(new GestionRecurso(10000));
        raza.aumentarGas(new GestionRecurso(10000));

        assertThrows( PoblacionExedidaError.class, ()-> {
            raza.agregarUnidad(hidralisco);
        });
    }
    @Test
    public void testSeIniciaElJuegoConUnCriaderoYAlAgregarGuardianNoDeberiaTirarError(){
        RazaZerg raza = new RazaZerg();
        Criadero criadero = new Criadero(0);
        Guardian guardian = new Guardian();
        raza.agregarEdificio(criadero);
        raza.aumentarMineral(new GestionRecurso(10000));
        raza.aumentarGas(new GestionRecurso(10000));

        assertDoesNotThrow(() -> {
            raza.agregarUnidad(guardian);
        });
    }
    @Test
    public void testSeAgregarUnGuardianNoDeberiaTirarError(){
        RazaZerg raza = new RazaZerg();
        Guardian guardian = new Guardian();
        raza.aumentarMineral(new GestionRecurso(10000));
        raza.aumentarGas(new GestionRecurso(10000));

        assertDoesNotThrow(() -> {
            raza.agregarUnidad(guardian);
        });
    }
    @Test
    public void testSeIniciaElJuegoConUnCriaderoYAlAgregarDragonNoDeberiaTirarError(){
        RazaZerg raza = new RazaZerg();
        Criadero criadero = new Criadero(0);
        Dragon dragon = new Dragon();
        raza.agregarEdificio(criadero);
        raza.aumentarMineral(new GestionRecurso(10000));
        raza.aumentarGas(new GestionRecurso(10000));

        assertDoesNotThrow(() -> {
            raza.agregarUnidad(dragon);
        });
    }
    @Test
    public void testSeIntentaAgregarUnDragonSinCapacidadDeberiaTirarError(){
        RazaZerg raza = new RazaZerg();
        Dragon dragon = new Dragon();
        raza.aumentarMineral(new GestionRecurso(10000));
        raza.aumentarGas(new GestionRecurso(10000));

        assertThrows( PoblacionExedidaError.class, ()-> {
            raza.agregarUnidad(dragon);
        });
    }
    @Test
    public void testSeIniciaElJuegoConUnCriaderoYAlAgregarDevoradorNoDeberiaTirarError(){
        RazaZerg raza = new RazaZerg();
        Criadero criadero = new Criadero(0);
        Devorador devorador = new Devorador();
        raza.agregarEdificio(criadero);
        raza.aumentarMineral(new GestionRecurso(10000));
        raza.aumentarGas(new GestionRecurso(10000));

        assertDoesNotThrow(() -> {
            raza.agregarUnidad(devorador);
        });
    }

    @Test
    public void testSeAgregarUnDevoradorNoDeberiaTirarError(){
        RazaZerg raza = new RazaZerg();
        Devorador devorador = new Devorador();
        raza.aumentarMineral(new GestionRecurso(10000));
        raza.aumentarGas(new GestionRecurso(10000));

        assertDoesNotThrow(() -> {
            raza.agregarUnidad(devorador);
        });
    }

}




