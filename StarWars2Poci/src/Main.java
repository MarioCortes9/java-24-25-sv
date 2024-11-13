import java.util.Random;
import java.util.Scanner;

public class Main {

    private static int MAX_DIMENSION = 10;
    private static char[][] tableroJUG1 = new char[MAX_DIMENSION][MAX_DIMENSION];
    private static char[][] tableroJUG2 = new char[MAX_DIMENSION][MAX_DIMENSION];
    private static int filaYODA, columnaYODA;
    private static int filaVADER, columnaVADER;
    private static Random aleatorio = new Random();
    private static final char YODA = 'Y';
    private static final char VADER = 'V';
    private static final char DARTHMAUL = 'D';
    private static final char R2D2 = 'R';
    private static final char LIBRE = 'L';
    private static final char MURO = 'M';
    private static final char FINAL = 'F';
    private static int cantidad3 = 5;
    private static int cantidadM = 5;
    private static int vidasJug1 = 3;
    private static int vidasJug2 = 3;
    private static int jugador1, jugador2;
    private static final char POCION = 'P';
    private static int cantidadPociones = 5;
    private static boolean puedeIntercambiar = false;  // boolenaopara permitir el intercambio
    private static Scanner leer = new Scanner(System.in);


    //inicializar tablero 1
    private static void inicializarTablero1() {
        for (int i = 0; i < MAX_DIMENSION; i++) {
            for (int j = 0; j < MAX_DIMENSION; j++) {
                tableroJUG1[i][j] = LIBRE;
            }
        }
    }

    //inicializar tablero 2
    private static void inicializarTablero2() {
        for (int i = 0; i < MAX_DIMENSION; i++) {
            for (int j = 0; j < MAX_DIMENSION; j++) {
                tableroJUG2[i][j] = LIBRE;
            }
        }
    }

    //colocamos Y y V de forma aleatoria
    private static void colocarYoda() {
        do {
            filaYODA = aleatorio.nextInt(MAX_DIMENSION);
            columnaYODA = aleatorio.nextInt(MAX_DIMENSION);
        } while (tableroJUG1[filaYODA][columnaYODA] != LIBRE);
        tableroJUG1[filaYODA][columnaYODA] = YODA;
    }

    private static void colocarVader() {
        do {
            filaVADER = aleatorio.nextInt(MAX_DIMENSION);
            columnaVADER = aleatorio.nextInt(MAX_DIMENSION);
        } while (tableroJUG2[filaVADER][columnaVADER] != LIBRE);
        tableroJUG2[filaVADER][columnaVADER] = VADER;
    }

    //5D EN YODA Y 5R EN DARTHVADER
    private static void rellenarD(int cantidad3) {
        for (int i = 0; i < cantidad3; i++) {
            int filaD, columnaD;
            do {
                filaD = aleatorio.nextInt(MAX_DIMENSION);
                columnaD = aleatorio.nextInt(MAX_DIMENSION);
            } while (tableroJUG1[filaD][columnaD] != LIBRE);
            tableroJUG1[filaD][columnaD] = DARTHMAUL;
        }
    }

    private static void rellenarR2D2(int cantidad3) {
        for (int i = 0; i < cantidad3; i++) {
            int filaR, columnaR;
            do {
                filaR = aleatorio.nextInt(MAX_DIMENSION);
                columnaR = aleatorio.nextInt(MAX_DIMENSION);
            } while (tableroJUG2[filaR][columnaR] != LIBRE);
            tableroJUG2[filaR][columnaR] = R2D2;
        }
    }

    // CELDAS NO OCUPADAS libre HECHO

    //RELLENAR 5 MUROS LETRA M SOBRE CADA TABLERO, MURO NO DESPLAZARME

