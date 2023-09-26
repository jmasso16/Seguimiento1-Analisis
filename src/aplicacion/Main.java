package aplicacion;

import java.util.List;

import excepciones.NumeroImparException;
import excepciones.ValorColumnasException;
import logica.Problemas;

/**
 * @author Juan Esteban Henao
 * 		   John Fredy Muñoz
 * 		   Julian Andres Masso
 */
public class Main {

	public static void main(String[] args) {
		// Este sera el valor de n para los puntos 4.1 , 4.2
		int n = 15;
		Problemas problemas = new Problemas();

		// Se declara la variable para calcular el tiempo de ejecucion del punto 4.1
		// iterativo
		long startTime = System.nanoTime();

		problemas.imprimirMatriz(problemas.llenarMatrizCuatroUno(n));

		// Se declara la varible para realizar el calculo del tiempo de ejecucion
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000; // Tiempo en milisegundos

		System.out.println("\t" + "Tiempo de ejecución problema 4.1 Iterativo: " + duration + " milisegundos" + "\n"+"\n");

		// Se declara la variable para calcular el tiempo de ejecucion del punto 4.1
		// recursivo
		startTime = System.nanoTime();

		int[][] matriz = new int[n][2 * n];
		problemas.llenarMatrizCuatroUnoRecursivo(matriz, n, 0, 0, 0);
		problemas.imprimirMatriz(matriz);

		// Se declara la varible para realizar el calculo del tiempo de ejecucion
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000; // Tiempo en milisegundos

		System.out.println("\t" + "Tiempo de ejecución problema 4.1 Recursivo: " + duration + " milisegundos" + "\n"+"\n");

		// Se declara la variable para calcular el tiempo de ejecucion del punto 4.2
		// Iterativo
		startTime = System.nanoTime();

		try {
			problemas.imprimirMatriz(problemas.llenarMatrizCuatroDos(n));
		} catch (NumeroImparException e) {
			System.out.println("Se ha producido una excepción: " + e.getMessage());
		}

		// Se declara la varible para realizar el calculo del tiempo de ejecucion
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000; // Tiempo en milisegundos

		System.out.println("\t" + "Tiempo de ejecución problema 4.2 Iterativo: " + duration + " milisegundos"+"\n"+"\n");

		// Se declara la variable para calcular el tiempo de ejecucion del punto 4.2
		// Recursivo
		startTime = System.nanoTime();

		try {
			problemas.llenarMatrizCuatroDosRecursiva(n);
		} catch (NumeroImparException e) {
			System.out.println("Se ha producido una excepción: " + e.getMessage());
		}

		// Se declara la varible para realizar el calculo del tiempo de ejecucio
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000; // Tiempo en milisegundos

		System.out.println("\t" + "Tiempo de ejecución problema 4.2 Recursivo: " + duration + " milisegundos"+"\n"+"\n");

		int[][] matrizHambrientos = { { 27, 5, 3 }, { 4, 17, 6 }, { 7, 8, 144 } };
		// Se declara la variable para calcular el tiempo de ejecucion del punto 4.3
		// Iterativo
		startTime = System.nanoTime();

		problemas.impirmirContenidoArreglo(problemas.encontrarNumerosCoincidentes(matrizHambrientos));

		// Se declara la varible para realizar el calculo del tiempo de ejecucion
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000; // Tiempo en milisegundos

		System.out.println("\t" + "Tiempo de ejecución problema 4.3 Iterativo: " + duration + " milisegundos"+"\n"+"\n");

		// Se declara la variable para calcular el tiempo de ejecucion del punto 4.3
		// Recursivo
		startTime = System.nanoTime();

		problemas.impirmirContenidoArreglo(problemas.encontrarNumerosCoincidentesRecursivo(matrizHambrientos));

		// Se declara la varible para realizar el calculo del tiempo de ejecucion
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000; // Tiempo en milisegundos

		System.out.println("\t" + "Tiempo de ejecución problema 4.3 Recursivo: " + duration + " milisegundos"+"\n"+"\n");

		// Se declara la variable para calcular el tiempo de ejecucion del punto 4.4
		// Iterativo

		startTime = System.nanoTime();
		try {
			// Se obtienen las matrices a partir de los probelmas 4.1 y 4.2
			int[][] matriz2 = problemas.llenarMatrizCuatroUno(n);
			int[][] matriz3 = problemas.llenarMatrizCuatroDos(n);

			List<Integer> numerosDeSmith = problemas.encontrarNumerosDeSmithEnMatriz(matriz2);
			System.out.println("Números de Smith en la matriz 1: " + numerosDeSmith);

			List<Integer> numerosDeSmith2 = problemas.encontrarNumerosDeSmithEnMatriz(matriz3);
			System.out.println("Números de Smith en la matriz 2: " + numerosDeSmith2);
		} catch (NumeroImparException e) {
			System.out.println("Se ha producido una excepción: " + e.getMessage());
		}

		// Se declara la varible para realizar el calculo del tiempo de ejecucion
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000; // Tiempo en milisegundos

		System.out.println("\t" + "Tiempo de ejecución problema 4.4 Iterativo: " + duration + " milisegundos"+"\n"+"\n");

		// Se declara la variable para calcular el tiempo de ejecucion del punto 4.4
		// Recursivo
		startTime = System.nanoTime();
		int[][] matriz2 = { { 4, 6, 27, 22 }, { 9, 15, 33, 8 }, { 7, 25, 12, 10 } };
		List<Integer> numerosDeSmith2 = problemas.encontrarNumerosDeSmithEnMatrizRecursivo(matriz2, 0, 0);
		System.out.println("Números de Smith en la matriz: " + numerosDeSmith2);

		// Se declara la varible para realizar el calculo del tiempo de ejecucion
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000; // Tiempo en milisegundos

		System.out.println("\t" + "Tiempo de ejecución problema 4.4 Recursiva: " + duration + " milisegundos"+"\n"+"\n");

		// Se declara la variable para calcular el tiempo de ejecucion del punto 4.5
		// Iterativo
		startTime = System.nanoTime();

		int filas = 9;
		int columnas = 7;
		try {
			problemas.estrella(filas, columnas);
		} catch (NumeroImparException | ValorColumnasException e) {
			e.printStackTrace();
		}

		// Se declara la varible para realizar el calculo del tiempo de ejecucion
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000; // Tiempo en milisegundos

		System.out.println("\t" + "Tiempo de ejecución problema 4.5 Iterativo: " + duration + " milisegundos"+"\n"+"\n");

		
		// Se declara la variable para calcular el tiempo de ejecucion del punto 4.5
		// Recursivo
		startTime = System.nanoTime();

		try {
			problemas.estrellaRecursivo(filas, columnas);
		} catch (NumeroImparException | ValorColumnasException e) {
			e.printStackTrace();
		}

		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000; // Tiempo en milisegundos

		System.out.println("\t" + "Tiempo de ejecución problema 4.5 Recursivo: " + duration + " milisegundos"+"\n"+"\n");

	}
}
