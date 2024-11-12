public class MaximoArray {
    public static void main(String[] args) {
        int[] numeros = {4, 2, 7, 1, 9, 3};
        int max = numeros[0]; // para que coja el primer valor del array

        for (int i = 1; i < numeros.length; i++) { // length es propiedad no metodo osea que no ()
            if (numeros[i] > max) {
                max = numeros[i];
            }
        }

        System.out.println("El máximo es: " + max);
    }
}
