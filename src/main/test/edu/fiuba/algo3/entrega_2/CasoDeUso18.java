package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Edificio.Protoss.Pilon;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Guarida;
import edu.fiuba.algo3.modelo.Unidad.*;
import edu.fiuba.algo3.modelo.HitPoints.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class CasoDeUso18 {

    /*
     * - Verificar que todas las unidades cuasen el daño que dicen que causan en sus ataques.*/

    @Test
    public void testUnZanganoAtacaAUnZealotQueEsUnaUnidadDeSuperficieTierrayLeDeberiaCausar0Danio(){
        //Arrange
        Unidad zangano = new Zangano();
        HitPoints hpZealot = new HPProtoss(60,100);
        Atacable zealot = new Zealot(hpZealot);
        HitPoints hpEsperado = new HPProtoss(60,100);

        //Dejo operativa a la unidad:
        for (int i = 0; i < 1; i++){
            zangano.ejecutarTurno();
        }

        //Act
        zangano.atacar(zealot);

        //Assert
        assertEquals(hpEsperado,hpZealot);

    }

    @Test
    public void testUnZerlingAtacaAUnZealotQueEsUnaUnidadDeSuperficieTierrayLeDeberiaCausar4Danio(){
        //Arrange
        HitPoints hpZealot = new HPProtoss(60,100);
        HitPoints hpEsperado = new HPProtoss(60,96);
        Unidad zerling = new Zerling();
        Atacable zealot = new Zealot(hpZealot);

        //Dejo operativa a la unidad:
        for (int i = 0; i < 2; i++){
            zerling.ejecutarTurno();
        }

        //Act
        zerling.atacar(zealot);

        //Assert
        assertEquals(hpEsperado,hpZealot);

    }

    @Test
    public void testUnHidraliscoAtacaAUnZealotQueEsUnaUnidadDeSuperficieTierrayLeDeberiaCausar10Danio(){
        //Arrange
        HitPoints hpZealot = new HPProtoss(60,100);
        HitPoints hpEsperado = new HPProtoss(60,90);

        Unidad hidralisco = new Hidralisco();
        Atacable zealot = new Zealot(hpZealot);

        //Dejo operativa a la unidad:
        for (int i = 0; i < 4; i++){
            hidralisco.ejecutarTurno();
        }

        //Act
        hidralisco.atacar(zealot);

        //Assert
        assertEquals(hpEsperado,hpZealot);
    }


    @Test
    public void testUnHidraliscoAtacaAUnZealotQueEsUnaUnidadDeSuperficieVVientoyLeDeberiaCausar10Danio(){
        //Arrange
        HitPoints hpScout = new HPProtoss(150,100);
        HitPoints hpEsperado = new HPProtoss(150,90);

        Unidad hidralisco = new Hidralisco();
        Atacable scout = new Scout(hpScout);

        //Dejo operativa a la unidad:
        for (int i = 0; i < 4; i++){
            hidralisco.ejecutarTurno();
        }

        //Act
        hidralisco.atacar(scout);

        //Assert
        assertEquals(hpEsperado, hpScout);
    }

    @Test
    public void testUnMutaliscoAtacaAUnZealotQueEsUnaUnidadDeSuperficieTierrayLeDeberiaCausar9Danio(){
        //Arrange
        HitPoints hpZealot = new HPProtoss(60,100);
        HitPoints hpEsperado = new HPProtoss(60,91);

        Unidad mutalisco = new Mutalisco();
        Atacable zealot = new Zealot(hpZealot);

        //Dejo operativa a la unidad:
        for (int i = 0; i < 7; i++){
            mutalisco.ejecutarTurno();
        }

        //Act
        mutalisco.atacar(zealot);

        //Assert
        assertEquals(hpEsperado,hpZealot);
    }


    @Test
    public void testUnMutaliscoAtacaAUnZealotQueEsUnaUnidadDeSuperficieVVientoyLeDeberiaCausar9Danio(){
        //Arrange
        HitPoints hpScout = new HPProtoss(150,100);
        HitPoints hpEsperado = new HPProtoss(150,91);

        Unidad mutalisco = new Mutalisco();
        Atacable scout = new Scout(hpScout);

        //Dejo operativa a la unidad:
        for (int i = 0; i < 7; i++){
            mutalisco.ejecutarTurno();
        }

        //Act
        mutalisco.atacar(scout);

        //Assert
        assertEquals(hpEsperado,hpScout);
    }

    @Test
    public void testUnGuardianAtacaAUnZealotQueEsUnaUnidadDeSuperficieTierrayLeDeberiaCausar25Danio(){
        //Arrange
        HitPoints hpZealot = new HPProtoss(60,100);
        HitPoints hpEsperado = new HPProtoss(60,75);

        Unidad guardian = new Guardian();
        Atacable zealot = new Zealot(hpZealot);

        //Dejo operativa a la unidad:
        for (int i = 0; i < 4; i++){
            guardian.ejecutarTurno();
        }

        //Act
        guardian.atacar(zealot);

        //Assert
        assertEquals(hpEsperado,hpZealot);
    }



    @Test
    public void testUnZealotAtacaAUnZerlingQueEsUnaUnidadDeSuperficieTierrayLeDeberiaCausar8Danio(){
        //Arrange
        HitPoints hpZerling = new HPZerg(35);
        HitPoints hpEsperado = new HPZerg(27);

        Unidad zealot = new Zealot();
        Atacable zerling = new Zerling(hpZerling);

        //Dejo operativa a la unidad:
        for (int i = 0; i < 4; i++){
            zealot.ejecutarTurno();
        }

        //Act
        zealot.atacar(zerling);

        //Assert
        assertEquals(hpEsperado,hpZerling);
    }

    @Test
    public void testUnDragonAtacaAUnZerlingQueEsUnaUnidadDeSuperficieTierrayLeDeberiaCausar8Danio(){
        //Arrange
        HitPoints hpZerling = new HPZerg(35);
        HitPoints hpEsperado = new HPZerg(15);

        Unidad dragon = new Dragon();
        Atacable zerling = new Zerling(hpZerling);

        //Dejo operativa a la unidad:
        for (int i = 0; i < 6; i++){
            dragon.ejecutarTurno();
        }

        //Act
        dragon.atacar(zerling);

        //Assert
        assertEquals(hpEsperado,hpZerling);
    }

    @Test
    public void testUnDragonAtacaAUnGuardianQueEsUnaUnidadDeSuperficieVientoyLeDeberiaCausar20Danio(){
        //Arrange
        HitPoints hpGuardian = new HPZerg(100);
        HitPoints hpEsperado = new HPZerg(80);

        Unidad dragon = new Dragon();
        Atacable guardian = new Guardian(hpGuardian);

        //Dejo operativa a la unidad:
        for (int i = 0; i < 6; i++){
            dragon.ejecutarTurno();
        }

        //Act
        dragon.atacar(guardian);

        //Assert
        assertEquals(hpEsperado,hpGuardian);
    }


    @Test
    public void testUnScoutAtacaAUnZerlingQueEsUnaUnidadDeSuperficieTierrayLeDeberiaCausar8Danio(){
        //Arrange
        HitPoints hpZerling = new HPZerg(35);
        HitPoints hpEsperado = new HPZerg(27);

        Unidad scout = new Scout();
        Atacable zerling = new Zerling(hpZerling);

        //Dejo operativa a la unidad:
        for (int i = 0; i < 9; i++){
            scout.ejecutarTurno();
        }

        //Act
        scout.atacar(zerling);

        //Assert
        assertEquals(hpEsperado,hpZerling);
    }

    @Test
    public void testUnScoutAtacaAUnGuardianQueEsUnaUnidadDeSuperficieVientoyLeDeberiaCausar14Danio(){
        //Arrange
        HitPoints hpGuardian = new HPZerg(100);
        HitPoints hpEsperado = new HPZerg(86);

        Unidad scout = new Scout();
        Atacable guardian = new Guardian(hpGuardian);

        //Dejo operativa a la unidad:
        for (int i = 0; i < 9; i++){
            scout.ejecutarTurno();
        }

        //Act
        scout.atacar(guardian);

        //Assert
        assertEquals(hpEsperado,hpGuardian);
    }


    //Con Edificios:
    @Test
    public void testUnZanganoAtacaAUnPilonDeberiaCausarle0Danio(){
        //Arrange
        Unidad zangano = new Zangano();
        HitPoints hpPilon = new HPProtoss(300,300);
        Atacable pilon = new Pilon(hpPilon);

        HitPoints hpEsperado = new HPProtoss(300,300);

        //Dejo operativa a la unidad:
        for (int i = 0; i < 1; i++){
            zangano.ejecutarTurno();
        }

        //Act
        zangano.atacar(pilon);

        //Assert
        assertEquals(hpEsperado,hpPilon);

    }

    @Test
    public void testUnZerlingAtacaAUnPilonDeberiaCausarle4Danio(){
        //Arrange
        Unidad zerling = new Zerling();
        HitPoints hpPilon = new HPProtoss(300,300);
        Atacable pilon = new Pilon(hpPilon);

        HitPoints hpEsperado = new HPProtoss(300,296);

        //Dejo operativa a la unidad:
        for (int i = 0; i < 2; i++){
            zerling.ejecutarTurno();
        }

        //Act
        zerling.atacar(pilon);

        //Assert
        assertEquals(hpEsperado,hpPilon);
    }

    @Test
    public void testUnHidraliscoAtacaAUnPilonDeberiaCausarle10Danio(){
        //Arrange
        Unidad hidralisco = new Hidralisco();
        HitPoints hpPilon = new HPProtoss(300,300);
        Atacable pilon = new Pilon(hpPilon);

        HitPoints hpEsperado = new HPProtoss(300,290);

        //Dejo operativa a la unidad:
        for (int i = 0; i < 4; i++){
            hidralisco.ejecutarTurno();
        }

        //Act
        hidralisco.atacar(pilon);

        //Assert
        assertEquals(hpEsperado,hpPilon);
    }

    @Test
    public void testUnMutaliscoAtacaAUnPilonDeberiaCausarle9Danio(){
        //Arrange
        Unidad mutalisco = new Mutalisco();
        HitPoints hpPilon = new HPProtoss(300,300);
        Atacable pilon = new Pilon(hpPilon);

        HitPoints hpEsperado = new HPProtoss(300,291);

        //Dejo operativa a la unidad:
        for (int i = 0; i < 7; i++){
            mutalisco.ejecutarTurno();
        }

        //Act
        mutalisco.atacar(pilon);

        //Assert
        assertEquals(hpEsperado,hpPilon);
    }

    @Test
    public void testUnGuardianAtacaAUnPilonDeberiaCausarle25Danio(){
        //Arrange
        Unidad guardian = new Guardian();
        HitPoints hpPilon = new HPProtoss(300,300);
        Atacable pilon = new Pilon(hpPilon);

        HitPoints hpEsperado = new HPProtoss(300,275);

        //Dejo operativa a la unidad:
        for (int i = 0; i < 4; i++){
            guardian.ejecutarTurno();
        }

        //Act
        guardian.atacar(pilon);

        //Assert
        assertEquals(hpEsperado,hpPilon);
    }

    @Test
    public void testUnZealotAtacaAUnaGuaridaDeberiaCausarle8Danio(){
        //Arrange
        Unidad zealot = new Zealot();
        HitPoints hpGuarida = new HPZerg(1250);
        Atacable guarida = new Guarida(hpGuarida);

        HitPoints hpEsperado = new HPZerg(1242);

        //Dejo operativa a la unidad:
        for (int i = 0; i < 4; i++){
            zealot.ejecutarTurno();
        }

        //Act
        zealot.atacar(guarida);

        //Assert
        assertEquals(hpEsperado,hpGuarida);
    }

    @Test
    public void testUnDragonAtacaAUnaGuaridaDeberiaCausarle20Danio(){
        //Arrange
        Unidad dragon = new Dragon();
        HitPoints hpGuarida = new HPZerg(1250);
        Atacable guarida = new Guarida(hpGuarida);

        HitPoints hpEsperado = new HPZerg(1230);

        //Dejo operativa a la unidad:
        for (int i = 0; i < 6; i++){
            dragon.ejecutarTurno();
        }

        //Act
        dragon.atacar(guarida);

        //Assert
        assertEquals(hpEsperado,hpGuarida);
    }

    @Test
    public void testUnScoutAtacaAUnaGuaridaDeberiaCausarle8Danio(){
        //Arrange
        Unidad scout = new Scout();
        HitPoints hpGuarida = new HPZerg(1250);
        Atacable guarida = new Guarida(hpGuarida);

        HitPoints hpEsperado = new HPZerg(1242);

        //Dejo operativa a la unidad:
        for (int i = 0; i < 9; i++){
            scout.ejecutarTurno();
        }

        //Act
        scout.atacar(guarida);

        //Assert
        assertEquals(hpEsperado,hpGuarida);
    }



}