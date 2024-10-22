/*Juego: Encuentra el Código Secreto
En este juego, el programa genera un código secreto compuesto por 4 números aleatorios entre 1 y 9. SI
El jugador debe intentar adivinar el código secreto ingresando 4 números.
Cada vez que el jugador adivina correctamente la posición y el número, se le notificará que ha acertado en esa posición.
El juego termina cuando el jugador adivina todo el código o se queda sin intentos.

Reglas:
El jugador tiene 8 intentos para adivinar el código.
Cada vez que adivina correctamente tanto el número como su posición, se le indica cuántos números ha acertado en su posición correcta.
Si el jugador adivina el código antes de agotar los intentos, gana.
Si el jugador no adivina el código después de los 8 intentos, pierde.
*/


import java.util.Random;
import java.util.Scanner;

public class codigoSecreto {

    public static void main(String[] args) {
        //inicializamos random y scanner
        Random aleatorio = new Random();
        Scanner leer = new Scanner(System.in);

        // declaramos los enteros que aparecen en el enunciado
        int[] codigoSecreto = new int[4];
        int intentos = 8;

        //codigo de 4 num aleatorios entre 1 y 9
        for (int i = 0; i < codigoSecreto.length; i++) {
            codigoSecreto[i] = aleatorio.nextInt(9) + 1;
        }

        //juego

        System.out.println("Comienza el juego");
        System.out.println("El codigo esta compuesto de 4 números aleatorios entre 1 y 9");
        System.out.println("Tienes " + intentos + "intentos para adivinar el codigo");

        //El jugador debe intentar adivinar el código secreto ingresando 4 números
        while (intentos > 0) {
            int[] numeroUsuario = new int[4];// los 4 numeros que ingresa
            int aciertos = 0;

            //ahora pones los 4 numeros
            System.out.println("Introduce 4 numeros del 1 al 9");
            for (int i = 0; i < 4; i++) {
                numeroUsuario[i] = leer.nextInt();// los vaya leyendo
            }

            //si el numero coincide acierto
            for (int i = 0; i < numeroUsuario.length; i++) {
                if (numeroUsuario[i] == codigoSecreto[i]) {
                    aciertos++;
                }
            }

            //final del juego
            if (aciertos == 4) {
                System.out.println("Has encontrado el codigo secreto");
                break;
            } else {
                System.out.println("Has adivinado " + aciertos + "numeros en la posicion correcta");
            }

            intentos--;
            if (intentos > 0) {
                System.out.println("Te quedan " + intentos + " intentos");
            }

            if (intentos == 0) {
                System.out.println("Te has quedado sin intentos");
                System.out.println("El codigo era: ");
                for (int num : codigoSecreto) {
                    System.out.println(num + " ");
                }
                System.out.println();
            }
        }
    }
}