/* Crea un juego de exploración en un tablero de 10x10
,donde un personaje llamado "Explorador" ('E')
se mueve en busca de un tesoro ('T'). El tablero
también contiene algunos obstáculos ('O') que no
se pueden atravesar. El jugador tiene 10 movimientos
disponibles. Si encuentra el tesoro antes de que se
acaben los movimientos, gana el juego. Si se queda sin
movimientos, pierde.


Reglas:

-El explorador ('E') empieza en una posición aleatoria del tablero.
-Hay un solo tesoro ('T'), también ubicado de manera aleatoria.
-Hay 5 obstáculos ('O'), colocados aleatoriamente.
-El jugador puede mover el explorador en las cuatro direcciones
(W: arriba, A: izquierda, S: abajo, D: derecha).
-Si el explorador encuentra el tesoro, gana el juego.
-Si choca con un obstáculo, pierde un movimiento pero no avanza.
-El explorador debe evitar salirse del tablero.
*/

import java.util.Random;

public class explorador {
    private static int MAX_DIMENSION = 10;//DIMENSION TABLERO
    private static char[][] tablero;
    private static int filaTesoro, columnaTesoro;
    private static int filaExplorador, columnaExplorador;
    private static int movimientos = 10;

    //AQUI DEFINIREMOS TODAS LAS FUNCIONES USADAS
    public static void main(String[] args) {
        tablero = new char[MAX_DIMENSION][MAX_DIMENSION];
        inicializarTablero();
        colocarTesoro();
        colocarObstaculos(5);
        colocarExplorador();
    }

    //1º INICIALIZAR TABLERO
    private static void inicializarTablero() {
        for (int i = 0; i < MAX_DIMENSION; i++) {
            for (int j = 0; j < MAX_DIMENSION; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    //2º colocamos el tesoro
    private static void colocarTesoro() {
        Random aleatorio = new Random();
        filaTesoro = aleatorio.nextInt(MAX_DIMENSION);
        columnaTesoro = aleatorio.nextInt(MAX_DIMENSION);
        tablero[filaTesoro][columnaTesoro] = 'T';
    }

    // 3º colocamos 5 obstaculos aleatorio
    private static void colocarObstaculos(int numObstaculos) {
        Random aleatorio = new Random();
        int filaObstaculo, columnaObstaculo;
        for (int i = 0; i < numObstaculos; i++) {
            do {
                filaObstaculo = aleatorio.nextInt(MAX_DIMENSION);
                columnaObstaculo = aleatorio.nextInt(MAX_DIMENSION);
            } while (tablero[filaObstaculo][columnaObstaculo] != ' ');// esto se pone para que sea en un sitio que no haya ya obstaculo o tesoro
            tablero[filaObstaculo][columnaObstaculo] = 'O';
        }
    }
    //  4º COLOCAR EXPLORADOR

    private static void colocarExplorador(){
        Random aleatorio= new Random();
        do{
            filaExplorador=aleatorio.nextInt(MAX_DIMENSION);
            columnaExplorador= aleatorio.nextInt(MAX_DIMENSION);
        }while (tablero[filaExplorador][columnaExplorador] != ' ');
        tablero[filaExplorador][columnaExplorador] = 'E';
    }

    
//NO ACABADO POR CHAT GPT










}
