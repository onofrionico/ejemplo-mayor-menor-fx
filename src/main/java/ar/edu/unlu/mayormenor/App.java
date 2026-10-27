package ar.edu.unlu.mayormenor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Punto de entrada de la aplicacion JavaFX.
 * <p>
 * JavaFX llama a {@link #start(Stage)} y nos entrega la primera ventana ({@code Stage}).
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // FXMLLoader lee el archivo, crea el controlador, inyecta los @FXML y devuelve el nodo raíz.
        // La ruta empieza con "/" porque es relativa a src/main/resources.
        Parent raiz = FXMLLoader.load(getClass().getResource("/fxml/menu.fxml"));
        stage.setTitle("Mayor o Menor");
        stage.setScene(new Scene(raiz));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
