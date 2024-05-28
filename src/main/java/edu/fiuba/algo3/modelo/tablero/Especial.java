package edu.fiuba.algo3.modelo.tablero;

import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.NoSePuedeConstruirSobreElEspacioError;
import edu.fiuba.algo3.modelo.TIPOSUPERFICIE;
import edu.fiuba.algo3.modelo.Unidad.Unidad;

public class Especial extends Tipo{

    public Especial(){
        tiposuperficie = TIPOSUPERFICIE.ESPECIAL;
    }
    public void instalar(Edificio edificio){
        throw new NoSePuedeConstruirSobreElEspacioError();
    }
    public void crecer(Coordenada coor,Mapa mapa,int radio){}
    public void ubicar(Unidad unaUnidad){
       unaUnidad.volar();
    }
}
