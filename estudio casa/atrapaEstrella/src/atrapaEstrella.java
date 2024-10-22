import java.io.FileOutputStream;
import java.util.Random;
import java.util.Scanner;

public class atrapaEstrella {

    private static int MAX_DIMENSION=10;
    private static char[][] tablero = new char[MAX_DIMENSION][MAX_DIMENSION];
    private static int filaJugador,columnaJugador;
    private static int filaEstrella,columnaEstrella;
    private static int movimientos =15;
    private static Random aleatorio = new Random();


    public static void main(String[] args) {
        inicializarTablero();
        colocarJugador();
        colocarEstrella();
        jugar();

    }

    //INICIALIZAMOS EL TABLERO
    private static void inicializarTablero(){
        for (int i = 0; i < MAX_DIMENSION; i++) {
            for (int j = 0; j < MAX_DIMENSION; j++) {
                tablero[i][j]= ' ';
        }
    }
}
    //COLOCAMOS AL JUGADOR
    private static void colocarJugador(){
        filaJugador= aleatorio.nextInt(MAX_DIMENSION);
        columnaJugador=aleatorio.nextInt(MAX_DIMENSION);
        tablero[filaJugador][columnaJugador]= 'J';
    }

    //COLOCAR ESTRELLA
    private static void colocarEstrella(){
        do {
            filaEstrella = aleatorio.nextInt(MAX_DIMENSION);
            columnaEstrella = aleatorio.nextInt(MAX_DIMENSION);
        }while (tablero[filaEstrella][columnaEstrella]!= ' ');
        tablero[filaEstrella][columnaEstrella]='*';
        }
    // imprimir tablero
    private static void imprimirTablero() {
        for (int i = 0; i < MAX_DIMENSION; i++) {
            for (int j = 0; j < MAX_DIMENSION; j++) {
                System.out.println(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
    //desplazamiento

    private static boolean moverJugador(String direccion){
            int nuevaFila=filaJugador, nuevaColumna=columnaJugador;

            switch (direccion){
                case"W": nuevaFila--; break;
                case"A":nuevaColumna-- ;break;
                case"S":nuevaFila++;break;
                case"D":nuevaColumna++;break;
                default: return false;   // movimiento invalido
            }

            //limites de tablero
            if(nuevaFila<0 || nuevaFila>= MAX_DIMENSION || nuevaColumna<0 || nuevaColumna>=MAX_DIMENSION){
                System.out.println("Fuera de tablero");
                return false;
            }

            //NUEVAS POSICIONES
            tablero[filaJugador][columnaJugador]= '-'; //para limpiar la posicion
            filaJugador=nuevaFila;
            columnaJugador=nuevaColumna;
            tablero[filaJugador][columnaJugador]= 'J';

            return true;
        }

        private static void jugar() {
            Scanner leer = new Scanner(System.in);

            while (movimientos > 0) {
                imprimirTablero();
                System.out.println("Movimientos restantes: " + movimientos);
                System.out.print("Mueve al jugador (W: arriba, A: izquierda, S: abajo, D: derecha): ");
                String movimiento = leer.nextLine().toUpperCase(); // Lee el movimiento del jugador

                if (moverJugador(movimiento)) {
                    // Verificar si el jugador ha atrapado la estrella
                    if (filaJugador == filaEstrella && columnaJugador == columnaEstrella) {
                        System.out.println("¡Has atrapado la estrella! ¡Ganaste!");
                        break;
                    }
                }

                movimientos--; // Resta un movimiento

                if (movimientos == 0) {
                    System.out.println("Te quedaste sin movimientos. ¡Perdiste!");
                    System.out.println("La estrella estaba en la posición (" + filaEstrella + ", " + columnaEstrella + ").");
                }
            }
    }
}


