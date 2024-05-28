package edu.fiuba.algo3.Controlador.OtrosHandlers;

import edu.fiuba.algo3.Vista.Botones.*;
import edu.fiuba.algo3.Vista.Botones.Construcciones.BotonCriadero;
import edu.fiuba.algo3.Vista.Botones.Construcciones.BotonEdificioPilon;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Criadero;
import edu.fiuba.algo3.modelo.IDEDIFICIO;
import edu.fiuba.algo3.modelo.TIPOSUPERFICIE;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.Unidad.*;
import edu.fiuba.algo3.modelo.tablero.Coordenada;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.io.File;

public class JuegoVista {
    private GridPane grPane;
    private JuegoModelo juegoModelo;
    private  final int MAPA_TAMANIO;

    private final int TAMANIO;

    private int cantTurnosZerg;
    private VBox vBoxMenu;


    public JuegoVista(JuegoModelo juegoModelo, VBox vBoxMenu){
        if(juegoModelo == null){
            System.out.println("HUBO ERROR");
        }
        grPane = new GridPane();
        this.juegoModelo = juegoModelo;
        MAPA_TAMANIO = this.juegoModelo.dimensionTablero();
        TAMANIO = (880/MAPA_TAMANIO) +1;
        cantTurnosZerg = 0;
        this.vBoxMenu = vBoxMenu;
    }

    public void iniciar(){
        //grPane.setBackground( new Background(new BackgroundFill( Color.rgb(65, 40, 27, 1) , CornerRadii.EMPTY, Insets.EMPTY) ) );
        for(int i = 0; i <= MAPA_TAMANIO; i++){
            for(int j = 0; j <= MAPA_TAMANIO; j++){
                try {
                    Ubicacion ubicacion = juegoModelo.buscar(new Coordenada(i,j));
                    if( !ubicacion.existeRecurso() && !ubicacion.existeEdificio() && (ubicacion.getTipoSuperficie() != TIPOSUPERFICIE.MOHO)){
                        BotonCeldaTablero botonSuperficie = new BotonTierra(TAMANIO,ubicacion,vBoxMenu,grPane,juegoModelo);
                        grPane.add(botonSuperficie, i, j);
                    } else if (ubicacion.existeRecurso() ){
                        agregarBotonRecurso(ubicacion, i, j, vBoxMenu);
                    } else if (ubicacion.existeEdificio() ){
                        agregarEdificioInicial(ubicacion, i, j, vBoxMenu);
                    } else if(ubicacion.existeUnidad()){
                        agregarUnidadInicial(ubicacion,i,j,vBoxMenu);
                    } else if ((ubicacion.getTipoSuperficie() == TIPOSUPERFICIE.MOHO)){
                        BotonCeldaTablero botonMoho = new BotonMoho(TAMANIO,ubicacion,vBoxMenu,grPane,juegoModelo);
                        grPane.add(botonMoho, i, j);
                    }

                } catch (Exception e){
                    System.out.println("Juego vista imprime error");
                    e.printStackTrace();

                }
            }
        }
        juegoModelo.notificarSobreJugadorActivo();
        grPane.setPrefSize(1000,950);
    }


    private void agregarBotonRecurso(Ubicacion ubicacion, int i , int j, VBox vBoxMenu) {
        BotonCeldaTablero botonRecurso;
        if( ubicacion.contieneNodoMineral() ){
            botonRecurso = new BotonRecursoMineral(TAMANIO,ubicacion,vBoxMenu,grPane, juegoModelo);
        }
        else{
            botonRecurso = new BotonRecursoVolcan(TAMANIO, ubicacion, vBoxMenu, grPane, juegoModelo);
        }
        grPane.add(botonRecurso,i,j);
    }

