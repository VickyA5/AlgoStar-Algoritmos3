package edu.fiuba.algo3.modelo.Raza;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Criadero;
import edu.fiuba.algo3.modelo.IDEDIFICIO;
import edu.fiuba.algo3.modelo.ID_RAZA;
import edu.fiuba.algo3.modelo.ID_UNIDAD;
import edu.fiuba.algo3.modelo.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Unidad.Larva;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import edu.fiuba.algo3.modelo.EstadoZangano.EstadoZangano;
import java.util.ArrayList;

public class RazaZerg extends Raza{
    public RazaZerg() {
        super();
        entidad = ID_RAZA.ZERG;
    }

    public RazaZerg(GestionRecurso mineral, GestionRecurso gas) {
        super(mineral, gas);
    }

    public void agregarEsteEdificio(EstadoZangano estadoZangano) {
        estadoZangano.agregarseAEstaRaza(this);
    }

    @Override
    public void existenAunEdificios() {
        if (edificios.size() == 0) {
            throw new FinDelJuegoGanaronLosProtoss();
        }
    }

    public Larva getLarva(){
        Larva larva = null;
        for (Edificio edificio : edificios){
            if(edificio.getEntidad() == IDEDIFICIO.CRIADERO /*&& (criadero.getCantidadLarvas() != 0)*/){
                Criadero criadero = (Criadero) edificio;
                larva = criadero.eliminarLarva();
                break;
            }
        }
        return larva;
    }

    @Override
    public void ejecutarTurno() {
        System.out.println("Pise el metodo ejecutar Turno");
        for(Unidad unidad : unidades){
            unidad.ejecutarTurno();
        }

        // para el criadero inicial asi el criadero inicial aumenta larvas.
        for (Edificio edificio: edificios){
            edificio.ejecutarTurno();
        }
    }

}
