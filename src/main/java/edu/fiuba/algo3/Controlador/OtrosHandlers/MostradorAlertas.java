package edu.fiuba.algo3.Controlador.OtrosHandlers;

import edu.fiuba.algo3.modelo.ConstruccionFueraDelRangoPilonError;
import edu.fiuba.algo3.modelo.ConstruccionProtoEnMohoError;
import edu.fiuba.algo3.modelo.Edificio.CorrelativaDeConstruccionIncumplidaError;
import edu.fiuba.algo3.modelo.Edificio.EdificioNoOperativoError;
import edu.fiuba.algo3.modelo.Edificio.ExtractorCantidadMaximaDeZanganosError;
import edu.fiuba.algo3.modelo.NoSePuedeConstruirSobreElEspacioError;
import edu.fiuba.algo3.modelo.Raza.FinDelJuegoGanaronLosProtoss;
import edu.fiuba.algo3.modelo.Raza.FinDelJuegoGanaronLosZerg;
import edu.fiuba.algo3.modelo.Raza.PoblacionExedidaError;
import edu.fiuba.algo3.modelo.Recurso.RecursosInsuficientesError;
import edu.fiuba.algo3.modelo.Unidad.InsuficientesRecursosParaCrearUnidadError;
import edu.fiuba.algo3.modelo.Unidad.UnidadNoOperativaError;
import edu.fiuba.algo3.modelo.Unidad.UnidadNoVuelaError;
import edu.fiuba.algo3.modelo.tablero.UbicacionOcupadaError;
import javafx.scene.control.Alert;

import java.util.HashMap;

public class MostradorAlertas {
   private static HashMap<String,String> mensajesErrores;
   private static Alert alerta;

   static {
       mensajesErrores = new HashMap<>();
       alerta = new Alert(Alert.AlertType.ERROR);
       alerta.setTitle("Error");
       alerta.setHeaderText(null);
       mensajesErrores.put(ConstruccionFueraDelRangoPilonError.class.getName(), "Error la construcción  esta fuera del rango del pilon mas cercano");
       mensajesErrores.put(RecursosInsuficientesError.class.getName(), "Error recursos insuficientes para construir ");
       mensajesErrores.put(CorrelativaDeConstruccionIncumplidaError.class.getName(), "Error en la correlativa de construccion ");
       mensajesErrores.put(UnidadNoOperativaError.class.getName(), "Error La unidad todaiva no esta operativa ");
       mensajesErrores.put(UbicacionOcupadaError.class.getName(), "Error La ubicacion a la que quiere moverse esta ocupada ");
       mensajesErrores.put(EdificioNoOperativoError.class.getName(), "Error el edificio todavia no esta operativo ");
       mensajesErrores.put(ExtractorCantidadMaximaDeZanganosError.class.getName(), "Error El extractor tiene la maxima cantidad de zanganos");
       mensajesErrores.put( IndexOutOfBoundsException.class.getName(), "El criadero no tiene larvas");
       mensajesErrores.put(PoblacionExedidaError.class.getName(), "No ees posible, exceede la maxima población");
       mensajesErrores.put(InsuficientesRecursosParaCrearUnidadError.class.getName(), "Insuficientes recursos para crear la unidad ");
       mensajesErrores.put(FinDelJuegoGanaronLosProtoss.class.getName(),"Ganaron los Protoss.\n\n Haga click en aceptar para terminar el juego");
       mensajesErrores.put(FinDelJuegoGanaronLosZerg.class.getName(),"Ganaron los Zergs.\n\n Haga click en aceptar para terminar el juego");
       mensajesErrores.put(ConstruccionProtoEnMohoError.class.getName(),"No se puede construir por el Moho");
       mensajesErrores.put(NoSePuedeConstruirSobreElEspacioError.class.getName(),"No se puede construir en el espacio");
           mensajesErrores.put(UnidadNoVuelaError.class.getName(),"Unidades de tierra no pueden caminar sobre el espacio");
   }

   public static void mostrarAlerta(Exception e){
       if(mensajesErrores.containsKey(e.getClass().getName())){
           String mensaje = mensajesErrores.get(e.getClass().getName());
           mostrarAlerta(mensaje);
       }else{
           System.out.println("Error no registrado: " + e.getClass().getName());
           e.printStackTrace();
       }

   }

    public static void  mostrarAlerta(Exception e, String mensajeAConcatenar){
        if(mensajesErrores.containsKey(e.getClass().getName())){
            String mensaje = mensajesErrores.get(e.getClass().getName());
            mostrarAlerta(mensaje.concat(mensajeAConcatenar));
        }else{
            System.out.println("Error no registrado: " + e.getClass().getName());
            e.printStackTrace();
        }

    }

    static private void mostrarAlerta(String mensaje){
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
