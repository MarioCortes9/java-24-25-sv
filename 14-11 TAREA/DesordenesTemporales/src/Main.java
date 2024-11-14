import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // número de habitantes
            int num = scanner.nextInt();

            // numero de habitantes es 0, terminamos
            if (num == 0)
                break;

            // edades (días) de los habitantes
            int[] edades = new int[num];
            for (int i = 0; i < num; i++) {
                edades[i] = scanner.nextInt();
            }

            // acumular el desorden total
            int desordenTotal = 0;

            // calcular el desorden
            for (int i = 0; i < num; i++) {
                //cada persona,cuántas personas anteriores tienen menos días vividos
                for (int j = 0; j < i; j++) {
                    if (edades[j] > edades[i]) {
                        desordenTotal++;
                    }
                }
            }

            System.out.println(desordenTotal);
        }
    }
}
