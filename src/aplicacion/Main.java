package aplicacion;

import java.util.List;

import excepciones.NumeroImparException;
import logica.Problemas;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7;
		long startTime = System.nanoTime();

		Problemas problemas = new Problemas();

		problemas.imprimirMatriz(problemas.llenarMatrizCuatroUno(n));


		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000; // Tiempo en milisegundos

		System.out.println("\t"+"Tiempo de ejecución problema 4.1 Iterativo: " + duration + " milisegundos"+"\n");

		startTime = System.nanoTime();

		int[][] matriz = new int[n][2 * n];
		problemas.llenarMatrizCuatroUnoRecursivo(matriz, n, 0, 0, 0);
		problemas.imprimirMatriz(matriz);

		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000; // Tiempo en milisegundos

		System.out.println("\t"+"Tiempo de ejecución problema 4.1 Recursivo: " + duration + " milisegundos"+"\n");
		
		//4.2 Iterativo
		startTime = System.nanoTime();
		
		try {
			problemas.imprimirMatriz(problemas.llenarMatrizCuatroDos(n));
		} catch (NumeroImparException e) {
			System.out.println("Se ha producido una excepción: " + e.getMessage());
		}
		
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000; // Tiempo en milisegundos

		System.out.println("\t"+"Tiempo de ejecución problema 4.2 Iterativo: " + duration + " milisegundos");

		// 4.2 Recursivo
		startTime = System.nanoTime();
		
		try {
			problemas.llenarMatrizCuatroDosRecursiva(n);
		} catch (NumeroImparException e) {
			System.out.println("Se ha producido una excepción: " + e.getMessage());
		}
		
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000; // Tiempo en milisegundos

		System.out.println("\t"+"Tiempo de ejecución problema 4.2 Recursivo: " + duration + " milisegundos");

		//4.4	

		startTime = System.nanoTime();
		try{
			int[][] matriz2 = problemas.llenarMatrizCuatroUno(n);
			int[][] matriz3 = problemas.llenarMatrizCuatroDos(n);
			
			
			List<Integer> numerosDeSmith = problemas.encontrarNumerosDeSmithEnMatriz(matriz2);
        	System.out.println("Números de Smith en la matriz 1: " + numerosDeSmith);

			List<Integer> numerosDeSmith2 = problemas.encontrarNumerosDeSmithEnMatriz(matriz3);
        	System.out.println("Números de Smith en la matriz 2: " + numerosDeSmith2);
		}catch (NumeroImparException e) {
			System.out.println("Se ha producido una excepción: " + e.getMessage());
		}
		

		
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000; // Tiempo en milisegundos

		System.out.println("\t"+"Tiempo de ejecución problema 4.4 Iterativo: " + duration + " milisegundos");

		//recursivo
		startTime = System.nanoTime();
		int[][] matriz2 = {
	            {4, 6, 27, 22},
	            {9, 15, 33, 8},
	            {7, 25, 12, 10}
	        };
        List<Integer> numerosDeSmith2 = problemas.encontrarNumerosDeSmithEnMatrizRecursivo(matriz2, 0, 0);
        System.out.println("Números de Smith en la matriz: " + numerosDeSmith2);
		
		
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000; // Tiempo en milisegundos

		System.out.println("\t"+"Tiempo de ejecución problema 4.4 Recursiva: " + duration + " milisegundos");

		startTime = System.nanoTime();

        int filas = 9;
        int columnas = 7;
        problemas.estrella(filas, columnas);

        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000; // Tiempo en milisegundos

        System.out.println("\t"+"Tiempo de ejecución problema 4.5 Iterativo: " + duration + " milisegundos");
	}
}
