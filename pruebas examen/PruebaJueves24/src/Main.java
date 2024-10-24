/*  A TRABAJAR

una matriz y dos tableros 10x10   matriznumAle y matrizXX   si
uno relleno con numeros aleatorios(10-99)   si
dos relleno con x   si
usuario puede insertar 10 numeros
10 inetntos
me dice un numero y digo si existo dentro d la matriz y me lo enseñas
se pueden repetir
*/

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int filas = 10;// numero de filas
        int columnas = 10; // numero de columnas
        int[][] tableroNumAle = new int[filas][columnas];
        String[][] tableroxx = new String[filas][columnas];//cadena de xx
        Random aleatorio = new Random();
        Scanner leer = new Scanner(System.in);
        int intentosUsuario = 10;

        // 1º) INICIALIZAMOS tablero num ale y xx

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tableroNumAle[i][j] = aleatorio.nextInt(90) + 10;// rellenamos el tablero con numeros aleatorios del 10 al 99 lo ponemos asi pa que vaya del 10 al 99
                tableroxx[i][j] = "XX";
            }
        }

        //empieza el juego
        System.out.println("Dispones de 10 intentos para adivinar los numeros");
        System.out.println();//pongo otro mas para que haya un salto de linea

        while (intentosUsuario > 0) { // mientras el usuario tenga intentos...
            System.out.println("Te quedan: " + intentosUsuario + " intentos");// muestre los intentos que le quedan
            System.out.println();//pongo otro mas para que haya un salto de linea
            System.out.println("Escribe un numero del 10 al 99");// pido numeros
            System.out.println();//pongo otro mas para que haya un salto de linea

            int numeroAdivinado = leer.nextInt();// entero que marque loss adivinados
            boolean encontrado = false; // creamos un booleano para ver si el numero es o no

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (tableroNumAle[i][j] == numeroAdivinado) { // si coinciden
                        tableroxx[i][j] = String.valueOf(numeroAdivinado);// tablero xx coja el numero adivinado
                        encontrado = true;//verdadero
                    }
                }
            }

            if (encontrado) {
                System.out.println("Numero encontrado. Enhorabuena!!");
            } else {    // mirar bien como van los corchetes
                System.out.println("Lo siento, numero no encontrado.");

            } // si falla
                imprimirTableroxx(tableroxx); // saque por pantalla el tablero
                intentosUsuario--;// pierde un intento
            }
         }
        public static void imprimirTableroxx(String[][]tableroxx){  //imprimir tableroXX con los respectivos aciertos
            for(int i = 0; i < tableroxx.length; i++) {
                for (int j = 0; j < tableroxx[i].length; j++) {
                    System.out.print(tableroxx[i][j] + " ");
                }
                System.out.println();
            }
         }
    }