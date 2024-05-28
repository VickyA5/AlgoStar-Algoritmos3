package edu.fiuba.algo3.modelo.EstadoZangano;

import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Unidad.*;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;

public interface EstadoZangano {
    void evolucionarLarva();

    void agregarseAEstaRaza(RazaZerg razaZerg);

    void crearMutalisco();

    void ejecutarTurno();

    void agregarZangano(Unidad zangano);

    GestionRecurso extraer(Recurso recurso);

    void evolucionarLarvaAHidra(Larva larva);

    void evolucionarLarvaAZerli(Larva larva);
}
