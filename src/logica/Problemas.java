package logica;

import excepciones.NumeroImparException;

public class Problemas {
	/**
	 * Metodo iterativo que llena los sectores de la matriz segun la estructura
	 * presentada en el Problema 4.1 Dicha estructura esta dada por lo siguiente:
	 * Inicialmente vemos que la matriz generada es de tamaño [n][2*n] , lo que
	 * interpetamos como tener dos matrices de tamaño [n][n], una matriz izquierda y
	 * otra derecha. Tambien observamos que la forma de llenar la matriz es
	 * iniciando con potencias del numero dos en la columna 0, luego valores vacios
	 * o 0, este comportamiento se repite hasta llenar la parte izquierda de la
	 * matriz. Luego llena la parte derecha de la matriz como un espejo.
	 * Adicionalmente para llenar las columnas que tendran las potencias de dos hace
	 * el siguiente comportamiento: A la primera fila no le pone vacios, la
	 * siguiente pone un vacio iniciando y otro terminando,y aumenta esos vacios de
	 * 1 en 1 hasta llegar al final de la parte izquierda de la matriz.Este
	 * comportamiento igualmente lo refleja a la parte derecha en espejo.
	 * 
	 * @param n El parametro n define el tamaño de la matriz necesaria para
	 *          almacenar los numeros segun dicha estructura
	 */
	public void llenarMatrizCuatroUno(int n) {
		int[][] matriz = new int[n][2 * n];
		int contador = 0;
		int potencia = 0;
		// Iteramos a través de las columnas de la matriz
		for (int i = 0; i < matriz[0].length; i++) {
			if (i % 2 == 0 && i < n) {// Columnas pares y dentro del rango n
				if (i > 0) {
					potencia = i;
					if (potencia == n - 1 || potencia == n - 2) {
						potencia = 0;
					}
					// Llenar la parte izquierda de la matriz con potencias de 2
					for (int j = i / 2; j < matriz.length - (i / 2); j++) {
						matriz[j][i] = (int) Math.pow(2, potencia);
						potencia++;
					}
				} else {
					// Llenar la primera columna de la matriz con potencias de 2
					for (int j = 0; j < matriz.length; j++) {
						matriz[j][i] = (int) Math.pow(2, j);
					}
				}
				contador = i;
			} else if (i % 2 != 0 && i >= n) {// Columnas impares y mayores iguales a n
				potencia = (n - 1);
				if (i < matriz[0].length - 1) {
					if (i == n + 1) {
						potencia = 1;
					} else if (i == n) {
						potencia = 0;
					}
					// Llenar la parte derecha de la matriz con potencias de 2
					for (int j = contador / 2; j < matriz.length - (contador / 2); j++) {
						matriz[j][i] = (int) Math.pow(2, potencia);
						potencia--;
					}
				} else {
					// Llenar la ultima columna de la matriz con potencias de 2
					for (int j = 0; j < matriz.length; j++) {
						matriz[j][i] = (int) Math.pow(2, potencia);
						potencia--;
					}
				}
				contador -= 2;
			}

		}

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.println();
		}

	}

	/**
	 * Metodo recursivo que llena los sectores de la matriz segun la estructura
	 * presentada en el Problema 4.1 Dicha estructura esta dada por lo siguiente:
	 * Inicialmente vemos que la matriz generada es de tamaño [n][2*n] , lo que
	 * interpetamos como tener dos matrices de tamaño [n][n], una matriz izquierda y
	 * otra derecha. Tambien observamos que la forma de llenar la matriz es
	 * iniciando con potencias del numero dos en la columna 0, luego valores vacios
	 * o 0, este comportamiento se repite hasta llenar la parte izquierda de la
	 * matriz. Luego llena la parte derecha de la matriz como un espejo.
	 * Adicionalmente para llenar las columnas que tendran las potencias de dos hace
	 * el siguiente comportamiento: A la primera fila no le pone vacios, la
	 * siguiente pone un vacio iniciando y otro terminando,y aumenta esos vacios de
	 * 1 en 1 hasta llegar al final de la parte izquierda de la matriz.Este
	 * comportamiento igualmente lo refleja a la parte derecha en espejo.
	 * 
	 * @param matriz   Matriz inicializada como [n][2*n]
	 * @param n        El parametro n define el tamaño de la matriz necesaria para
	 *                 almacenar los numeros segun dicha estructura
	 * @param i        Indice para desplazarce en las columnas
	 * @param potencia Valor por el cual se va a elevar el numero 2
	 * @param contador Toma el valor de i al finalizar el llenado de la parte
	 *                 izqueirda, luego con ese valor se calculan los ceros en la
	 *                 parte derecha
	 */
	public void llenarMatrizCuatroUnoRecursivo(int[][] matriz, int n, int i, int potencia, int contador) {
		// Comprueba si hemos llegado al final de las columnas de la matriz
		if (i >= matriz[0].length) {
			return;// Si es así, termina la recursión
		}
		// Si la columna es par y está dentro del rango [0, n)
		if (i % 2 == 0 && i < n) {
			// Si no es la primera columna
			if (i > 0) {
				// Inicializa una variable temporal para la potencia
				int tempPotencia = i;
				// Si tempPotencia es igual a n - 1 o n - 2, reinicializa a 0
				if (tempPotencia == n - 1 || tempPotencia == n - 2) {
					tempPotencia = 0;
				}
				// Llena la parte izquierda de la matriz con potencias de 2
				for (int j = i / 2; j < matriz.length - (i / 2); j++) {
					matriz[j][i] = (int) Math.pow(2, tempPotencia);
					tempPotencia++;
				}
				contador = i;// Actualiza el contador
				// Llama recursivamente a la función para la siguiente columna
				llenarMatrizCuatroUnoRecursivo(matriz, n, i + 1, tempPotencia, contador);
			} else {
				// Llena la primera columna de la matriz con potencias de 2
				for (int j = 0; j < matriz.length; j++) {
					matriz[j][i] = (int) Math.pow(2, j);
				}
				// Llama recursivamente a la función para la siguiente columna
				llenarMatrizCuatroUnoRecursivo(matriz, n, i + 1, potencia, contador);
			}
			// Si la columna es menor que n, pero no es par
		} else if (i < n) {
			// Llama recursivamente a la función para la siguiente columna
			llenarMatrizCuatroUnoRecursivo(matriz, n, i + 1, potencia, contador);
		}
		// Si la columna es impar y es mayor o igual a n
		if (i % 2 != 0 && i >= n) {
			// Inicializa una variable temporal para la potencia
			int tempPotencia = (n - 1);
			// Si i es igual a n + 1, reinicializa tempPotencia a 1
			// Si i es igual a n, reinicializa tempPotencia a 0
			if (i < matriz[0].length - 1) {
				if (i == n + 1) {
					tempPotencia = 1;
				} else if (i == n) {
					tempPotencia = 0;
				}
				// Llena la parte derecha de la matriz con potencias de 2
				for (int j = contador / 2; j < matriz.length - (contador / 2); j++) {
					matriz[j][i] = (int) Math.pow(2, tempPotencia);
					tempPotencia--;
				}
				// Llama recursivamente a la función para la siguiente columna
				llenarMatrizCuatroUnoRecursivo(matriz, n, i + 1, tempPotencia, contador - 2);
			} else {
				// Llena la última columna de la matriz con potencias de 2
				for (int j = 0; j < matriz.length; j++) {
					matriz[j][i] = (int) Math.pow(2, tempPotencia);
					tempPotencia--;
				}
				// Llama recursivamente a la función para la siguiente columna
				llenarMatrizCuatroUnoRecursivo(matriz, n, i + 1, tempPotencia, contador - 2);
			}
			// Si la columna es mayor o igual a n, pero no es impar
		} else if (i >= n) {
			// Llama recursivamente a la función para la siguiente columna
			llenarMatrizCuatroUnoRecursivo(matriz, n, i + 1, potencia, contador);
		}
	}

	public void imprimirMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * Metodo iterativo que llena los sectores de la matriz segun la estructura
	 * presentada en el Problema 4.2 Dicha estructura esta dada por lo siguiente:
	 * Inicialmente vemos que la matriz generada es de tamaño [n][n] donde n debe
	 * ser un numero impar. Tambien observamos que la forma de llenar la matriz es
	 * iniciando con potencias del numero dos en la columna 0,las potencias inician
	 * por 2 ^ (n-1) y disminuyen a medida que se llena la columna, luego valores
	 * vacios o 0, este comportamiento se repite hasta llenar la matriz.
	 * Adicionalmente para llenar las columnas que tendran las potencias de dos hace
	 * el siguiente comportamiento: A la primera fila no le pone vacios, la
	 * siguiente pone un vacio iniciando y otro terminando,y aumenta esos vacios de
	 * 1 en 1 hasta llegar al final de la matriz.
	 * 
	 * @param n El parametro n define el tamaño de la matriz necesaria para
	 *          almacenar los numeros segun dicha estructura
	 */
	public void llenarMatrizCuatroDos(int n) throws NumeroImparException{
		if(n%2 != 1) {
			throw new NumeroImparException("El número n debe ser impar.");
		}
		int[][] matriz = new int[n][n];
		int potencia = 0;
		// Iteramos a través de las columnas de la matriz
		for (int i = 0; i < matriz[0].length; i++) {
			if (i % 2 == 0) {// Columnas pares
				if (i > 0) {
					potencia = (n - 1);
					// Llenar la matriz con potencias de 2
					for (int j = i / 2; j < matriz.length - (i / 2); j++) {
						matriz[j][i] = (int) Math.pow(2, potencia);
						potencia--;
					}
				} else {
					potencia = (n - 1);
					// Llenar la primera columna de la matriz con potencias de 2
					for (int j = 0; j < matriz.length; j++) {
						matriz[j][i] = (int) Math.pow(2, potencia);
						potencia--;
					}
				}
			}
		}

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
