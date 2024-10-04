
public class Simpson {
    //visible a nivel de la clase simpson
    static char [][] tablero = new char[10][10];  //0 a n-1    casillas van de 0 a 9 10-1
    //fin

    //software de gestion de venta online
public static void rellenarTablero(char pers){
    for (int i = 0; i < 10 ; i++) {
        for (int j = 0; j <10 ; j++) {
            tablero [i][j] = pers;
        }
    }
    //tablero [i][j]

}
    public static void main (String[] args){
        System.out.printf("Hello and welcome!");
                            //int contador=0;
        char personaje = '#';
        rellenarTablero(personaje);
                            //contador=10
        imprimirTablero();
        personaje= 'H';
        rellenarTablero(contador);
        //for
    }
}





