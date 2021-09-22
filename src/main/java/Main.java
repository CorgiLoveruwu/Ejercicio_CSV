import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ingresar();
    }

    private static void Ingresar() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese ruta");
        String ruta = teclado.next();
        RevisarCSV(ruta);
    }

    private static void RevisarCSV(String ruta) {
        GestorArchivo ga = new GestorArchivo();
        System.out.println(ga.leerArchivo(ruta));
        String[] lineas = ga.leerArchivo(ruta).split("\n");
        for (int i=1;i<lineas.length;i++ ){
            String[] posiciones = lineas[i].split(";");
            Trycatch(posiciones, 0);
            Trycatch(posiciones, 2);
            Trycatch(posiciones, posiciones.length-1);
        }
    }

    private static void Trycatch(String[] posiciones, int i) {
        try {
            Integer.parseInt(posiciones[i]);
        }catch (NumberFormatException e){
            System.out.println("Error en la linea");
            System.out.println(posiciones[i]);
        }
    }
}
