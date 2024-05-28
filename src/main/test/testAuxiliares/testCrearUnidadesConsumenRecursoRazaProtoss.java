package testAuxiliares;

import edu.fiuba.algo3.modelo.Edificio.Protoss.Acceso;
import edu.fiuba.algo3.modelo.Edificio.Protoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Raza.RazaProtoss;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import edu.fiuba.algo3.modelo.tablero.Coordenada;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testCrearUnidadesConsumenRecursoRazaProtoss {
    public GestionRecurso mineral;
    public GestionRecurso gas;
    public Raza raza;
    public Ubicacion ubicacion;

    @BeforeEach
    void setup() {
        //Arrange
        mineral = new GestionRecurso(500);
        gas = new GestionRecurso(500);
        raza = new RazaProtoss(mineral, gas);
        raza.aumentarCapacidad(100);
        ubicacion = new Ubicacion(new Coordenada(0,0));
        ubicacion.energizar();

    }

    @Test
    public void ConstruirZealotConsume100MineralesYQueda400MineralesY500DeGas() {

        Acceso edificio = new Acceso(ubicacion);
        raza.aumentarMineral(new GestionRecurso(150)); //agregamos recursos para el edificio
        raza.agregarEdificio(edificio); // quedan 500 minerales
        GestionRecurso mineralEsperado = new GestionRecurso(400);
        GestionRecurso gasEsperado = new GestionRecurso(500);

        for(int i = 0; i<=8; i++){
            edificio.ejecutarTurno();
        }


        //Act
        edificio.crearZealot();

        //Assert
        assertEquals(mineralEsperado, mineral);
        assertEquals(gasEsperado, gas);
    }

    @Test
    public void ConstruirDragonConsume125MineralesY50DeGasYQueda375MineralesY450DeGas() {

        Acceso edificio = new Acceso(ubicacion);
        raza.aumentarMineral(new GestionRecurso(150)); //agregamos recursos para el edificio
        raza.agregarEdificio(edificio); // quedan 500 minerales
        GestionRecurso mineralEsperado = new GestionRecurso(375);
        GestionRecurso gasEsperado = new GestionRecurso(450);
        for(int i = 0; i<=8; i++){
            edificio.ejecutarTurno();
        }

        //Act
        edificio.crearDragon();

        //Assert
        assertEquals(mineralEsperado, mineral);
        assertEquals(gasEsperado, gas);
    }


    @Test
    public void ConstruirScoutConsume300MineralesY125DeGasYQueda200MineralesY350DeGas() {

        Acceso edificioAux = new Acceso(ubicacion);
        raza.aumentarMineral(new GestionRecurso(150)); //agregamos recursos para el edificio
        raza.agregarEdificio(edificioAux); // quedan 500 minerales
        for(int i = 0; i<=8; i++){
            edificioAux.ejecutarTurno();
        }


        PuertoEstelar edificio = new PuertoEstelar();
        raza.aumentarMineral(new GestionRecurso(150)); //agregamos recursos para el edificio
        raza.aumentarGas(new GestionRecurso(150)); //agregamos recursos para el edificio
        raza.agregarEdificio(edificio);
        GestionRecurso mineralEsperado = new GestionRecurso(200);
        GestionRecurso gasEsperado = new GestionRecurso(350);
        for(int i = 0; i<=10; i++){
            edificio.ejecutarTurno();
        }

        //Act
        edificio.crearScout();

        //Assert
        assertEquals(mineralEsperado, mineral);
        assertEquals(gasEsperado, gas);
    }
}
