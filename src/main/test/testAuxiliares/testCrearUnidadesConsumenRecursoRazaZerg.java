package testAuxiliares;

import edu.fiuba.algo3.modelo.Edificio.Zerg.Criadero;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Espiral;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Guarida;
import edu.fiuba.algo3.modelo.Edificio.Zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import edu.fiuba.algo3.modelo.Unidad.*;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class testCrearUnidadesConsumenRecursoRazaZerg {
    public GestionRecurso mineral;
    public GestionRecurso gas;
    public Raza raza;
    public Larva larva;

    @BeforeEach
    void setup() {
        //Arrange
        mineral = new GestionRecurso(500);
        gas = new GestionRecurso(500);
        raza = new RazaZerg(mineral, gas);
        raza.aumentarCapacidad(100);
        larva = new Larva(); //ver de donde sacar la larva
    }

    @Test
    public void ConstruirZanganoConsume25MineralesYQueda475MineralesY500DeGas() {

        Criadero criadero = new Criadero();
        raza.aumentarMineral(new GestionRecurso(200)); //agregamos recursos para el edificio
        raza.agregarEdificio(criadero); // quedan 500 minerales
        GestionRecurso mineralEsperado = new GestionRecurso(475);
        GestionRecurso gasEsperado = new GestionRecurso(500);


        //Act
        criadero.evolucionarLarva();

        //Assert
        assertEquals(mineralEsperado, mineral);
        assertEquals(gasEsperado, gas);
    }

    @Test
    public void ConstruirZerlingConsume25MineralesYQueda475MineralesY500DeGas() {

        ReservaDeReproduccion edificio = new ReservaDeReproduccion();
        raza.aumentarMineral(new GestionRecurso(150)); //agregamos recursos para el edificio
        raza.agregarEdificio(edificio); // quedan 500 minerales
        GestionRecurso mineralEsperado = new GestionRecurso(475);
        GestionRecurso gasEsperado = new GestionRecurso(500);
        for (int i = 0; i<= 12 ; i++){  //dejamos operativo al edificio
            edificio.ejecutarTurno();
        }

        //Act
        edificio.crearZerling(larva);

        //Assert
        assertEquals(mineralEsperado, mineral);
        assertEquals(gasEsperado, gas);
    }

    @Test
    public void ConstruirHidraliscoConsume75MineralesY25GasYQueda425MineralesY475DeGas() {
        ReservaDeReproduccion edificioAux = new ReservaDeReproduccion();
        raza.aumentarMineral(new GestionRecurso(150)); //agregamos recursos para el edificioAux
        raza.agregarEdificio(edificioAux); // quedan 500 minerales

        Guarida edificio = new Guarida();
        raza.aumentarMineral(new GestionRecurso(200)); //agregamos recursos para el edificio
        raza.aumentarGas(new GestionRecurso(100)); //agregamos recursos para el edificio
        raza.agregarEdificio(edificio); // quedan 500 minerales
        GestionRecurso mineralEsperado = new GestionRecurso(425);
        GestionRecurso gasEsperado = new GestionRecurso(475);
        for (int i = 0; i<= 12 ; i++){  //dejamos operativo al edificio
            edificio.ejecutarTurno();
        }


        //Act
        edificio.evolucionarLarvaAHidra(larva);

        //Assert
        assertEquals(mineralEsperado, mineral);
        assertEquals(gasEsperado, gas);
    }

    @Test
    public void ConstruirMutaliscoConsume100MineralesY100GasYQueda400MineralesY400DeGas() {
        ReservaDeReproduccion edificioAux = new ReservaDeReproduccion();
        raza.aumentarMineral(new GestionRecurso(150)); //agregamos recursos para el edificioAux
        raza.agregarEdificio(edificioAux); // quedan 500 minerales

        Guarida edificioAux2 = new Guarida();
        raza.aumentarMineral(new GestionRecurso(200)); //agregamos recursos para el edificioAux2
        raza.aumentarGas(new GestionRecurso(100)); //agregamos recursos para el edificioAux2
        raza.agregarEdificio(edificioAux2); // quedan 500 minerales
        for (int i = 0; i<= 12 ; i++){  //dejamos operativo al edificio
            edificioAux2.ejecutarTurno();
        }

        Espiral edificio = new Espiral();
        raza.aumentarMineral(new GestionRecurso(150)); //agregamos recursos para el edificio
        raza.aumentarGas(new GestionRecurso(100)); //agregamos recursos para el edificio
        raza.agregarEdificio(edificio); // quedan 500 minerales
        GestionRecurso mineralEsperado = new GestionRecurso(400);
        GestionRecurso gasEsperado = new GestionRecurso(400);
        for (int i = 0; i<= 10 ; i++){  //dejamos operativo al edificio
            edificio.ejecutarTurno();
        }

        //Act
        edificio.crearMutalisco();

        //Assert
        assertEquals(mineralEsperado, mineral);
        assertEquals(gasEsperado, gas);
    }
}


