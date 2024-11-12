import java.util.Scanner;

public class JuegoMemoria {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String[] palabras = {"sol", "luna", "estrella", "cielo", "mar", "montaña", "río", "nube", "flor", "árbol"};
    private static final String[] respuestas = new String[10];

    public static void main(String[] args) {
        memorizarPalabras();
        System.out.println("¡Felicidades! Has memorizado todas las palabras correctamente.");
        scanner.close();
    }

    private static void memorizarPalabras() {
        for (int i = 0; i < palabras.length; i++) {
            mostrarPalabra(i);
            guardarRespuesta(i);
            String entrada = pedirEntradaUsuario();
            if (!verificarRespuesta(i, entrada)) {
                reiniciarJuego();
                i = -1; // Reiniciar el juego
            } else {
                System.out.println("¡Correcto! Sigue a la siguiente palabra.\n");
            }
        }
    }

    private static void mostrarPalabra(int indice) {
        System.out.println("Palabra a memorizar: " + palabras[indice]);
    }

    private static void guardarRespuesta(int indice) {
        respuestas[indice] = palabras[indice];
    }

    private static String pedirEntradaUsuario() {
        System.out.print("Escribe todas las palabras memorizadas hasta ahora: ");
        return scanner.nextLine();
    }

    private static boolean verificarRespuesta(int indice, String entrada) {
    /*El StringBuilder en Java es una clase utilizada para construir cadenas de caracteres
    de manera eficiente. A diferencia de la clase String, que es inmutable (una vez creada
    , su valor no puede cambiar), StringBuilder permite modificar el contenido de la cadena
    sin crear nuevos objetos cada vez que se hace una modificación.

    En tu código, la línea StringBuilder correctas = new StringBuilder(); crea una instancia
    de StringBuilder llamada correctas. Esta instancia se utiliza para construir una cadena que
    contiene todas las palabras memorizadas hasta el momento de manera eficiente.*/
        StringBuilder correctas = new StringBuilder();
        for (int j = 0; j <= indice; j++) {
            correctas.append(respuestas[j]).append(" ");
        }
        boolean esCorrecto = entrada.equals(correctas.toString().trim());
        if (!esCorrecto) {
            System.out.println("¡Incorrecto! La secuencia era: " + correctas.toString().trim());
            System.out.println("Intenta de nuevo desde el inicio.");
        }
        return esCorrecto;
    }

    private static void reiniciarJuego() {
        System.out.println("Reiniciando el juego...");
    }
}





