import java.util.Random;
import java.util.Scanner;

//acordarme siempre de intentar acortar procedimiento, las dos primeras funciones son basicas pero la tercera tengo que repasarmela mas
public class EjercicioGrabado {

    // MARIO CORTES CANTIN
    //corregir al final el tabulado
    // primero creamos un tablero 10x10 requerido

    private static int MAX_FILA_TABLERO = 10; // 10 filas
    private static int MAX_COLUMNA_TABLERO = 10;  //10 columnas
    private static char[][] tablero; //para el tablero
    private static int filaBart;
    private static int columnaBart;

    //vamos a crear el tablero
    /*primero de todo hemos de imprimirlo*/ //mirar luego lo de color azul si falla
    //creamos el imprimirtablero

    private static void imprimirTablero() {
        for (int i = 0; i < MAX_FILA_TABLERO; i++) { //recorremos la fila
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) { //recorremos lo de columna
                System.out.print(tablero[i][j] + " ");// imprima la casilla y fuera de este corchete hay que poner el println
            }
            System.out.println(" ");
        }
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
    }
    //ahora debemos crear un segundo paso donde nos escriba en esos huecos de arriba que son casillas
    //las letras correspondientes al tablero-----> character

    private static void asignarLibreALasCasillas(char caracter) { //declaramos el char aqui dentro ya //luego declaro que ahi va la L
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                tablero[i][j] = caracter; // para completar esas casillas con letras ( caracter) (L)
            }
        }
    }

    //MARIO CORTES CANTIN
    //en este ultimo tenemos q rellenar con letras esas casillas
    private static void asignarPersonajeACasillaLibre(char caracter, int numeroRepeticiones) {//volvemos a meter el carcter pq queremos rellenar de letras
        Random aleatorio = new Random();
        //DEBO CREAR ALGO QUE CREE NUMERO ALEATORIO EN FILAS Y COLUMNAS
        int filaAle = -1;
        int columnaAle = -1;
        //creamos algo que nos permita repetir este paso, un entero
        for (int i = 0; i < numeroRepeticiones; i++) {
            do {
                //debemos crear un aleatorio para los enteros que hemos hecho antes de fila y columna (nextInt) acordarme
                filaAle = aleatorio.nextInt(MAX_FILA_TABLERO); // nos va a crear un aleatorio del 0 al 9
                columnaAle = aleatorio.nextInt(MAX_COLUMNA_TABLERO); // nos va a crear un aleatorio del 0 al 9
            } while (tablero[filaAle][columnaAle] != 'L');//ahora claro,rellenaremos con un aleatorio cuando sea distinto de L
            tablero[filaAle][columnaAle] = caracter;//para que rellne con caracter b,h,m
        }
        if (caracter == 'B') { //el personaje a mover que tiene que caer aleatoriamente es bart enmtonces por esp creo este if y tendre que crear unas filas y columnas solo par el
            filaBart = filaAle; //creada anteriormente y que nos da ese valor aleatorio en el tasblero
            columnaBart = columnaAle;//creada anteriormente y que nos da ese valor aleatorio en el tasblero

        }
    }
    //acordarme siempre de revisar los corchetes si oligan entre ellos
    //mario cortes cantin

    public static void main(String[] args) {
        //debo guardar los procedimientos aqui ,       ATENTO MARIO
        //me falta declarar aqui el tablero para las letras
        tablero = new char[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];
        // 1     INICIALIZACION
        asignarLibreALasCasillas('L');   // aqui debo meter las letras que corresponden en cada paso---->libre
        //3 ahora ya debemos meter los homers,barts y los muros de final y su impresion pa que aprezca por pantalla
        imprimirTablero();
        asignarPersonajeACasillaLibre('B', 1);// HAY 1 BART EN EL JUEGO //ME HA AYUDADO CAMILO A CORREGIR EL ERROR ESTE PQ NO LO ENTENDIA
        //BARTS
        imprimirTablero();
        asignarPersonajeACasillaLibre('H', 10);//hay 10 homers
        //homers
        imprimirTablero();
        asignarPersonajeACasillaLibre('M', 5);//hay 5 muros
        //muros
        imprimirTablero();
        //ahora tengo que volver a declarar el tablero pero para la posicion anterior a la sustituida opor las letras nuestras b,h,m
        tablero[MAX_FILA_TABLERO - 1][MAX_COLUMNA_TABLERO - 1] = 'F';// Y QUE LO IMPRIMA, no es con igual es lo mismo que arriba tablero[i][j] que van sin el igual
        //pq yo no quiero iualar el tablero a esas dos posiciones
        imprimirTablero();



    //revisar letras en rojo luego

//ahora debo crear los desplazamientos con 5 vidas


//ESTABA DESCANSANDO
//MARIO CORTES CANTIN

    Scanner lector = new Scanner(System.in); //creamos el scanner y le ponemos la condicion de static // ACORDARMEEEEEE SIEMPRE DEL SYSTEM.IN SI ME SALE UN ERROR SERA ESO

    // JUEGO BART
/* DESPLAZAMIENTO
A-----> IZQ
W--->ARRI
S---->ABAJ
D---->DER
 */
    int vidas = 10;


        do {
            System.out.println("Que movimiento quieres hacer?"); //LE PREGUNTAMOS EL DESPLAZAMIENTO QUE QUIERE COMPLETAR Y ABAJO LE DAMOS LAS OPCIONES
            System.out.println("A-----> IZQ, W--->ARRI ,S---->ABAJ ,D---->DER");
            //CREAMOS UNA CADENA DE DESPLZAMIENTO (4)
            String movimiento = lector.nextLine();
            System.out.println("Movimiento" + movimiento); // para que se mueva al ponerle la condicion de mvimiento
            switch (movimiento) { // este comando lo creamos porque como tenemos diferentes opciones de movimiento pueda ir cambiando
                //ahora vamos a los diferentes casos de movimiento que tiene que son W,A,S,D

                case "A":// en el case  y en el default acordarme de que no es ";" sino que son ":" mirar si sale error el corrector de abajo
                    //MOVIMIENTO A IZQUIERDA
                    if (columnaBart - 1 >= 0) {   //si es mayor que 0 se puede hacer
                        columnaBart = columnaBart - 1; //la nueva
                        switch (tablero[filaBart][columnaBart]) { // pa que cambie
                            //ahra miramos los diferentes casos de personajes
                            // si cae en h
                            case 'H':
                                vidas = vidas - 1; //pierdo vida si homer
                                tablero[filaBart][columnaBart] = 'B'; //conversion casilla
                                tablero[filaBart][columnaBart + 1] = 'L'; // la anterior s queda libre
                                System.out.println("Has perdido una vida" + " te quedan "  +  vidas  +  " vidas"); // pa que muestre las nuevas vidas
                                break;
                            case 'L': // en caso de casilla libre
                                tablero[filaBart][columnaBart] = 'B'; // NO SE PIERDE VIDA E ESTE CASO
                                tablero[filaBart][columnaBart + 1] = 'L';
                                break;
                            case 'M'://caso de chocar muro
                                System.out.println("Ups,te has topado con el muro,no puedes moverte a esat casilla");
                                columnaBart = columnaBart + 1;
                                break;
                        }
                    }else{
                        System.out.println("Desplazamiento prohibido. Límite de tablero.");
                    }
                    break;

                case "D":
                    if (columnaBart + 1 >= 0) {   //si es mayor que 0 se puede hacer
                        columnaBart = columnaBart + 1; //la nueva
                        switch (tablero[filaBart][columnaBart]) { // pa que cambie
                            //ahra miramos los diferentes casos de personajes
                            // si cae en h
                            case 'H':
                                vidas = vidas - 1; //pierdo vida si homer
                                tablero[filaBart][columnaBart] = 'B'; //conversion casilla
                                tablero[filaBart][columnaBart - 1] = 'L'; // la anterior s queda libre
                                System.out.println("Has perdido una vida" + " te quedan " + vidas + " vidas"); // pa que muestre las nuevas vidas
                                break;
                            case 'L': // en caso de casilla libre
                                tablero[filaBart][columnaBart] = 'B'; // NO SE PIERDE VIDA E ESTE CASO
                                tablero[filaBart][columnaBart - 1] = 'L';
                                break;
                            case 'M'://caso de chocar muro
                                System.out.println("Ups,te has topado con el muro,no puedes moverte a esat casilla");
                                columnaBart = columnaBart - 1;
                                break;
                        }
                    }else{
                        System.out.println("Desplazamiento prohibido. Límite de tablero.");
                    }
                    break;
                case "W":
                    if (filaBart + 1 >= 0) {   //si es mayor que 0 se puede hacer
                        filaBart = filaBart - 1; //la nueva
                        switch (tablero[filaBart][columnaBart]) { // pa que cambie
                            //ahra miramos los diferentes casos de personajes
                            // si cae en h
                            case 'H':
                                vidas = vidas - 1; //pierdo vida si homer
                                tablero[filaBart][columnaBart] = 'B'; //conversion casilla
                                tablero[filaBart + 1][columnaBart] = 'L'; // la anterior s queda libre
                                System.out.println("Has perdido una vida" + " te quedan " + vidas + " vidas"); // pa que muestre las nuevas vidas
                                break;
                            case 'L': // en caso de casilla libre
                                tablero[filaBart][columnaBart] = 'B'; // NO SE PIERDE VIDA E ESTE CASO
                                tablero[filaBart + 1][columnaBart] = 'L';
                                break;
                            case 'M'://caso de chocar muro
                                System.out.println("Ups,te has topado con el muro,no puedes moverte a esat casilla");
                                filaBart = filaBart - 1;
                                break;
                        }
                    }else{
                        System.out.println("Desplazamiento prohibido. Límite de tablero.");
                    }
                    break;
                case "S":
                    if (filaBart - 1 >= 0) {   //si es mayor que 0 se puede hacer
                        filaBart = filaBart + 1; //la nueva
                        switch (tablero[filaBart][columnaBart]) { // pa que cambie
                            //ahra miramos los diferentes casos de personajes
                            // si cae en h
                            case 'H':
                                vidas = vidas - 1; //pierdo vida si homer
                                tablero[filaBart][columnaBart] = 'B'; //conversion casilla
                                tablero[filaBart - 1][columnaBart] = 'L'; // la anterior s queda libre
                                System.out.println("Has perdido una vida" + " te quedan" + vidas + " vidas"); // pa que muestre las nuevas vidas
                                break;
                            case 'L': // en caso de casilla libre
                                tablero[filaBart][columnaBart] = 'B'; // NO SE PIERDE VIDA E ESTE CASO
                                tablero[filaBart - 1][columnaBart] = 'L';
                                break;
                            case 'M'://caso de chocar muro
                                System.out.println("Ups,te has topado con el muro,no puedes moverte a esat casilla");
                                filaBart = filaBart + 1;
                                break;
                        }
                    }else{
                        System.out.println("Desplazamiento prohibido. Límite de tablero.");
                    }
                    break;
                default:
                    break;
            }
            imprimirTablero();
        }while(vidas>0);
        //////////////////////////////////////////////////

    }

}

/* TABLERO DE EJEMPLO PARA NO LIARME ENTRE FILAS Y COLUMNAS
 X X X X X X X X X X
 X X X X X X X X X X
 X X X X X X X X X X
 X X X X X X X X X X   A---> COLUMNA-1
 X X X X X X X X X X   W---->FILA+1
 X X X X X X X X X X   S--->FILA-1
 X X X X X X X X X X   D--->COLUMNA+1
 X X X X X X X X X X
 X X X X X X X X X X
 X X X X X X X X X X
  */