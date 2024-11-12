//OPTIMIZA EL CÓDIGO
public class BuscarNumero {
    public static void main(String[] args) {
        int[] numeros = {4, 2, 9, 1, 5, 3};
        int objetivo = 5;
        boolean encontrado = false;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == objetivo) {
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            System.out.println("Número encontrado");
        } else {
            System.out.println("Número no encontrado");
        }
    }
}



