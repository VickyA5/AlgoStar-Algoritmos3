package edu.fiuba.algo3.modelo.Unidad;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Ataque.Ataque;
import edu.fiuba.algo3.modelo.Ataque.AtaqueSoloTierra;
import edu.fiuba.algo3.modelo.Edificio.Zerg.*;
import edu.fiuba.algo3.modelo.HitPoints.HPZerg;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import edu.fiuba.algo3.modelo.Recurso.NodoMineral;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;

public class Larva extends Unidad{

    private TipoEvolucionDeLarva tipoEvolucionDeLarva;

    public Larva() {//Aca estoy tomando bastantes SUPUESTOS
        super(new HPZerg(1), new TipoTierra(), new AtaqueSoloTierra(0), 0, 0, 0, 0);
        tipoEvolucionDeLarva = null;
    }

    public void evolucionar() {
        tipoEvolucionDeLarva = new Zangano();
    }

    public void evolucionar(ReservaDeReproduccion reserva) {
        tipoEvolucionDeLarva = new Zerling();
    }

    public void evolucionar(Guarida guarida) {
        tipoEvolucionDeLarva = new Hidralisco();
    }

    public GestionRecurso extraer(Recurso recurso){
        return tipoEvolucionDeLarva.extraer(recurso);
    }

    public GestionRecurso extraerMineral(NodoMineral nodoMineral){
        return  tipoEvolucionDeLarva.extraerMineral(nodoMineral);
    }

    public void mutarCriadero(RazaZerg raza) {
        tipoEvolucionDeLarva.mutarCriadero(raza);
    }

    public void mutarEspiral(RazaZerg raza) {
        tipoEvolucionDeLarva.mutarEspiral(raza);
    }

    public void mutarExtractor(RazaZerg raza) {
        tipoEvolucionDeLarva.mutarExtractor(raza);
    }
    @Override
    public boolean equals(Object object){
        return tipoEvolucionDeLarva.equals(object);
    }

    public void evolucionarLarva() {
        tipoEvolucionDeLarva.evolucionarLarva();
    }

    public void crearMutalisco() {
        tipoEvolucionDeLarva.crearMutalisco();
    }

    /*Esto creo que no es necesario
    @Override
    public void ejecutarTurno(){
        tipoDeUnidadZerg.ejecutarTurno();
    }*/

    public void agregarZangano(Zangano zangano) {
        tipoEvolucionDeLarva.agregarZangano(zangano);
    }

    public void mutarGuarida(RazaZerg raza) {
        tipoEvolucionDeLarva.mutarGuarida(raza);
    }

    public void evolucionarLarvaAHidra(Larva larva) {
        tipoEvolucionDeLarva.evolucionarLarvaAHidra(larva);
    }

    public void evolucionarLarvaAZerli(Larva larva) {
        tipoEvolucionDeLarva.evolucionarLarvaAZerli(larva);
    }

    public void mutarReservaReproduccion(RazaZerg raza) {
        tipoEvolucionDeLarva.mutarReservaReproduccion(raza);
    }

    public TipoEvolucionDeLarva getTipoDeUnidadZerg(){
        return tipoEvolucionDeLarva;
    }


    //Delego los metodos de Unidad a su respectivo Tipo ------------------------------

    public void verificarSiEsUnaLarva(){
        if( tipoEvolucionDeLarva == null){
            throw new LarvaNoTieneEseComportamientoError();
        }
    }

    public void atacar(Atacable atacable){
        verificarSiEsUnaLarva();
        Unidad unidadActual = (Unidad) tipoEvolucionDeLarva;
        unidadActual.atacar(atacable);
    }

    public void recibirAtaque(Ataque ataque){
        verificarSiEsUnaLarva();
        Unidad unidadActual = (Unidad) tipoEvolucionDeLarva;
        unidadActual.recibirAtaque(ataque);
    }

    public void atacarSobreUbicacion(Atacable atacable){
        verificarSiEsUnaLarva();
        Unidad unidadActual = (Unidad) tipoEvolucionDeLarva;
        unidadActual.atacarSobreUbicacion(atacable);
    }

    public void asignarRango(int Rango){
        verificarSiEsUnaLarva();
        Unidad unidadActual = (Unidad) tipoEvolucionDeLarva;
        unidadActual.asignarRango(Rango);
    }

    public void volar(){
        verificarSiEsUnaLarva();
        Unidad unidadActual = (Unidad) tipoEvolucionDeLarva;
        unidadActual.volar();
    }

    public void aumentarPoblacion(Raza raza) {
        verificarSiEsUnaLarva();
        Unidad unidadActual = (Unidad) tipoEvolucionDeLarva;
        unidadActual.aumentarPoblacion(raza);
    }

    public void disminuirPoblacion(Raza unaRaza){
        verificarSiEsUnaLarva();
        Unidad unidadActual = (Unidad) tipoEvolucionDeLarva;
        unidadActual.disminuirPoblacion(unaRaza);
    }
    protected void disminuirCapacidad(Raza unaRaza){
        verificarSiEsUnaLarva();
        Unidad unidadActual = (Unidad) tipoEvolucionDeLarva;
        unidadActual.disminuirCapacidad(unaRaza);
    }

    public void verificarConsumoRecurso(GestionRecurso mineral, GestionRecurso gas) {
        verificarSiEsUnaLarva();
        Unidad unidadActual = (Unidad) tipoEvolucionDeLarva;
        unidadActual.verificarConsumoRecurso(mineral, gas);
    }

    public void consumirGas(GestionRecurso gas) {
        verificarSiEsUnaLarva();
        Unidad unidadActual = (Unidad) tipoEvolucionDeLarva;
        unidadActual.consumirGas(gas);
    }

    public void consumirMineral(GestionRecurso mineral) {
        verificarSiEsUnaLarva();
        Unidad unidadActual = (Unidad) tipoEvolucionDeLarva;
        unidadActual.consumirMineral(mineral);
    }

    public void ejecutarTurno() {
        verificarSiEsUnaLarva();
        Unidad unidadActual = (Unidad) tipoEvolucionDeLarva;
        unidadActual.ejecutarTurno();
    }
}
