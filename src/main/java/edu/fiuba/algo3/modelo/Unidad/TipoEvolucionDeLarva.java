package edu.fiuba.algo3.modelo.Unidad;

import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import edu.fiuba.algo3.modelo.Recurso.NodoMineral;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;

interface TipoEvolucionDeLarva {

    GestionRecurso extraer(Recurso recurso);

    GestionRecurso extraerMineral(NodoMineral nodoMineral);

    public void mutarCriadero(RazaZerg raza);

    void mutarEspiral(RazaZerg raza) ;

    void mutarExtractor(RazaZerg raza);

    boolean equals(Object object);

    void evolucionarLarva() ;

    void crearMutalisco() ;

    void agregarZangano(Zangano zangano);

    void mutarGuarida(RazaZerg raza);

    void evolucionarLarvaAHidra(Larva larva) ;

    void evolucionarLarvaAZerli(Larva larva);

    void mutarReservaReproduccion(RazaZerg raza);


}
