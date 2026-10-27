package ar.edu.unlu.mayormenor.vista;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controlador de la vista menu.fxml.
 * <p>
 * JavaFX crea esta clase al cargar el FXML, inyecta los campos {@code @FXML}
 * cuyo nombre coincide con un {@code fx:id} y conecta los {@code onAction="#metodo"}.
 */
public class MenuController {

    @FXML
    private Button btnJugar;

    /**
     * ATAJO PROVISORIO: el controlador de la vista cambia de escena por su cuenta.
     * En el paso 4 esto pasa a manos del Controlador MVC y de VistaGrafica.
     */
    @FXML
    private void onJugar(ActionEvent event) throws IOException {
        Parent mesa = FXMLLoader.load(getClass().getResource("/fxml/juego.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(mesa));
    }
}
