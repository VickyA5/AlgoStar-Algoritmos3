package edu.fiuba.algo3.modelo.Unidad;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Ataque.Ataque;
import edu.fiuba.algo3.modelo.Ataque.AtaqueSoloTierra;
import edu.fiuba.algo3.modelo.Ataque.ZealotNoPuedeSerAtacadaError;
import edu.fiuba.algo3.modelo.HitPoints.HPProtoss;
import edu.fiuba.algo3.modelo.HitPoints.HitPoints;
import edu.fiuba.algo3.modelo.ID_UNIDAD;

public class Zealot extends Unidad {

    private boolean visibilidad;
    public Zealot(HitPoints hpZealot) {
        super(
                hpZealot,
                new TipoTierra(),
                new AtaqueSoloTierra(8),
                4,2,100,0
        );
        visibilidad = true;
        entidad = ID_UNIDAD.ZEALOT;
        rango = 1;
    }

    public Zealot() {
        super(
                new HPProtoss(100,60),
                new TipoTierra(),
                new AtaqueSoloTierra(8),
                4,2,100,0
        );
        visibilidad = true;
        entidad = ID_UNIDAD.ZEALOT;
        rango = 1;

    }

    @Override
    public void atacar(Atacable atacable){
        super.atacar(atacable);
        if(unidadesAsesinadas >= 3 ){
            visibilidad = false;
        }
    }

    public void actualizarVisibilidad(){
        if(ubicacion().estaBajoElRangoDeUnAmoSupremo()){
           visibilidad = true;
        }
    }
    @Override
    public void recibirAtaque(Ataque ataque){
        if(visibilidad){
            super.recibirAtaque(ataque);
        } else {
            throw new ZealotNoPuedeSerAtacadaError();
        }
    }

}
