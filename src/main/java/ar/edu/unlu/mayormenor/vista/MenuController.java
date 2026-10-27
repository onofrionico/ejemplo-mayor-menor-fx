package ar.edu.unlu.mayormenor.vista;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Controlador de la vista menu.fxml.
 * <p>
 * JavaFX crea esta clase al cargar el FXML, inyecta los campos {@code @FXML}
 * cuyo nombre coincide con un {@code fx:id} y conecta los {@code onAction="#metodo"}.
 */
public class MenuController {

    @FXML
    private Button btnJugar;

    @FXML
    private void onJugar(ActionEvent event) {
        System.out.println("Clic en Jugar");
    }
}
