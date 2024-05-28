package edu.fiuba.algo3.modelo.HitPoints;

import edu.fiuba.algo3.modelo.Unidad.UnidadMuertaError;

public class HPProtoss implements HitPoints {

    private int vidaMax;
    private int escudoMax;
    private int vidaActual;
    private int escudoActual;

    public HPProtoss(int Vida,int Escudo){
        vidaMax = Vida;
        escudoMax = Escudo;
        vidaActual = Vida;
        escudoActual = Escudo;
    }
    @Override
    public void recibirDaño(int daño) {

        vidaActual = Math.min(vidaActual,escudoActual+vidaActual-daño);
        escudoActual = Math.max(escudoActual-daño,0);
        if(vidaActual <= 0){
            throw new UnidadMuertaError();
        }
    }

    @Override
    public void regenerar() {
        escudoActual = Math.min(escudoMax,escudoActual+cura());
    }

    @Override
    public int vida() {
        return vidaActual;
    }

    @Override
    public int escudo() {
        return escudoActual;
    }

    @Override
    public boolean vidaDestruida() {
        return (vidaActual == 0);
    }

    private int cura(){
        return escudoMax/4;
    }

    @Override
    public boolean equals(Object object){
        if (!(object instanceof HPProtoss)) return false;

        HPProtoss hpProtoss = (HPProtoss) object;
        return (vidaActual == hpProtoss.vidaActual) && (escudoActual == hpProtoss.escudoActual)  ; //preguntar a diego;
    }

}