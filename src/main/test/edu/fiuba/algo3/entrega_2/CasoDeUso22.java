package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Unidad.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso22 {

    @Test
    public void testUnZanganoNoOperativoNoDeberiaPoderAtacar(){
        //Arrange
        Zangano unidad = new Zangano();

        //Act y assert
        assertThrows(UnidadNoOperativaError.class, ()-> {
            unidad.atacar(new Zealot());
        });
    }

    @Test
    public void testUnZanganoOperativoDeberiaPoderAtacar(){
        //Arrange
        Zangano unidad = new Zangano();

        //Act
        unidad.ejecutarTurno();

        //Assert
        assertDoesNotThrow(  ()->{
            unidad.atacar(new Zealot());
        });
    }

    @Test
    public void testUnZerlingNoOperativoNoDeberiaPoderAtacar(){
        //Arrange
        Zerling unidad = new Zerling();

        //Act y assert
        assertThrows(UnidadNoOperativaError.class, ()-> {
            unidad.atacar(new Zealot());
        });
    }

    @Test
    public void testUnZerlingOperativoDeberiaPoderAtacar(){
        //Arrange
        Zerling unidad = new Zerling();

        //Act
        unidad.ejecutarTurno();
        unidad.ejecutarTurno();

        //Assert
        assertDoesNotThrow(  ()->{
            unidad.atacar(new Zealot());
        });
    }

    @Test
    public void testUnHidraliscoNoOperativoNoDeberiaPoderAtacar(){
        //Arrange
        Hidralisco unidad = new Hidralisco();

        //Act y assert
        assertThrows(UnidadNoOperativaError.class, ()-> {
            unidad.atacar(new Zealot());
        });
    }

    @Test
    public void testUnHidraliscoOperativoDeberiaPoderAtacar(){
        //Arrange
        Hidralisco unidad = new Hidralisco();

        //Act
        for(int i = 0; i < 4; i++){
            unidad.ejecutarTurno();
        }

        //Assert
        assertDoesNotThrow(  ()->{
            unidad.atacar(new Zealot());
        });
    }

    @Test
    public void testUnMutaliscoNoOperativoNoDeberiaPoderAtacar(){
        //Arrange
        Mutalisco unidad = new Mutalisco();

        //Act y assert
        assertThrows(UnidadNoOperativaError.class, ()-> {
            unidad.atacar(new Scout());
        });
    }

    @Test
    public void testUnMutaliscoOperativoDeberiaPoderAtacar(){
        //Arrange
        Mutalisco unidad = new Mutalisco();

        //Act
        for(int i = 0; i < 7; i++){
            unidad.ejecutarTurno();
        }

        //Assert
        assertDoesNotThrow(  ()->{
            unidad.atacar(new Scout());
        });
    }

    @Test
    public void testUnGuardianNoOperativoNoDeberiaPoderAtacar(){
        //Arrange
        Guardian unidad = new Guardian();

        //Act y assert
        assertThrows(UnidadNoOperativaError.class, ()-> {
            unidad.atacar(new Zealot());
        });
    }

    @Test
    public void testUnGuardianOperativoDeberiaPoderAtacar(){
        //Arrange
        Guardian unidad = new Guardian();

        //Act
        for(int i = 0; i < 4; i++){
            unidad.ejecutarTurno();
        }

        //Assert
        assertDoesNotThrow(  ()->{
            unidad.atacar(new Zealot());
        });
    }

    @Test
    public void testUnZealotNoOperativoNoDeberiaPoderAtacar(){
        //Arrange
        Zealot unidad = new Zealot();

        //Act y assert
        assertThrows(UnidadNoOperativaError.class, ()-> {
            unidad.atacar(new Zerling());
        });
    }

    @Test
    public void testUnZealotOperativoDeberiaPoderAtacar(){
        //Arrange
        Zealot unidad = new Zealot();

        //Act
        for(int i = 0; i < 4; i++){
            unidad.ejecutarTurno();
        }

        //Assert
        assertDoesNotThrow(  ()->{
            unidad.atacar(new Zerling());
        });
    }

    @Test
    public void testUnDragonNoOperativoNoDeberiaPoderAtacar(){
        //Arrange
        Dragon unidad = new Dragon();

        //Act y assert
        assertThrows(UnidadNoOperativaError.class, ()-> {
            unidad.atacar(new Zerling());
        });
    }

    @Test
    public void testUnDragonOperativoDeberiaPoderAtacar(){
        //Arrange
        Dragon unidad = new Dragon();

        //Act
        for(int i = 0; i < 6; i++){
            unidad.ejecutarTurno();
        }

        //Assert
        assertDoesNotThrow(  ()->{
            unidad.atacar(new Zerling());
        });
    }

    @Test
    public void testUnScoutNoOperativoNoDeberiaPoderAtacar(){
        //Arrange
        Scout unidad = new Scout();

        //Act y assert
        assertThrows(UnidadNoOperativaError.class, ()-> {
            unidad.atacar(new Zerling());
        });
    }

    @Test
    public void testUnScoutOperativoDeberiaPoderAtacar(){
        //Arrange
        Scout unidad = new Scout();

        //Act
        for(int i = 0; i < 9; i++){
            unidad.ejecutarTurno();
        }

        //Assert
        assertDoesNotThrow(  ()->{
            unidad.atacar(new Zerling());
        });
    }
}
