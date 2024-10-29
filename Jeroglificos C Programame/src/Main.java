/* A Hacer

Entrada

-Cada caso de prueba es un numero entre 1 y 9.999.999.
-La entrada termina con un 0, que no debe procesarse.

Salida
-Por cada caso de prueba el programa escribira la
representacion del numero en notacion egipcia.
Dado que no se pueden escribir los sımbolos originales,
para cada uno se utilizara la inicial del nombre.
del sımbolo que aparece destacada en la tabla superior
(por orden de menor a mayor potencia, T, G, C,F, D, R y H).
Se indicaran primero los sımbolos de mayor valor.

 */

import java.util.Scanner;

public class Main {
    private static Scanner lector = new Scanner(System.in);
    private static int [] potencia= {1000000,100000,10000,1000,100,10,1}; //POTENCIAS
    private static char [] simbolo={'H','R','D','F','C','G','T'};//SIMBOLOS DE LAS PALABRAS

    //PRIMERO CREAMOS UNA FUNCION DONDE SE VAYAN LEYENDO LOS NUMEROS INGRESADOS.
    private static int leeNumero(){
        System.out.println("Introduce un numero del (1 a 9.999.999) o 0 si desea salir del programa");
        return lector.nextInt();
    }
    // FUNCION PARA LA CONVERSION DE NUMERO A EGIPCIO
    private static String aNumeroEgipcio(int numero){
        //CADENA QUE GUARDE LOS RESULTADOS
        String resultado=" ";
        
        for (int i = 0; i < potencia.length; i++) {
            // CANTIDAD
           int cantidad= numero / potencia[i];
            //VALOR DEL NUMERO
           numero = numero % potencia[i];

            for (int j = 0; j < cantidad; j++) {
                //VALOR RESULTADO
                resultado = resultado + simbolo[i];
            }
        }
        return resultado;
    }

    private static void imprimirResultado(String resultado){
        //SOLCUION EN NOTACION EGIPCIA
        System.out.println("Resultado en notación egipcia :" + resultado);
    }

    public static void main(String[] args) {
        //SI NUMERO EN EL INTERVALO
        while (true){
            int numero=leeNumero();
            //SI NUMERO ES 0 VUELVE AL INICIO
            if(numero==0){
                break;
            }
            //GUARDE EN LA CADENA EL RESULTADO DE LA CONVERSION
            String resultado=aNumeroEgipcio(numero);
            imprimirResultado(resultado);
        }
        lector.close();
    }
}
