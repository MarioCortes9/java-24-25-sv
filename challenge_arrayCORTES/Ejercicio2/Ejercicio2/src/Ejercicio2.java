import java.util.Random;

public class Ejercicio2 {
    static Random aleatorio = new Random();
    private static   int MAX_DIMENSION= 10;
    private static int [][] matriz = new int [MAX_DIMENSION][MAX_DIMENSION];

    public static void imprimirMatriz(){
        for (int i = 0; i < MAX_DIMENSION; i++) {
            for (int j = 0; j < MAX_DIMENSION; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
    public static void main(String[] args) {
        int MAX_FILA_TABLERO = 10; //10 FILAS
        int MAX_COLUMNA_TABLERO = 10;// 10 COLUMNAS
        //scope->
        //escritura de tipo camello
        // int ArrayNumAleatorio[] = new int[10];
        for (int i = 0; i < MAX_DIMENSION; i++) { //coja lo que mide el array
            for (int j = 0; j < MAX_DIMENSION; j++) {
                matriz[i][j]= aleatorio.nextInt(100);
                    //FALTA EL ULTIMO PASO
                }
            }
        imprimirMatriz();
    }
}

