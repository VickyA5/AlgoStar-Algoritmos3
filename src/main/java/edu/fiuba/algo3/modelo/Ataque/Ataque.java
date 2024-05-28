package edu.fiuba.algo3.modelo.Ataque;

import edu.fiuba.algo3.modelo.HitPoints.HitPoints;

public abstract class Ataque {
    private int danioTierra;

    public Ataque(int danioTierra){
        this.danioTierra = danioTierra;
    }

    public void aplicarDanioTierra(HitPoints hp){
        hp.recibirDaño(danioTierra);
    }

    public abstract void aplicarDanioViento(HitPoints hp);
}
