
import java.util.Random;

public class OrdenarFunciones{
    static int FILAS = 10;
    static int COLUMNAS = 9;
    static Random random = new Random();
    static int[][] tablero = new int[FILAS][COLUMNAS];

    public static void main(String[] args) {
        llenarTablero();
        System.out.println("Tablero del principio");
        imprimirTablero();

        rellenarAleatorio();
        imprimirTablero();

        ordenarColumnas();
        System.out.println("Tablero ordenado");
        imprimirTablero();

    }


    public static void llenarTablero (){
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                int numAleatorio = random.nextInt(10 * (j + 1), (10 * (j + 1) + 10));
                tablero[i][j] = numAleatorio;
            }
        }
    }

    public static void  rellenarAleatorio() {
        for (int j = 0; j < COLUMNAS; j++) {
            for (int i = 0; i < FILAS; i++) {
                for (int k = 0; k < FILAS - 1; k++) {
                    if (tablero[k][j] > tablero[k + 1][j]) {
                        int aux = tablero[k][j];
                        tablero[k][j] = tablero[k + 1][j];
                        tablero[k + 1][j] = aux;
                    }
                }
            }
        }
    }
    public static void ordenarColumnas (){
        for (int COLUMNAS = 0; COLUMNAS < 9; COLUMNAS++) {
            for (int i = 0; i < FILAS - 1; i++) {
                for (int j = i; j < FILAS; j++) {
                    if (tablero[i][COLUMNAS] > tablero[j][COLUMNAS]) {
                        int aux = tablero[i][COLUMNAS];
                        tablero[i][COLUMNAS] = tablero[j][COLUMNAS];
                        tablero[j][COLUMNAS] = aux;
                    }
                }
            }
        }
    }

    public static void imprimirTablero (){
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

}