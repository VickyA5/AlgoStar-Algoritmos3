package edu.fiuba.algo3.modelo.Recurso;

import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.UnidadesRecurso.ExtraccionRecurso;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import edu.fiuba.algo3.modelo.UnidadesRecurso.UnidadesRecurso;

public  abstract class Recurso {
    protected ExtraccionRecurso extraccionRecurso;
    protected Edificio edificio;

    public Recurso(int unidades){
        this.extraccionRecurso = new ExtraccionRecurso(unidades);
    }

    public GestionRecurso extraer(int unidades){
        return extraccionRecurso.extraer(unidades);
    }


    public abstract void agregarEdificio(Edificio edificio);

    public void verificarRecursoOcupado(){
        if(this.edificio != null){
            throw new RecursoOcupadoError();
        }
    }


    public abstract boolean contieneNodoMineral();

    public int cantidadRecurso(){
        return extraccionRecurso.getCantidadRecurso();
    }
}
