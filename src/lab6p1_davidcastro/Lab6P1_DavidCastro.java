package lab6p1_davidcastro;

import java.util.Scanner;
import java.util.Random;
public class Lab6P1_DavidCastro {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int opcion;
        do{
            System.out.print("\n-------------MENU------------\n1) Ejercicio 1\n2) Ejercicio 2\n3) Salir\nEleccion: ");
            opcion = read.nextInt();
            read.nextLine();
            
            switch (opcion){
                case 1:
                    int tamano = 0; 
                    do{
                        System.out.print("Ingresa tamano de matriz (numero impar): ");
                        tamano = read.nextInt();
                    } while (tamano % 2 == 0);
                    int [][] matriz = new int[tamano][tamano];
                    System.out.println("--------------Matriz normal---------------");
                    MatrizRandom(matriz);
                    
                    System.out.print("\nIngrese input de rotacion: ");
                    String rotacion = read.next();
                    char signo = rotacion.charAt(0);
                    char num = rotacion.charAt(1);
                    int numRotar = num - '0';
                    System.out.println(numRotar);
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    System.out.println("Saliste del programa");
                    break;
                default:
                    System.out.println("Opcion incorrecta. Ingresa de las opciones mostradas");
                    break;
                
            }
            
        } while (opcion != 3);
    }
    
    public static void MatrizRandom(int[][] arreglo){
        Random numRandom = new Random();
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                arreglo[i][j] = numRandom.nextInt(10);
                System.out.print("["+arreglo[i][j] + "]"+" ");  
            }
            System.out.println("");
        }
    }
    
    public static int[][] RotacionDeMatriz(int matriz[][], char signo, int numero){
        
        return matriz;
    }
    
    public static int[][] imprimirMatriz(int[][] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                System.out.print("["+arreglo[i][j] + "]"+" ");  
            }
            System.out.println("");
        }
        return arreglo;
    }
    
}
