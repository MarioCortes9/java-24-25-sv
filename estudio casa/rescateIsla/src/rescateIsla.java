

/* Eres un capitán de un barco que debe rescatar
a un náufrago en una isla de 10x10. El barco ('B')
se mueve por el mar en busca del náufrago ('N').
Sin embargo, hay varios arrecifes ('A') que no puedes
atravesar. Tienes un límite de 15 movimientos para
encontrar al náufrago y salvarlo. Si lo encuentras antes
de que se acaben los movimientos, ganas el juego; de lo
contrario, pierdes.

Reglas:
-El barco ('B') empieza en una posición aleatoria del tablero.
-Hay un solo náufrago ('N') en una ubicación aleatoria.
-Hay 7 arrecifes ('A') que representan obstáculos, colocados
de manera aleatoria.
-El jugador puede mover el barco usando las teclas W (arriba),
A (izquierda), S (abajo), D (derecha).
-Si el barco encuentra al náufrago, gana el juego.
-Si choca con un arrecife, pierde un movimiento pero no avanza.
-El barco no puede salirse del tablero.
Objetivo:
-Rescatar al náufrago antes de que se acaben los 15 movimientos.


*/

import java.util.Random;
import java.util.Scanner;

public class rescateIsla {

    private static final int MAX_DIMENSION = 10; // Dimensión del tablero
    private static char[][] tablero; // Tablero del juego
    private static int movimientos = 15; // Movimientos disponibles
    private static int filaBarco, columnaBarco; // Posición del barco
    private static int filaNaufrago, columnaNaufrago; // Posición del náufrago
    private static Random aleatorio = new Random(); // Generador aleatorio

    // Aquí almacenamos todas las funciones
    public static void main(String[] args) {
        tablero = new char[MAX_DIMENSION][MAX_DIMENSION]; // Inicializa el tablero
        inicializarTablero();
        colocarNaufrago();
        colocarArrecifes(7);
        colocarBarco();

        juego(); // Inicia el juego

        Scanner leer = new Scanner(System.in); // Inicia el escáner
    }

    // INICIALIZAMOS TABLERO
    private static void inicializarTablero() {
        for (int i = 0; i < MAX_DIMENSION; i++) {
            for (int j = 0; j < MAX_DIMENSION; j++) {
                tablero[i][j] = ' '; // Llena el tablero con espacios vacíos
            }
        }
    }

    // COLOCAMOS NAUFRAGO
    private static void colocarNaufrago() {
        filaNaufrago = aleatorio.nextInt(MAX_DIMENSION);
        columnaNaufrago = aleatorio.nextInt(MAX_DIMENSION);
        tablero[filaNaufrago][columnaNaufrago] = 'N'; // Marca la posición del náufrago
    }

    // COLOCAMOS ARRECIFES
    private static void colocarArrecifes(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            int filaArrecife, columnaArrecife;
            do {
                filaArrecife = aleatorio.nextInt(MAX_DIMENSION);
                columnaArrecife = aleatorio.nextInt(MAX_DIMENSION);
            } while (tablero[filaArrecife][columnaArrecife] != ' '); // Evita colocar arrecifes en lugares ocupados
            tablero[filaArrecife][columnaArrecife] = 'A'; // Coloca arrecife
        }
    }

    // COLOCAMOS EL BARCO
    private static void colocarBarco() {
        do {
            filaBarco = aleatorio.nextInt(MAX_DIMENSION);
            columnaBarco = aleatorio.nextInt(MAX_DIMENSION);
        } while (tablero[filaBarco][columnaBarco] != ' '); // Evita colocar el barco en lugares ocupados
        tablero[filaBarco][columnaBarco] = 'B'; // Coloca el barco
    }

    // IMPRIME EL TABLERO
    private static void mostrarTablero() {
        for (int i = 0; i < MAX_DIMENSION; i++) {
            for (int j = 0; j < MAX_DIMENSION; j++) {
                System.out.print(tablero[i][j] + " "); // Imprime cada fila de forma correcta
            }
            System.out.println(); // Nueva línea al final de cada fila
        }
    }

    // MOVER BARCO (W: arriba, A: izquierda, S: abajo, D: derecha)
    private static boolean moverBarco(String direccion) {
        int nuevaFila = filaBarco, nuevaColumna = columnaBarco;

        // Mover el barco según la dirección
        switch (direccion) {
            case "W":
                nuevaFila--;
                break; // Mover arriba
            case "A":
                nuevaColumna--;
                break; // Mover izquierda
            case "S":
                nuevaFila++;
                break; // Mover abajo
            case "D":
                nuevaColumna++;
                break; // Mover derecha
            default:
                return false; // Movimiento inválido
        }

        // Verificar si el movimiento está dentro del tablero
        if (nuevaFila < 0 || nuevaFila >= MAX_DIMENSION || nuevaColumna < 0 || nuevaColumna >= MAX_DIMENSION) {
            System.out.println("¡Movimiento fuera del tablero!");
            return false;
        }

        // Verificar si choca con un arrecife
        if (tablero[nuevaFila][nuevaColumna] == 'A') {
            System.out.println("¡Chocaste con un arrecife!");
            return true; // No avanza, pero cuenta como movimiento
        }

        // Actualizar la posición del barco en el tablero
        tablero[filaBarco][columnaBarco] = ' '; // Limpia la posición anterior
        filaBarco = nuevaFila;
        columnaBarco = nuevaColumna;
        tablero[filaBarco][columnaBarco] = 'B'; // Coloca el barco en la nueva posición

        return true; // Movimiento válido
    }

    // BUCLE DEL JUEGO
    private static void juego() {
        Scanner scanner = new Scanner(System.in);

        while (movimientos > 0) {
            mostrarTablero();
            System.out.println("Movimientos restantes: " + movimientos);
            System.out.print("Mueve el barco (W: arriba, A: izquierda, S: abajo, D: derecha): ");
            String movimiento = scanner.nextLine().toUpperCase(); // Lee el movimiento del usuario

            if (moverBarco(movimiento)) {
                // Si el barco llega a la posición del náufrago
                if (filaBarco == filaNaufrago && columnaBarco == columnaNaufrago) {
                    System.out.println("¡Has rescatado al náufrago! ¡Ganaste!");
                    break;
                }
            }

            movimientos--; // Resta un movimiento
        }

        if (movimientos == 0) {
            System.out.println("Te quedaste sin movimientos. ¡Perdiste!");
        }

        scanner.close(); // Cierra el escáner
    }
}