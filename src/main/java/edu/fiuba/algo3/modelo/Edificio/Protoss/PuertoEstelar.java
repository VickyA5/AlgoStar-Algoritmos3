package edu.fiuba.algo3.modelo.Edificio.Protoss;

import edu.fiuba.algo3.modelo.ConstruccionFueraDelRangoPilonError;
import edu.fiuba.algo3.modelo.ConstruccionProtoEnMohoError;
import edu.fiuba.algo3.modelo.Edificio.ConstruccionIncorrectaError;
import edu.fiuba.algo3.modelo.Edificio.CorrelativaDeConstruccionIncumplidaError;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.HitPoints.HPProtoss;
import edu.fiuba.algo3.modelo.IDEDIFICIO;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Unidad.Scout;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import edu.fiuba.algo3.modelo.tablero.Moho;
import edu.fiuba.algo3.modelo.tablero.Tierra;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;


public class PuertoEstelar extends Edificio {

    private static final int CANTIDAD_TURNOS_OPERATIVO = 10;


    public PuertoEstelar(){
        super(CANTIDAD_TURNOS_OPERATIVO,new HPProtoss(600,600),150,150);
        entidad = IDEDIFICIO.PUERTOESTELAR;

    }
    public PuertoEstelar(Ubicacion ubicacion){
        super(CANTIDAD_TURNOS_OPERATIVO,new HPProtoss(600,600),150,150);
        entidad = IDEDIFICIO.PUERTOESTELAR;
        ubicacion.ubicar(this);

    }

    public void transportarUnidades() {
        verififarEdificioOperativo();
    }

    @Override
    public void construirEdificioEn(Recurso recurso) {
        throw new ConstruccionIncorrectaError();
    }

    public void verificarSiPuedeSerConstruido(GestionRecurso unidadesDeMineral, GestionRecurso unidadesDeGas){
        verificarSiPuedeSerConstruidoSegunRecursos(unidadesDeMineral, unidadesDeGas);
    }

    @Override
    public void fueAgregado(Raza raza) {
        if( ! raza.existePuerto() ){
            throw new CorrelativaDeConstruccionIncumplidaError();
        }
        this.raza = raza;
    }

    @Override
    public void instalar(Tierra tierra) {
        return;
    }

    @Override
    public void instalar(Moho moho) {
        throw new ConstruccionProtoEnMohoError();
    }

    public Scout crearScout() {
        verififarEdificioOperativo();
        Scout scout = new Scout();
        raza.agregarUnidad(scout);
        return scout;
    }

    @Override
    public void ubicar(Ubicacion unLugar){
        if(!unLugar.energizado()){
            throw new ConstruccionFueraDelRangoPilonError();
        }
        super.ubicar(unLugar);
    }

    public void verificarEnergia(){
        if(!ubicacion.energizado()){
            throw new ConstruccionFueraDelRangoPilonError();
        }
    }
}