    private void agregarEdificioInicial(Ubicacion ubicacion, int i , int j, VBox vBoxMenu) {
        Edificio edificio = ubicacion.getEdificio();
        BotonCeldaTablero botonEdificio = null;

        if( edificio.getEntidad() == IDEDIFICIO.CRIADERO ){
            botonEdificio = new BotonCriadero(TAMANIO,ubicacion,vBoxMenu,juegoModelo.getJugador1(),grPane,juegoModelo);
            BotonCriadero botonCriadero = (BotonCriadero) botonEdificio;
            botonCriadero.setTooltipLarvasRestantes();
        }
        if( edificio.getEntidad() == IDEDIFICIO.PILON ){
            botonEdificio   = new BotonEdificioPilon(TAMANIO,ubicacion,vBoxMenu,grPane,juegoModelo);
        }

        grPane.add(botonEdificio, i, j );

    }


    public void agregarContenedor(AnchorPane contenedorMapa){
        contenedorMapa.getChildren().add(grPane);
    }

    public void agregarUnidadInicial(Ubicacion ubicacion,int i,int j,VBox vBoxMenu){
        //si es zangano cambia el vbox para que tenga las opciones de zangano
        Button botonUnidad;
        if(ubicacion.getUnidad() instanceof AmoSupremo){
            botonUnidad = new BotonGenerico(TAMANIO, "images/amosupremo.png", ubicacion);
            AmoSupremo unidad = (AmoSupremo) ubicacion.getUnidad();
            botonUnidad.setOnAction(new BotonAmoSupremoHandler(unidad, vBoxMenu));//falta como saber que raza esta jugando
        }
        if(ubicacion.getUnidad() instanceof Zangano){
            botonUnidad = new BotonGenerico(TAMANIO, "images/zangano.png", ubicacion);
            Zangano unidad = (Zangano) ubicacion.getUnidad();
            //botonUnidad.setOnAction(new BotonZanganoHandler(unidad, vBoxMenu,raza));//falta como saber que raza esta jugando
        }
        if(ubicacion.getUnidad() instanceof Zerling){
            botonUnidad = new BotonGenerico(TAMANIO, "images/zerling.png", ubicacion);
            Zerling unidad = (Zerling) ubicacion.getUnidad();
            botonUnidad.setOnAction(new BotonUnidadesGenericaHandler(unidad, vBoxMenu));//falta como saber que raza esta jugando
        }
        if(ubicacion.getUnidad() instanceof Hidralisco){
            botonUnidad = new BotonGenerico(TAMANIO, "images/hidralisco.png", ubicacion);
            Hidralisco unidad = (Hidralisco) ubicacion.getUnidad();
            botonUnidad.setOnAction(new BotonUnidadesGenericaHandler(unidad, vBoxMenu));//falta como saber que raza esta jugando
        }
        if(ubicacion.getUnidad() instanceof Mutalisco){
            botonUnidad = new BotonGenerico(TAMANIO, "images/mutalisco.png", ubicacion);
            Mutalisco unidad = (Mutalisco) ubicacion.getUnidad();
            //botonUnidad.setOnAction(new BotonMutaliscoHandler(unidad, vBoxMenu,raza));//falta como saber que raza esta jugando
        }
        if(ubicacion.getUnidad() instanceof Guardian){
            botonUnidad = new BotonGenerico(TAMANIO, "images/guardian.png", ubicacion);
            Guardian unidad = (Guardian) ubicacion.getUnidad();
            botonUnidad.setOnAction(new BotonUnidadesGenericaHandler(unidad, vBoxMenu));//falta como saber que raza esta jugando
        }
        if(ubicacion.getUnidad() instanceof Devorador){
            botonUnidad = new BotonGenerico(TAMANIO, "images/devorador.png", ubicacion);
            Devorador unidad = (Devorador) ubicacion.getUnidad();
            botonUnidad.setOnAction(new BotonUnidadesGenericaHandler(unidad, vBoxMenu));//falta como saber que raza esta jugando
        }
        if(ubicacion.getUnidad() instanceof Zealot){
            botonUnidad = new BotonGenerico(TAMANIO, "images/zealot.png", ubicacion);
            Zealot unidad = (Zealot) ubicacion.getUnidad();
            botonUnidad.setOnAction(new BotonUnidadesGenericaHandler(unidad, vBoxMenu));//falta como saber que raza esta jugando
        }
        if(ubicacion.getUnidad() instanceof Dragon){
            botonUnidad = new BotonGenerico(TAMANIO, "images/dragon.png", ubicacion);
            Dragon unidad = (Dragon) ubicacion.getUnidad();
            botonUnidad.setOnAction(new BotonUnidadesGenericaHandler(unidad, vBoxMenu));//falta como saber que raza esta jugando
        }
        if(ubicacion.getUnidad() instanceof Scout){
            botonUnidad = new BotonGenerico(TAMANIO, "images/scout.png", ubicacion);
            Scout unidad = (Scout) ubicacion.getUnidad();
            botonUnidad.setOnAction(new BotonUnidadesGenericaHandler(unidad, vBoxMenu));//falta como saber que raza esta jugando
        }
        //si es mutalisco cambia el vbox para que tenga las opciones de mutalisco
        //si es amo supremo cambia el vbox para que tenga nada
        //si es otra cosa cambia a generico

    }

