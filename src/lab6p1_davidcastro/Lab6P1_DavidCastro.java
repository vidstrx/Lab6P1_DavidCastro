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
                    imprimirMatriz(MatrizRandom(matriz));
                    
                    System.out.print("\nIngrese input de rotacion: ");
                    String rotacion = read.next();
                    char signo = rotacion.charAt(0); char num = rotacion.charAt(1);
                    int numRotar = num - '0';
                    
                    System.out.println("Rotacion es: ");
                    imprimirMatriz(RotacionDeMatriz(matriz, signo, numRotar));
                    
                    
                    break;
                case 2:
                    int vidas = 3;
                    int matrizSolucion[][] = new int[4][4];
                    char matrizX[][] = new char[4][4];
                    Matrices(matrizSolucion, matrizX);
                    do{
                        System.out.println("vidas: "+vidas);
                        

                        System.out.print("\nIngrese par de casillas: ");
                        String casillas = read.next();
                        char fila = casillas.charAt(0); char columna = casillas.charAt(2);
                        char fila2 = casillas.charAt(4); char columna2 = casillas.charAt(6);
                        int numfila = fila - '0';  int numcolumna = columna - '0';
                        int numfila2 = fila2 - '0'; int numcolumna2 = columna2 - '0';

                        boolean mat = MatrizElementosIguales(matrizSolucion, matrizX, numfila, numcolumna, numfila2, numcolumna2);
                        if (mat == false){
                            vidas -=1;
                        }
                    }  while (vidas != 0);
                    break;
                case 3:
                    char c = (char) 3;
                    
                    System.out.println("Saliste del programa");
                    break;
                default:
                    System.out.println("Opcion incorrecta. Ingresa de las opciones mostradas");
                    break;
                
            }
            
        } while (opcion != 3);
    }
    
    public static void imprimirMatriz(int[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("["+matriz[i][j] + "]"+" ");  
            }
            System.out.println("");
        }
    }
    
    public static int[][] MatrizRandom(int[][] arreglo){
        Random numRandom = new Random();
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                arreglo[i][j] = numRandom.nextInt(10);  
            }
        }
        return arreglo;
    }
    
    public static int[][] RotacionDeMatriz(int matriz[][], char signo, int numero){
        if (signo == '+'){
            for (int i = 0; i < numero; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    for (int k = j; k < matriz.length; k++) {
                        int posicionOriginal = matriz[j][k];
                        matriz[j][k] = matriz[k][j];
                        matriz[k][j] = posicionOriginal;
                    }
                }
                for (int a = 0; a < matriz.length; a++) {
                    for (int b = 0; b < matriz.length/2; b++) {
                        int posicionOriginal = matriz[a][b];
                        matriz[a][b] = matriz[a][matriz.length - 1 - b];
                        matriz[a][matriz.length -1 - b] = posicionOriginal;
                    }
                }
            } 
        } else if (signo == '-'){
            for (int i = 0; i < numero; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    for (int k = j+1; k < matriz[0].length; k++) {
                        int posicionOriginal = matriz[j][k];
                        matriz[j][k] = matriz[k][j];
                        matriz[k][j] = posicionOriginal;
                    }
                }
                for (int a = 0;a < matriz[0].length/2;a++) {
                    int [] posicionOriginal = matriz[a];
                    matriz[a] = matriz[matriz.length - 1 - a];
                    matriz[matriz.length-1-a] = posicionOriginal;
                }
            }
        }
        return matriz;
    }
    
    // --------------------------------------Metodos del 2 ejercicio----------------------------------------------
    
    public static char[][] Matrices(int[][] matriz4x4, char[][] matrizX){
        Random numRandom = new Random();
        for (int i = 0; i < matriz4x4.length; i++) {
            for (int j = 0; j < matriz4x4[i].length; j++) {
                matriz4x4[i][j] = numRandom.nextInt(8);  
                System.out.print("["+ matriz4x4[i][j]  + "]");
            }
            System.out.println("");
        }
        for (int i = 0; i < matrizX.length; i++) {
            for (int j = 0; j < matrizX[i].length; j++) {
                System.out.print("["+ (matrizX[i][j] = 'X') + "]");
            }
            System.out.println("");
        }
        return matrizX;
    }
    
    public static void imprimirMatrizChar(char[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("["+matriz[i][j] + "]"+" ");  
            }
            System.out.println("");
        }
    }
    
    public static boolean MatrizElementosIguales(int[][] matriz4x4, char[][] matrizX, int fila, int columna, int fila2, int columna2){
        boolean matrizIgual;
        int numero = matriz4x4[fila][columna];
        int numero2 = matriz4x4[fila2][columna2];
        char num = (char) numero;
        System.out.println("Primera casilla: "+numero);
        System.out.println("Segunda casilla: "+numero2);
        for (int i = 0; i < matrizX.length; i++) {
            for (int j = 0; j < matrizX[i].length; j++) {
                if (numero == numero2){
                    matrizX[fila][columna] = (char) numero;
                    matrizX[fila2][columna2] = (char) numero2;
                } 
            }
        }
        if (numero == numero2){
            System.out.println("Si son iguales");
            matrizIgual = true;
        } else {
            System.out.println("No son iguales");
            matrizIgual = false;
        }
        imprimirMatrizChar(matrizX);
        return matrizIgual;
    }
    
}
