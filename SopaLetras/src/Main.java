/*

MATRIZ 10X10
SLEC POS ALEA MATRIZ Y ESC PAL LETRA X LETRA
QUEPA Y EN CADA UNA DE LAS 8 DIRECCIONES
 */

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static int MAX_DIMENSION = 10;
    private static final char[][] tablero = new char[MAX_DIMENSION][MAX_DIMENSION];
    private static final Random aleatorio = new Random();
    private static final Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(" ");
        System.out.println("Dime una palabra");
        System.out.println(" ");
        String palabra = leer.nextLine().toUpperCase();


        llenarTableroLetras();
        colocarPalabra(palabra);
        imprimirTablero();
    }

    private static void llenarTableroLetras() {
        for (int i = 0; i < MAX_DIMENSION; i++) {
            for (int j = 0; j < MAX_DIMENSION; j++) {
                tablero[i][j] = (char) +('A' + aleatorio.nextInt(26));  //tabla ascii
            }
        }
    }


    private static void colocarPalabra(String palabra) {
        int filaPal, colPal;
        char direccion;

        while (true) {
            filaPal = aleatorio.nextInt(MAX_DIMENSION);
            colPal = aleatorio.nextInt(MAX_DIMENSION);
            direccion = generarDireccion(); //  direcciones que tiene

            if (verificarMoverPalabra(filaPal, colPal, direccion, palabra)) {
                break; // si exito sale bucle
            }
        }
    }

    private static char generarDireccion() {
        char[] direcciones = {'W', 'S', 'A', 'D', 'Q', 'E', 'Z', 'X'}; //array desplazamientois
        return direcciones[aleatorio.nextInt(8)];// 8 direcciones
    }


    private static boolean verificarMoverPalabra(int X, int Y,char direccion, String palabra) {

        int longitud = palabra.length();
        int nuevaX = X, nuevaY = Y;


        for (int i = 0; i < longitud; i++) {  //limites
            if (nuevaX < 0 || nuevaY < 0 || nuevaX >= MAX_DIMENSION || nuevaY >= MAX_DIMENSION) {
                return false; //
            }

            // direcciónes para comprobar los limites
            switch (direccion) {
                case 'W':
                    nuevaX--;
                    break;    // Arriba
                case 'S':
                    nuevaX++;
                    break;     // Abajo
                case 'A':
                    nuevaY--;
                    break;    // Izquierda
                case 'D':
                    nuevaY++;
                    break;     // Derecha
                case 'Q':
                    nuevaX--;
                    nuevaY--;
                    break;   // Diagonal arriba-izquierda
                case 'E':
                    nuevaX--;
                    nuevaY++;
                    break;    // Diagonal arriba-derecha
                case 'Z':
                    nuevaX++;
                    nuevaY--;
                    break;    // Diagonal abajo-izquierda
                case 'X':
                    nuevaX++;
                    nuevaY++;
                    break;     // Diagonal abajo-derecha
                default:
                    return false;
            }
        }

        nuevaX = X;
        nuevaY = Y;

        for (int i = 0; i < longitud; i++) {
            tablero[nuevaX][nuevaY] = palabra.charAt(i); // colocar letra

            // otra vez para mover
            switch (direccion) {
                case 'W':
                    nuevaX--;
                    break;    // Arriba
                case 'S':
                    nuevaX++;
                    break;     // Abajo
                case 'A':
                    nuevaY--;
                    break;    // Izquierda
                case 'D':
                    nuevaY++;
                    break;     // Derecha
                case 'Q':
                    nuevaX--;
                    nuevaY--;
                    break;   // Diagonal arriba-izquierda
                case 'E':
                    nuevaX--;
                    nuevaY++;
                    break;    // Diagonal arriba-derecha
                case 'Z':
                    nuevaX++;
                    nuevaY--;
                    break;    // Diagonal abajo-izquierda
                case 'X':
                    nuevaX++;
                    nuevaY++;
                    break;     // Diagonal abajo-derecha
            }
        }
        return true;
    }

    private static void imprimirTablero() {
        for (int i = 0; i < MAX_DIMENSION; i++) {
            for (int j = 0; j < MAX_DIMENSION; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}