    private Node findNodoDelGridPane(int posX, int posY) {
        for (Node node : grPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == posX && GridPane.getRowIndex(node) == posY) {
                return node;
            }
        }
        return null;
    }

    public void cambiarHandlerSuperficieActualZerg() {
        cantTurnosZerg++;
        for(int i = 0; i <= MAPA_TAMANIO; i++){
            for(int j = 0; j<= MAPA_TAMANIO; j++){
                Ubicacion ubicacion = juegoModelo.buscar(new Coordenada(i,j));
                if( ubicacion.existeEdificio() && ubicacion.getEdificio().getEntidad() == IDEDIFICIO.CRIADERO ){
                    ubicacion.crecer(cantTurnosZerg + 5, juegoModelo.getMapa());
                }
                if((juegoModelo.buscar(new Coordenada(i,j)).getTipoSuperficie() == TIPOSUPERFICIE.MOHO && juegoModelo.buscar(new Coordenada(i,j)).ubicacionVacia())){
                    if(findNodoDelGridPane(i,j).getClass() == BotonTierra.class){
                        BotonTierra botonTierra = (BotonTierra) findNodoDelGridPane(i,j);
                        botonTierra.borrarBotonDelTablero();
                        BotonMoho botonMoho = new BotonMoho(botonTierra);
                        grPane.add(botonMoho, i, j);
                    }
                }
            }
        }
    }

    public void ganaronLosProtoss(Button btnTerminarTurno){
        btnTerminarTurno.setText("Salir");
        btnTerminarTurno.setOnAction(new BotonSalirHandler(btnTerminarTurno));
        vBoxMenu.getChildren().clear();
        grPane.getChildren().clear();
        File fileFondo = new File("images/ganoprotoss.png");

        BackgroundImage primerBackGro = new BackgroundImage(new Image(fileFondo.toURI().toString(),
                1200, 675,true,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        grPane.setBackground(new Background(primerBackGro));
        Button salir = new Button("Salir");
        salir.setOnAction(new BotonSalirHandler(salir));
        vBoxMenu.getChildren().add(salir);

    }

    public void ganaronLosZerg(Button btnTerminarTurno){
        btnTerminarTurno.setText("Salir");
        btnTerminarTurno.setOnAction(new BotonSalirHandler(btnTerminarTurno));
        vBoxMenu.getChildren().clear();
        grPane.getChildren().clear();
        File fileFondo = new File("images/ganozergs.png");

        BackgroundImage primerBackGro = new BackgroundImage(new Image(fileFondo.toURI().toString(),
                1200, 675,true,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        grPane.setBackground(new Background(primerBackGro));
        Button salir = new Button("Salir");
        salir.setOnAction(new BotonSalirHandler(salir));
        vBoxMenu.getChildren().add(salir);

    }
}
