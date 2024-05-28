package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Unidad.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso19 {
    /*
    Verificar que todas las unidades que no tienen ataque de aire no puedan atacar a una
     unidad voladora. Idem para todas las combinaciones.
    */

    @Test
    public void testUnidadZerlingNoDeberiaPoderAtacarAUnScout(){

        //Arrange
        Unidad atacante = new Zerling();
        Atacable scout = new Scout();

        //Dejo operativa a la unidad:
        for (int i = 0; i < 2; i++){
            atacante.ejecutarTurno();
        }

        //Act y Assert
        assertThrows(NoPuedeAplicarDanioUnidadTipoAireError.class, () -> {
            atacante.atacar(scout);
        });

    }

    @Test
    public void testUnidadZerlingNoDeberiaPoderAtacarAUnMutalisco(){
        //Arrange
        Unidad atacante = new Zerling();
        Atacable mutalisco = new Mutalisco();

        //Dejo operativa a la unidad:
        for (int i = 0; i < 2; i++){
            atacante.ejecutarTurno();
        }

        //Act y Assert
        assertThrows(NoPuedeAplicarDanioUnidadTipoAireError.class, () -> {
            atacante.atacar(mutalisco);
        });

    }

    @Test
    public void testUnidadZerlingNoDeberiaPoderAtacarAUnGuardian(){
        //Arrange
        Unidad atacante = new Zerling();
        Atacable guardian = new Guardian();

        //Dejo operativa a la unidad:
        for (int i = 0; i < 2; i++){
            atacante.ejecutarTurno();
        }

        //Act y Assert
        assertThrows(NoPuedeAplicarDanioUnidadTipoAireError.class, () -> {
            atacante.atacar(guardian);
        });
    }

    @Test
    public void testUnidadGuardianNoDeberiaPoderAtacarAUnMutalisco(){
        //Arrange
        Unidad guardian = new Guardian();
        Atacable mutalisco = new Mutalisco();

        //Dejo operativa a la unidad:
        for (int i = 0; i < 4; i++){
            guardian.ejecutarTurno();
        }

        //Act y Assert
        assertThrows(NoPuedeAplicarDanioUnidadTipoAireError.class, () -> {
            guardian.atacar(mutalisco);
        });
    }

    @Test
    public void testUnidadGuardianNoDeberiaPoderAtacarAOtroGuardian(){
        //Arrange
        Unidad guardian = new Guardian();
        Atacable guardianDos = new Guardian();

        //Dejo operativa a la unidad:
        for (int i = 0; i < 4; i++){
            guardian.ejecutarTurno();
        }

        //Act y Assert
        assertThrows(NoPuedeAplicarDanioUnidadTipoAireError.class, () -> {
            guardian.atacar(guardianDos);
        });

    }

    @Test
    public void testUnidadGuardianNoDeberiaPoderAtacarAUnScout(){
        //Arrange
        Unidad guardian = new Guardian();
        Atacable scout = new Scout();

        //Dejo operativa a la unidad:
        for (int i = 0; i < 4; i++){
            guardian.ejecutarTurno();
        }

        //Act y Assert
        assertThrows(NoPuedeAplicarDanioUnidadTipoAireError.class, () -> {
            guardian.atacar(scout);
        });
    }


    @Test
    public void testUnidadZealotNoDeberiaPoderAtacarAUnMutalisco(){
        //Arrange
        Unidad zealot = new Zealot();
        Atacable mutalisco = new Mutalisco();

        //Dejo operativa a la unidad:
        for (int i = 0; i < 4; i++){
            zealot.ejecutarTurno();
        }

        //Act y Assert
        assertThrows(NoPuedeAplicarDanioUnidadTipoAireError.class, () -> {
            zealot.atacar(mutalisco);
        });

    }


    @Test
    public void testUnidadZealotNoDeberiaPoderAtacarAUnGuardian(){
        //Arrange
        Unidad zealot = new Zealot();
        Atacable guardian = new Guardian();

        //Dejo operativa a la unidad:
        for (int i = 0; i < 4; i++){
            zealot.ejecutarTurno();
        }

        //Act y Assert
        assertThrows(NoPuedeAplicarDanioUnidadTipoAireError.class, () -> {
            zealot.atacar(guardian);
        });

    }

    @Test
    public void testUnidadZealotNoDeberiaPoderAtacarAUnScout(){
        //Arrange
        Unidad zealot = new Zealot();
        Atacable scout = new Scout();

        //Dejo operativa a la unidad:
        for (int i = 0; i < 4; i++){
            zealot.ejecutarTurno();
        }

        //Act y Assert
        assertThrows(NoPuedeAplicarDanioUnidadTipoAireError.class, () -> {
            zealot.atacar(scout);
        });
    }

}

