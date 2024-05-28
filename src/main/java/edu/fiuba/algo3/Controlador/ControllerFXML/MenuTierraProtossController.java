package edu.fiuba.algo3.Controlador.ControllerFXML;

import edu.fiuba.algo3.Controlador.OtrosHandlers.MostradorAlertas;
import edu.fiuba.algo3.Vista.Botones.BotonTierra;
import edu.fiuba.algo3.Vista.Botones.Construcciones.BotonAcceso;
import edu.fiuba.algo3.Vista.Botones.Construcciones.BotonEdificioPilon;
import edu.fiuba.algo3.Vista.Botones.Construcciones.BotonPuertoEstelar;
import edu.fiuba.algo3.modelo.Edificio.CorrelativaDeConstruccionIncumplidaError;
import edu.fiuba.algo3.modelo.Edificio.Protoss.Acceso;
import edu.fiuba.algo3.modelo.Edificio.Protoss.Pilon;
import edu.fiuba.algo3.modelo.Edificio.Protoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.NoSePuedeConstruirSobreElEspacioError;
import edu.fiuba.algo3.modelo.Raza.RazaProtoss;
import edu.fiuba.algo3.modelo.Recurso.RecursosInsuficientesError;
import edu.fiuba.algo3.modelo.tablero.Mapa;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class MenuTierraProtossController {

    @FXML
    public AnchorPane contenerdorMenu;

    private GridPane tablero;
    private Ubicacion ubicacion;
    private RazaProtoss razaProtoss;
    private BotonTierra botonTierra;
    private Mapa mapa;


    @FXML
    public void onClickedConstruirAcceso(MouseEvent event) {
        try{
            Acceso acceso = new Acceso(ubicacion);
            razaProtoss.agregarEdificio(acceso);
            botonTierra.borrarBotonDelTablero();
            tablero.add(new BotonAcceso(botonTierra),ubicacion.coordenada().horizontal(),ubicacion.coordenada().vertical());
        } catch ( RecursosInsuficientesError e ){
            MostradorAlertas.mostrarAlerta(e,"un Acceso");
            ubicacion.desalojar();
        } catch (Exception e){
            MostradorAlertas.mostrarAlerta(e);
            ubicacion.desalojar();
        }
    }

    @FXML
    public void onClickedConstruirPilon(MouseEvent event) {
        Pilon pilon = new Pilon();
        try {
            razaProtoss.agregarEdificio(pilon);
            ubicacion.ubicar(pilon);
            botonTierra.borrarBotonDelTablero();
            tablero.add(new BotonEdificioPilon(botonTierra),ubicacion.coordenada().horizontal(),ubicacion.coordenada().vertical());
        }catch ( RecursosInsuficientesError e ) {
            MostradorAlertas.mostrarAlerta(e,"un Pilon");
            ubicacion.desalojar();
        } catch (Exception e){
            MostradorAlertas.mostrarAlerta(e);
            ubicacion.desalojar();
        }
    }


    @FXML
    public void onClickedConstruirPuertoEstelar(MouseEvent event) {
        try{
            PuertoEstelar puertoEstelar = new PuertoEstelar(ubicacion);
            razaProtoss.agregarEdificio(puertoEstelar);
            botonTierra.borrarBotonDelTablero();
            tablero.add(new BotonPuertoEstelar(botonTierra),ubicacion.coordenada().horizontal(),ubicacion.coordenada().vertical());
        }
        catch (CorrelativaDeConstruccionIncumplidaError e ){
            MostradorAlertas.mostrarAlerta(e,"Necesitas un Acceso para construir");
            ubicacion.desalojar();
        }catch ( RecursosInsuficientesError e ) {
            MostradorAlertas.mostrarAlerta(e,"un Puerto Estelar");
            ubicacion.desalojar();
        } catch( Exception e){
            MostradorAlertas.mostrarAlerta(e);
            ubicacion.desalojar();
        }

    }

    public void setElements(GridPane tablero, Ubicacion ubicacion, RazaProtoss razaProtoss, BotonTierra botonTierra, Mapa mapa) {
        this.tablero = tablero;
        this.ubicacion =ubicacion;
        this.botonTierra = botonTierra;
        this.razaProtoss = razaProtoss;
        this.mapa = mapa;
    }
}
