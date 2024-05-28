package edu.fiuba.algo3.modelo.Unidad;

import edu.fiuba.algo3.modelo.Ataque.AtaqueTierraYViento;
import edu.fiuba.algo3.modelo.HitPoints.HPZerg;
import edu.fiuba.algo3.modelo.HitPoints.HitPoints;
import edu.fiuba.algo3.modelo.ID_UNIDAD;
import edu.fiuba.algo3.modelo.Raza.*;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import edu.fiuba.algo3.modelo.tablero.Coordenada;
import edu.fiuba.algo3.modelo.tablero.Mapa;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;

import java.util.ArrayList;

public class AmoSupremo extends Unidad {
    public AmoSupremo() {
        super(
                new HPZerg(200),
                new TipoAire(),
                new AtaqueTierraYViento(0,0)
                , 5,0,50,0 );
        entidad = ID_UNIDAD.AMOSUPREMO;
        rango = 0;
    }

    public void aumentarPoblacion(Raza raza){
        raza.aumentarCapacidad(5);
    }
    public void disminuirCapacidad(Raza raza){
        raza.disminuirCapacidad(5);
    }


    public void asignarLugarAmoSupremo(Ubicacion unLugar, Mapa unMapa){
        super.asignarLugar(unLugar);
        ArrayList<Ubicacion> ubicaciones = unMapa.buscar(unLugar.coordenada(),4);
        for(int i=0;i<ubicaciones.size();i++){
            ubicaciones.get(i).establecerEnRangoAmoSupremo();
        }
    }
}
