package edu.fiuba.algo3.modelo.Raza;

import edu.fiuba.algo3.modelo.Edificio.*;
import edu.fiuba.algo3.modelo.ID_RAZA;
import edu.fiuba.algo3.modelo.Observers.ObservadorRazaRecursos;
import edu.fiuba.algo3.modelo.Unidad.Unidad;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import edu.fiuba.algo3.modelo.UnidadesRecurso.Poblacion;

import java.util.ArrayList;
import java.util.List;

public abstract class Raza {

    private GestionRecurso mineral;
    private GestionRecurso gas;
    private Poblacion poblacion;
    protected ArrayList<Edificio> edificios;
    protected ArrayList<Unidad> unidades;
    private int cantReservas;
    private int cantAccesos;
    private int cantGuaridas;

    private List<ObservadorRazaRecursos> observadores;

    protected ID_RAZA entidad;

    public Raza(){
        gas = new GestionRecurso(0);
        mineral = new GestionRecurso(200); //cambiar esto test noma
        poblacion = new Poblacion(200);
        edificios = new ArrayList<Edificio>();
        unidades = new ArrayList<Unidad>();
        cantAccesos = 0;
        cantReservas = 0;
        observadores = new ArrayList<>();
    }
    public Raza(GestionRecurso mineral, GestionRecurso gas){
        this.mineral = mineral;
        this.gas = gas;
        poblacion = new Poblacion(200);
        edificios = new ArrayList<Edificio>();
        unidades = new ArrayList<Unidad>();
        cantAccesos = 0;
        cantReservas = 0;
        observadores = new ArrayList<>();
    }

    public void agregarEdificio(Edificio edificio){
        edificio.verificarSiPuedeSerConstruido(mineral, gas);
        edificio.fueAgregado(this);
        edificio.consumirGas(gas);
        edificio.consumirMineral(mineral);
        edificios.add(edificio);
        notificar();
    }

    public void agregarEdificioInicial(Edificio edificio){
        edificio.fueAgregado(this);
        edificios.add(edificio);
    }

    public void agregarUnidad(Unidad unidad){
        unidad.verificarConsumoRecurso(mineral,gas);
        unidad.consumirGas(gas);
        unidad.consumirMineral(mineral);
        unidad.aumentarPoblacion(this);
        unidades.add(unidad);
        notificar();
    }

    public void aumentarGas(GestionRecurso gas ){
        this.gas.aumentar(gas);
        notificar();
    }
    public void aumentarMineral(GestionRecurso mineral ){
        this.mineral.aumentar(mineral);
        notificar();
    }

    public boolean existeReserva() {
        return (cantReservas > 0) ;
    }

    public boolean existeGuarida() {
        return (cantGuaridas > 0) ;
    }

    public void fueAgregadoReserva() {
        cantReservas++;
    }


    public void fueAgregadoAcceso() {
        cantAccesos++;
    }

    public void fueAgregadaGuarida() {
        cantGuaridas++;
    }


    public boolean existePuerto() {
        return (cantAccesos>0);
    }


    public void aumentarCapacidad(int unaPoblacion) {
        poblacion.aumentarCapacidad(unaPoblacion);
        notificar();
    }

    public void disminuirCapacidad(int unaPoblacion) {
        poblacion.disminuirCapacidad(unaPoblacion);
        notificar();
    }

    public void aumentarPoblacion(int costoPoblacion) {
        poblacion.aumentarPoblacion(costoPoblacion);
        notificar();
    }

    public void disminuirPoblacion(int costoPoblacion) {
        poblacion.disminuirPoblacion(costoPoblacion);
        notificar();
    }
    public int capacidadReal(){
        return poblacion.capacidadReal();
    }

    public int obtenerCantidadPoblacion(){
        return poblacion.obtenerPoblacion();
    }

    public void destruirEdificio(Edificio unEdificio){
        edificios.remove(unEdificio);
        unEdificio.disminuirCapacidad(this);
    }

    public void matarUnidad(Unidad unaUnidad){
        unidades.remove(unaUnidad);
        unaUnidad.disminuirPoblacion(this);
    }

    public abstract void existenAunEdificios();

    public Unidad getUltimaUnidad(){
        int ultimo = unidades.size()-1;
        return unidades.get(ultimo);
    }
    public ID_RAZA getEntidad(){
        return entidad;
    }

    public String getCantidadGas(){
        return gas.toString();
    }
    public String getCantidadMineral(){
        return mineral.toString();
    }

    public void agregarObservador(ObservadorRazaRecursos o){
        if(!observadores.contains(o)) observadores.add(o);
    }
    public void eliminarObservador(ObservadorRazaRecursos o){
        observadores.remove(o);
    }
    public void notificar(){
        observadores.forEach(o -> o.actualizar());
    }

    public void ejecutarTurno(){
        edificios.forEach(edificio -> {
            try {
                edificio.ejecutarTurno();
            }catch (Exception e){
                e.printStackTrace();
            }

        });
        unidades.forEach( unidad -> {
            unidad.ejecutarTurno();
        });

    }
    public boolean puedoSeguirJugando(){
        return edificios.size()>0;
    }
}
