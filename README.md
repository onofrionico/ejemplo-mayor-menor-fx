# Mayor o Menor — ejemplo JavaFX para POO UNLu

Juego de cartas de ejemplo para la **autoguía de la Clase 11** de Programación Orientada a Objetos (UNLu): cómo pasar de un modelo ya armado a una interfaz gráfica con **JavaFX + FXML**, aplicando **MVC** y **Observer**.

Se muestra una carta del mazo español; apostás si la siguiente va a ser **mayor** o **menor**. Si acertás sumás un punto; si fallás (o sale una carta del mismo número) se termina la partida. Si se acaba el mazo, ganaste.

## Requisitos

- JDK 17 o superior (recomendado: **JDK 21**).
- No hace falta instalar Maven ni descargar JavaFX: el proyecto trae el *Maven Wrapper* (`mvnw`) y Maven baja JavaFX solo.

## Cómo correrlo

```bash
./mvnw javafx:run
```

En Windows (cmd / PowerShell): `mvnw.cmd javafx:run`.

Desde IntelliJ: abrí la carpeta como proyecto Maven y ejecutá la clase `Lanzador`.

## Créditos de imágenes

- **Cartas** (`src/main/resources/img/cartas/`): mazo de Heraclio Fournier de 1878, de Ignacio Díaz Olano, Heraclio Fournier González y Emilio Soubrier. **Dominio público.** Fuente: [Wikimedia Commons — Heraclio Fournier’s 1878 card deck](https://commons.wikimedia.org/wiki/Category:Heraclio_Fournier%E2%80%99s_1878_card_deck). Reducidas a 200 px de ancho y renombradas (`espada-1.png`, `reverso.png`, ...).
- **Íconos** de los botones (`src/main/resources/img/iconos/`): generados por el equipo docente de la asignatura.
