package edu.fiuba.algo3.modelo.Unidad;

import edu.fiuba.algo3.modelo.Ataque.AtaqueTierraYViento;
import edu.fiuba.algo3.modelo.HitPoints.HPProtoss;
import edu.fiuba.algo3.modelo.ID_UNIDAD;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;

public class Dragon extends Unidad {

    public Dragon() {

        super(
                new HPProtoss(100,80),
                new TipoTierra(),
                new AtaqueTierraYViento(20,20),
                6,3,125,50);
        entidad = ID_UNIDAD.DRAGON;
        rango = 4;
    }

}
