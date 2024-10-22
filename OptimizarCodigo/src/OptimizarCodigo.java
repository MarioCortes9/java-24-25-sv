import java.util.Arrays;
import java.util.List;

public class OptimizarCodigo {
    //String bloque = new String(27);
    public static void main(String[] bloquesSalida) {
        //creamos una lista de string (para almacenarlo)
        List<String> bloques = Arrays.asList(   //convierte un grupo de bloques en una lista
                "IRON", "BED", "BED_BLOCK", "CACTUS", "BRICK_STAIRS",
                "BIRCH_WOOD_STAIRS", "BREWING_STAND", "CAKE", "CAKE_BLOCK",
                "CAULDRON", "CHEST", "CLAY", "SAND", "BURNING_FURNACE",
                "COBBLESTONE_STAIRS", "FENCE", "FENCE_GATE", "FIRE",
                "GRAVEL", "IRON_DOOR_BLOCK", "IRON_FENCE", "IRON_DOOR",
                "LADDER", "MELON", "LEAVES", "LOCKED_CHEST", "SANDSTONE_STAIRS"); //todos los elemtnos de la lista

        String block = "MELON"; // ponemos un MELON, por la posicion en la que empezamos a mirar, como ejemplo


        if (bloques.contains(block)) {
            System.out.println("El bloque " + block + " esta en la lista");
        } else {
            System.out.println("El bloque " + block + " no está en la lista");
        }
    }
}


