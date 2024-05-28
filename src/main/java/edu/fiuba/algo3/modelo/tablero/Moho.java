package edu.fiuba.algo3.modelo.tablero;

import edu.fiuba.algo3.modelo.ConstruccionProtoEnMohoError;
import edu.fiuba.algo3.modelo.Edificio.*;
import edu.fiuba.algo3.modelo.Edificio.Protoss.*;
import edu.fiuba.algo3.modelo.TIPOSUPERFICIE;
import edu.fiuba.algo3.modelo.Unidad.Unidad;

import java.util.ArrayList;

public class Moho extends Tipo{

    public Moho(){
        tiposuperficie = TIPOSUPERFICIE.MOHO;
    }

    public void instalar(Edificio edificio){
        edificio.instalar(this);
    }

    public void crecer(Coordenada coor,Mapa mapa,int radio){

        ArrayList<Ubicacion> ubicaciones = mapa.buscar(coor,radio);
        for(int i = 0 ; i < ubicaciones.size() ; i++){
            ubicaciones.get(i).infectar();
        }
    }
    public void ubicar(Unidad unaUnidad){};
}
