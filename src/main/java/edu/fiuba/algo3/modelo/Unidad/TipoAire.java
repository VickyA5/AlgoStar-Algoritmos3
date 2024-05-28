package edu.fiuba.algo3.modelo.Unidad;

import edu.fiuba.algo3.modelo.Ataque.Ataque;
import edu.fiuba.algo3.modelo.HitPoints.HitPoints;

public class TipoAire implements TipoSuperficie {
    @Override
    public void recibirAtaque(Ataque ataque, HitPoints hp) {
        ataque.aplicarDanioViento(hp);
    }
    public void volar(){}
}
