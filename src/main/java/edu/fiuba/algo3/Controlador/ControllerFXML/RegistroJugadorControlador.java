package edu.fiuba.algo3.Controlador.ControllerFXML;

import edu.fiuba.algo3.modelo.Juego.*;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Raza.RazaProtoss;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class RegistroJugadorControlador  implements Initializable {

    @FXML
    public Button btnContinuar;

    @FXML
    public ComboBox<Color> cmbColor;

    @FXML
    public Label lblTitle;

    @FXML
    public ToggleGroup tgRaza;

    @FXML
    public TextField txtNombre;

    private JuegoModelo juegoModelo;

    private HashMap<String,Raza> razas;

    public RegistroJugadorControlador(){
        razas = new HashMap<String, Raza>();
        razas.put("Protoss",new RazaProtoss());
        razas.put("Zerg",new RazaZerg());
    }

    @FXML
    public void onPressContinuar(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        if(txtNombre.equals("") || cmbColor.getSelectionModel().getSelectedItem() == null || tgRaza.getSelectedToggle() == null){
            alert.setContentText("Complete todos los campos del formulario");
            alert.showAndWait();
            return;
        }
        agregarJugador(alert);

    }

    public void setearJuego( JuegoModelo unJuegoModelo) {
        this.juegoModelo = unJuegoModelo;
        lblTitle.setText(lblTitle.getText()+" "+ juegoModelo.cantidadJugadores());
    }

    private void agregarJugador(Alert alert){

        String errorMensaje = "";
        RadioButton radioButtonSelected = (RadioButton) tgRaza.getSelectedToggle();

        try{
            Jugador jugadorNuevo = new Jugador(txtNombre.getText(),cmbColor.getSelectionModel().getSelectedItem().toString(),razas.get(radioButtonSelected.getText()));
            juegoModelo.agregarJugador(jugadorNuevo);
            limpiarCampos();
        } catch ( JugadorMismaRazaError e){
            errorMensaje = "Error el Jugador 1 Tiene la misma raza";
        } catch ( JugadorMismoNombreError e){
            errorMensaje = "Error el Jugador 1 Tiene el mismo nombre";
        } catch (JugadorMismoColorError e){
            errorMensaje = "Error el Jugador 1 Tiene el mismo color";
        } catch (JugadorNombreError e){
            errorMensaje = "El nombre del jugador tiene que tener mas de 6 caracteres";
        }
        if(!errorMensaje.equals("")){
            alert.setContentText(errorMensaje);
            alert.showAndWait();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Color> list = FXCollections.observableArrayList(Color.values());
        cmbColor.setItems(list);
        //cmbColor.getItems().addAll(Color.values());
        cmbColor.setOnAction(event -> {
            //System.out.println(cmbColor.getSelectionModel().getSelectedItem().toString());
        });
    }

    private void limpiarCampos(){
        txtNombre.clear();
        //String text = cmbColor.getPromptText();
        cmbColor.getSelectionModel().clearSelection();
        tgRaza.selectToggle(null);
    }
}
