package aplicacion;

import excepciones.NumeroImparException;
import logica.Problemas;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 21;
		long startTime = System.nanoTime();

		Problemas problemas = new Problemas();

		problemas.llenarMatrizCuatroUno(n);

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
		
		startTime = System.nanoTime();
		
		try {
			problemas.llenarMatrizCuatroDos(n);
		} catch (NumeroImparException e) {
			System.out.println("Se ha producido una excepción: " + e.getMessage());
		}
		
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000; // Tiempo en milisegundos

		System.out.println("\t"+"Tiempo de ejecución problema 4.2 Iterativo: " + duration + " milisegundos");
	}
}
