package edu.fiuba.algo3.modelo.Edificio.Protoss;

import edu.fiuba.algo3.modelo.ConstruccionProtoEnMohoError;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.HitPoints.HPProtoss;
import edu.fiuba.algo3.modelo.IDEDIFICIO;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Recurso.Volcan;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import edu.fiuba.algo3.modelo.tablero.Moho;
import edu.fiuba.algo3.modelo.tablero.Tierra;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;

public class Asimilador extends Edificio {
    private static final int CANTIDAD_TURNOS_OPERATIVO = 6;
    private Volcan volcan;


    public Asimilador(Ubicacion ubicacion){
        super(CANTIDAD_TURNOS_OPERATIVO,new HPProtoss(450,450),100,0);
        entidad = IDEDIFICIO.ASIMILADOR;
        ubicacion.ubicar(this);
        this.volcan = ubicacion.getVolcan();
        volcan.agregarEdificio(this);

    }

    public void prepararCapsula() {
        verififarEdificioOperativo();

    }

    public GestionRecurso extraer() {
        if(this.volcan != null){
            return volcan.extraer(20);
        }
        return volcan.extraer(20);

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
        return;
    }

    @Override
    public void instalar(Moho moho) {
        throw new ConstruccionProtoEnMohoError();
    }


}
