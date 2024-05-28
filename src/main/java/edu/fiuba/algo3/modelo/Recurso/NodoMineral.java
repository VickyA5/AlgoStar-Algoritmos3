package edu.fiuba.algo3.modelo.Recurso;

import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Edificio.Protoss.NexoMineral;
import edu.fiuba.algo3.modelo.Unidad.Zangano;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import edu.fiuba.algo3.modelo.UnidadesRecurso.UnidadesRecurso;

public class NodoMineral extends Recurso{

    private Zangano zangano;
    public NodoMineral(){
        super(2000);
    }

    @Override
    public void agregarEdificio(Edificio edificio) {
        verificarRecursoOcupado();
        verificarRecursoOcupadoPorZangano();
        this.edificio = edificio;
    }

    @Override
    public boolean contieneNodoMineral() {
        return true;
    }

    public GestionRecurso extraerConZangano(int unidades , Zangano zangano){
        verificarRecursoOcupado();
        this.zangano = zangano;
        return extraer(unidades);
    }

    public void agregarZangano(Zangano zangano) {
        verificarRecursoOcupado();
        this.zangano = zangano;
    }

    public void verificarRecursoOcupadoPorZangano(){
        if(zangano != null){
            throw new RecursoOcupadoError();
        }
    }

    public void ocuparConEdificio(NexoMineral nexoMineral) {
        verificarRecursoOcupado();
        verificarRecursoOcupadoPorZangano();
        edificio = nexoMineral;
    }
}
