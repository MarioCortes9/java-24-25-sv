import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        //cadena donde guarde los primeros digitos de cada pais
        String[] codigosPais = {"380", "50", "539", "560", "70", "759", "850", "890"};
        //cadena que guarde los paises
        String[] nombresPais = {"Bulgaria", "Inglaterra", "Irlanda", "Portugal", "Noruega", "Venezuela", "Cuba", "India"};

        System.out.println("Ingrese los códigos de barras EAN");

        while (true){
            String codigo = leer.nextLine();

            // si es 0...
            if (codigo.equals("0")) {
                break;
            }

            // mira a que codigo de ean corresponde
            //mediante un boolean
            boolean esValido = false;
            if (codigo.length() == 8) {
                esValido = verificarEAN8(codigo);
            } else if (codigo.length() == 13) {
                esValido = verificarEAN13(codigo);
            }


            if (esValido) {
                if (codigo.length() == 13) {
                    String prefijo = codigo.substring(0, 3); // para coger los tres primeros caracteres de cada codigo
                    String pais = obtenerPais(prefijo, codigosPais, nombresPais);
                    System.out.println("SI " + pais); // salida desco o ingla
                } else {
                    System.out.println("SI"); //salida si
                }
            } else {
                System.out.println("NO");//salida no
            }
        }

       leer.close();
    }

    // miro si es ean-8
    public static boolean verificarEAN8(String codigo) {
        int suma = 0;
        for (int i = 0; i < 7; i++) {
            int digito = codigo.charAt(i) - '0';
            suma += (i % 2 == 0) ? digito * 3 : digito; //chatgpt
        }
        int digitoControl = (10 - (suma % 10)) % 10;
        return digitoControl == (codigo.charAt(7) - '0');//chatgpt
    }

    // mirar si es EAN-13
    public static boolean verificarEAN13(String codigo) {
        int suma = 0;
        for (int i = 0; i < 12; i++) {
            int digito = codigo.charAt(i) - '0';
            suma += (i % 2 == 0) ? digito : digito * 3;//chatgpt
        }
        int digitoControl = (10 - (suma % 10)) % 10;
        return digitoControl == (codigo.charAt(12) - '0');//chatgpt no sabia hacer esos pasos
    }

    // nombre pais segun prefijo
    public static String obtenerPais(String prefijo, String[] codigosPais, String[] nombresPais) {
        for (int i = 0; i < codigosPais.length; i++) {
            //comando de chatgpt pq me daba muchos fallos
            if (prefijo.startsWith(codigosPais[i])) {
                return nombresPais[i];
            }
        }
        return "Desconocido";
    }
}
