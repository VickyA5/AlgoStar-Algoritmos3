package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Vista.Botones.Construcciones.BotonCriadero;
import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Atacante;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Criadero;
import edu.fiuba.algo3.modelo.Unidad.Unidad;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;

public class BotonAtacable extends Button  {

    private Atacante atacante;
    private Atacable atacable;

    public BotonAtacable(String rutaImagen, Atacable atacable, Atacante atacante){
        File fileImagen = new File( rutaImagen);
        Image imagenGenerica = new Image(fileImagen.toURI().toString(), 50, 50, true, true );
        this.setMinSize(30,30);
        this.setGraphic( new ImageView(imagenGenerica) );
        this.atacable = atacable;
        this.atacante = atacante;
    }

    public void setTooltipVidaYEscudoRestante(){
        BotonAtacable boton = this;
        this.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(atacable.ubicacion().existeUnidad() ){
                    Unidad unidad = atacable.ubicacion().getUnidad();
                    boton.setTooltip(new Tooltip("Vida : " + unidad.getVida()  + "\n" + "Escudo: " + unidad.getEscudo() ) );
                }
                if(atacable.ubicacion().existeEdificio()){
                    Edificio edificio = atacable.ubicacion().getEdificio();
                    boton.setTooltip(new Tooltip("Vida : " + edificio.getVida() + "\n"  + "Escudo: " + edificio.getEscudo() ) );
                }
            }
        }
        );
    }

}
