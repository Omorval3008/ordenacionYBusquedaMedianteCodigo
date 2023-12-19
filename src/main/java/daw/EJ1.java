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
        final int tamanoArray = 15;
        /*Creo mi array*/
        double[] arrayDoubles = new double[tamanoArray];
        /*relleno todas las posiciones con el mismo valor*/
        for (int i = 0; i < arrayDoubles.length; i++) {
            arrayDoubles[i] = 7.5;
        }
        /*relizo una copia de mi array*/
        double[] copiaArrayDoubles = arrayDoubles.clone();
        /*muestro ambos por consola*/
        System.out.println(Arrays.toString(arrayDoubles));
        System.out.println("--------------------------------------");
        System.out.println(Arrays.toString(copiaArrayDoubles));
        System.out.println("--------------------------------------");
        /*Comparo los arrays y devuelvo si son iguales*/
        boolean arraysIguales = Arrays.equals(arrayDoubles, copiaArrayDoubles);
        System.out.println(arraysIguales);
        /*cambio el valor en una posicion aleatoria de mi array*/
        Random random = new Random();
        int arrayElegido = random.nextInt(1, 3);
        if (arrayElegido == 1) {
            int posAleatoria = random.nextInt(0, arrayDoubles.length);
            arrayDoubles[posAleatoria] = 6.3;
        } else {
            int posAleatoria = random.nextInt(0, copiaArrayDoubles.length);
            copiaArrayDoubles[posAleatoria] = 6.3;
        }
        /*muestro ambos por consola*/
        System.out.println(Arrays.toString(arrayDoubles));
        System.out.println("----------------------------------------");
        System.out.println(Arrays.toString(copiaArrayDoubles));
        System.out.println("----------------------------------------");
        /*Comparo los arrays y devuelvo si son iguales*/
        arraysIguales = Arrays.equals(arrayDoubles, copiaArrayDoubles);
        System.out.println(arraysIguales);
        System.out.println("----------------------------------------");
        /*Ej 2*/
        /*genero un array con el metodo rellenaArray*/
        int[] arrayDeNumAleatorios = new int[20];
        rellenaArray(arrayDeNumAleatorios);
        System.out.println("----------------------------------------");
        System.out.println(Arrays.toString(arrayDeNumAleatorios));
        /*Ordeno las posiciones de mi array*/
        Arrays.sort(arrayDeNumAleatorios);
        System.out.println(Arrays.toString(arrayDeNumAleatorios));
        System.out.println("----------------------------------------");
        /*busco un numero especifico*/
        Scanner teclado = new Scanner(System.in);
        boolean errorNum = true;
        int numEspecifico = 0;
        do {
            try {
                System.out.println("Introduce un número entero");
                numEspecifico = teclado.nextInt();
                teclado.nextLine();/*limpio la variable en caso de que sea correcto*/
                errorNum = false;
            } catch (InputMismatchException ime) {
                System.out.println("No has cumplido con los requisitos especificados");
                errorNum = true;
                teclado.nextLine();/*limpio la variable en caso de error*/
            }
        } while (errorNum);
        /*encuentra la posición del número especificado*/
        int pos = Arrays.binarySearch(arrayDeNumAleatorios,numEspecifico);
        if (pos >=0) {/*se ha decidido implementar con binary search*/
            System.out.println(numEspecifico + " esta en la posición " + pos + " del array");
        } else {
            System.out.println(numEspecifico + " no se encuentra en el array");
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
/*metodo que hace lo mismo que binarySearch*/
//    public static int numSpecifico(int[] array, int num) {/* hace lo mismo que
//        Arrays.binarySearch(array, num)*/
//        /*posiciones*/
//        int mitad = 0;
//        int izquierda = 0;
//        int derecha = array.length - 1;
//        /*le indico el numero que deseo buscar*/
//        int numABuscar = num;
//        boolean numEncontrado = false;
//        while ((izquierda <= derecha) && (!numEncontrado)) {
//            mitad = (izquierda + derecha) / 2;
//            if (array[mitad] == numABuscar) {
//                numEncontrado = true;/*si encuentra la posicion, indica que la ha encontrado*/
//            } else if (array[mitad] > numABuscar) {
//                derecha = mitad - 1;
//                /*buscar en el cuadrante izq del array*/
//            } else {
//                izquierda = mitad + 1;
//                /*buscar en el cuadrante derecho del array*/
//            }
//        }
        /*si el número ha sido encontrado, devuelve la posición en la que esta*/
        /*si no devuelve un valor por defecto, en este caso 504*/
//        if (numEncontrado) {
//            return mitad;
//        } else {
//            return 504;
//        }
//
//    }
}
