package edu.fiuba.algo3.modelo.Unidad;

import edu.fiuba.algo3.modelo.Ataque.AtaqueSoloTierra;
import edu.fiuba.algo3.modelo.Ataque.AtaqueTierraYViento;
import edu.fiuba.algo3.modelo.HitPoints.HPZerg;
import edu.fiuba.algo3.modelo.HitPoints.HitPoints;
import edu.fiuba.algo3.modelo.ID_UNIDAD;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;

public class Devorador extends Unidad implements TipoEvolucionDeMutalisco{


    public Devorador(){

        super(
                new HPZerg(200),
                new TipoAire(),
                new AtaqueTierraYViento(0,25),
                4,0,150,50);
        entidad = ID_UNIDAD.DEVORADOR;
        rango = 5;
    }

}