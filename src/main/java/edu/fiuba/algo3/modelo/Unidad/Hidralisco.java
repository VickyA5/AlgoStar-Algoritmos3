package edu.fiuba.algo3.modelo.Unidad;

import edu.fiuba.algo3.modelo.Ataque.AtaqueTierraYViento;
import edu.fiuba.algo3.modelo.Edificio.Zerg.NoDeberiaEjecutarEsteMetodoError;
import edu.fiuba.algo3.modelo.HitPoints.HPZerg;
import edu.fiuba.algo3.modelo.HitPoints.HitPoints;
import edu.fiuba.algo3.modelo.ID_UNIDAD;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import edu.fiuba.algo3.modelo.Recurso.NodoMineral;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;

public class Hidralisco extends Unidad implements TipoEvolucionDeLarva {

    public Hidralisco() {
        super(
                new HPZerg(35),
                new TipoTierra(),
                new AtaqueTierraYViento(10,10),
                4,2,75,25);
        entidad = ID_UNIDAD.HIDRALISCO;
        rango = 4;
    }

    public Hidralisco(HitPoints vida) {
        super(vida, new TipoTierra(), new AtaqueTierraYViento(10,10), 4,2,75,25);
        entidad = ID_UNIDAD.HIDRALISCO;
        rango = 4;

    }

    @Override
    public GestionRecurso extraer(Recurso recurso) {
        throw new NoDeberiaEjecutarEsteMetodoError();
    }

    @Override
    public GestionRecurso extraerMineral(NodoMineral nodoMineral) {
        throw new NoDeberiaEjecutarEsteMetodoError();
    }

    @Override
    public void mutarCriadero(RazaZerg raza) {

    }

    @Override
    public void mutarEspiral(RazaZerg raza) {

    }

    @Override
    public void mutarExtractor(RazaZerg raza) {

    }

    @Override
    public boolean equals(Object object){
        if (!(object instanceof Hidralisco)) return false;
        Hidralisco hidralisco = (Hidralisco) object;

        return hidralisco.hp.equals(hp);
    }

    @Override
    public void evolucionarLarva() {

    }

    @Override
    public void crearMutalisco() {

    }

    @Override
    public void agregarZangano(Zangano zangano) {

    }

    @Override
    public void mutarGuarida(RazaZerg raza) {

    }

    @Override
    public void evolucionarLarvaAHidra(Larva larva) {
        throw new NoDeberiaEjecutarEsteMetodoError();
    }

    @Override
    public void evolucionarLarvaAZerli(Larva larva) {

    }

    @Override
    public void mutarReservaReproduccion(RazaZerg raza) {

    }


}