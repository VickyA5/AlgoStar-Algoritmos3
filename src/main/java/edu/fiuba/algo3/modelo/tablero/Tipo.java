package edu.fiuba.algo3.modelo.tablero;

import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.TIPOSUPERFICIE;
import edu.fiuba.algo3.modelo.Unidad.*;

public abstract class Tipo {

    protected TIPOSUPERFICIE tiposuperficie;

    abstract void instalar(Edificio edificio);
    abstract void crecer(Coordenada coor,Mapa mapa,int radio);
    abstract void ubicar(Unidad unaUnidad);

    TIPOSUPERFICIE getTiposuperficie(){
        return tiposuperficie;
    }
}
