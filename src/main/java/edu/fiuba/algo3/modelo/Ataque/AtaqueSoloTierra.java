package edu.fiuba.algo3.modelo.Ataque;

import edu.fiuba.algo3.modelo.HitPoints.HitPoints;
import edu.fiuba.algo3.modelo.NoPuedeAplicarDanioUnidadTipoAireError;

public class AtaqueSoloTierra extends Ataque{

    public AtaqueSoloTierra(int danioTierra) {
        super(danioTierra);
    }

    @Override
    public void aplicarDanioViento(HitPoints hp) {
        throw new NoPuedeAplicarDanioUnidadTipoAireError();
    }
}
