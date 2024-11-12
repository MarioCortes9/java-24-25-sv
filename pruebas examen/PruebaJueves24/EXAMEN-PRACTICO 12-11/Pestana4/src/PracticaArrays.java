import java.util.Arrays;

public class PracticaArrays {

    private static final int[] array = new int[10];

    public static void main(String[] args) {
        rellenarAscendente();
        mostrarInverso();
        rellenarPares();
        mostrarPares();
        rellenarImpares();
        duplicarElementos();
        calcularSuma();
        buscarMaxMin();
    }

    // Rellenar el array en orden ascendente (0, 1, 2, ..., 9)
    private static void rellenarAscendente() {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        System.out.println("Array en orden ascendente: " + Arrays.toString(array));
    }

    // Mostrar el array en orden inverso
    private static void mostrarInverso() {
        System.out.print("Array en orden inverso: ");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Rellenar el array con números pares (0, 2, 4, ..., 18)
    private static void rellenarPares() {
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2;
        }
        System.out.println("Array con números pares: " + Arrays.toString(array));
    }

    // Mostrar elementos de dos en dos (primer y segundo, tercer y cuarto, etc.)
    private static void mostrarPares() {
        System.out.print("Elementos de dos en dos: ");
        for (int i = 0; i < array.length; i += 2) {
            System.out.print("[" + array[i] + ", " + (i + 1 < array.length ? array[i + 1] : " ") + "] ");
        }
        System.out.println();
    }

    // Rellenar el array con números impares (1, 3, 5, ..., 19)
    private static void rellenarImpares() {
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2 + 1;
        }
        System.out.println("Array con números impares: " + Arrays.toString(array));
    }

    // Duplicar cada elemento del array
    private static void duplicarElementos() {
        for (int i = 0; i < array.length; i++) {
            array[i] *= 2;
        }
        System.out.println("Array con cada elemento duplicado: " + Arrays.toString(array));
    }

    // Calcular la suma de todos los elementos
    private static void calcularSuma() {
        int suma = 0;
        for (int num : array) {
            suma += num;
        }
        System.out.println("Suma de todos los elementos: " + suma);
    }

    // Buscar el valor máximo y mínimo del array
    private static void buscarMaxMin() {
        int max = array[0];
        int min = array[0];
        for (int num : array) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        System.out.println("Valor máximo: " + max);
        System.out.println("Valor mínimo: " + min);
    }
}


