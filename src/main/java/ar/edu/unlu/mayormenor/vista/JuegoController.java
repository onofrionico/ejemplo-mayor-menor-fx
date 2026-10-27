package ar.edu.unlu.mayormenor.vista;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * Controlador de la vista juego.fxml (la mesa).
 * <p>
 * Los botones con imagen están armados en el FXML. En código sería:
 * <pre>
 * ImageView icono = new ImageView(new Image(getClass().getResource("/img/iconos/mayor.png").toExternalForm()));
 * icono.setFitWidth(24);
 * icono.setPreserveRatio(true);
 * Button btnMayor = new Button("Mayor", icono);   // texto + "graphic"
 * </pre>
 */
public class JuegoController {

    @FXML
    private ImageView imgCarta;
    @FXML
    private Label lblPuntaje;
    @FXML
    private Label lblRestantes;
    @FXML
    private Button btnMayor;
    @FXML
    private Button btnMenor;

    /** JavaFX llama a este método después de inyectar los campos @FXML. */
    @FXML
    private void initialize() {
        imgCarta.setImage(ImagenesCartas.reverso());
    }

    @FXML
    private void onMayor() {
        System.out.println("Clic en Mayor");
    }

    @FXML
    private void onMenor() {
        System.out.println("Clic en Menor");
    }
}
