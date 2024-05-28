package edu.fiuba.algo3.modelo.Unidad;

import edu.fiuba.algo3.modelo.Ataque.AtaqueTierraYViento;
import edu.fiuba.algo3.modelo.HitPoints.HPProtoss;
import edu.fiuba.algo3.modelo.HitPoints.HitPoints;
import edu.fiuba.algo3.modelo.ID_UNIDAD;
import edu.fiuba.algo3.modelo.Unidad.TipoAire;
import edu.fiuba.algo3.modelo.Unidad.Unidad;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;

public class Scout extends Unidad {


    public Scout(){
        super(
                new HPProtoss(150,100),
                new TipoAire(),
                new AtaqueTierraYViento(8,14),
                9,4,300,150);
        entidad = ID_UNIDAD.SCOUT;
        rango = 4;
    }

    public Scout(HitPoints hp){
        super(hp, new TipoAire(), new AtaqueTierraYViento(8,14), 9,4,300,150);
        entidad = ID_UNIDAD.SCOUT;
        rango = 4;

    }
}
