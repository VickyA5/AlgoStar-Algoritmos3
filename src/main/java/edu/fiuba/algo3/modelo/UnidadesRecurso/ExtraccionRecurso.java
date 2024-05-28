package edu.fiuba.algo3.modelo.UnidadesRecurso;

public class ExtraccionRecurso {
    private UnidadesRecurso unidadesRecurso;

    public ExtraccionRecurso(int cantidad){
        unidadesRecurso = new UnidadesRecurso(cantidad);
    }

    public GestionRecurso extraer(int cantidad){
        try {
            return unidadesRecurso.extraer(cantidad);
        } catch (CantidadInsuficienteError e ){
            return unidadesRecurso.extraerTodo();
        }
    }
    public int getCantidadRecurso(){
        return unidadesRecurso.getCantidad();
    }
}
