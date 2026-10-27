package ar.edu.unlu.mayormenor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Punto de entrada de la aplicacion JavaFX.
 * <p>
 * JavaFX llama a {@link #start(Stage)} y nos entrega la primera ventana ({@code Stage}).
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Label mensaje = new Label("¡JavaFX funciona!");
        StackPane raiz = new StackPane(mensaje);
        stage.setTitle("Mayor o Menor");
        stage.setScene(new Scene(raiz, 400, 300));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
