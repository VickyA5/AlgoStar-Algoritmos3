package edu.fiuba.algo3.modelo.tablero;

import edu.fiuba.algo3.modelo.Edificio.Protoss.Pilon;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Criadero;
import edu.fiuba.algo3.modelo.Recurso.NodoMineral;
import edu.fiuba.algo3.modelo.Recurso.Volcan;

import java.util.ArrayList;

public class Mapa {

    private Ubicacion[][] mapa;
    private int base;
    private int altura;

    public Mapa(int Base, int Altura) {
        mapa = new Ubicacion[Base+1][Altura+1];
        base = Base;
        altura = Altura;
        for (int i = 0; i <= Base; i++) {
            for (int j = 0; j <= Altura; j++) {
                mapa[i][j] = new Ubicacion(new Coordenada(i, j));
            }
        }
        int a,b,y,z;
        for (int i = 0; i <= Base; i++) {
            for (int j = 0; j <= Altura; j++) {
            a = i-1;
            b = i+1;
            y = j-1;
            z = j+1;
            if(a<0) a = i;
            if(b> base) b = i;
            if(y<0) y = j;
            if (z>altura) z = j;
            mapa[j][i].Arriba(mapa[j][a]);
            mapa[j][i].Abajo(mapa[j][b]);
            mapa[j][i].Izquierda(mapa[y][i]);
            mapa[j][i].Derecha(mapa[z][i]);
            }
        }
        // falta definir los nodos minerales y los volcanes lugares ala mtitad del mapa lo definimos apriori.
    } // si base es de 10, y altura 10 , mapa se puede acceder al 10,10 tambien.

    public Ubicacion buscar(Coordenada coordenada) {
        for (int i = 0; i <= base; i++) {
            for (int j = 0; j <= altura; j++) {
                if (coordenada.esIgual(mapa[i][j].coordenada())) {
                    return mapa[i][j];
                }
            }

        }
        throw new UbicacionFueraDelMapaError();
    }
    public ArrayList<Ubicacion> buscar(Coordenada coordenada,int radio){

        ArrayList<Ubicacion> lista = new ArrayList<Ubicacion>();
        for (int i =0;i<=base;i++){
            for (int j = 0;j<=altura;j++){
                if (coordenada.distancia(mapa[i][j].coordenada())<= radio){
                    lista.add(mapa[i][j]);
                }
            }
        }
        return lista;

    }

    public int distanciaMaxima(){
        return mapa[0][0].distancia(mapa[base][altura]);
    }
    public Ubicacion buscarOpuesto(Coordenada coor){
        return buscar(coor.opuesta(base,altura));
    }

    private void darTipoAlMapaInicio(){
        for(int i = 0; i < base ; i++){
            for(int j = 0; j < altura ; j++){
                Ubicacion ubicacion1 = this.buscar(new Coordenada(i,j));
                if( i == 0 && j == 0){
                    ubicacion1.darTipo(new Moho());
                }
                else{
                    ubicacion1.darTipo(new Tierra());
                }
            }
        }
        //damos tipo a los terrenos especiales

        this.buscar(new Coordenada(4 , 6)).darTipo(new Especial() );
        this.buscar(new Coordenada(5 , 3)).darTipo(new Especial() );
        this.buscar(new Coordenada(7 , 5)).darTipo(new Especial() );

    }
    public void inicializarMapa() {
        darTipoAlMapaInicio();

        this.buscar(new Coordenada(0,0)).ubicar(new Criadero());
        this.buscar(new Coordenada(0,2)).ubicarRecurso(new NodoMineral());
        this.buscar(new Coordenada(2,0)).ubicarRecurso(new NodoMineral());
        this.buscar(new Coordenada(2,2)).ubicarRecurso(new Volcan());

        this.buscar(new Coordenada(base,altura)).ubicar(new Pilon(0));
        this.buscar(new Coordenada(base - 2, altura)).ubicarRecurso(new NodoMineral());
        this.buscar(new Coordenada(base, altura - 2 )).ubicarRecurso(new NodoMineral());
        this.buscar(new Coordenada(base - 2, altura - 2)).ubicarRecurso(new Volcan());

        if(base == 14){ // es factor 2 entonces.
            agregarBasesDiagonales();
        }

        if(base == 17){  // es factor 3 entonces.
            agregarBasesDiagonales();
            this.buscar(new Coordenada(2, 9)).ubicarRecurso(new NodoMineral());
            this.buscar(new Coordenada(2, 7)).ubicarRecurso(new NodoMineral());
            this.buscar(new Coordenada(0, 8)).ubicarRecurso(new Volcan());

            this.buscar(new Coordenada(base-2, 7)).ubicarRecurso(new NodoMineral());
            this.buscar(new Coordenada(base, 8)).ubicarRecurso(new Volcan());
            this.buscar(new Coordenada(base-2, 9)).ubicarRecurso(new NodoMineral());
        }
    }

    private void agregarBasesDiagonales(){
        this.buscar(new Coordenada(0, altura)).ubicarRecurso(new Volcan());
        this.buscar(new Coordenada(2, altura)).ubicarRecurso(new NodoMineral());
        this.buscar(new Coordenada(0, altura-2)).ubicarRecurso(new NodoMineral());

        this.buscar(new Coordenada(base, 0)).ubicarRecurso(new Volcan());
        this.buscar(new Coordenada(base, 2)).ubicarRecurso(new NodoMineral());
        this.buscar(new Coordenada(base-2 , 0)).ubicarRecurso(new NodoMineral());
    }


    public int getDimension() {
        return base;
    }
}
