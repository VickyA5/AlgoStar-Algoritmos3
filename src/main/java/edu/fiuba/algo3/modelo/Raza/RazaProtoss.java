package edu.fiuba.algo3.modelo.Raza;

import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Edificio.Protoss.Pilon;
import edu.fiuba.algo3.modelo.IDEDIFICIO;
import edu.fiuba.algo3.modelo.ID_RAZA;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import edu.fiuba.algo3.modelo.tablero.Mapa;

public class RazaProtoss extends Raza{

    public RazaProtoss(){
        super();
        entidad = ID_RAZA.PROTOSS;
    }
    public RazaProtoss(GestionRecurso mineral, GestionRecurso gas){
        super(mineral, gas);
    }

    @Override
    public void existenAunEdificios() {
        if( edificios.size() == 0){
            throw new FinDelJuegoGanaronLosZerg();
        }
    }

    public void activarPilonesActivos(Mapa mapa){
        for(Edificio edificio : edificios ){
            if((edificio.getEntidad() == IDEDIFICIO.PILON && edificio.estaOperativo()) && (edificio.ubicacion() != null)){
                Pilon pilon = (Pilon) edificio;
                pilon.energizar(pilon.ubicacion(), mapa);
            }
        }
    }
}
