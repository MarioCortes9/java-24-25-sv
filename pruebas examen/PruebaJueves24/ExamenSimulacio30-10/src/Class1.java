import java.util.Random;

public class Class1{
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            do{
                bandera=true;
                array[i] = numAleatorio.nextInt(10) + 10;
                for (int j = 0; j < i; j++) {
                    if(array[i] == array[j]){
                        bandera = false;
                    }else{
                        bandera = true;
                    }
                }
            }while(bandera==false);
        }

    }
}