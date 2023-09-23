package aplicacion;

import logica.Problemas;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		long startTime = System.nanoTime();

		Problemas problemas = new Problemas();

		problemas.llenarMatrizCuatroUno(n);

		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000; // Tiempo en milisegundos

		System.out.println("Tiempo de ejecución: " + duration + " milisegundos");

		startTime = System.nanoTime();

		int[][] matriz = new int[n][2 * n];
		problemas.llenarMatrizCuatroUnoRecursivo(matriz, n, 0, 0, 0);
		problemas.imprimirMatriz(matriz);

		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000; // Tiempo en milisegundos

		System.out.println("Tiempo de ejecución: " + duration + " milisegundos");
	}
}
