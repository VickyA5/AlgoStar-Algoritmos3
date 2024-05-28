package edu.fiuba.algo3.Controlador.ControllerFXML;

import edu.fiuba.algo3.Controlador.OtrosHandlers.MostradorAlertas;
import edu.fiuba.algo3.Vista.Botones.BotonMoho;
import edu.fiuba.algo3.Vista.Botones.Construcciones.*;
import edu.fiuba.algo3.modelo.Edificio.CorrelativaDeConstruccionIncumplidaError;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Espiral;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Guarida;
import edu.fiuba.algo3.modelo.Edificio.Zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import edu.fiuba.algo3.modelo.Recurso.RecursosInsuficientesError;
import edu.fiuba.algo3.modelo.tablero.Mapa;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class MenuMohoZergController {

    @FXML
    public AnchorPane contenerdorMenu;
    private GridPane tablero;
    private Ubicacion ubicacion;
    private RazaZerg razaZerg;
    private BotonMoho botonMoho;
    private Mapa mapa;


    @FXML
    public void onClickedConstruirGuarida(MouseEvent event) {
        try{
            Guarida guarida = new Guarida();
            razaZerg.agregarEdificio(guarida);
            ubicacion.ubicar(guarida);
            botonMoho.borrarBotonDelTablero();
            tablero.add(new BotonGuarida(botonMoho),ubicacion.coordenada().horizontal(),ubicacion.coordenada().vertical());
        } catch ( RecursosInsuficientesError e ){
            MostradorAlertas.mostrarAlerta(e,"una Guarida");
        } catch (CorrelativaDeConstruccionIncumplidaError e){
            MostradorAlertas.mostrarAlerta(e,"Necesitas una Reserva de Reproduccion para construir");
        } catch (Exception e){
            MostradorAlertas.mostrarAlerta(e);
        }
    }

    @FXML
    public void onClickedConstruirEspiral(MouseEvent event) {
        Espiral espiral = new Espiral();
        try {
            razaZerg.agregarEdificio(espiral);
            ubicacion.ubicar(espiral);
            botonMoho.borrarBotonDelTablero();
            tablero.add(new BotonEspiral(botonMoho),ubicacion.coordenada().horizontal(),ubicacion.coordenada().vertical());
        }catch ( RecursosInsuficientesError e ) {
            MostradorAlertas.mostrarAlerta(e,"un Espiral");
        } catch (CorrelativaDeConstruccionIncumplidaError e){
            MostradorAlertas.mostrarAlerta(e,"Necesitas una Guarida para construir");
        } catch (Exception e){
            MostradorAlertas.mostrarAlerta(e);
        }
    }


    @FXML
    public void onClickedConstruirReservaDeReproduccion(MouseEvent event) {
        try{
            ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion();
            razaZerg.agregarEdificio(reservaDeReproduccion);
            ubicacion.ubicar(reservaDeReproduccion);
            botonMoho.borrarBotonDelTablero();
            tablero.add(new BotonReservaDeReproduccion(botonMoho),ubicacion.coordenada().horizontal(),ubicacion.coordenada().vertical());
        } catch (RecursosInsuficientesError e) {
            MostradorAlertas.mostrarAlerta(e,"una Reserva De Reproduccion");
        } catch( Exception e){
            MostradorAlertas.mostrarAlerta(e);
        }



    }

    public void setElements(GridPane tablero, Ubicacion ubicacion, RazaZerg razaZerg, BotonMoho botonMoho, Mapa mapa) {
        this.tablero = tablero;
        this.ubicacion =ubicacion;
        this.botonMoho = botonMoho;
        this.razaZerg = razaZerg;
        this.mapa = mapa;
    }
}
