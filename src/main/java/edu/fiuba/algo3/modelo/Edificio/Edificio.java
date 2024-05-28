package edu.fiuba.algo3.modelo.Edificio;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Ataque.Ataque;
import edu.fiuba.algo3.modelo.HitPoints.HitPoints;
import edu.fiuba.algo3.modelo.IDEDIFICIO;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.*;
import edu.fiuba.algo3.modelo.Recurso.RecursosInsuficientesError;
import edu.fiuba.algo3.modelo.Unidad.UnidadMuertaError;
import edu.fiuba.algo3.modelo.UnidadesRecurso.*;
import edu.fiuba.algo3.modelo.tablero.*;

public abstract class Edificio implements Atacable {
    protected IDEDIFICIO entidad;
    protected Ubicacion ubicacion;
    protected int turnosRestantesParaSerOperativo;
    protected int costoMineral;
    protected int costoGas;
    protected Raza raza;
    private HitPoints hp;


    public Edificio(int turnosRestantesParaSerOperativo,HitPoints HP, int mineralNecesario, int gasNecesario){
        this.turnosRestantesParaSerOperativo = turnosRestantesParaSerOperativo;
        this.hp = HP;
        this.costoMineral = mineralNecesario;
        this.costoGas = gasNecesario;
    }
    public Edificio(HitPoints HP){
        hp = HP;
        turnosRestantesParaSerOperativo = 0;
    }

    public void verififarEdificioOperativo() {
        if(turnosRestantesParaSerOperativo > 0 ){
            throw  new EdificioNoOperativoError();
        }
    }

    public void ejecutarTurno() {
        if(turnosRestantesParaSerOperativo > 0)
            turnosRestantesParaSerOperativo--;
        hp.regenerar();
    }


    public abstract void construirEdificioEn(Recurso recurso);

    public void verificarSiPuedeSerConstruidoSegunRecursos(GestionRecurso mineral, GestionRecurso gas){
        if(!gas.puedeConsumir(costoGas) || !mineral.puedeConsumir(costoMineral)){
            throw new RecursosInsuficientesError();
        }
    }

    public abstract void verificarSiPuedeSerConstruido(GestionRecurso unidadesDeMineral, GestionRecurso unidadesDeGas);

    public  void consumirGas(GestionRecurso gas){
        gas.consumir(costoGas);
    }

    public  void consumirMineral(GestionRecurso mineral){
        mineral.consumir(costoMineral);
    }

    public void asignarHP(HitPoints HP){
        hp = HP;
    }

    public void recibirDaño(int daño){
        hp.recibirDaño(daño);
    }

    public int vidaActual(){
        return hp.vida();
    }

    public int escudoActual(){
        return hp.escudo();
    }

    public void regeneracionFinDeTurno(){
        hp.regenerar();
    }

    public void ubicar(Ubicacion unLugar){
        ubicacion = unLugar;
    }

    public void desalojar(){
        ubicacion = null;
    }


    public int distancia(Ubicacion unaUbicacion){
        return unaUbicacion.distancia(ubicacion);
    }


    public Ubicacion ubicacion() {
        return ubicacion;
    }
    @Override
    public void recibirAtaque(Ataque unAtaque){
        try{
            unAtaque.aplicarDanioTierra(hp);
        }catch (UnidadMuertaError e){
            raza.destruirEdificio(this);
            throw new UnidadMuertaError();
        }

/*        if(hp.vidaDestruida()){
            raza.destruirEdificio(this);          //puede mejorar pero los edificios tienen que tener una referencia a raza.
        }*/
    }

    public abstract void fueAgregado(Raza raza);


    public abstract void instalar(Tierra tierra);

    public abstract void instalar(Moho moho);

    public void disminuirCapacidad(Raza unaRaza){
        unaRaza.disminuirCapacidad(0);
    }

    public IDEDIFICIO getEntidad(){
        return entidad;
    }

    public void asignarRaza(Raza unaRaza){
        raza = unaRaza;
    }

    public boolean estaOperativo() {
        if(turnosRestantesParaSerOperativo > 0 ){
            return false;
        }
        return true;
    }
    public int getTurnosRestantesParaSerOperativo(){
        return turnosRestantesParaSerOperativo;
    }

    public int getVida() {
        return hp.vida();
    }

    public int getEscudo() {
        return hp.escudo();
    }


}
