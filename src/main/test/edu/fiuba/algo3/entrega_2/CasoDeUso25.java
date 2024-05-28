package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Juego.*;
import edu.fiuba.algo3.modelo.Raza.RazaProtoss;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso25 {
    @Test
    public void seCreaJugadorConNombreDeMenosDe6CaracteresDevuelveJugadorNombreError(){
        //Average
        String nombre = "Stev";

        //Act y Assert
        assertThrows(JugadorNombreError.class, () -> {
            new Jugador(nombre, "Verde", new RazaZerg());
        });
    }

    @Test
    public void seCreaJugadorConNombreDeDe6CaracteresExitosamente(){
        //Average
        String nombre = "Steven";

        //Act y Assert
        assertDoesNotThrow( () -> {
            new Jugador(nombre, "Verde", new RazaZerg());
        });
    }

    @Test
    public void seCreaJugadoreesConMismosNombreDevuelveJugadorMismoNombreError(){
        //Average
        String jugadorUnoNombre = "Steven";
        String jugadorUnoColor = "Verde";
        Jugador jugadorUno = new Jugador(jugadorUnoNombre,jugadorUnoColor, new RazaZerg());

        String jugadorDosColor = "Rojo";
        Jugador jugadorDos = new Jugador(jugadorUnoNombre,jugadorDosColor, new RazaProtoss());

        //Act y Assert
        assertThrows(JugadorMismoNombreError.class, () -> {
            jugadorDos.compatibleCon(jugadorUno);
        });
    }


    @Test
    public void jugadoresConLosMismosColoresDevuelveJugadorMismoColorError(){
        //Average
        String jugadorUnoNombre = "Steven";
        String jugadorUnoColor = "Verde";
        Jugador jugadorUno = new Jugador(jugadorUnoNombre,jugadorUnoColor, new RazaZerg());

        String jugadorDosNombre = "Kevin_s ";
        String jugadorDosColor = "Verde";
        Jugador jugadorDos = new Jugador(jugadorDosNombre,jugadorDosColor, new RazaProtoss());

        //Act y Assert
        assertThrows(JugadorMismoColorError.class, () -> {
            jugadorDos.compatibleCon(jugadorUno);
        });
    }

    @Test
    public void jugadoresConLasMismasRazasDevuelveJugadorMismaRazaError(){
        //Average
        String jugadorUnoNombre = "Steven";
        String jugadorUnoColor = "Verde";
        Jugador jugadorUno = new Jugador(jugadorUnoNombre,jugadorUnoColor, new RazaZerg());

        String jugadorDosNombre = "Kevin_s ";
        String jugadorDosColor = "Rojo";
        Jugador jugadorDos = new Jugador(jugadorDosNombre,jugadorDosColor, new RazaZerg());

        //Act y Assert
        assertThrows(JugadorMismaRazaError.class, () -> {
            jugadorDos.compatibleCon(jugadorUno);
        });
    }

    @Test
    public void seCreanJugadoresExitosamenteConDiferentesNombresColoresRazas(){
        //Average
        String jugadorUnoNombre = "Steven";
        String jugadorUnoColor = "Verde";
        Jugador jugadorUno = new Jugador(jugadorUnoNombre,jugadorUnoColor, new RazaZerg());

        String jugadorDosNombre = "Kevin_s ";
        String jugadorDosColor = "Rojo";
        Jugador jugadorDos = new Jugador(jugadorDosNombre,jugadorDosColor, new RazaProtoss());

        //Act y Assert
        assertDoesNotThrow( () -> {
            jugadorDos.compatibleCon(jugadorUno);
        });
    }

}
