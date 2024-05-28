package edu.fiuba.algo3.modelo.HitPoints;

import edu.fiuba.algo3.modelo.Unidad.UnidadMuertaError;

public class HPZerg implements HitPoints {

    private int vidaMax;
    private int vidaActual;

    public HPZerg(int Vida){
        vidaMax = Vida;
        vidaActual = Vida;
    }
    @Override
    public void recibirDaño(int daño) {
        vidaActual = vidaActual - daño;
        if(vidaActual <= 0){
            throw new UnidadMuertaError();
        }
    }

    @Override
    public void regenerar() {

        vidaActual = Math.min(vidaActual+ cura(),vidaMax );
    }

    @Override
    public int vida() {
        return vidaActual;
    }

    @Override
    public int escudo() {
        return 0;
    }

    @Override
    public boolean vidaDestruida() {
        return (vidaActual == 0);
    }

    private int cura(){
        return vidaMax/10;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof HPZerg)) return false;
        HPZerg hpZerg = (HPZerg) o;
        return hpZerg.vidaActual == vidaActual;
    }
}
