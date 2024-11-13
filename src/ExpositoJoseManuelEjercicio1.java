import java.util.Scanner;
public class ExpositoJoseManuelEjercicio1 {
    public static void main(String[] args) {

        Scanner input= new Scanner(System.in);
        final int RANGO = 22; //numero maximo del valor filas y columnas
        int filas = 0;
        int columnas = 0;

        do {
            System.out.println("___________________Bomber man___________________" + "Matriz_MAX:"+ RANGO+"x"+RANGO );
            System.out.print("Por favor introduce el número de filas (1-" + RANGO + "): ");
            if (input.hasNextInt()) {
                filas = input.nextInt();
                if (filas <= 0 || filas > RANGO) {
                    System.out.println("Repiensa tu respuesta. El número de filas debe estar entre 1 y " + RANGO + ".");
                }
            } else {
                System.out.println("Repiensa tu respuesta. Debe ser un número entero.");
                input.next();
                filas = 0;
            }
        } while (filas <= 0 || filas > RANGO);

        System.out.println(filas);
    }
}