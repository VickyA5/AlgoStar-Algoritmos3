package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Edificio.*;
import edu.fiuba.algo3.modelo.Edificio.Protoss.Acceso;
import edu.fiuba.algo3.modelo.Edificio.Protoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Guarida;
import edu.fiuba.algo3.modelo.Edificio.Zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Raza.RazaProtoss;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import edu.fiuba.algo3.modelo.tablero.Coordenada;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class CasoDeUso17 {


    @Test
    public void testRazaZergQuiereConstruirUnaGuaridaNoDeberiaPoderSiNoTieneReservaDeReproduccion(){

        //Arrange
        RazaZerg raza = new RazaZerg();
        raza.aumentarMineral(new GestionRecurso(500));
        raza.aumentarGas(new GestionRecurso(500));


        //Act y Assert
        assertThrows(CorrelativaDeConstruccionIncumplidaError.class, ()-> {
            raza.agregarEdificio(new Guarida());
        });

    }

    @Test
    public void testRazaZergQuiereConstruirUnaGuaridaSiDeberiaPoderSiTieneReservaDeReproduccion(){

        //Arrange
        RazaZerg raza = new RazaZerg();
        raza.aumentarMineral(new GestionRecurso(500));
        raza.aumentarGas(new GestionRecurso(500));
        raza.agregarEdificio(new ReservaDeReproduccion());

        //Act y Assert
        assertDoesNotThrow(  ()-> {
            raza.agregarEdificio(new Guarida());
        });

    }
    @Test
    public void testRazaProtossQuiereConstruirUnPuertoEstelarNoDeberiaPoderSiNoTieneAcceso(){

        //Arrange
        RazaProtoss raza = new RazaProtoss();
        raza.aumentarMineral(new GestionRecurso(500));
        raza.aumentarGas(new GestionRecurso(500));

        //Act y Assert
        assertThrows( CorrelativaDeConstruccionIncumplidaError.class, ()-> {
            raza.agregarEdificio(new PuertoEstelar());
        });

    }

    @Test
    public void testRazaProtossQuiereConstruirUnPuertoEstelarSiDeberiaPoderSiTieneAcceso(){
        //Arrange
        RazaProtoss raza = new RazaProtoss();
        Ubicacion ubicacion = new Ubicacion(new Coordenada(0,0));
        ubicacion.energizar();

        raza.aumentarMineral(new GestionRecurso(500));
        raza.aumentarGas(new GestionRecurso(500));

        raza.agregarEdificio(new Acceso(ubicacion));

        //Act y Assert
        assertDoesNotThrow(  ()-> {
            raza.agregarEdificio(new PuertoEstelar());
        });

    }

}

