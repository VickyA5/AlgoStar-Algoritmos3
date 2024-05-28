package edu.fiuba.algo3.modelo.Edificio.Zerg;

import edu.fiuba.algo3.modelo.ConstruccionFueraDelMohoError;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Edificio.ExtractorCantidadMaximaDeZanganosError;
import edu.fiuba.algo3.modelo.EstadoZangano.EstadoZangano;
import edu.fiuba.algo3.modelo.HitPoints.HPZerg;
import edu.fiuba.algo3.modelo.IDEDIFICIO;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Unidad.*;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import edu.fiuba.algo3.modelo.tablero.Moho;
import edu.fiuba.algo3.modelo.tablero.Tierra;

import java.util.ArrayList;

public class Extractor extends Edificio implements EstadoZangano {
    private static final int CANTIDAD_TURNOS_OPERATIVO = 6;
    private ArrayList<Unidad> zanganos;


    public Extractor(){
        super(CANTIDAD_TURNOS_OPERATIVO,new HPZerg(750),100,0);
        zanganos = new ArrayList<Unidad>();
        entidad = IDEDIFICIO.EXTRACTOR;

    }

    public void agregarZangano(Unidad zangano){
        if(!puedeAgregarZangano() ){
            throw new ExtractorCantidadMaximaDeZanganosError();
        }
        verififarEdificioOperativo();
        zanganos.add(zangano);
    }
    public boolean puedeAgregarZangano(){
        return cantidadZanganosTrabajando() < 3;
    }


    public GestionRecurso extraer(Recurso recurso){
        verififarEdificioOperativo();
        GestionRecurso gasAcumulado = new GestionRecurso();
        for(Unidad zangano: zanganos){
            gasAcumulado.aumentar( zangano.extraer(recurso) );
        }
        return gasAcumulado;
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
    public void construirEdificioEn(Recurso recurso) {
        recurso.agregarEdificio(this);
    }


    public void verificarSiPuedeSerConstruido(GestionRecurso unidadesDeMineral,GestionRecurso unidadesDeGas){
        verificarSiPuedeSerConstruidoSegunRecursos(unidadesDeMineral, unidadesDeGas);
    }


    @Override
    public void fueAgregado(Raza raza) {
        this.raza = raza;
        return;
    }

    @Override
    public void instalar(Tierra tierra) {
        throw  new ConstruccionFueraDelMohoError();
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

    public int cantidadZanganosTrabajando(){
        return  zanganos.size();
    }


}
