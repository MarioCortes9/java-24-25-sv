//ENCUENTRA EL ERROR

public class ComparacionCadenas {
    public static void main(String[] args) {
        String cadena1 = "Hola";
        String cadena2 = "Hola";


        /*Por eso, aunque cadena1 y cadena2 contienen el mismo texto,
        es mejor usar el método .equals() para comparar los contenidos de las cadenas*/

        if (cadena1.equals(cadena2)) {
            System.out.println("Las cadenas son iguales");
        } else {
            System.out.println("Las cadenas son diferentes");
        }
    }
}

