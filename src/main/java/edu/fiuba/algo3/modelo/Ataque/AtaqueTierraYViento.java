package edu.fiuba.algo3.modelo.Ataque;

import edu.fiuba.algo3.modelo.HitPoints.HitPoints;

public class AtaqueTierraYViento extends Ataque{
    private int danioViento;

    public AtaqueTierraYViento(int danioTierra, int danioViento) {
        super(danioTierra);
        this.danioViento = danioViento;
    }

    @Override
    public void aplicarDanioViento(HitPoints hp) {
        hp.recibirDaño(danioViento);
    }
}
