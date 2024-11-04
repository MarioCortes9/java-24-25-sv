import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        while (true) {
            String codigoBarras = leer.nextLine();
            if (codigoBarras.equals("0"))
                break;

            String codigo = comprobarCodigo(codigoBarras);
            if (codigo.length() == 8) {
                if (leerEAN8(codigo)) {
                    System.out.println("SI");
                } else {
                    System.out.println("NO");
                }
            } else if (codigo.length() == 13) {
                System.out.println(leerEAN13(codigo));
            } else {
                System.out.println("NO");
            }
        }
        leer.close();
    }


    private static String comprobarCodigo(String codigo) {
        while (codigo.length() < 8) {
            codigo = "0" + codigo;
        }
        return codigo;
    }

    private static boolean verificarEAN(String codigo, int longitud) {
        int digitoControlCalculado = calcularDigitoControl(codigo.substring(0, longitud - 1));
        int digitoControl = Character.digit(codigo.charAt(longitud - 1), 10);
        return digitoControlCalculado == digitoControl;
    }

    private static boolean leerEAN8(String codigo) {
        return verificarEAN(codigo, 8);
    }

    private static String leerEAN13(String codigo) {
        if (verificarEAN(codigo, 13)) {
            String pais = identificarPais(codigo);
            return "SI " + pais;
        } else {
            return "NO";
        }
    }


    private static int calcularDigitoControl(String codigo) {
        int suma = 0;
        for (int i = 0; i < codigo.length(); i++) {
            int digito = Character.digit(codigo.charAt(i), 10);
            suma += (i % 2 == 0) ? digito * 3 : digito;
        }
        int modulo = suma % 10;
        return (modulo == 0) ? 0 : 10 - modulo;
    }

   
    private static String identificarPais(String codigo) {
        String prefijo = codigo.substring(0, 3);

        if (prefijo.equals("0")) return "EEUU";
        else if (prefijo.equals("539")) return "Irlanda";
        else if (prefijo.equals("759")) return "Venezuela";
        else if (prefijo.equals("380")) return "Bulgaria";
        else if (prefijo.equals("560")) return "Portugal";
        else if (prefijo.equals("850")) return "Cuba";
        else if (prefijo.equals("50")) return "Inglaterra";
        else if (prefijo.equals("70")) return "Noruega";
        else if (prefijo.equals("890")) return "India";

        return "Desconocido";
    }
}
