import java.util.Random;
import java.util.Scanner;

public class Ejercicio3 {
    // Me tengo que acordar de STATIC,
    // si lo quiero arriba
    // static String arrayPrimitiva[] = new String[6];
    public static void main(String[] args) {
        Random alea = new Random();
        Scanner leer = new Scanner(System.in);
        // PRIMITVA
        String arrayPrimitiva[] = new String[6];
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            int numAle = alea.nextInt(100);
            // ¿Cómo puedo convertir un entero a cadena?
            // CONVERSOR DE TIPOS DE DATOS
            // de int a String
            arrayPrimitiva[i] = String.valueOf(numAle) ;
        }
        // IMPRIMIR EL ARRAY
        for (int i = 0; i < arrayPrimitiva.length ; i++) {
            System.out.println(arrayPrimitiva[i]);
        }
        System.out.println("Dame un num1");
        String cadUsuario1 = leer.next();
        int valor = leer.nextInt(); // 99
        String cad = leer.next();// "99" "HOLA"
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            if(cadUsuario1.equals(arrayPrimitiva[i])){
                arrayPrimitiva[i] = "XX";
            }
        }
        System.out.println("Dame un num2");
        String cadUsuario2 = leer.next();
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            if(cadUsuario2.equals(arrayPrimitiva[i])){
                arrayPrimitiva[i] = "XX";
            }
        }
        System.out.println("Dame un num3");
        String cadUsuario3 = leer.next();
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            if(cadUsuario3.equals(arrayPrimitiva[i])){
                arrayPrimitiva[i] = "XX";
            }
        }
        // IMPRIMIR EL ARRAY
        for (int i = 0; i < arrayPrimitiva.length ; i++) {
            System.out.println(arrayPrimitiva[i]);
        }
        // FIN PRIMITIVA

    }
}



// array 6 aleat---pedir 3 num-buyscralos si estan reemplazar por XX y si no esta eres un paquete