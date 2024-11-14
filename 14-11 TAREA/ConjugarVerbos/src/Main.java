import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            String entrada = scanner.nextLine().trim();
            String[] partes = entrada.split(" ");  // separo el verbo y el tiempo
            String verbo = partes[0];
            String tiempo = partes[1];

            // si entrada es terminar T, salir
            if (verbo.equals("terminar") && tiempo.equals("T")) {
                break;
            }

            // raiz del verbo y su terminacion
            String raiz = verbo.substring(0, verbo.length() - 2);
            String terminacion = verbo.substring(verbo.length() - 2);

            // array para las conjugaciones
            String[] conjugaciones = new String[6];


            if (tiempo.equals("A")) {  // Presente
                if (terminacion.equals("ar")) {
                    conjugaciones[0] = "yo " + raiz + "o";
                    conjugaciones[1] = "tu " + raiz + "as";
                    conjugaciones[2] = "el " + raiz + "a";
                    conjugaciones[3] = "nosotros " + raiz + "amos";
                    conjugaciones[4] = "vosotros " + raiz + "áis";
                    conjugaciones[5] = "ellos " + raiz + "an";
                } else if (terminacion.equals("er")) {
                    conjugaciones[0] = "yo " + raiz + "o";
                    conjugaciones[1] = "tu " + raiz + "es";
                    conjugaciones[2] = "el " + raiz + "e";
                    conjugaciones[3] = "nosotros " + raiz + "emos";
                    conjugaciones[4] = "vosotros " + raiz + "eis";
                    conjugaciones[5] = "ellos " + raiz + "en";
                } else if (terminacion.equals("ir")) {
                    conjugaciones[0] = "yo " + raiz + "o";
                    conjugaciones[1] = "tu " + raiz + "es";
                    conjugaciones[2] = "el " + raiz + "e";
                    conjugaciones[3] = "nosotros " + raiz + "imos";
                    conjugaciones[4] = "vosotros " + raiz + "ís";
                    conjugaciones[5] = "ellos " + raiz + "en";
                }
            } else if (tiempo.equals("P")) {  // preterito perfecto simple
                if (terminacion.equals("ar")) {
                    conjugaciones[0] = "yo " + raiz + "e";
                    conjugaciones[1] = "tu " + raiz + "aste";
                    conjugaciones[2] = "el " + raiz + "o";
                    conjugaciones[3] = "nosotros " + raiz + "amos";
                    conjugaciones[4] = "vosotros " + raiz + "asteis";
                    conjugaciones[5] = "ellos " + raiz + "aron";
                } else if (terminacion.equals("er")) {
                    conjugaciones[0] = "yo " + raiz + "í";
                    conjugaciones[1] = "tu " + raiz + "iste";
                    conjugaciones[2] = "el " + raiz + "ió";
                    conjugaciones[3] = "nosotros " + raiz + "imos";
                    conjugaciones[4] = "vosotros " + raiz + "isteis";
                    conjugaciones[5] = "ellos " + raiz + "ieron";
                } else if (terminacion.equals("ir")) {
                    conjugaciones[0] = "yo " + raiz + "í";
                    conjugaciones[1] = "tu " + raiz + "iste";
                    conjugaciones[2] = "el " + raiz + "ió";
                    conjugaciones[3] = "nosotros " + raiz + "imos";
                    conjugaciones[4] = "vosotros " + raiz + "isteis";
                    conjugaciones[5] = "ellos " + raiz + "ieron";
                }
            } else if (tiempo.equals("F")) {  // futuro
                String raizFuturo = verbo;
                conjugaciones[0] = "yo " + raizFuturo + "é";
                conjugaciones[1] = "tu " + raizFuturo + "ás";
                conjugaciones[2] = "el " + raizFuturo + "á";
                conjugaciones[3] = "nosotros " + raizFuturo + "emos";
                conjugaciones[4] = "vosotros " + raizFuturo + "éis";
                conjugaciones[5] = "ellos " + raizFuturo + "án";
            }

            for (int i = 0; i < 6; i++) {
                System.out.println(conjugaciones[i]);
            }
        }
    }
}
