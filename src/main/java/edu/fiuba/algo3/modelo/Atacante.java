package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.tablero.Ubicacion;

public interface Atacante {
    void atacar(Atacable atacable);
    Ubicacion ubicacion();
}
