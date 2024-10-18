import java.util.Arrays;
import java.util.Random;

public class Bingo {
    public static void main(String[] args) {
        // Creamos primero un tablero bingo (3x9)
        int[][] bingo = new int[3][9]; // lo validamos aqui con las funciones para que pueda usarse en ellas
        llenarBingo(bingo);
        ordenarBingo(bingo);
        imprimirBingo(bingo);
    }  // guardamos aqui las funciones

        //creamos una funcion para rellenar el bingo
        public static void llenarBingo ( int[][] bingo){ // el int bingo es nuestros numeros del bingo
            //estos numeros son random por lo q  creamo el random
            Random aleatorio = new Random();
            for (int columnas = 0; columnas < 9; columnas++) {
                int min = columnas * 10 + 10;  // valor minimo de cada rango ej:col1---->  0*10+10=10
                int max = min + 9; // lo mismo que minimo pero sumandole 9
                //ahora tenemos que hacer lo mismo pero con filas
                for (int fila = 0; fila < 3; fila++) {
                    bingo[fila][columnas] = aleatorio.nextInt(max - min + 1) + min;// (99-90+1)+90-->100,(98-93+1)+93--->99  ese +1 esta para asi poder incluir el 100 sino no saldria
                }
            }
        }
        // funcion para ordenar las columnas
        public static void ordenarBingo ( int[][] bingo){
            for (int columnas = 0; columnas < 9; columnas++) {
                int[] columna = new int[3];   //esto sirve para guardar en esa columna tres valores solamente
                for (int fila = 0; fila < 3; fila++) {
                    columna[fila] = bingo[fila][columnas]; // esto es para extraer esos numeros que han salido de la columna
                }
                Arrays.sort(columna); // comando para ordenar la columna de manera ascendente 10,18,19
                for (int fila = 0; fila < 3; fila++) { // ya ordenados colocarlos de nuevo en su columna
                    bingo[fila/*pos 1*/][columnas/*x*/] = columna[fila/*21,18,15 ejemplo*/];
                }
            }
        }
// funcion imprimir por pantalla el bingo
        public static void imprimirBingo ( int[][] bingo){
            for (int fila = 0; fila < 3; fila++) {
                for (int columnas = 0; columnas < 9; columnas++) {
                    System.out.print(bingo[fila][columnas] + " ");
            }
                    System.out.println();
        }
    }
}

