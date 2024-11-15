import java.util.Scanner;
import java.util.Random;

public class ExpositoJoseManuelEjercicio1 {
    public static void main(String[] args) {

        Scanner input= new Scanner(System.in);
        final int RANGO = 22; //numero maximo del valor filas y columnas
        int filas ;
        int columnas ;
        int low = 0;
        int high = 9;
        int opcion;
        int x, y;
        int explosion = 0;


        System.out.println("___________________Bomber man___________________" + "Matriz_MAX:"+ RANGO+"x"+RANGO );
        do {

            System.out.println(" ");
            System.out.print("Por favor introduce el número de filas    (1-" + RANGO + "): ");
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

        do {
            System.out.print("Por favor introduce el número de columnas (1-" + RANGO + "): ");
            if (input.hasNextInt()) {
                columnas = input.nextInt();
                if (columnas <= 0 || filas > RANGO) {
                    System.out.println("Repiensa tu respuesta. El número de columnas debe estar entre 1 y " + RANGO + ".");
                }
            } else {
                System.out.println("Repiensa tu respuesta. Debe ser un número entero.");
                input.next();
                columnas = 0;
            }
        } while (columnas <= 0 || filas > RANGO);
        System.out.println(filas);
        System.out.println(columnas);

         Random r = new Random();
        // Rellenar matriz con números aleatorios entre 0 y 9
        int[][] matriz = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = r.nextInt(high + 1 - low) + low;
            }
        }

        // Imprimir matriz
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        do {
            // Mostrar el menú
            System.out.println("\n--- Menú ---");
            System.out.println("[2] Poner bomba");
            System.out.println("[1] Mostrar matriz");
            System.out.println("[0] Salir");
            System.out.print("Seleccione una opción: ");

            // Leer la opción pulsada
            if (input.hasNextInt()) {
                opcion = input.nextInt();

                // Procesar la opción seleccionada
                switch (opcion) {
                    case 2:
                        // ponerBomba
                        do {
                            System.out.print("Introduce el valor de x (entre 0 y " +(filas-1)+ "): ");
                            while (!input.hasNextInt()) {
                                System.out.println("Error: Debes introducir un número entero.");
                                System.out.print("Introduce el valor de x (entre 0 y " +(filas-1)+ "): ");
                                input.next();
                            }
                            x = input.nextInt();

                            if (x < 0 || x >= filas) {
                                System.out.println("Error: x debe estar entre 0 y " + (filas-1));
                            }
                        } while (x < 0 || x >= filas);

                        do {
                            System.out.print("Introduce el valor de y (entre 0 y " + (columnas-1)+ "): ");
                            while (!input.hasNextInt()) {
                                System.out.println("Error: Debes introducir un número entero.");
                                System.out.print("Introduce el valor de y (entre 0 y " + (columnas-1) + "): ");
                                input.next();
                            }
                            y = input.nextInt();

                            if (y < 0 || y >= columnas) {
                                System.out.println("Error: y debe estar entre 0 y " + (columnas-1));
                            }
                        } while (y < 0 || y >= columnas);

                        System.out.println("Valores introducidos: x = " + x + ", y = " + y);

                        //Calcular la suma de la explosion
                        for (int j = 0; j < matriz[x].length; j++) {
                            explosion += matriz[x][j];
                        }
                        for (int i = 0; i < matriz.length; i++) {
                            if (i != x) {
                                explosion += matriz[i][y];
                            }
                        }
                        //muestra la matriz junto con el valor de la explosion
                        for (int i = 0; i < filas; i++) {
                            for (int j = 0; j < columnas; j++) {
                                System.out.print(matriz[i][j] + "\t");
                            }
                            System.out.println();
                        }
                        System.out.println("Valor explosion: "+ explosion);

                        // Poner a cero la fila x
                        for (int j = 0; j < matriz[x].length; j++) {
                            matriz[x][j] = 0;
                        }
                        // Poner a cero la columna y
                        for (int i = 0; i < matriz.length; i++) {
                            matriz[i][y] = 0;
                        }
                        //muestra la matriz para mostrar valores a 0 podria omitirse
                        for (int i = 0; i < filas; i++) {
                            for (int j = 0; j < columnas; j++) {
                                System.out.print(matriz[i][j] + "\t");
                            }
                            System.out.println();
                        }
                        break;

                    case 1:
                        // Imprimir matriz
                        for (int i = 0; i < filas; i++) {
                            for (int j = 0; j < columnas; j++) {
                                System.out.print(matriz[i][j] + "\t");
                            }
                            System.out.println();
                        }
                        break;
                    case 0:
                        System.out.println("Adios");
                        break;
                    default:
                        System.out.println("Elige una de las opciones del menu");
                }
            } else {
                // Si la entrada no es un número
                System.out.println("Por favor, ingresa un número válido.");
                input.next(); // Limpiar el buffer del scanner
                opcion = -1; // Asignar un valor que no sea 0 para continuar el bucle
            }

        } while (opcion != 0);

}
}