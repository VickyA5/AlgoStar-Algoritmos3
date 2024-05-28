package edu.fiuba.algo3.modelo.UnidadesRecurso;

public class GestionRecurso {
    private UnidadesRecurso unidadesRecurso;

    public GestionRecurso(){
        this.unidadesRecurso = new UnidadesRecurso(0);
    }
    public GestionRecurso(int cantidad){
        this.unidadesRecurso = new UnidadesRecurso(cantidad);
    }

    public void consumir(int cantidad){
        unidadesRecurso.extraer(cantidad);
    }
    public  boolean puedeConsumir(int cantidad){
        return unidadesRecurso.puedeExtraer(cantidad);
    }

    public void aumentar(GestionRecurso gestionRecurso){
        unidadesRecurso.aumentar(gestionRecurso.unidadesRecurso);
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof GestionRecurso)) return false;
        GestionRecurso gestionRecurso = (GestionRecurso) o;
        return unidadesRecurso.equals(gestionRecurso.unidadesRecurso);
    }


    @Override
    public String toString(){
        return unidadesRecurso.toString();
    }
}
