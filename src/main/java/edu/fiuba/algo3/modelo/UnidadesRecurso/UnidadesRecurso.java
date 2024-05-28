package edu.fiuba.algo3.modelo.UnidadesRecurso;

public class UnidadesRecurso {
    private int cantidad;

    public UnidadesRecurso(int cantidad){
        this.cantidad = cantidad;
    }
    public boolean puedeExtraer(int cantidad){
        return this.cantidad >= cantidad;
    }

    public GestionRecurso extraer(int cantidad){
        if(!puedeExtraer(cantidad))
            throw  new CantidadInsuficienteError();
        this.cantidad -= cantidad;
        return new GestionRecurso(cantidad);
    }

    public GestionRecurso extraerTodo(){
        GestionRecurso retorno = new GestionRecurso(cantidad);
        cantidad = 0;
        return retorno;
    }

    public void aumentar(UnidadesRecurso unidadesRecurso){
        cantidad += unidadesRecurso.cantidad;
        unidadesRecurso.cantidad = 0;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof UnidadesRecurso)) return false;
        UnidadesRecurso unidadesRecurso = (UnidadesRecurso) o;
        return cantidad == unidadesRecurso.cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString(){
        return String.valueOf(cantidad);
    }
}
