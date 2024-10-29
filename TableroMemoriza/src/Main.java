import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int MAX_DIMESION = 4;
    private static int parejas = 1;
    private static int[][] tableroParejas = new int[MAX_DIMESION][MAX_DIMESION];
    private static int[][] tableroTrabajo = new int[MAX_DIMESION][MAX_DIMESION];
    private static Random aleatorio = new Random();

    public static void main(String[] args) throws InterruptedException {
        Scanner leer = new Scanner(System.in);
        inicializarTablero();


        //bucle de juego
        while (!finJuego()) {

            mostrarTablero(tableroTrabajo);

            //primer numero coordenadas i
            System.out.println("Introduce las coordenadas del primer numero: ");
            int num1fila1 = leer.nextInt();
            int num1columna1 = leer.nextInt();

            //primer numero coordenadas j
            System.out.println("Introduce las coordenadas del segundo numero:");
            int num2fila2 = leer.nextInt();
            int num2columna2 = leer.nextInt();


            //para encontrar el par
            if (tableroParejas[num1fila1][num1columna1] == tableroParejas[num2fila2][num2columna2]) {

                // destapar si coinciden
                tableroTrabajo[num1fila1][num1columna1] = tableroParejas[num1fila1][num1columna1];
                tableroTrabajo[num2fila2][num2columna2] = tableroParejas[num2fila2][num2columna2];

                System.out.println("¡Par encontrado!");
                System.out.println();

            } else {

                // si no lo encontramos
                System.out.println("No coinciden, intentalo de nuevo.");
                System.out.println();

                tableroTrabajo[num1fila1][num1columna1] = tableroParejas[num1fila1][num1columna1];
                tableroTrabajo[num2fila2][num2columna2] = tableroParejas[num2fila2][num2columna2];

                mostrarTablero(tableroTrabajo);
                System.out.println("");
                Thread.sleep(5000);

                tableroTrabajo[num1fila1][num1columna1] = 0;
                tableroTrabajo[num2fila2][num2columna2] = 0;
            }
        }

        System.out.println("Has encontrado todas las parejas");
        leer.close();
        }

        public static void inicializarTablero () {
            for (int i = 0; i < MAX_DIMESION; i++) {
                for (int j = 0; j < MAX_DIMESION; j += 2) {//incremenatr j en 2 para asi conseguir pares
                    tableroParejas[i][j] = parejas;
                    tableroParejas[i][j + 1] = parejas;
                    parejas++;
                }
            }
            // generar aleatorias
            for (int i = 0; i < MAX_DIMESION; i++) {
                for (int j = 0; j < MAX_DIMESION; j++) {
                    int nuevoTablero = tableroParejas[i][j];
                    int i1 = aleatorio.nextInt(MAX_DIMESION);
                    int j1 = aleatorio.nextInt(MAX_DIMESION);
                    tableroParejas[i][j] = tableroParejas[i1][j1];
                    nuevoTablero = tableroParejas[i1][j1];
                }
            }
        }

        public static void mostrarTablero ( int[][] tablero){

            for (int i = 0; i < MAX_DIMESION; i++) {
                for (int j = 0; j < MAX_DIMESION; j++) {
                    if (tablero[i][j] == 0) {
                        System.out.print("X ");
                    } else {
                        System.out.print(tablero[i][j] + " ");
                    }
                }
                System.out.println();
            }
        }

        public static boolean finJuego () {
            for (int i = 0; i < MAX_DIMESION; i++) {
                for (int j = 0; j < MAX_DIMESION; j++) {
                    if (tableroTrabajo[i][j] == 0) {
                        return false;
                    }
                }
            }
            return true;
        }
    }









