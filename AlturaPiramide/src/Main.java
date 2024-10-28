
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
public class Main {

    static Scanner leer = new Scanner(System.in);
    static int bloques;

    // funcion con datos enunciado
    public static int alturaPiramide(int bloques) {
        /*minima altura posible */
        int altura = 0;// va incrementando
        /*niveles lados siempre X x X*/
        int lado = 1; //inicialmente
        /*bloques usados*/
        int bloquesUsados = 0;// va incrementando

        while(bloquesUsados +(lado *lado)-1 <=bloques){ // me sale fallo en la entrada 30, que me sale 2
            bloquesUsados += (lado * lado)-1/*-1*/;
            altura++;
            lado += 2;

    }
        // Y ESTO DEVUELVA LA ALTURA MINIMA QUE SE PIDE EN LA SALIDA
        return altura;
    }

    public  static void main(String[] args){
        while (true) { // utilizo esto para que diga si cada caso es verdadero
            int bloques = leer.nextInt();// bloques casos de prueba
            if ( bloques == 0) { // si es 0 la entrada termina
                break;
            }
            int altura= alturaPiramide(bloques);
            System.out.println(altura);
        }
    }
}
