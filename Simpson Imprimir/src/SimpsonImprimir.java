
public class SimpsonImprimir {
    // VISIBLE A NIVEL DE LA CLASE SIMPSON
    static char[][] tablero = new char[10][10]; //  (0 a N-1)
    // FIN

    // Software de gestión de venta ONLINE
    public static void rellenarTablero(char pers){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10 ; j++) {
                tablero[i][j] = '#'; // para que rellene el tablero con almohadillas
            }
        }
    }// rellenarTablero ('L');

    public static void imprimirTablero() {   // funcion para imprimir el tablero por pantalla
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(tablero[i][j] + " "); // imprime el caracter del tablero
            }
            System.out.println(); // saque por pantalla cada linea
        }
    }


    public static void main(String[] args) {
        System.out.println("Rellena el tablero con almohadillas");

        // Rellenar el tablero con el carácter '#'

        char personaje = '#';
        rellenarTablero(personaje);
        System.out.println("Tablero rellenado con '#':");//rellene con almohadillas
        imprimirTablero();


        // for ()
    }
}
