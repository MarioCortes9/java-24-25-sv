/* Entrada
El programa debera leer, de la entrada estandar, un primer numero indicando cuantos casos de prueba deberan ser procesados.
Cada caso de prueba son tres numeros,–10.000 ≤ A < B < C ≤ 10.000 que representan tres años.
Los años negativos indican que son antes de Cristo, y los positivos que son despues de Cristo.
Dado que no existio el año 0, se garantiza que ninguno de los tres tendra dicho valor.

Salida
Por cada caso de prueba el programa escribira el año A o C que este mas cerca de B.
Si esta a la misma distancia de ambos, se escribir´a “EMPATE”.
Ten en cuenta que el año 0 no existio, por lo que, por ejemplo, la distancia entre los años –1 y 1 es 1.
*/


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);

        //para que lea los diferentes casos que hay que hacer
        int casos=leer.nextInt();

        // los casos diferentes (años) siempre hasta que llegue a 0
        while(casos-- != 0) {
            int A=leer.nextInt(); // Año A
            int B=leer.nextInt(); // Año B
            int C=leer.nextInt(); // Año C

            //distancia de a y c respecto de b
            int distanciaAB=Math.abs(A - B);
            int distanciaCB=Math.abs(C - B);

            //como el 0 no existe si el primer num es negativo y el segundo positivo, la distancia disminuye 1.
            if (A < 0 && B > 0) distanciaAB--;
            if (B < 0 && C > 0) distanciaCB--;

            // SI DISTANCIAS SON IGUALES  sale EMPATE
            if (distanciaAB == distanciaCB ) {
                System.out.println("EMPATE");
            } // AB MENOR QUECB , A ESTA MAS CERCA DE B QUE C
            else if (distanciaAB<distanciaCB) {
                System.out.println(A);
            }
            else{ // C ES EL MAS CERCANO
                System.out.println(C);
            }
        }
    }
}
