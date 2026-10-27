package ar.edu.unlu.mayormenor.herramientas;

import ar.edu.unlu.mayormenor.controlador.Controlador;
import ar.edu.unlu.mayormenor.demos.DemoDialogos;
import ar.edu.unlu.mayormenor.demos.DemoEventos;
import ar.edu.unlu.mayormenor.demos.DemoLayouts;
import ar.edu.unlu.mayormenor.demos.DemoMenus;
import ar.edu.unlu.mayormenor.modelo.Carta;
import ar.edu.unlu.mayormenor.modelo.Mazo;
import ar.edu.unlu.mayormenor.modelo.Partida;
import ar.edu.unlu.mayormenor.vista.VistaGrafica;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static ar.edu.unlu.mayormenor.modelo.Palo.*;

/**
 * Herramienta del equipo docente (no es un test): genera las capturas de pantalla
 * que usa el post de la autoguía, a partir del código real del repo.
 * Para las pantallas del juego arma el MVC completo con un mazo fijo y "hace clic"
 * con {@code Button.fire()}, así también sirve como prueba de humo de la interfaz.
 * <p>
 * ./mvnw test-compile exec:java -Dexec.mainClass=ar.edu.unlu.mayormenor.herramientas.GenerarCapturas -Dexec.classpathScope=test
 * <p>
 * Las imágenes quedan en target/capturas/.
 */
public class GenerarCapturas {

    private static final File DESTINO = new File("target/capturas");

    public static void main(String[] args) throws Exception {
        DESTINO.mkdirs();
        CountDownLatch listo = new CountDownLatch(1);
        Platform.startup(() -> {
            try {
                capturar(DemoLayouts.crearRaiz(), 520, 420, "demo-layouts.png");
                capturar(DemoMenus.crearRaiz(), 420, 250, "demo-menus.png");
                capturar(new DemoEventos().crearRaiz(), 380, 280, "demo-eventos.png");
                capturar(DemoDialogos.crearRaiz(), 320, 380, "demo-dialogos.png");
                capturarJuego();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                listo.countDown();
            }
        });
        listo.await();
        Platform.exit();
    }

    private static void capturarJuego() throws Exception {
        Partida modelo = new Partida(() -> new Mazo(List.of(
                new Carta(5, ORO), new Carta(11, ESPADA), new Carta(3, COPA), new Carta(7, BASTO))));
        Controlador controlador = new Controlador(modelo);
        Stage stage = new Stage();
        VistaGrafica vista = new VistaGrafica(stage, controlador);
        controlador.setVista(vista);

        vista.mostrarMenu();
        guardar(stage, "juego-menu.png");

        clic(stage, "#btnJugar");      // menú → mesa con el 5 de oros
        clic(stage, "#btnMayor");      // 11 de espadas: acierto
        guardar(stage, "juego-mesa.png");

        clic(stage, "#btnMayor");      // 3 de copas: error → pantalla de resultado
        guardar(stage, "juego-resultado.png");

        clic(stage, "#btnJugarDeNuevo"); // vuelve a la mesa con puntaje 0
        Label puntaje = (Label) stage.getScene().lookup("#lblPuntaje");
        if (!"Puntaje: 0".equals(puntaje.getText())) {
            throw new IllegalStateException("Jugar de nuevo no reinició el puntaje: " + puntaje.getText());
        }
        clic(stage, "#btnMenor");      // 11 de espadas: error
        clic(stage, "#btnVolver");     // vuelve al menú
        if (stage.getScene().lookup("#btnJugar") == null) {
            throw new IllegalStateException("Volver al menú no mostró el menú");
        }
        stage.close();
    }

    private static void clic(Stage stage, String selector) {
        Button boton = (Button) stage.getScene().lookup(selector);
        if (boton == null) {
            throw new IllegalStateException("No se encontró " + selector);
        }
        boton.fire();
    }

    private static void capturar(Parent raiz, double ancho, double alto, String archivo) throws Exception {
        escribir(new Scene(raiz, ancho, alto).snapshot(null), archivo);
    }

    private static void guardar(Stage stage, String archivo) throws Exception {
        escribir(stage.getScene().snapshot(null), archivo);
    }

    private static void escribir(WritableImage imagen, String archivo) throws Exception {
        File salida = new File(DESTINO, archivo);
        ImageIO.write(SwingFXUtils.fromFXImage(imagen, null), "png", salida);
        System.out.println("Captura: " + salida.getPath());
    }
}
