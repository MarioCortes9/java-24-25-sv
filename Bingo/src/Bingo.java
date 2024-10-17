public class Bingo {
    public static void main(String[] args) {
    // Creamos primero un tablero bingo (3x9)
        int [][] bingo = new int [3][9];


    }
}

/*  import java.util.Random;
import java.util.Arrays;

    public class BingoSimple {

        public static void main(String[] args) {
            // Crear el tablero de Bingo (3x9)
            int[][] bingo = new int[3][9];

            // Llenar el tablero con los rangos 10-19, 20-29, ..., 90-99
            llenarBingo(bingo);

            // Ordenar cada columna del tablero
            ordenarBingo(bingo);

            // Imprimir el tablero de Bingo
            imprimirBingo(bingo);
        }

        // Función para llenar el Bingo con números de cada rango
        static void llenarBingo(int[][] bingo) {
            Random random = new Random();

            // Recorrer cada columna
            for (int col = 0; col < 9; col++) {
                int min = col * 10 + 10;  // El valor mínimo de cada rango (10, 20, ..., 90)
                int max = min + 9;        // El valor máximo de cada rango (19, 29, ..., 99)

                // Llenar la columna con números aleatorios dentro del rango
                for (int fila = 0; fila < 3; fila++) {
                    bingo[fila][col] = random.nextInt(max - min + 1) + min;
                }
            }
        }

        // Función para ordenar cada columna del Bingo
        static void ordenarBingo(int[][] bingo) {
            for (int col = 0; col < 9; col++) {
                int[] columna = new int[3];

                // Extraer los números de la columna
                for (int fila = 0; fila < 3; fila++) {
                    columna[fila] = bingo[fila][col];
                }

                // Ordenar la columna
                Arrays.sort(columna);

                // Poner los números ordenados de vuelta en la columna
                for (int fila = 0; fila < 3; fila++) {
                    bingo[fila][col] = columna[fila];
                }
            }
        }

        // Función para imprimir el Bingo
        static void imprimirBingo(int[][] bingo) {
            for (int fila = 0; fila < 3; fila++) {
                for (int col = 0; col < 9; col++) {
                    System.out.print(bingo[fila][col] + "\t");
                }
                System.out.println();
            }
        }
    }
    */