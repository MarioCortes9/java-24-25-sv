import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int huevos = scanner.nextInt(); // Nnumero de huevos
            int capacidad = scanner.nextInt(); // capacidad de la olla


            if (huevos == 0 && capacidad == 0) {
                break;
            }

            //número de tandas necesarias
            int tandas = (huevos + capacidad - 1) / capacidad;
            // tiempo total en minutos
            int tiempoTotal = tandas * 10;


            System.out.println(tiempoTotal);
        }
    }
}