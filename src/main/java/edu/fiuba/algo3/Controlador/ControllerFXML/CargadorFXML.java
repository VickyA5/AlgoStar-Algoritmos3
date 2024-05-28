package edu.fiuba.algo3.Controlador.ControllerFXML;

import edu.fiuba.algo3.Controlador.OtrosHandlers.RUTAS_FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.HashMap;

public class CargadorFXML {
    static public HashMap<RUTAS_FXML,String> MAP_RUTAS_FXML;

    static{
        MAP_RUTAS_FXML = new HashMap<>();
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_VACIO, "/VistaFxml/Menus/MenuVacio.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.INTERFACE_JUEGO, "/VistaFxml/interfazJuego.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_CRIADERO, "/VistaFxml/Menus/EdificioZerg/MenuCriadero.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_PILON, "/VistaFxml/Menus/EdificioProtoss/MenuPilon.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_NODO_MINERAL_PROTOSS, "/VistaFxml/Menus/NodoMineral/MenuNodoMineralProtoss.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_NODO_MINERAL_ZERG, "/VistaFxml/Menus/NodoMineral/MenuNodoMineralZerg.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_VOLCAN_PROTOSS, "/VistaFxml/Menus/Volcan/MenuVolcanProtoss.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_VOLCAN_ZERG, "/VistaFxml/Menus/Volcan/MenuVolcanZerg.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_TIERRA_PROTOSS, "/VistaFxml/Menus/Tierra/MenuTierraProtoss.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_TIERRA_ZERG, "/VistaFxml/Menus/Tierra/MenuTierraZerg.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_ACCESO, "/VistaFxml/Menus/EdificioProtoss/MenuAcceso.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_EXTRACTOR, "/VistaFxml/Menus/EdificioZerg/MenuExtractor.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_ASIMILADOR, "/VistaFxml/Menus/EdificioProtoss/MenuAsimilador.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_ATACAR_ENEMIGO, "/VistaFxml/Menus/MenuAtacarEnemigo.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_MOHO_ZERG, "/VistaFxml/Menus/Moho/MenuMohoZerg.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_MOHO_PROTOSS, "/VistaFxml/Menus/Moho/MenuMohoProtoss.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_ZANGANO, "/VistaFxml/Menus/UnidadesZerg/MenuZangano.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_ZEALOT, "/VistaFxml/Menus/UnidadesProtoss/MenuZealot.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_DRAGON, "/VistaFxml/Menus/UnidadesProtoss/MenuDragon.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_SCOUT, "/VistaFxml/Menus/UnidadesProtoss/MenuScout.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_NEXO_MINERAL, "/VistaFxml/Menus/EdificioProtoss/MenuNexoMineral.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_EN_CONSTRUCCION, "/VistaFxml/Menus/MenuEnConstruccion.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_RESERVA_DE_REPRODUCCION, "/VistaFxml/Menus/EdificioZerg/MenuReservaDeReproduccion.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_GUARIDA, "/VistaFxml/Menus/EdificioZerg/MenuGuarida.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_UNIDAD, "/VistaFxml/Menus/MenuUnidad.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_ESPIRAL, "/VistaFxml/Menus/EdificioZerg/MenuEspiral.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_PUERTO_ESTELAR, "/VistaFxml/Menus/EdificioProtoss/MenuPuertoEstelar.fxml");
        MAP_RUTAS_FXML.put(RUTAS_FXML.MENU_MUTALISCO, "/VistaFxml/Menus/UnidadesZerg/MenuMutalisco.fxml");

    }


    public static Pane prepararLayout(FXMLLoader fxmlLoader){
        Pane pane = null;
        try {
            pane = fxmlLoader.load();
        }catch (IOException e){
            e.printStackTrace();
        }

        return pane;
    }
}
