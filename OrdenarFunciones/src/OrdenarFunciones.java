/*import java.util.Random;


public class OrdenarFunciones {
    public static void main(String[] args) {
        int filas = 10;
        int columnas = 9;
        int tablero[][] = new int[filas][columnas];
        Random random=new Random();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                //int numAleatorio= random.nextInt(10)+10*(j+1); //10 - 19
                int numAleatorio = random.nextInt(10*(j+1),(10*(j+1)+10));
                tablero[i][j] = numAleatorio;
            }
        }
                /*
        int cont = 0;
        do {
            for (int i = 0; i < filas -1; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (tablero[i][j] > tablero[i + 1][j]) {
                        int aux;
                        aux = tablero[i][j];
                        tablero[i][j] = tablero[i + 1][j];
                        tablero[i + 1][j] = aux;
                    }
                }
            }
            cont++;
        }while (cont < filas);

                 */

        /*for (int j = 0; j < columnas; j++) {
            for (int i = 0; i < filas; i++) {
                for (int k = 0; k < filas - 1; k++) {
                    if(tablero[k][j] > tablero[k + 1][j]){
                        int aux = tablero[k][j];
                        tablero[k][j] = tablero[k + 1][j];
                        tablero[k + 1][j] = aux;
                    }
                }
            }

        }*/
       /* for (int i = 0; i < filas-1; i++) { // [0,0][1,0], [1,0][2,0]
            for (int j = 0; j < columnas; j++) {
                if (tablero[i][j]>tablero[i+1][j]){
                    int aux = tablero[i+1][j];
                    tablero[i][j] = tablero[i + 1][j];
                    tablero[i + 1][j] = aux;
                }
            }
        }
        for (int columna = 0; columna < 9; columna++) {

            for (int i = 0; i < filas - 1; i++) {
                for (int j = i; j < filas; j++) {
                    if (tablero[i][columna] > tablero[j][columna]) {
                        int aux = tablero[i][columna];
                        tablero[i][columna] = tablero[j][columna];
                        tablero[j][columna] = aux;
                    }
                }
            }

        }


        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++){
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}*/

import java.util.Random;

public class OrdenarFunciones {
    static int FILAS = 10;
    static int COLUMNAS = 9;
    static Random random = new Random();
    static int[][] tablero = new int[FILAS][COLUMNAS];

    public static void main(String[] args) {
        llenarTablero();
        System.out.println("Tablero del principio");
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

