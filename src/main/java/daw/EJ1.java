/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package daw;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author oscar
 */
public class EJ1 {

    public static void main(String[] args) {
        /*ctes*/
        final int TAMAÑO_ARRAY = 20;
        /*creo mis dos arrays*/
        int[] array1 = new int[TAMAÑO_ARRAY];
        rellenaArray(array1);
        System.out.println("Primer array: " + Arrays.toString(array1));
        int[] array2 = new int[25];
        rellenaArray(array2);
        System.out.println("Segundo array: " + Arrays.toString(array2));
        /*ordeno los arrays*/
        System.out.println("------------------------------------------------------------------");
        ordenaArray(array1);
        ordenaArray(array2);
        System.out.println("Primer array ordenado: " + Arrays.toString(array1));
        System.out.println("Segundo array ordenado: " + Arrays.toString(array2));
        System.out.println("------------------------------------------------------------------");
        /*verifico si son iguales*/
        boolean iguales = arraysIguales(array1, array2);
        if (iguales == true) {
            System.out.println("Los arrays son iguales");
        } else {
            System.out.println("Los arrays son distintos");
        }
        System.out.println("--------------------------------------------------------------------");
        /*busco un numero especifico*/
        /*encuentra la posición del número especificado*/
        int pos = numSpecifico(array2);
        if (pos >= 0) {/*se ha decidido implementar con binary search*/
            System.out.println( "el numero introducido esta en la posicion "+pos+" del array");
        } else {
            System.out.println("EL numero introducido no se encuentra en el array");
        }

    }

    /*Ej 2*/
    public static int[] rellenaArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {/*rellena las posiciones de mi array*/
            array[i] = random.nextInt(10, 101);
        }
        return array;
    }

    /*metodo que ordena el array mediante el metodo de ordenacion de la burbuja*/
    public static void ordenaArray(int[] array) {
        int aux;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    aux = array[i];
                    array[i] = array[j];
                    array[j] = aux;
                }
            }
        }
    }

    /*metodo que mira si dos arrays son iguales*/
    public static boolean arraysIguales(int[] array1, int[] array2) {
        boolean arrayIgual = true;
        if (array1.length != array2.length) {
            arrayIgual = false;
        } else {
            for (int i = 0; i < array1.length; i++) {
                if (array1[i] != array2[i]) {
                    arrayIgual = false;
                }
            }

        }
        return arrayIgual;
    }

    /*metodo que hace lo mismo que binarySearch*/
    public static int numSpecifico(int[] array) {/* hace lo mismo que
        Arrays.binarySearch(array, num)*/
        Scanner teclado = new Scanner(System.in);
        boolean errorNum = true;
 /*posiciones*/
        int mitad = 0;
        int izquierda = 0;
        int derecha = array.length - 1;
        /*le indico el numero que deseo buscar*/
        int numABuscar = 0;
        
        do {
            try {
                System.out.println("Introduce un número entero");
                numABuscar = teclado.nextInt();
                teclado.nextLine();/*limpio la variable en caso de que sea correcto*/
                errorNum = false;
            } catch (InputMismatchException ime) {
                System.out.println("No has cumplido con los requisitos especificados");
                errorNum = true;
                teclado.nextLine();/*limpio la variable en caso de error*/
            }
        } while (errorNum);
        boolean numEncontrado = false;
        while ((izquierda <= derecha) && (!numEncontrado)) {
            mitad = (izquierda + derecha) / 2;
            if (array[mitad] == numABuscar) {
                numEncontrado = true;/*si encuentra la posicion, indica que la ha encontrado*/
            } else if (array[mitad] > numABuscar) {
                derecha = mitad - 1;
                /*buscar en el cuadrante izq del array*/
            } else {
                izquierda = mitad + 1;
                /*buscar en el cuadrante derecho del array*/
            }
        }
        /*si el número ha sido encontrado, devuelve la posición en la que esta*/
 /*si no devuelve un valor por defecto, en este caso -1*/
        if (numEncontrado) {
            return mitad;
        } else {
            return -1;
        }

    }
}
