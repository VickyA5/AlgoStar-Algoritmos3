package edu.fiuba.algo3.entrega_2;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.tablero.Coordenada;
import edu.fiuba.algo3.modelo.tablero.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class CasoDeUso24 {

    @Test
    public void LasBasesDe2JugadoresSeInicianEnExtremos() {
        Mapa mapa =new Mapa(20,20);
        JuegoModelo elJuegoModelo = new JuegoModelo(mapa,new Coordenada(0,0));

        int distanciaEsperada = mapa.distanciaMaxima();

        assertEquals(distanciaEsperada, elJuegoModelo.distanciaEntreBases());
    }
    @Test
    public void BasesEnPuntosNoExtremosOpuestosTiranError(){
        Mapa mapa =new Mapa(20,20);

        assertThrows(CoordenadaNoEsExtremoDelMapaError.class, () -> {
            new JuegoModelo(mapa,new Coordenada(1,1));
        });
    }
}