    private static void colocarMuros(int cantidadM) {
        for (int i = 0; i < cantidadM; i++) {
            int filaM, columnaM;
            do {
                filaM = aleatorio.nextInt(MAX_DIMENSION);
                columnaM = aleatorio.nextInt(MAX_DIMENSION);
            } while (tableroJUG1[filaM][columnaM] != LIBRE);
            tableroJUG1[filaM][columnaM] = MURO;
        }
        for (int i = 0; i < cantidadM; i++) {
            int filaM, columnaM;
            do {

                filaM = aleatorio.nextInt(MAX_DIMENSION);
                columnaM = aleatorio.nextInt(MAX_DIMENSION);
            } while (tableroJUG2[filaM][columnaM] != LIBRE);
            tableroJUG2[filaM][columnaM] = MURO;
        }
    }

    //SITUA LA CASILLA FINAL [9][9]

    private static void colocarFinal(char[][] tableroJUG1, char[][] tableroJUG2) {
        tableroJUG2[9][9] = FINAL;
        tableroJUG1[9][9] = FINAL;
    }

    //colocar las pociones en ambos tab

    private static void repartirPociones() {
        for (int i = 0; i < cantidadPociones; i++) {
            int filaP, columnaP;
            do {
                filaP = aleatorio.nextInt(MAX_DIMENSION);
                columnaP = aleatorio.nextInt(MAX_DIMENSION);
            } while (tableroJUG1[filaP][columnaP] != LIBRE);
            tableroJUG1[filaP][columnaP] = POCION;
        }
        for (int i = 0; i < cantidadPociones; i++) {
            int filaP, columnaP;
            do {
                filaP = aleatorio.nextInt(MAX_DIMENSION);
                columnaP = aleatorio.nextInt(MAX_DIMENSION);
            } while (tableroJUG2[filaP][columnaP] != LIBRE);
            tableroJUG2[filaP][columnaP] = POCION;
        }
    }

    //comprobar si hay ganador

    private static boolean verGanador() {
        if (filaYODA == 9 && columnaYODA == 9) {
            System.out.println("Yoda ha ganado");
            return true;
        }
        if (filaVADER == 9 && columnaVADER == 9) {
            System.out.println("Vader ha ganado");
            return true;
        }
        return false;
    }

    //imprimir los tableros

