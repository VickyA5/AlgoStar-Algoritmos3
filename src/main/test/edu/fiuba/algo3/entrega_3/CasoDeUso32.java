package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Edificio.Protoss.Pilon;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Criadero;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.Raza.*;
import edu.fiuba.algo3.modelo.Unidad.Dragon;
import edu.fiuba.algo3.modelo.Unidad.Hidralisco;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import edu.fiuba.algo3.modelo.tablero.Coordenada;
import edu.fiuba.algo3.modelo.tablero.Mapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso32 {

    @Test
    public void testElJugadorDeProtossLeDestruyeTodosLosEdificioAlJugadorDeZerg(){
        RazaZerg razaZerg = new RazaZerg();
        Criadero unCriadero = new Criadero();
        razaZerg.aumentarGas(new GestionRecurso(3000));
        razaZerg.aumentarMineral(new GestionRecurso(5000));
        razaZerg.agregarEdificio(unCriadero);

        RazaProtoss razaProtoss = new RazaProtoss();
        razaProtoss.aumentarGas(new GestionRecurso(3000));
        razaProtoss.aumentarMineral(new GestionRecurso(5000));
        razaProtoss.agregarEdificio(new Pilon());
        razaProtoss.agregarEdificio(new Pilon());
        Dragon unDragon = new Dragon();
        razaProtoss.agregarUnidad(unDragon);

        JuegoModelo unJuegoModelo = new JuegoModelo(new Mapa(100,100), new Coordenada(100,100));

        for(int i = 0; i < 6 ; i++){               //dragon se construye en 6 turnos lo dejamos operativo;
            unDragon.ejecutarTurno();
        }

        for(int i = 0; i < 25 ; i++){
            unDragon.atacar(unCriadero);
        }

        assertThrows( FinDelJuegoGanaronLosProtoss.class, ()-> {
            unJuegoModelo.esElfinDeJuego(razaZerg, razaProtoss);
        });

    }

    @Test
    public void testElJugadorDeZergLeDestruyeTodosLosEdificioAlJugadorDeProtoss(){
        RazaZerg razaZerg = new RazaZerg();
        razaZerg.aumentarGas(new GestionRecurso(3000));
        razaZerg.aumentarMineral(new GestionRecurso(5000));
        Criadero unCriadero = new Criadero();
        razaZerg.agregarEdificio(unCriadero);
        Hidralisco hidralisco = new Hidralisco();
        razaZerg.agregarUnidad(hidralisco);


        RazaProtoss razaProtoss = new RazaProtoss();
        Pilon unPilon = new Pilon();
        razaProtoss.aumentarGas(new GestionRecurso(3000));
        razaProtoss.aumentarMineral(new GestionRecurso(5000));
        razaProtoss.agregarEdificio(unPilon);

        JuegoModelo unJuegoModelo = new JuegoModelo(new Mapa(100,100), new Coordenada(100,100));

        for(int i = 0; i < 4 ; i++){               //hidralisco se construye en 4 turnos lo dejamos operativo;
            hidralisco.ejecutarTurno();
        }

        for(int i = 0; i < 60 ; i++){
            hidralisco.atacar(unPilon);
        }

        assertThrows( FinDelJuegoGanaronLosZerg.class, ()-> {
            unJuegoModelo.esElfinDeJuego(razaZerg, razaProtoss);
        });
    }

    @Test
    public void testElJugadorDeProtossConUnEdificioYJugadorZergConDosNoDeberiaSerElFinDelJuego(){
        RazaZerg razaZerg = new RazaZerg();
        razaZerg.aumentarGas(new GestionRecurso(3000));
        razaZerg.aumentarMineral(new GestionRecurso(5000));
        Criadero unCriadero = new Criadero();
        razaZerg.agregarEdificio(unCriadero);
        razaZerg.agregarEdificio(new Criadero() );

        RazaProtoss razaProtoss = new RazaProtoss();
        razaProtoss.aumentarGas(new GestionRecurso(3000));
        razaProtoss.aumentarMineral(new GestionRecurso(5000));
        razaProtoss.agregarEdificio(new Pilon());
        Dragon unDragon = new Dragon();
        razaProtoss.agregarUnidad(unDragon);
        JuegoModelo unJuegoModelo = new JuegoModelo(new Mapa(100,100), new Coordenada(100,100));
        for(int i = 0; i < 6 ; i++){               //dragon se construye en 6 turnos lo dejamos operativo;
            unDragon.ejecutarTurno();
        }

        for(int i = 0; i < 10 ; i++){
            unDragon.atacar(unCriadero);
        }

        assertDoesNotThrow(() -> {
            unJuegoModelo.esElfinDeJuego(razaZerg, razaProtoss);
        });

    }

    @Test
    public void testElJugadorDeZergConUnEdificioYJugadorProtossConUnoNoDeberiaSerElFinDelJuego(){
        RazaZerg razaZerg = new RazaZerg();
        razaZerg.aumentarGas(new GestionRecurso(3000));
        razaZerg.aumentarMineral(new GestionRecurso(4000));
        Criadero unCriadero = new Criadero();
        razaZerg.agregarEdificio(unCriadero);
        Hidralisco hidralisco = new Hidralisco();
        razaZerg.agregarUnidad(hidralisco);

        RazaProtoss razaProtoss = new RazaProtoss();
        Pilon pilon = new Pilon();
        razaProtoss.agregarEdificio(pilon);

        JuegoModelo unJuegoModelo = new JuegoModelo(new Mapa(100,100), new Coordenada(100,100));
        for(int i = 0; i < 4 ; i++){               //hidralisco se construye en 4 turnos lo dejamos operativo;
            hidralisco.ejecutarTurno();
        }

        for(int i = 0; i < 10 ; i++){
            hidralisco.atacar(pilon);
        }

        assertDoesNotThrow(() -> {
            unJuegoModelo.esElfinDeJuego(razaZerg, razaProtoss);
        });

    }

}