import java.util.Random;
import java.util.Scanner;

/* De que trata el ejercicio?
Aquí tienes un ejercicio similar al que proporcionas, pero con una mecánica diferente.
Vamos a crear un juego de lotería en el que el programa genera 5 números aleatorios,
y el usuario deberá adivinar algunos de esos números en tres intentos.
Si el usuario acierta un número, se reemplazará en el array con "ACIERTO". ¡Vamos allá!

Guion:
-El programa genera 5 números aleatorios entre 1 y 50. SI
-El usuario tiene 3 intentos para adivinar algunos de esos números. SI
-Si el usuario adivina un número correctamente, el programa lo reemplaza
en el array con la palabra "ACIERTO".SI
-Después de los 3 intentos, se mostrará el estado del array,
indicando cuáles números se adivinaron y cuáles no.

*/
public class adivinaLoteria {

    public static void main(String[] args) {
        Random aleatorio = new Random();
        Scanner leer = new Scanner(System.in);

        String[] numerosLoteria = new String[5];// creamos una cadena de 5 numeros

        //llenamos el array con 50 numeros aleatorios
        for (int i = 0; i < numerosLoteria.length; i++) {
            // entero que guarde los numeros aleatorios
            int numAle = aleatorio.nextInt(50) + 1; // el +1 es porque sino empieza por el numero 0
            // una cadena que los guarde
            numerosLoteria[i] = String.valueOf(numAle);
        }
//El usuario tiene 3 intentos para adivinar algunos de esos números
        for (int intento = 0; intento <= 3; intento++) {
            System.out.println("Intento " + intento + " : Dame un numero entre 1 y 50");
            String numUsuario = leer.next();// leer num ingresado por el usuario

//Si el usuario adivina un número correctamente, el programa lo reemplazar en el array con la palabra "ACIERTO"
            boolean encontrado = false;
            for (int i = 0; i < numerosLoteria.length; i++) {
                if (numUsuario.equals(numerosLoteria[i])) {
                    numerosLoteria[i] = "ACIERTO";
                    encontrado = true;
                }
            }

//Después de los 3 intentos, se mostrará el estado del array,indicando cuáles números se adivinaron y cuáles no

            if (encontrado) {
                System.out.println("Has acertado");
            } else {
                System.out.println("No acertaste");
            }
        }

        System.out.println("Resultado final de la loteria");
        for (String numero : numerosLoteria) {
            System.out.println(numero + " ");
        }
        System.out.println();
    }
}