    private static void imprimirTablero1() {
        for (int i = 0; i < MAX_DIMENSION; i++) {
            for (int j = 0; j < MAX_DIMENSION; j++) {
                System.out.print(tableroJUG1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("");
        System.out.println("");
    }

    private static void imprimirTablero2() {
        for (int i = 0; i < MAX_DIMENSION; i++) {
            for (int j = 0; j < MAX_DIMENSION; j++) {
                System.out.print(tableroJUG2[i][j] + " ");
            }
            System.out.println();
        }
    }

   //CADA JUGAR 3 VIDAS , CASILLA MALO(D-R) -VIDA
    private static void caerVidas(int vidasJug) {
        if (jugador1 == 1) {
            if (tableroJUG1[filaYODA][columnaYODA] == DARTHMAUL || tableroJUG1[filaYODA][columnaYODA] == R2D2) {
                vidasJug1 = vidasJug1 - 1;
                System.out.println("Yoda ha perdido una vida");
            } else {
                if (jugador2 == 2) {
                    if (tableroJUG2[filaVADER][columnaVADER] == DARTHMAUL || tableroJUG2[filaVADER][columnaVADER] == R2D2) {
                        vidasJug2 = vidasJug2 - 1;
                        System.out.println("Vader ha perdido una vida");
                    }
                }
            }
        }
    }

    // ganador

    private static boolean ganaPrimero() {
        if (jugador1 == 1 && filaYODA == 9 && columnaYODA == 9) {  // si llega al final [9][9]
            System.out.println("Yoda ha ganado");
            return true;
        }
        if (jugador2 == 2 && filaVADER == 9 && columnaVADER == 9) {  // si llega al final [9][9]
            System.out.println("Vader ha ganado");
            return true;
        }
        return false;
    }


    //jugar
    //d,a,w,s,q,r,e,b
    private static boolean desplazarJugador(int turno) {
        int nuevafYODA = filaYODA, nuevacYODA = columnaYODA, nuevafVADER = filaVADER, nuevacVADER = columnaVADER;
        String direccion;

        // Cambiar flujo para que puedas manejar el turno
        if (turno == 1) {  // Turno de Yoda
            System.out.println("Turno de Yoda. Introduce un movimiento: W, A, S, D, Q, R, E, B");
            direccion = leer.nextLine().toUpperCase();  // Leer el movimiento de Yoda
        } else {  // Turno de Vader
            System.out.println("Turno de Vader. Introduce un movimiento: W, A, S, D, Q, R, E, B");
            direccion = leer.nextLine().toUpperCase();  // Leer el movimiento de Vader
        }

        // Procesar el movimiento del jugador (Yoda o Vader)
        if (turno == 1) {
            switch (direccion) {
                case "W":
                    nuevafYODA--;
                    break;
                case "A":
                    nuevacYODA--;
                    break;
                case "S":
                    nuevafYODA++;
                    break;
                case "D":
                    nuevacYODA++;
                    break;
                case "Q":
                    nuevafYODA--;
                    nuevacYODA--;
                    break;
                case "R":
                    nuevafYODA--;
                    nuevacYODA++;
                    break;
                case "E":
                    nuevafYODA++;
                    nuevacYODA--;
                    break;
                case "B":
                    nuevafYODA++;
                    nuevacYODA++;
                    break;
                default:
                    return false; // Movimiento inválido
            }

            // Comprobar límites
            if (nuevafYODA < 0 || nuevafYODA >= MAX_DIMENSION || nuevacYODA < 0 || nuevacYODA >= MAX_DIMENSION) {
                System.out.println("Fuera de los límites del tablero Yoda");
                return false;
            }

            // Actualizar posiciones de Yoda
            filaYODA = nuevafYODA;
            columnaYODA = nuevacYODA;
            tableroJUG1[filaYODA][columnaYODA] = YODA;
        }

        if (turno == 2) {
            switch (direccion) {
                case "W":
                    nuevafVADER--;
                    break;
                case "A":
                    nuevacVADER--;
                    break;
                case "S":
                    nuevafVADER++;
                    break;
                case "D":
                    nuevacVADER++;
                    break;
                case "Q":
                    nuevafVADER--;
                    nuevacVADER--;
                    break;
                case "R":
                    nuevafVADER--;
                    nuevacVADER++;
                    break;
                case "E":
                    nuevafVADER++;
                    nuevacVADER--;
                    break;
                case "B":
                    nuevafVADER++;
                    nuevacVADER++;
                    break;
                default:
                    return false; // Movimiento inválido
            }

            // Comprobar límites
            if (nuevafVADER < 0 || nuevafVADER >= MAX_DIMENSION || nuevacVADER < 0 || nuevacVADER >= MAX_DIMENSION) {
                System.out.println("Fuera de los límites del tablero Vader");
                return false;
            }

            // Actualizar posiciones de Vader
            filaVADER = nuevafVADER;
            columnaVADER = nuevacVADER;
            tableroJUG2[filaVADER][columnaVADER] = VADER;
        }

        return true;
    }
    public static void main(String[] args) {
        inicializarTablero1();
        inicializarTablero2();
        colocarYoda();
        colocarVader();
        repartirPociones();

        boolean ganador = false;
        int turno = 1;

        // Comenzar el juego
        while (!ganador) {
            if (turno == 1) {
                imprimirTablero1();
                ganador = verGanador();
                if (ganador) break;
            } else {
                imprimirTablero2();
                ganador = verGanador();
                if (ganador) break;
            }

            if (!desplazarJugador(turno)) continue;

            turno = (turno == 1) ? 2 : 1; // Alternar entre los jugadores
        }
    }
}


