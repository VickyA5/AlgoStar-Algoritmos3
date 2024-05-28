package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Unidad.*;
import edu.fiuba.algo3.modelo.tablero.Coordenada;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso23 {

    @Test
    public void unZerlingNoPuedeAtacarAlgoAUnRangoMayorA1(){
        Unidad atacante = new Zerling();
        Unidad objetivo = new Zealot();
        Ubicacion ubicacion1 = new Ubicacion(new Coordenada(2,2));
        Ubicacion ubicacion2 = new Ubicacion(new Coordenada(3,3));
        ubicacion1.asignarUnidad(atacante);
        ubicacion2.asignarUnidad(objetivo);
        atacante.asignarRango(1);

        assertThrows( EnemigoFueraDeRangoError.class, ()-> {
            atacante.atacarSobreUbicacion(objetivo);
        });
    }
    @Test
    public void unHidraliscoNoPuedeAtacarAlgoAUnRangoMayorA4(){
        Unidad atacante = new Hidralisco();
        Unidad objetivo = new Zealot();
        Ubicacion ubicacion1 = new Ubicacion(new Coordenada(2,2));
        Ubicacion ubicacion2 = new Ubicacion(new Coordenada(4,5));
        ubicacion1.asignarUnidad(atacante);
        ubicacion2.asignarUnidad(objetivo);
        atacante.asignarRango(4);

        assertThrows( EnemigoFueraDeRangoError.class, ()-> {
            atacante.atacarSobreUbicacion(objetivo);
        });
    }
    @Test
    public void unMutaliscoNoPuedeAtacarAlgoAUnRangoMayorA3(){
        Unidad atacante = new Mutalisco();
        Unidad objetivo = new Zealot();
        Ubicacion ubicacion1 = new Ubicacion(new Coordenada(2,2));
        Ubicacion ubicacion2 = new Ubicacion(new Coordenada(4,4));
        ubicacion1.asignarUnidad(atacante);
        ubicacion2.asignarUnidad(objetivo);
        atacante.asignarRango(3);

        assertThrows( EnemigoFueraDeRangoError.class, ()-> {
            atacante.atacarSobreUbicacion(objetivo);
        });
    }
    @Test
    public void unGuardianNoPuedeAtacarAlgoAUnRangoMayorA10(){
        Unidad atacante = new Guardian();
        Unidad objetivo = new Zealot();
        Ubicacion ubicacion1 = new Ubicacion(new Coordenada(2,2));
        Ubicacion ubicacion2 = new Ubicacion(new Coordenada(7,8));
        ubicacion1.asignarUnidad(atacante);
        ubicacion2.asignarUnidad(objetivo);
        atacante.asignarRango(10);

        assertThrows( EnemigoFueraDeRangoError.class, ()-> {
            atacante.atacarSobreUbicacion(objetivo);
        });
    }
    @Test
    public void unZealotNoPuedeAtacarAlgoAUnRangoMayorA1(){
        Unidad atacante = new Zealot();
        Unidad objetivo = new Zerling();
        Ubicacion ubicacion1 = new Ubicacion(new Coordenada(2,2));
        Ubicacion ubicacion2 = new Ubicacion(new Coordenada(3,3));
        ubicacion1.asignarUnidad(atacante);
        ubicacion2.asignarUnidad(objetivo);
        atacante.asignarRango(1);

        assertThrows( EnemigoFueraDeRangoError.class, ()-> {
            atacante.atacarSobreUbicacion(objetivo);
        });
    }
    @Test
    public void unDragonNoPuedeAtacarAlgoAUnRangoMayorA4(){
        Unidad atacante = new Dragon();
        Unidad objetivo = new Zerling();
        Ubicacion ubicacion1 = new Ubicacion(new Coordenada(2,2));
        Ubicacion ubicacion2 = new Ubicacion(new Coordenada(4,5));
        ubicacion1.asignarUnidad(atacante);
        ubicacion2.asignarUnidad(objetivo);
        atacante.asignarRango(4);

        assertThrows( EnemigoFueraDeRangoError.class, ()-> {
            atacante.atacarSobreUbicacion(objetivo);
        });
    }
    @Test
    public void unScoutNoPuedeAtacarAlgoAUnRangoMayorA4(){
        Unidad atacante = new Scout();
        Unidad objetivo = new Zerling();
        Ubicacion ubicacion1 = new Ubicacion(new Coordenada(2,2));
        Ubicacion ubicacion2 = new Ubicacion(new Coordenada(4,5));
        ubicacion1.asignarUnidad(atacante);
        ubicacion2.asignarUnidad(objetivo);
        atacante.asignarRango(4);

        assertThrows( EnemigoFueraDeRangoError.class, ()-> {
            atacante.atacarSobreUbicacion(objetivo);
        });
    }
}
