import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        // CTRL + ALT + L
        Scanner sc = new Scanner(System.in);


        while (true) {
            String codigo = sc.nextLine().trim();
            if (codigo.equals("0")) break;


            // 1º) LONGITUD DE LA ENTRADA
            /******************************************************************/
            int longitud = codigo.length();
            /******************************************************************/
            // FIN


            /* 2º) COMPLETAR CON CEROS*/
            /******************************************************************/
            boolean esEAN8 = longitud <= 8;
            boolean esEAN13 = longitud > 8 && longitud <= 13;
            if (esEAN8) {
                while (codigo.length() < 8) {
                    codigo = "0" + codigo;  //menor de 8 le meto 0 delante para completar
                }
            } else if (esEAN13) {
                while (codigo.length() < 13) {
                    codigo = "0" + codigo;
                }
            }
            /* FIN COMPLETAR CON CEROS*/
            /******************************************************************/


            int sumaImpares = 0; // *3
            int sumaPares = 0;   // *1
            int contPos = 0;
            /* 3º) SUMA PARES E IMPARES*/
            /******************************************************************/
            for (int i = codigo.length() - 2; i >= 0; i--) { // Me salto el último dígito
                int digito = Integer.parseInt(String.valueOf(codigo.charAt(i)));
                contPos++;  //Integer.parseInt convierte el char de charAt a numero, charAt caracter a posicion x
                if (contPos % 2 == 0) {   // resto disntito a 0
                    sumaPares = sumaPares + (digito * 1);   // pares es x1
                } else {
                    sumaImpares = sumaImpares + (digito * 3);  // impares es x3
                }
            }


            int sumaPonderada = sumaImpares + sumaPares;   // aqui realizp la suma de los pares y impares en un entero aparte
            /* FIN SUMA PARES E IMPARES*/
            /******************************************************************/
            /* CALCULAR DÍGITO DE COMPROBACIÓN*/
            /******************************************************************/
            int digitoControlCalculado;
            int resto = sumaPonderada % 10;  // miro si es multiplo de 10
            digitoControlCalculado = (resto == 0) ? 0 : (10 - resto);// si no es a 10 le resto el resto
            // el interrogante de arriba ()?:; es un if abreviado (operador ternario) si es
            // true ejecuta a continuacion interrogante y false despues de los dos puntos
            // () ? {} : {} ;
            /* CALCULAR DÍGITO DE COMPROBACIÓN*/
            /******************************************************************/


// Verificación del dígito de control
            int digitoControlReal = Integer.parseInt(String.valueOf(codigo.charAt(codigo.length() - 1)));
            boolean controlValido = (digitoControlCalculado == digitoControlReal);
// Resultado inicial para el control
            if (controlValido) {
                System.out.print("SI");
            } else {
                System.out.println("NO");
                continue;
            }
// Identificación del país para EAN-13
               /*if (esEAN13 && controlValido) {
                   int prefijoPais = Integer.parseInt(codigo.substring(0, 3));
                   if (prefijoPais == 380) System.out.print(" Bulgaria");
                   else if (prefijoPais == 50) System.out.print(" Inglaterra");
                   else if (prefijoPais == 560) System.out.print(" Portugal");
                   else if (prefijoPais == 70) System.out.print(" Noruega");
                   else if (prefijoPais == 590) System.out.print(" Polonia");
                   else if (prefijoPais == 850) System.out.print(" Cuba");
                   else if (prefijoPais == 890) System.out.print(" India");
                   else System.out.print(" Desconocido");
               }*/


            if (esEAN13 && controlValido) {
                int[] prefijos = {380, 50, 560, 70, 590, 850, 890};
                String[] paises = {"Bulgaria", "Inglaterra", "Portugal", "Noruega", "Polonia", "Cuba", "India"};


                String nombrePais = "Desconocido";
                int prefijoPais = 0;
                for (int i = 0; i < prefijos.length; i++) {
                    prefijoPais = Integer.parseInt(codigo.substring/* COGE X POSICIONES DEL CODIGO*/(0, (String.valueOf( prefijos[i] )).length()) );
                    if (prefijos[i] == prefijoPais) {
                        nombrePais = paises[i];
                        break;
                    }
                }


                System.out.print(" " + nombrePais);
            }


            System.out.println();




        }
        sc.close();
    }


}



