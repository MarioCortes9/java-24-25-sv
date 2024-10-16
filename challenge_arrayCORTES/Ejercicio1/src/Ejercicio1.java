import java.util.Random;
import java.util.Scanner;

public class Ejercicio1 {
    static Random aleatorio = new Random();

        public static int generarAleatorio (int semilla){
        int numAle = aleatorio.nextInt(semilla);
        return numAle;
    }

        public static void main (String[]args){
        //scope->
        //escritura de tipo camello
        // int ArrayNumAleatorio[] = new int[10];
        int arrayNumAleatorio[] = new int[10];

        for (int i = 0; i < arrayNumAleatorio.length; i++) { //coja lo que mide el array
            arrayNumAleatorio[i] = generarAleatorio(100);
            ; //numero aleatorio para la i
             }
        }
    }





        /*int [] vector = new int [10];
        Random aleatorio= new Random(10);
        Scanner leer = new Scanner(System.in);
        int x;
        }
    }


//array 10 dimensiones con numeros aleatorio*/