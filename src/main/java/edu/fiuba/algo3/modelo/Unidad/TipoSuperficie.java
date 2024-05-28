package edu.fiuba.algo3.modelo.Unidad;

import edu.fiuba.algo3.modelo.Ataque.Ataque;
import edu.fiuba.algo3.modelo.HitPoints.HitPoints;

public interface TipoSuperficie {
    void recibirAtaque(Ataque ataque, HitPoints hp);
    void volar();
}
