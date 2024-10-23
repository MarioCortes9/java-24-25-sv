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

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);

        //para que lea los diferentes casos que hay que hacer
        System.out.println("Ingrese un numero");
        int casos=leer.nextInt();

        // los casos diferentes (años)
        for (int i = 0; i < casos; i++) {
            int A=leer.nextInt(); // Año A
            int B=leer.nextInt(); // Año B
            int C=leer.nextInt(); // Año C

            //distancia de a y c respecto de b
            int distanciaAB=Math.abs(A - B);
            int distanciaCB=Math.abs(C - B);


            if (distanciaAB==distanciaCB) {
                System.out.println("EMPATE");
            }
            else if (distanciaAB<distanciaCB) {
                System.out.println(A);
            }
            else{
                System.out.println(C);
            }
        }
    }
}