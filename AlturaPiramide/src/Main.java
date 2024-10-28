
import java.util.Scanner;

/* A TRABAJAR

1    X

2          X X X
           X X X
           X X X

3        X X X X X
         X X X X X
         X X X X X
         X X X X X
         X X X X X

Asi sucesivamente..... cada nivel sube 2 bloques

ENTRADA

-Sucesion de casos de prueba
-Numeros entre 1 y 2.000.000.000
-indicando cantidad bloques
-entrada termina con 0

SALIDA

-En cada caso, minima altura posible de la piramide(num nivel)
-Termina con 0


*/
import java.util.Scanner;

public class Main {

    private static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {

        // bucle que hasta que no sea 0 no rompe
        while(true){
            System.out.println("Ingrese el numero de bloques: ");
            int numeroBloques = leer.nextInt(); // numero de bloques a calcular
            int auxiliar = numeroBloques;//creamos una variable aux que gaurde el numero de bloques

            if (numeroBloques == 0) break; // si es cero, se acaba el bucle

            int alturas = 0; // alturas con el numero de bloques dados
            int lado = 1; // tamaño del lado inicial

            while (numeroBloques > 0) { // mientras sea mayor a 0....
                int bloquesUsados = lado*lado; // valor del numero de bloques

                if (numeroBloques > bloquesUsados) { // si bloques son mayores al numero de bloques que se han usado seguimos
                    numeroBloques -= bloquesUsados;
                }else { //si bloques son menores al numero de bloques que se han usado , fin bucle
                    numeroBloques = 0;
                }

                alturas++; // sumamos 1 a alturas
                lado += 2; // le sumamos 2 a lado para ir haciendo los saltos de 2 en 2
            }
            System.out.println(alturas + " Alturas completada con " + auxiliar + " bloques");
        }

    }
}
