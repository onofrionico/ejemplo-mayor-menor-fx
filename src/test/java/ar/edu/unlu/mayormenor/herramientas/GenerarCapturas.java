package ar.edu.unlu.mayormenor.herramientas;

import ar.edu.unlu.mayormenor.demos.DemoDialogos;
import ar.edu.unlu.mayormenor.demos.DemoEventos;
import ar.edu.unlu.mayormenor.demos.DemoLayouts;
import ar.edu.unlu.mayormenor.demos.DemoMenus;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.concurrent.CountDownLatch;

/**
 * Herramienta del equipo docente (no es un test): genera las capturas de pantalla
 * que usa el post de la autoguía, a partir del código real del repo.
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
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                listo.countDown();
            }
        });
        listo.await();
        Platform.exit();
    }

    static void capturar(Parent raiz, double ancho, double alto, String archivo) throws Exception {
        Scene scene = new Scene(raiz, ancho, alto);
        WritableImage imagen = scene.snapshot(null);
        File salida = new File(DESTINO, archivo);
        ImageIO.write(SwingFXUtils.fromFXImage(imagen, null), "png", salida);
        System.out.println("Captura: " + salida.getPath());
    }
}
