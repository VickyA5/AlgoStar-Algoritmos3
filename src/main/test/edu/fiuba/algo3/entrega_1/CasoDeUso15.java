package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Edificio.Protoss.Asimilador;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Extractor;
import edu.fiuba.algo3.modelo.Edificio.Protoss.NexoMineral;
import edu.fiuba.algo3.modelo.HitPoints.HPZerg;
import edu.fiuba.algo3.modelo.Recurso.NodoMineral;
import edu.fiuba.algo3.modelo.Recurso.Volcan;
import edu.fiuba.algo3.modelo.Unidad.Zangano;
import edu.fiuba.algo3.modelo.UnidadesRecurso.GestionRecurso;
import edu.fiuba.algo3.modelo.tablero.Coordenada;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso15 {

    @Test
    public void RazaZergDejaDeConseguirGasDelVolcanCuandoSeQuedaSinUnidadesDeGas(){
        //Arrange
        Volcan volcan = new Volcan();
        Extractor extractor = new Extractor();

        // dejo el Extractor operrable en 6 turnos
        for(int i = 0; i <6; i++ ){
            extractor.ejecutarTurno();
        }

        for(int i = 0; i < 3; i++ ){
            extractor.agregarZangano(new Zangano(new HPZerg(25)));
        }

        GestionRecurso maximaCantidadRecursoExtraible = new GestionRecurso(5000);
        int cantidadDeTurnosParaSacarTodoElRecurso = 167;
        GestionRecurso recursoExtraido = new GestionRecurso();
        GestionRecurso cantidadRecursoExceso = new GestionRecurso();

        //Act
        for(int i = 0; i <=cantidadDeTurnosParaSacarTodoElRecurso ; i++ ){
            recursoExtraido.aumentar(extractor.extraer(volcan));
        }

        // Intentamos extraer 5 veces mas el Volcan

        for(int i = 0; i < 5 ; i++){
            cantidadRecursoExceso.aumentar(extractor.extraer(volcan));
        }


        //Assert
        assertEquals(maximaCantidadRecursoExtraible, recursoExtraido);
        assertEquals(new GestionRecurso(),cantidadRecursoExceso );
    }


    @Test
    public void RazaZergDejaDeConseguirMineralCuandoDelNodoMineralCuandoSeQuedaSinUnidadesDeMineral(){
        //Arrange
        NodoMineral nodoMineral = new NodoMineral();
        Zangano zangano = new Zangano(new HPZerg(25));
        GestionRecurso maximaCantidadRecursoExtraible = new GestionRecurso(2000);
        int cantidadDeTurnosParaSacarTodoElRecurso = 200;
        GestionRecurso recursoExtraido = new GestionRecurso();
        GestionRecurso cantidadRecursoExceso = new GestionRecurso();


        //Act

        for(int i = 0; i <=cantidadDeTurnosParaSacarTodoElRecurso ; i++ ){
            recursoExtraido.aumentar(zangano.extraer(nodoMineral));
        }

        // Intentamos extraer 5 veces mas en el nodoMineral

        for(int i = 0; i < 5 ; i++){
            cantidadRecursoExceso.aumentar(zangano.extraer(nodoMineral));
        }


        //Assert
        assertEquals(maximaCantidadRecursoExtraible, recursoExtraido);
        assertEquals(new GestionRecurso(),cantidadRecursoExceso );

    }

    @Test
    public void RazaProtoDejaDeConseguirGasDelVolcanCuandoSeQuedaSinUnidadesDeGas(){
        //Arrange
        Volcan volcan = new Volcan();
        Ubicacion ubicacion = new Ubicacion(new Coordenada(0,0));
        ubicacion.ubicarRecurso(volcan);
        Asimilador asimilador = new Asimilador(ubicacion);

        // dejo el Asimilador operrable en 6 turnos
        for(int i = 0; i <6; i++ ){
            asimilador.ejecutarTurno();
        }

        GestionRecurso maximaCantidadRecursoExtraible = new GestionRecurso(5000);
        int cantidadDeTurnosParaSacarTodoElRecurso = 250;
        GestionRecurso recursoExtraido = new GestionRecurso();
        GestionRecurso cantidadRecursoExceso = new GestionRecurso();

        //Act
        for(int i = 0; i <=cantidadDeTurnosParaSacarTodoElRecurso; i++ ){
            recursoExtraido.aumentar(asimilador.extraer());
        }

        // Intentamos extraer 5 veces mas en el volcan

        for(int i = 0; i < 5 ; i++){
            cantidadRecursoExceso.aumentar(asimilador.extraer());
        }

        //Assert
        assertEquals(maximaCantidadRecursoExtraible, recursoExtraido);
        assertEquals(new GestionRecurso(),cantidadRecursoExceso );
    }

    @Test
    public void RazaProtossDejaDeConseguirMineralCuandoDelNodoMineralCuandoSeQuedaSinUnidadesDeMineral(){
        //Arrange
        Ubicacion ubicacion = new Ubicacion(new Coordenada(0,0));
        NexoMineral nexoMineral = new NexoMineral( new NodoMineral(),ubicacion );

        // dejo el Asimilador operrable en 6 turnos
        for(int i = 0; i <4; i++ ){
            nexoMineral.ejecutarTurno();
        }

        GestionRecurso maximaCantidadRecursoExtraible = new GestionRecurso(2000);
        int cantidadDeTurnosParaSacarTodoElRecurso = 250;
        GestionRecurso recursoExtraido = new GestionRecurso();
        GestionRecurso cantidadRecursoExceso = new GestionRecurso();

        //Act
        for(int i = 0; i <=cantidadDeTurnosParaSacarTodoElRecurso ; i++ ){
            recursoExtraido.aumentar(nexoMineral.extraer());
        }

        // Intentamos extraer 5 veces mas en el nodoMineral

        for(int i = 0; i < 5 ; i++){
            cantidadRecursoExceso.aumentar(nexoMineral.extraer());
        }

        //Assert
        assertEquals(maximaCantidadRecursoExtraible, recursoExtraido);
        assertEquals(new GestionRecurso(),cantidadRecursoExceso );
    }

}
