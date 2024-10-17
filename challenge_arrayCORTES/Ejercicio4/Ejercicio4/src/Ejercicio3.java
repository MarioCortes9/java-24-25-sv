import java.util.Random;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        Random alea = new Random();
        Scanner leer = new Scanner(System.in);

        // PRIMITVA
        String arrayPrimitiva[] = new String[6];//CADENA 6 NUMEROS
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            int numAle = alea.nextInt(100);// NUM ALE 100
            // ¿Cómo puedo convertir un entero a cadena?
            // CONVERSOR DE TIPOS DE DATOS
            // de int a String coversion
            arrayPrimitiva[i] = String.valueOf(numAle) ;//LEDAS AL ARRAY EL VALOR DE ALEATORIO
        }

        // IMPRIMIR EL ARRAY
        for (int i = 0; i < arrayPrimitiva.length ; i++) {
            System.out.println(arrayPrimitiva[i]);
        }

        //DAME PRIMER  NUMERO
        System.out.println("Dame un num1");
        String cadUsuario1 = leer.next();
        int valor = leer.nextInt(); // 99 num
        String cad = leer.next();// "99" "HOLA"
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            if(cadUsuario1.equals(arrayPrimitiva[i])){
                arrayPrimitiva[i] = "XX";   // SI ..... CAMBIAS POR XX
            }
        }

        //DAME SEGUNDO NUMERO
        System.out.println("Dame un num2");
        String cadUsuario2 = leer.next();
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            if(cadUsuario2.equals(arrayPrimitiva[i])){
                arrayPrimitiva[i] = "XX"; // SI ..... CAMBIAS POR XX
            }
        }

        //DAME TERCER NUEMERO
        System.out.println("Dame un num3");
        String cadUsuario3 = leer.next();
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            if(cadUsuario3.equals(arrayPrimitiva[i])){
                arrayPrimitiva[i] = "XX"; // SI..... CAMBIAS POR XX
            }
        }


        // IMPRIMIR EL ARRAY PARA QUE SALGA POR PANTALLA
        for (int i = 0; i < arrayPrimitiva.length ; i++) {
            System.out.println(arrayPrimitiva[i]);
        }
        // FIN PRIMITIVA

    }
}
//ACORDARME DE TABULAR TODO AL FINAL


// array 6 aleat---pedir 3 num-buyscralos si estan reemplazar por XX y si no esta eres un paquete