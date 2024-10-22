import java.lang.ref.PhantomReference;
import java.util.Random;
import java.util.Scanner;

public class encuentraTesoro {
    private static final int MAX_DIMENSION = 8;
    private static char[][] tablero = new char[MAX_DIMENSION][MAX_DIMENSION];
    private static int filaJugador, columnaJugador;
    private static int filaTesoro, columnaTesoro;
    private static int movimientos = 10;
    private static Random aleatorio = new Random();

    public static void main(String[] args) {
        inicializarTablero();
        colocarJugador();
        colocarTesoro();
        jugar();


    }

    private static void inicializarTablero() {
        for (int i = 0; i < MAX_DIMENSION; i++) {
            for (int j = 0; j < MAX_DIMENSION; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    private static void colocarJugador() {
        filaJugador = aleatorio.nextInt(MAX_DIMENSION);
        columnaJugador = aleatorio.nextInt(MAX_DIMENSION);
        tablero[filaJugador][columnaJugador] = 'P';
    }

    private static void colocarTesoro() {
        do {
            filaTesoro = aleatorio.nextInt(MAX_DIMENSION);
            columnaTesoro = aleatorio.nextInt(MAX_DIMENSION);
        } while (filaTesoro == filaJugador && columnaTesoro == columnaJugador);
        tablero[filaTesoro][columnaTesoro] = 'T';
    }

    private static void imprimirTablero() {
        for (int i = 0; i < MAX_DIMENSION; i++) {
            for (int j = 0; j < MAX_DIMENSION; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean moverJugador(String direccion) {

        int nuevaFila = filaJugador, nuevaColumna = columnaJugador;
        switch (direccion) {
            case "W":
                nuevaFila--;
                break;
            case "S":
                nuevaFila++;
                break;
            case "A":
                nuevaColumna--;
                break;
            case "D":
                nuevaColumna++;
                break;
            default:
                return false;
        }

        if (nuevaFila < 0 || nuevaFila >= MAX_DIMENSION || nuevaColumna < 0 || nuevaColumna >= MAX_DIMENSION) {
            System.out.println("Movimiento fuera de tablero");
            return false;
        }

        tablero[filaJugador][columnaJugador] = ' ';
        filaJugador = nuevaFila;
        columnaJugador = nuevaColumna;
        tablero[filaJugador][columnaJugador] = 'P';
        return true;
    }

    private static void jugar() {
        Scanner leer = new Scanner(System.in);

        while (movimientos > 0) {
            imprimirTablero();
            System.out.println("Movimientos restantes" + movimientos);
            System.out.println("eLIGE TU DESPLAZAMIENTO WASD");
            String movimiento = leer.nextLine().toUpperCase();

            if (moverJugador(movimiento)) {
                if (filaJugador == filaTesoro && columnaJugador == columnaTesoro) {
                    System.out.println("has encontrado el tesoro");
                    break;
                }
            }
            movimientos--;

            if (movimientos == 0) {
                System.out.println("Has perido");
                System.out.println("el tesoro estaba en la posicion(" + filaTesoro + "," + columnaTesoro + ").");
            }
        }
    }
}





