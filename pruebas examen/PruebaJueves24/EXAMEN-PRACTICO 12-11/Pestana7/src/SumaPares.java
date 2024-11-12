import java.util.Scanner;

public class SumaPares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número entero positivo: ");
        int n = scanner.nextInt();

        /*for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                suma += i;
            }
        }*/

        int suma= (n/2) * (n/2+1);    //   ESTO ES LO MISMO QUE ARRIBA EL I%2 Y LUEGO AL RSULTADO SUMARLE 1 COMO SUMA=+1

        System.out.println("La suma de los números pares de 1 a " + n + " es: " + suma);
        //scanner.close();
    }
}
