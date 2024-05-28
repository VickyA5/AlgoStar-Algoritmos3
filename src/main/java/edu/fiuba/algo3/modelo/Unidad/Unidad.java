package edu.fiuba.algo3.modelo.Unidad;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Atacante;
import edu.fiuba.algo3.modelo.Ataque.Ataque;
import edu.fiuba.algo3.modelo.HitPoints.HitPoints;
import edu.fiuba.algo3.modelo.ID_UNIDAD;
import edu.fiuba.algo3.modelo.Raza.PoblacionExedidaError;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import edu.fiuba.algo3.modelo.tablero.UbicacionOcupadaError;

public abstract class  Unidad implements Atacable, Atacante {
    protected HitPoints hp;
    private TipoSuperficie tipoSuperficie;
    private Ubicacion ubicacion;
    protected int rango;
    private Ataque ataque;
    protected  int costoGas;
    protected  int costoMineral;
    protected int costoSuministro;
    protected int costoPoblacion;
    protected int turnosRestantesParaSerOperativo;
    protected int unidadesAsesinadas;

    protected ID_UNIDAD entidad;

    public Unidad(HitPoints vida, int suministroNecesario){
        hp = vida;
        costoSuministro = suministroNecesario;
    }

    public void verificarUnidadOperativa() {
        if(turnosRestantesParaSerOperativo > 0 ){
            throw  new UnidadNoOperativaError();
        }
    }
    public Unidad(HitPoints vida, TipoSuperficie tipoSuperficie, Ataque ataque, int turnosRestantesParaSerOperativo, int costoPoblacion, int costoMineral, int costoGas){
        hp = vida;
        this.tipoSuperficie = tipoSuperficie;
        this.ataque = ataque;
        this.turnosRestantesParaSerOperativo = turnosRestantesParaSerOperativo;
        this.costoPoblacion = costoPoblacion;
        this.costoMineral = costoMineral;
        this.costoGas = costoGas;
        unidadesAsesinadas = 0;
    }

    public void atacar(Atacable atacable){
        verificarUnidadOperativa();
        try {
            atacable.recibirAtaque(ataque);
        } catch (UnidadMuertaError e){
            unidadesAsesinadas++;
        }
    }

    public void ejecutarTurno() {
        if(turnosRestantesParaSerOperativo > 0){
            turnosRestantesParaSerOperativo--;
        }
    }

    public void recibirAtaque(Ataque ataque){
        tipoSuperficie.recibirAtaque(ataque, hp);
    }

    public void asignarLugar(Ubicacion unLugar){
        ubicacion=unLugar;
    }

    public void atacarSobreUbicacion(Atacable atacable){
        if(ubicacion.distancia(atacable.ubicacion())> rango){
            throw new EnemigoFueraDeRangoError();
        }
        else {
            atacar(atacable);
        }
    }
    public Ubicacion ubicacion(){
        return ubicacion;
    }
    public void asignarRango(int Rango){
        rango = Rango;
    }

    public void volar(){
        verificarUnidadOperativa();
        tipoSuperficie.volar();
    }

    public void aumentarPoblacion(Raza raza) {
        raza.aumentarPoblacion(costoPoblacion);
    }

    public void disminuirPoblacion(Raza unaRaza){
        unaRaza.disminuirPoblacion(costoPoblacion);
        disminuirCapacidad(unaRaza);
    }
    protected void disminuirCapacidad(Raza unaRaza){
        unaRaza.disminuirCapacidad(0);
    }

    public void verificarConsumoRecurso(GestionRecurso mineral, GestionRecurso gas) {
        if(!mineral.puedeConsumir(costoMineral) || !gas.puedeConsumir(costoGas))
            throw new InsuficientesRecursosParaCrearUnidadError();
    }

    public void consumirGas(GestionRecurso gas) {
        gas.consumir(costoGas);
    }

    public void consumirMineral(GestionRecurso mineral) {
        mineral.consumir(costoMineral);
    }

    public GestionRecurso extraer(Recurso recurso) {
        return null;
    }

    public void moverseArriba(){
        Ubicacion ubicacionNueva =   ubicacion.getArriba();
        if(  ! this.ubicacion.esIgual(ubicacionNueva) ){
            try {
                ubicacionNueva.asignarUnidad(this);
                ubicacion.getAbajo().quitarUnidad();
            }catch (UbicacionOcupadaError e){
                System.out.println("la nueva ubicacion esta ocupada");
            }
        }
    }

    public void moverseAbajo(){
        Ubicacion ubicacionNueva =   ubicacion.getAbajo();
        if(  ! this.ubicacion.esIgual(ubicacionNueva) ){
            try {
                ubicacionNueva.asignarUnidad(this);
                ubicacion.getArriba().quitarUnidad();
            }catch (UbicacionOcupadaError e){
                System.out.println("la nueva ubicacion esta ocupada");
            }
        }
    }

    public void moverseDerecha(){
        Ubicacion ubicacionNueva =   ubicacion.getDerecha();
        if(  ! this.ubicacion.esIgual(ubicacionNueva) ){
            try {
                ubicacion.getDerecha().asignarUnidad(this);
                ubicacion.getIzquierda().quitarUnidad();
            }catch (UbicacionOcupadaError e){
                System.out.println("la nueva ubicacion esta ocupada");
            }
        }
    }

    public void moverseIzquierda(){
        Ubicacion ubicacionNueva =   ubicacion.getIzquierda();
        if(  ! this.ubicacion.esIgual(ubicacionNueva) ){
            try {
                ubicacionNueva.asignarUnidad(this);
                ubicacion.getDerecha().quitarUnidad();
            }catch (UbicacionOcupadaError e){
                System.out.println("la nueva ubicacion esta ocupada");
            }
        }
    }

    public ID_UNIDAD getEntidad(){
        return entidad;
    }

    public int getTurnosRestantesParaSerOperativo(){
        return turnosRestantesParaSerOperativo;
    }
    public boolean esOperativo(){
        return turnosRestantesParaSerOperativo <= 0;
    }

    public int getRango() {
        return rango;
    }

    public int getVida(){
        return hp.vida();
    }

    public int getEscudo(){
        return hp.escudo();
    }

}