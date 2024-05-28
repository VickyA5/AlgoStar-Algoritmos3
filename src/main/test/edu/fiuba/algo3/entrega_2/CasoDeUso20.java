package edu.fiuba.algo3.entrega_2;
import edu.fiuba.algo3.modelo.Unidad.Scout;
import edu.fiuba.algo3.modelo.Unidad.*;
import edu.fiuba.algo3.modelo.tablero.Coordenada;
import edu.fiuba.algo3.modelo.tablero.Especial;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso20 {

    @Test
    public void UnScoutPuedeUbicarseEnUnaUbicacionEspecial(){
        Ubicacion ubicacion = new Ubicacion(new Coordenada(5,5));
        ubicacion.darTipo(new Especial());
        Unidad unidad = new Scout();

        //Dejo operativa a la unidad:
        for (int i = 0; i < 9; i++){
            unidad.ejecutarTurno();
        }

        assertDoesNotThrow(  ()-> {
            ubicacion.asignarUnidad(unidad);
        });
    }
    @Test
    public void UnGuardianPuedeUbicarseEnUnaUbicacionEspecial(){
        Ubicacion ubicacion = new Ubicacion(new Coordenada(5,5));
        ubicacion.darTipo(new Especial());
        Unidad unidad = new Guardian();

        //Dejo operativa a la unidad:
        for (int i = 0; i < 4; i++){
            unidad.ejecutarTurno();
        }

        assertDoesNotThrow(  ()-> {
            ubicacion.asignarUnidad(unidad);
        });
    }
    @Test
    public void UnMutaliscoPuedeUbicarseEnUnaUbicacionEspecial(){
        Ubicacion ubicacion = new Ubicacion(new Coordenada(5,5));
        ubicacion.darTipo(new Especial());
        Unidad unidad = new Mutalisco();

        //Dejo operativa a la unidad:
        for (int i = 0; i < 7; i++){
            unidad.ejecutarTurno();
        }

        assertDoesNotThrow(  ()-> {
            ubicacion.asignarUnidad(unidad);
        });
    }

    @Test
    public void UnDragonNoPuedeUbicarseEnUnaUbicacionEspecial(){
        Ubicacion ubicacion = new Ubicacion(new Coordenada(5,5));
        ubicacion.darTipo(new Especial());
        Unidad unidad = new Dragon();

        //Dejo operativa a la unidad:
        for (int i = 0; i < 6; i++){
            unidad.ejecutarTurno();
        }

        assertThrows( UnidadNoVuelaError.class, ()-> {
            ubicacion.asignarUnidad(unidad);
        });
    }
    @Test
    public void UnZealotNoPuedeUbicarseEnUnaUbicacionEspecial(){
        Ubicacion ubicacion = new Ubicacion(new Coordenada(5,5));
        ubicacion.darTipo(new Especial());
        Unidad unidad = new Zealot();

        //Dejo operativa a la unidad:
        for (int i = 0; i < 4; i++){
            unidad.ejecutarTurno();
        }

        assertThrows( UnidadNoVuelaError.class, ()-> {
            ubicacion.asignarUnidad(unidad);
        });
    }
    @Test
    public void UnHidraliscoNoPuedeUbicarseEnUnaUbicacionEspecial(){
        Ubicacion ubicacion = new Ubicacion(new Coordenada(5,5));
        ubicacion.darTipo(new Especial());
        Unidad unidad = new Hidralisco();

        //Dejo operativa a la unidad:
        for (int i = 0; i < 4; i++){
            unidad.ejecutarTurno();
        }

        assertThrows( UnidadNoVuelaError.class, ()-> {
            ubicacion.asignarUnidad(unidad);
        });
    }
    @Test
    public void UnZerlingNoPuedeUbicarseEnUnaUbicacionEspecial(){
        Ubicacion ubicacion = new Ubicacion(new Coordenada(5,5));
        ubicacion.darTipo(new Especial());
        Unidad unidad = new Zerling();

        //Dejo operativa a la unidad:
        for (int i = 0; i < 2; i++){
            unidad.ejecutarTurno();
        }

        assertThrows( UnidadNoVuelaError.class, ()-> {
            ubicacion.asignarUnidad(unidad);
        });
    }

    @Test
    public void UnZanganoNoPuedeUbicarseEnUnaUbicacionEspecial(){
        Ubicacion ubicacion = new Ubicacion(new Coordenada(5,5));
        ubicacion.darTipo(new Especial());
        Unidad unidad = new Zangano();

        //Dejo operativa a la unidad:
        for (int i = 0; i < 1; i++){
            unidad.ejecutarTurno();
        }

        assertThrows( UnidadNoVuelaError.class, ()-> {
            ubicacion.asignarUnidad(unidad);
        });
    }

}
