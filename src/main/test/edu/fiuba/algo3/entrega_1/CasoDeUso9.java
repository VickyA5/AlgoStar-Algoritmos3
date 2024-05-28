package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.ConstruccionFueraDelRangoPilonError;
import edu.fiuba.algo3.modelo.Edificio.Protoss.Acceso;
import edu.fiuba.algo3.modelo.Edificio.Protoss.Pilon;
import edu.fiuba.algo3.modelo.Edificio.Protoss.PuertoEstelar;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.tablero.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso9 {

    @Test
    public void unEdificioProtossEnRangoDe2PilonesDebeSeguirEnergizadoSiSeDestruyeUno(){
        //arrange
        Mapa mapa = new Mapa(20,20);
        Ubicacion ubicacionPilon1 =  mapa.buscar(new Coordenada(9,9));
        Pilon pilon1 = new Pilon();
        ubicacionPilon1.ubicar(pilon1, mapa);
        Ubicacion ubicacionPilon2 =  mapa.buscar(new Coordenada(10, 10));
        Pilon pilon2 = new Pilon();
        ubicacionPilon2.ubicar(pilon2, mapa);
        Ubicacion ubicacionPuerto = mapa.buscar(new Coordenada(11, 11));
        PuertoEstelar puerto = new PuertoEstelar();
        ubicacionPuerto.ubicar(puerto);

        //act
        ubicacionPilon1.desalojarPilon(mapa);

        //assert
        assertDoesNotThrow( ()-> {
            puerto.verificarEnergia();
        });
    }

    @Test
    public void unEdificioProtossEnRangoDe1PilonNoDeberiaEstarEnergizadoSiSeDestruyeElPilon(){
        //arrange
        Mapa mapa = new Mapa(20,20);
        Ubicacion ubicacionPilon1 =  mapa.buscar(new Coordenada(9,9));
        Pilon pilon1 = new Pilon();
        ubicacionPilon1.ubicar(pilon1, mapa);
        Ubicacion ubicacionPuerto = mapa.buscar(new Coordenada(10, 10));
        PuertoEstelar puerto = new PuertoEstelar();
        ubicacionPuerto.ubicar(puerto);

        //act
        ubicacionPilon1.desalojarPilon(mapa);

        //assert
        assertThrows(ConstruccionFueraDelRangoPilonError.class, () -> {
            puerto.verificarEnergia();
        });
    }

}
