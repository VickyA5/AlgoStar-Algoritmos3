package edu.fiuba.algo3.modelo.Unidad;

import edu.fiuba.algo3.modelo.Ataque.AtaqueSoloTierra;
import edu.fiuba.algo3.modelo.Edificio.Zerg.NoDeberiaEjecutarEsteMetodoError;
import edu.fiuba.algo3.modelo.HitPoints.HPZerg;
import edu.fiuba.algo3.modelo.HitPoints.HitPoints;
import edu.fiuba.algo3.modelo.ID_UNIDAD;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import edu.fiuba.algo3.modelo.Recurso.NodoMineral;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;

public class Zerling extends Unidad implements TipoEvolucionDeLarva {

    public Zerling(){
        super(
                new HPZerg(35),
                new TipoTierra(),
                new AtaqueSoloTierra(4),
                2,1,25,0
        );
        entidad = ID_UNIDAD.ZERLING;
        rango = 1;
    }

    public Zerling(HitPoints vida){
        super(
                vida,
                new TipoTierra(),
                new AtaqueSoloTierra(4),
                2,1,25,0
        );
        entidad = ID_UNIDAD.ZERLING;
        rango = 1;
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
        if (!(object instanceof Zerling)) return false;
        Zerling zerling = (Zerling) object;

        return zerling.hp.equals(hp) ;
    }

    @Override
    public void evolucionarLarva() {

    }

    @Override
    public void crearMutalisco() {
        throw new NoDeberiaEjecutarEsteMetodoError();
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
        throw new NoDeberiaEjecutarEsteMetodoError();
    }

    @Override
    public void mutarReservaReproduccion(RazaZerg raza) {

    }

}
