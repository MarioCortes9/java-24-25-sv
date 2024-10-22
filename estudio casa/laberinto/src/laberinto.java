import java.util.Collection;
import java.util.Random;
import java.util.Scanner;

/* Ejercicio: Juego de Laberinto
---El juego se desarrolla en un tablero de 10x10.
---Hay un personaje, representado por 'P', que debe
llegar a la salida, representada por 'S'.
---Hay varios obstáculos en el camino, representados por 'X',
que el personaje debe evitar.
---El personaje puede moverse en las direcciones arriba (W)
,izquierda (A), abajo (S) y derecha (D).
---El jugador tiene un límite de 20 movimientos.
Si llega a la salida antes de que se acaben los movimientos,
gana. Si se queda sin movimientos, pierde.
---El juego debe mostrar el estado del tablero después de
cada movimiento.*/
public class laberinto {

    private static int MAX_DIMENSION = 10;
    private static char[][] tablero;
    private static int filaPersonaje, columnaPersonaje;
    private static int filaSalida, columnaSalida;
    private static int movimientos = 20;
    private static Random aleatorio = new Random();

    public static void main(String[] args) {
        tablero = new char[MAX_DIMENSION][MAX_DIMENSION];
        inicializarTablero();
        colocarPersonaje();
        colocarObstaculos(5);
        colocarSalida();
        juego();


        Scanner leer = new Scanner(System.in);
    }

    //inicializamos
    private static void inicializarTablero() {
        for (int i = 0; i < MAX_DIMENSION; i++) {
            for (int j = 0; j < MAX_DIMENSION; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    //colocamos personaje
    private static void colocarPersonaje() {
        do {
            filaPersonaje = aleatorio.nextInt(MAX_DIMENSION);
            columnaPersonaje = aleatorio.nextInt(MAX_DIMENSION);
        } while (tablero[filaPersonaje][columnaPersonaje] != ' ');
        tablero[filaPersonaje][columnaPersonaje] = 'P';
    }

    //COLOCAR OBSTACULOS
    private static void colocarObstaculos(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            int filaObstaculo, columnaObstaculo;
            do {
                filaObstaculo = aleatorio.nextInt(MAX_DIMENSION);
                columnaObstaculo = aleatorio.nextInt(MAX_DIMENSION);
            } while (tablero[filaObstaculo][columnaObstaculo] != ' ');
            tablero[filaObstaculo][columnaObstaculo] = 'O';
        }
    }

    //COLOCAR SALIDA
    private static void colocarSalida() {
        filaSalida = aleatorio.nextInt(MAX_DIMENSION);
        columnaSalida = aleatorio.nextInt(MAX_DIMENSION);
        tablero[filaSalida][columnaSalida] = 'S';
    }

    //imprimir tablero
    private static void imprimirTablero() {
        for (int i = 0; i < MAX_DIMENSION; i++) {
            for (int j = 0; j < MAX_DIMENSION; j++) {
                System.out.println(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

//desplazamientos

    private static boolean moverJugador(String direccion) {
        int nuevaFila = filaPersonaje, nuevaColumna = columnaPersonaje;

        // Movemos el jugador según la dirección
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

        // Verifica que el movimiento esté dentro del tablero
        if (nuevaFila < 0 || nuevaFila >= MAX_DIMENSION || nuevaColumna < 0 || nuevaColumna >= MAX_DIMENSION) {
            System.out.println("¡Movimiento fuera del tablero!");
            return false;
        }

        // Verifica si choca con un obstáculo
        if (tablero[nuevaFila][nuevaColumna] == 'X') {
            System.out.println("¡Te topaste con un obstáculo!");
            return true; // No avanza, pero cuenta como movimiento
        }

        // Actualizamos la posición del jugador en el tablero
        tablero[filaPersonaje][columnaPersonaje] = ' '; // Limpia la posición anterior
        filaPersonaje = nuevaFila;
        columnaPersonaje = nuevaColumna;
        tablero[filaPersonaje][columnaPersonaje] = 'P'; // Coloca al jugador en la nueva posición

        return true; // Movimiento válido
    }

    // FUNCIÓN DEL BUCLE DE JUEGO
    private static void juego() {
        Scanner scanner = new Scanner(System.in);

        while (movimientos > 0) {
            imprimirTablero();
            System.out.println("Movimientos restantes: " + movimientos);
            System.out.print("Mueve el jugador (W: arriba, A: izquierda, S: abajo, D: derecha): ");
            String movimiento = scanner.nextLine().toUpperCase(); // Lee el movimiento del jugador

            if (moverJugador(movimiento)) {
                // Si el jugador llega a la posición de la salida
                if (filaPersonaje == filaSalida && columnaPersonaje == columnaSalida) {
                    System.out.println("¡Has llegado a la salida! ¡Ganaste!");
                    break;
                }
            }

            movimientos--; // Resta un movimiento
        }

        if (movimientos == 0) {
            System.out.println("Te quedaste sin movimientos. ¡Perdiste!");
        }

    }
}






