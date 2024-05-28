package edu.fiuba.algo3.modelo.Unidad;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Ataque.Ataque;
import edu.fiuba.algo3.modelo.Ataque.AtaqueTierraYViento;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.HitPoints.HPZerg;
import edu.fiuba.algo3.modelo.HitPoints.HitPoints;
import edu.fiuba.algo3.modelo.ID_UNIDAD;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;

public class Mutalisco extends Unidad implements TipoEvolucionDeMutalisco{

    private TipoEvolucionDeMutalisco tipoEvolucionDeMutalisco;
    public Mutalisco() {
        super(
                new HPZerg(120),
                new TipoAire(),
                new AtaqueTierraYViento(9,9),
                7,4,100,100);
        tipoEvolucionDeMutalisco = null;
        entidad = ID_UNIDAD.MUTALISCO;
        rango = 3;
    }

    public Mutalisco(HitPoints vida) {
            super(vida, 4);
            tipoEvolucionDeMutalisco = null;
            entidad = ID_UNIDAD.MUTALISCO;
            rango = 3;
    }

    public void evolucionarAGuardian(RazaZerg raza) {
        tipoEvolucionDeMutalisco = new Guardian();
        raza.agregarUnidad((Unidad) this.getTipoEvolucionDeMutalisco());
    }

    public void evolucionarDevorador(RazaZerg raza) {
        tipoEvolucionDeMutalisco = new Devorador();
        raza.agregarUnidad((Unidad) this.getTipoEvolucionDeMutalisco());
    }

    @Override
    public boolean equals(Object object){
        if (!(object instanceof Mutalisco)) return false;
        Mutalisco mutalisco = (Mutalisco) object;

        return mutalisco.hp.equals(hp)  ;
    }

    public TipoEvolucionDeMutalisco getTipoEvolucionDeMutalisco(){
        return tipoEvolucionDeMutalisco;
    }

    // Delego los metodos de Unidad al tipo de Evolucion --------------------------------

    public Boolean verificarSiEsMutalisco(){
        return tipoEvolucionDeMutalisco == null;
    }

    public void atacar(Atacable atacable){

        if(verificarSiEsMutalisco()){
            super.atacar(atacable);
        }else {
            Unidad unidadActual = (Unidad) tipoEvolucionDeMutalisco;
            unidadActual.atacar(atacable);
        }
    }

    public void recibirAtaque(Ataque ataque){

        if(verificarSiEsMutalisco()){
            super.recibirAtaque(ataque);
        }else {
            Unidad unidadActual = (Unidad) tipoEvolucionDeMutalisco;
            unidadActual.recibirAtaque(ataque);
        }
    }

    public void atacarSobreUbicacion(Atacable atacable){
        if(verificarSiEsMutalisco()){
            super.atacarSobreUbicacion(atacable);
        }else{
            Unidad unidadActual = (Unidad) tipoEvolucionDeMutalisco;
            unidadActual.atacarSobreUbicacion(atacable);
        }
    }

    public void asignarRango(int Rango){
        if(verificarSiEsMutalisco()){
            super.asignarRango(Rango);
     }else{
            Unidad unidadActual = (Unidad) tipoEvolucionDeMutalisco;
            unidadActual.asignarRango(Rango);
        }
    }

    public void volar(){
        if(verificarSiEsMutalisco()){
            super.volar();
        }else{
            Unidad unidadActual = (Unidad) tipoEvolucionDeMutalisco;
            unidadActual.volar();
        }
    }

    public void aumentarPoblacion(Raza raza) {
        if(verificarSiEsMutalisco()){
           super.aumentarPoblacion(raza);
        }else{
            Unidad unidadActual = (Unidad) tipoEvolucionDeMutalisco;
            unidadActual.aumentarPoblacion(raza);
        }
    }

    public void disminuirPoblacion(Raza unaRaza){
        if(verificarSiEsMutalisco()){
            super.disminuirPoblacion(unaRaza);
        }else{
            Unidad unidadActual = (Unidad) tipoEvolucionDeMutalisco;
            unidadActual.disminuirPoblacion(unaRaza);
        }
    }
    protected void disminuirCapacidad(Raza unaRaza){
        if(verificarSiEsMutalisco()){
            super.disminuirCapacidad(unaRaza);
        }else{
            Unidad unidadActual = (Unidad) tipoEvolucionDeMutalisco;
            unidadActual.disminuirCapacidad(unaRaza);
        }
    }

    public void verificarConsumoRecurso(GestionRecurso mineral, GestionRecurso gas) {
       if(verificarSiEsMutalisco()){
            super.verificarConsumoRecurso(mineral, gas);
       }else{
           Unidad unidadActual = (Unidad) tipoEvolucionDeMutalisco;
           unidadActual.verificarConsumoRecurso(mineral, gas);
       }
    }

    public void consumirGas(GestionRecurso gas) {
        if(verificarSiEsMutalisco()){
            super.consumirGas(gas);
        }else{
            Unidad unidadActual = (Unidad) tipoEvolucionDeMutalisco;
            unidadActual.consumirGas(gas);
        }
    }

    public void consumirMineral(GestionRecurso mineral) {
        if(verificarSiEsMutalisco()){
            super.consumirMineral(mineral);
        }else{
            Unidad unidadActual = (Unidad) tipoEvolucionDeMutalisco;
            unidadActual.consumirMineral(mineral);
        }
    }

    public void ejecutarTurno() {
        if(verificarSiEsMutalisco()){
            super.ejecutarTurno();
        }else{
            Unidad unidadActual = (Unidad) tipoEvolucionDeMutalisco;
            unidadActual.ejecutarTurno();
        }
    }

    public Unidad getTipoMutalisco(){
        Unidad unidad = null;
        if(tipoEvolucionDeMutalisco != null){
            unidad = (Unidad) tipoEvolucionDeMutalisco;
        }
        return unidad;
    }
}
