package edu.fiuba.algo3.modelo.Unidad;

import edu.fiuba.algo3.modelo.Ataque.AtaqueSoloTierra;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Edificio.Zerg.*;
import edu.fiuba.algo3.modelo.EstadoZangano.EstadoZangano;
import edu.fiuba.algo3.modelo.HitPoints.HPZerg;
import edu.fiuba.algo3.modelo.HitPoints.HitPoints;
import edu.fiuba.algo3.modelo.ID_UNIDAD;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import edu.fiuba.algo3.modelo.Recurso.NodoMineral;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;

public class Zangano extends Unidad implements TipoEvolucionDeLarva {
    private EstadoZangano estadoZangano;
    public Zangano(){
        super(
                new HPZerg(25),
                new TipoTierra(),
                new AtaqueSoloTierra(0),
                1,1,25,0
        );
        estadoZangano = null;
        entidad = ID_UNIDAD.ZANGANO;
        rango = 0;
    }

    public Zangano(HitPoints vida){
        super(vida,1);
        entidad = ID_UNIDAD.ZANGANO;
    }

    public GestionRecurso extraer(Recurso recurso){
        if(estadoZangano == null){
            return recurso.extraer(10);
        }
        return estadoZangano.extraer(recurso);
    }

    public GestionRecurso extraerMineral(NodoMineral nodoMineral){
        return  nodoMineral.extraerConZangano(10, this);
    }

    private void verificarEstadoLibreZangano(){
        if( estadoZangano != null ){
            throw new ZanganoYaEsUnaEdificacionError();   //luego al criadero ponerle 4 crias.
        }
    }

    public void mutarCriadero(RazaZerg raza) {
        verificarEstadoLibreZangano();
        estadoZangano = new Criadero(4);  //creo un criadero con 0 turnos para ser operativos. ojo.
        raza.agregarEsteEdificio(estadoZangano);
    }

    public void mutarEspiral(RazaZerg raza) {
        verificarEstadoLibreZangano();
        estadoZangano = new Espiral();
        raza.agregarEsteEdificio(estadoZangano);
    }

    public void mutarExtractor(RazaZerg raza) {
        verificarEstadoLibreZangano();
        estadoZangano = new Extractor();
        raza.agregarEsteEdificio(estadoZangano);
    }

    public void estadoZangano() {
        estadoZangano = null;
        //ver si tengo que sacar al ultimo edificio de la raza
    }

    //--------Wrappers de criadero.
    @Override
    public boolean equals(Object object){
        if (!(object instanceof Zangano)) return false;
        Zangano zangano = (Zangano) object;

        return zangano.estadoZangano == this.estadoZangano ;
    }

    //wrapper de criadero.
    public void evolucionarLarva() {
        estadoZangano.evolucionarLarva();
    }

    //wrapper de espiral:
    public void crearMutalisco() {
        estadoZangano.crearMutalisco();
    }

    @Override
    public void ejecutarTurno(){
        if(estadoZangano == null){
            if(turnosRestantesParaSerOperativo > 0 ) turnosRestantesParaSerOperativo--;
        }
    }

    // wrapper del extractor.
    public void agregarZangano(Zangano zangano) {
        estadoZangano.agregarZangano(zangano);
    }

    public void mutarGuarida(RazaZerg raza) {
        verificarEstadoLibreZangano();
        estadoZangano = new Guarida();
        raza.agregarEsteEdificio(estadoZangano);
    }

    public void evolucionarLarvaAHidra(Larva larva) {
        estadoZangano.evolucionarLarvaAHidra(larva);
    }

    public void evolucionarLarvaAZerli(Larva larva) {
        estadoZangano.evolucionarLarvaAZerli(larva);
    }


    public void mutarReservaReproduccion(RazaZerg raza) {
        verificarEstadoLibreZangano();
        estadoZangano = new ReservaDeReproduccion();
        raza.agregarEsteEdificio(estadoZangano);
    }

    public Edificio getEstadoZangano(){
        Edificio edificio = null;
        if(estadoZangano != null){
            edificio = (Edificio) estadoZangano;
        }
        return edificio;
    }

}
