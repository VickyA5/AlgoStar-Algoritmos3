package edu.fiuba.algo3.modelo.Recurso;

import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Edificio.Protoss.Asimilador;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;

public class Volcan extends Recurso{

    public Volcan() {
        super(5000);
        edificio = null;
    }

    public void agregarEdificio(Edificio edificio) {
        verificarRecursoOcupado();
        this.edificio = edificio;
    }

    public GestionRecurso extraer(){
        if( edificio == null) return null;

        return ((Asimilador) edificio).extraer();
    }

    @Override
    public boolean contieneNodoMineral() {
        return false;
    }


}
