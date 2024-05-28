package edu.fiuba.algo3.modelo.Edificio.Zerg;

import edu.fiuba.algo3.modelo.ConstruccionFueraDelMohoError;
import edu.fiuba.algo3.modelo.Edificio.ConstruccionIncorrectaError;
import edu.fiuba.algo3.modelo.Edificio.CorrelativaDeConstruccionIncumplidaError;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.EstadoZangano.EstadoZangano;
import edu.fiuba.algo3.modelo.HitPoints.HPZerg;
import edu.fiuba.algo3.modelo.HitPoints.HitPoints;
import edu.fiuba.algo3.modelo.IDEDIFICIO;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import edu.fiuba.algo3.modelo.Unidad.*;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import edu.fiuba.algo3.modelo.tablero.Moho;
import edu.fiuba.algo3.modelo.tablero.Tierra;


public class Guarida extends Edificio implements EstadoZangano {
    private static final int CANTIDAD_TURNOS_OPERATIVO = 12;

    public Guarida(){
        super(CANTIDAD_TURNOS_OPERATIVO,new HPZerg(1250),200,100);
        entidad = IDEDIFICIO.GUARIDA;
    }
    public Guarida(HitPoints hp){
        super(hp);
        entidad = IDEDIFICIO.GUARIDA;

    }

    @Override
    public void construirEdificioEn(Recurso recurso) {
        throw new ConstruccionIncorrectaError();
    }

    @Override
    public void evolucionarLarvaAHidra(Larva unaLarva) {
        verififarEdificioOperativo();
        unaLarva.evolucionar(this);
        raza.agregarUnidad((Unidad) unaLarva.getTipoDeUnidadZerg());
    }

    @Override
    public void evolucionarLarvaAZerli(Larva larva) {
        throw new NoDeberiaEjecutarEsteMetodoError();
    }

    public void verificarSiPuedeSerConstruido(GestionRecurso unidadesDeMineral, GestionRecurso unidadesDeGas){
        verificarSiPuedeSerConstruidoSegunRecursos(unidadesDeMineral, unidadesDeGas);
    }

    @Override
    public void fueAgregado(Raza raza) {
        if( ! raza.existeReserva() ){
            throw new CorrelativaDeConstruccionIncumplidaError();
        }
        raza.fueAgregadaGuarida();
        this.raza = raza;
    }

    @Override
    public void instalar(Tierra tierra) {
        throw new ConstruccionFueraDelMohoError();
    }

    @Override
    public void instalar(Moho moho) {
        return;
    }


    @Override
    public void evolucionarLarva() {
        throw new NoDeberiaEjecutarEsteMetodoError();
    }

    @Override
    public void agregarseAEstaRaza(RazaZerg razaZerg) {
        razaZerg.agregarEdificio(this);
    }

    @Override
    public void crearMutalisco() {
        throw new NoDeberiaEjecutarEsteMetodoError();
    }

    @Override
    public void agregarZangano(Unidad zangano) {
        throw new NoDeberiaEjecutarEsteMetodoError();
    }

    @Override
    public GestionRecurso extraer(Recurso recurso) {
        throw new NoDeberiaEjecutarEsteMetodoError();
    }

}
