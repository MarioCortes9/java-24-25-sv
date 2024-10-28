/*Entrada

-La entrada está formada por un número indeterminado de casos de prueba.

-Cada caso de prueba consiste en una única línea cuyo primer carácter
es el código de la letra 'p', seguido de un mensaje codificado con el
método Cesar descrito antes utilizando el desplazamiento adecuado.
para que la letra 'p' se codifique con ese primer carácter.

-Los casos de prueba terminan con un mensaje codificado que,
una vez traducido, contiene exactamente la cadena "FIN".
Cuando se lee este mensaje codificado el programa debe terminar
sin generar ninguna otra salida más.

Salida

-Para cada caso de prueba, el programa indicará el número de vocales
no acentuadas que contiene el mensaje codificado.
*/


import java.util.Scanner;

public class Main {

    // Primero, creamos una fuicnion que calcule los desplazamientos
    private static int calcularDesplazamiento(char caracterEntrada) {
        return (caracterEntrada - 'p' + 26) % 26; // Desplazamiento desde 'p' segun las tablñas ascii y el numero de letras del abecedario
    }

    //funcuion para decodificar
    private static char decodificar(char letra, int desplazamiento) {
        if (letra >= 'a' && letra <= 'z') { // esto es para ver si es minusucla
            //calcula y mira si el resultado esta del 0-25 del abecedario
            return (char) ('a' + (letra - 'a' - desplazamiento + 26) % 26);
        }else if (letra >= 'A' && letra <= 'Z') {// si es mayuscula
            //mismos pasos que antes pero en mayus
            return (char) ('A' + (letra - 'A' - desplazamiento + 26) % 26);
        }else{
            return letra; // si no es letra, vuelve a su original
        }
    }

    // funcion vocales no acentuadas de la salida
    private static int contarVocales(String mensaje) {// esta cadena es para la frase
        int contadorVocales = 0;// creamos un contador de vocales
        for (char c : mensaje.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) >= 0) { // cadena que incluye las vocales , a la cual le pedimos que busque una letra c en ella(ponemos c por el enunciado)
                contadorVocales++;
            }
        }
        return contadorVocales;
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        while (true) {
            // Leer una línea del mensaje
            String linea = leer.nextLine(); // lee la frase
            if (linea.equals("")) continue; // si la linea esta vacia salta

            char primeraLetra = linea.charAt(0); //caracter pos 0
            String mensajeCodificado = linea.substring(1);//mensaje codificado
            // substring sirve opara extraer parte del string

            //  ver si  mensaje codificado es "FIN"
            if (mensajeCodificado.equals("FIN")) {
                break; // terminar el programa
            }

            // calcular el desplazamiento
            int desplazamiento = calcularDesplazamiento(primeraLetra);

            // decodificar el mensaje
            // stringbuilder sirbe para construir el mensaje codificado
            StringBuilder mensajeDecodificado = new StringBuilder();
            for (char c : mensajeCodificado.toCharArray()) {
                mensajeDecodificado.append(decodificar(c, desplazamiento));
            }

            // Contar vocales no acentuadas
            int vocales = contarVocales(mensajeDecodificado.toString());

            // Imprimir el resultado
            System.out.println(vocales);
        }

        leer.close();
    }
}