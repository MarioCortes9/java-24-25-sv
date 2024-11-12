import java.util.Random;

public class MatrizAleatoria {

    private static int[][] matriz = new int[3][9];
    private static Random random = new Random();

    public static void main(String[] args) {

        generarOrdenarMatriz(matriz);


        System.out.println("Matriz ordenada:");
        imprimirTablero(matriz);

    }

    private static void generarOrdenarMatriz(int[][] matriz) {
        for (int col = 0; col < matriz[0].length; col++) {
            int min = 10 + (col * 10); // valor minimo para la columna
            int max = min + 9;        // valor maximo para la columna

            for (int row = 0; row < matriz.length; row++) {
                matriz[row][col] = random.nextInt(max - min + 1) + min;
            }

            //ordenar mayor a menor
            for (int i = 0; i < matriz.length - 1; i++) {
                for (int j = 0; j < matriz.length - i - 1; j++) {
                    if (matriz[j][col] > matriz[j + 1][col]) {

                        int auxiliar = matriz[j][col];
                        matriz[j][col] = matriz[j + 1][col];
                        matriz[j + 1][col] = auxiliar;
                    }
                }
            }
        }
    }


    private static void imprimirTablero(int[][] matriz) {
        for (int row = 0; row < matriz.length; row++) {
            for (int col = 0; col < matriz[0].length; col++) {
                System.out.print(matriz[row][col] + "\t");
            }
            System.out.println();
        }
    }
}














