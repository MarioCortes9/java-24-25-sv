import java.util.Scanner;

public class Main {

    public static int contarCombinaciones(String cadenaRomana) {
        // dígitos romanos válidos
        String[] digitosRomanos = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int[] resParcial = new int[cadenaRomana.length() + 1]; // guardar resultados parciales
        resParcial[0] = 1; // caso base


        for (int i = 1; i <= cadenaRomana.length(); i++) {
            // recorremos los dígitos romanos posibles para ver si coinciden con base
            for (String romano : digitosRomanos) {
                if (i >= romano.length() && cadenaRomana.substring(i - romano.length(), i).equals(romano)) {
                    resParcial[i] += resParcial[i - romano.length()]; // sumamos las combinaciones previas válidas
                }
            }
        }

        // res final
        return resParcial[cadenaRomana.length()];
    }

    //procesar las cadenas
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer múltiples líneas hasta que no haya más entradas
        while (scanner.hasNextLine()) {
            String telefono = scanner.nextLine().trim(); // Leer cada línea de entrada
            int resultado = contarCombinaciones(telefono); // Contar combinaciones válidas
            System.out.println(resultado);
        }
    }
}
