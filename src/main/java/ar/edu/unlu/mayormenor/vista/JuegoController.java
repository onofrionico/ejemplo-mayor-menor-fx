package ar.edu.unlu.mayormenor.vista;

import ar.edu.unlu.mayormenor.controlador.Controlador;
import ar.edu.unlu.mayormenor.modelo.Apuesta;
import ar.edu.unlu.mayormenor.modelo.Carta;
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

    private Controlador controlador;

    /** JavaFX llama a este método después de inyectar los campos @FXML. */
    @FXML
    private void initialize() {
        imgCarta.setImage(ImagenesCartas.reverso());
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    /** Lo llama la VistaGrafica cuando el modelo avisó que hay una carta nueva. */
    public void mostrarCarta(Carta carta, int puntaje, int restantes) {
        imgCarta.setImage(ImagenesCartas.imagen(carta));
        lblPuntaje.setText("Puntaje: " + puntaje);
        lblRestantes.setText("Quedan: " + restantes);
    }

    // Los botones NO tocan la vista: solo le avisan al Controlador.
    // La carta cambia cuando el modelo notifica (Observer).

    @FXML
    private void onMayor() {
        controlador.apostar(Apuesta.MAYOR);
    }

    @FXML
    private void onMenor() {
        controlador.apostar(Apuesta.MENOR);
    }
}
