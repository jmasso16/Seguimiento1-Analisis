package logica;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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
	public int[][] llenarMatrizCuatroUno(int n) {
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
		return matriz;
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
	public int[][] llenarMatrizCuatroDos(int n) throws NumeroImparException{
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
		return matriz;
	}

	public void llenarMatrizCuatroDosRecursiva(int n) throws NumeroImparException {
		if (n % 2 != 1) {
			throw new NumeroImparException("El número n debe ser impar.");
		}
	
		int[][] matriz = new int[n][n];
		llenarMatrizRecursiva(matriz, n, 0, 0);
	
		// Imprimir la matriz (opcional)
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
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
	 * @param matriz   Matriz inicializada como [n][n]
	 * @param n        El parametro n define el tamaño de la matriz necesaria para
	 *                 almacenar los numeros segun dicha estructura
	 * @param i        Indice para desplazarce en las columnas
	 * @param potencia Valor por el cual se va a elevar el numero 2
	 */
	public void llenarMatrizRecursiva(int[][] matriz, int n, int i, int potencia) {
		// Comprueba si hemos llegado al final de las columnas de la matriz
		if (i >= matriz[0].length) {
			return;// Si es así, termina la recursión
		}
		// Si la columna es par
		if (i % 2 == 0) {
			// Si no es la primera columna
			if (i > 0) {
				// Inicializa una variable temporal para la potencia
				int tempPotencia = n-1;
				// Llena la matriz con potencias de 2 despues de la primera columna
				for (int j = i / 2; j < matriz.length - (i / 2); j++) {
					matriz[j][i] = (int) Math.pow(2, tempPotencia);
					tempPotencia--;
				}
				// Llama recursivamente a la función para la siguiente columna
				llenarMatrizRecursiva(matriz, n, i + 1, tempPotencia);
			} else {
				 int tempPotencia = n-1;
				// Llena la primera columna de la matriz con potencias de 2
				for (int j = 0; j < matriz.length; j++) {
					matriz[j][i] = (int) Math.pow(2, tempPotencia);
					tempPotencia--;
				}
				// Llama recursivamente a la función para la siguiente columna
				llenarMatrizRecursiva(matriz, n, i + 1, potencia);
			}
			// Si la columna es menor que n, pero no es par
		} else if (i < n) {
			// Llama recursivamente a la función para la siguiente columna
			llenarMatrizRecursiva(matriz, n, i + 1, potencia);
		}

	}	

	

	// Encuentra los números de Smith en una matriz y los almacena en una lista.
	public List<Integer> encontrarNumerosDeSmithEnMatriz(int[][] matriz) {
		List<Integer> numerosDeSmith = new ArrayList<>();

		for (int[] fila : matriz) {
			for (int numero : fila) {
				// Verifica si el número no es primo y es un número de Smith.
				if (!esPrimo(numero) && esNumeroDeSmith(numero)) {
					numerosDeSmith.add(numero);
				}
			}
		}

		return numerosDeSmith;
	}

	// Verifica si un número es un número de Smith.
	public boolean esNumeroDeSmith(int numero) {
		// Calcula la suma de los dígitos del número.
		int sumaDigitos = sumarDigitos(numero);
		// Calcula la suma de los dígitos de sus divisores primos.
		int sumaDivisoresPrimos = sumarDivisoresPrimos(numero);

		// Compara si ambas sumas son iguales.
		return sumaDigitos == sumaDivisoresPrimos;
	}

	// Suma los dígitos de un número.
	public int sumarDigitos(int numero) {
		int suma = 0;

		while (numero > 0) {
			suma += numero % 10;
			numero /= 10;
		}

		return suma;
	}

	// Suma los dígitos de los divisores primos de un número.
	public int sumarDivisoresPrimos(int numero) {
		int suma = 0;

		for (int i = 2; i <= numero; i++) {
			while (numero % i == 0 && esPrimo(i)) {
				suma += sumarDigitos(i);
				numero /= i;
			}
		}

		return suma;
	}

	// Verifica si un número es primo.
	public boolean esPrimo(int numero) {
		if (numero <= 1) {
			return false;
		}

		for (int i = 2; i * i <= numero; i++) {
			if (numero % i == 0) {
				return false;
			}
		}

		return true;
	}


	/////////////////////

	public List<Integer> encontrarNumerosDeSmithEnMatrizRecursivo(int[][] matriz, int fila, int columna) {
        List<Integer> numerosDeSmith = new ArrayList<>();

        // Caso base: cuando llegamos al final de la matriz
        if (fila >= matriz.length) {
            return numerosDeSmith;
        }

        // Verifica si el número no es primo y es un número de Smith.
        if (!esPrimoRecursivo(matriz[fila][columna], 2) && esNumeroDeSmithRecursivo2(matriz[fila][columna])) {
            numerosDeSmith.add(matriz[fila][columna]);
        }

        // Avanza a la siguiente columna o fila de manera recursiva
        int nuevaFila = fila;
        int nuevaColumna = columna + 1;
        if (nuevaColumna >= matriz[0].length) {
            nuevaFila++;
            nuevaColumna = 0;
        }

        // Llamada recursiva para procesar el siguiente elemento de la matriz
        numerosDeSmith.addAll(encontrarNumerosDeSmithEnMatrizRecursivo(matriz, nuevaFila, nuevaColumna));

        return numerosDeSmith;
    }

	public int sumarDigitosRecursivo(int numero) {
		// Caso base: si el número tiene un solo dígito, se devuelve ese dígito.
		if (numero < 10) {
			return numero;
		} else {
			// Se suma el último dígito (numero % 10) y se realiza una llamada recursiva
			// para sumar los dígitos restantes (numero / 10).
			return numero % 10 + sumarDigitosRecursivo(numero / 10);
		}
	}
	
	// Calcula la suma de los dígitos de los divisores primos de un número de manera recursiva.
	public int sumarDivisoresPrimosRecursivo(int numero, int divisor, int suma) {
		// Caso base: cuando el número llega a 1, se devuelve la suma acumulada.
		if (numero == 1) {
			return suma;
		} else if (numero % divisor == 0 && esPrimoRecursivo(divisor, 2)) {
			// Si el número es divisible por el divisor actual y el divisor es primo,
			// se suma la suma acumulada con la suma de los dígitos del divisor y se
			// realiza una llamada recursiva con el número dividido por el divisor.
			return sumarDivisoresPrimosRecursivo(numero / divisor, divisor, suma + sumarDigitosRecursivo(divisor));
		} else {
			// Si no se cumple la condición anterior, se pasa al siguiente divisor
			// de manera recursiva.
			return sumarDivisoresPrimosRecursivo(numero, divisor + 1, suma);
		}
	}
	
	// Verifica si un número es primo de manera recursiva.
	public boolean esPrimoRecursivo(int numero, int divisor) {
		// Caso base: si el número es menor o igual a 1, no es primo.
		if (numero <= 1) {
			return false;
		}
	
		// Si el divisor al cuadrado es mayor que el número, el número es primo.
		if (divisor * divisor > numero) {
			return true;
		}
	
		// Si el número es divisible por el divisor actual, no es primo.
		if (numero % divisor == 0) {
			return false;
		}
	
		// Llamada recursiva para probar el siguiente divisor.
		return esPrimoRecursivo(numero, divisor + 1);
	}
	
	// Verifica si un número es un número de Smith de manera recursiva.
	public boolean esNumeroDeSmithRecursivo2(int numero) {
		// Calcula la suma de los dígitos del número y la suma de los dígitos de sus
		// divisores primos utilizando las funciones recursivas previamente definidas.
		int sumaDigitos = sumarDigitosRecursivo(numero);
		int sumaDivisoresPrimos = sumarDivisoresPrimosRecursivo(numero, 2, 0);
	
		// Compara si ambas sumas son iguales.
		return sumaDigitos == sumaDivisoresPrimos;
	}

	public  void estrella(int filas, int columnas){
        char[][] matriz = new char[filas][columnas];

        // Llenar toda la matriz con vacios ' ' por defecto.
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = ' ';
            }
        }

        // Llenar el borde de la matriz con unos '1'.
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i == 0 || i == filas - 1 || j == 0 || j == columnas - 1) {
                    matriz[i][j] = '1';
                }
            }
        }

		int centroFila = filas / 2;
        int centroColumna = columnas / 2;

        // llena arriba
       for (int k = 0; k < centroFila-1; k++) {
            for (int i = 1; i < centroFila-1; i++) {
                for (int j = 1; j < matriz[0].length-1; j++) {
                    if(j < centroColumna-k){
                        matriz[i][j] = '1';
                    }
                    if(j> centroColumna+k ){
                        matriz[i][j] = '1';
                    }
                }
                k++;
            }
        }
        // llena abajo
        for (int k = centroFila-2; k > 1; k--) {
            for (int i = centroFila+1; i < matriz.length-1; i++) {
                for (int j = 1; j < matriz[0].length-1; j++) {
                    if(j < centroColumna-k){
                        matriz[i][j] = '1';
                    }
                    if(j> centroColumna+k ){
                        matriz[i][j] = '1';
                    }
                }
                k--;
            }
        }



        // Imprimir la matriz resultante.
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
               		System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
		
    }
	
	public  void llenarArribaRecursivo(char[][] matriz, int centroFila, int centroColumna, int k, int i, int j) {
        // Caso base: detener la recursión cuando k sea mayor o igual a centroFila.
        if (k >= centroFila) {
            return;
        }

        // Llenar la parte superior de la matriz en la posición actual (i, j).

        //parte izquierda
        if(j < centroColumna-k){
            matriz[i][j] = '1';
        }

        //parte derecha
        if(j> centroColumna+k ){
            matriz[i][j] = '1';
        }

        // Llamar recursivamente para la siguiente posición.
        if (j < matriz[0].length - 2) {
            llenarArribaRecursivo(matriz, centroFila, centroColumna, k, i, j + 1);
        } else {
            // Cambiar de fila y reiniciar j al principio de la fila.
            llenarArribaRecursivo(matriz, centroFila, centroColumna, k+1, i + 1, 1);
        }
    }

    public  void llenarAbajoRecursivo(char[][] matriz, int centroFila, int centroColumna, int k, int i, int j) {
        // Caso base: detener la recursión cuando k sea menor a 0.
        if (k < 0) {
            return;
        }

        // Llenar la parte inferior de la matriz en la posición actual (i, j).

        //parte izquierda
        if(j < centroColumna-k){
            matriz[i][j] = '1';
        }

        //parte derecha
        if(j> centroColumna+k ){
            matriz[i][j] = '1';
        }

        // Llamar recursivamente para la siguiente posición.
        if (j < matriz[0].length - 2) {
            llenarAbajoRecursivo(matriz, centroFila, centroColumna, k, i, j + 1);
        } else {
            // Cambiar de fila y reiniciar j al principio de la fila.
            llenarAbajoRecursivo(matriz, centroFila, centroColumna, k-1, i + 1, 1);
        }
    }

    public  void estrella2(int filas, int columnas) {
        char[][] matriz = new char[filas][columnas];
        
        // Llenar toda la matriz con vacios ' ' por defecto.
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = ' ';
            }
        }

        // Lena los limites de la matriz con 1
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i == 0 || i == filas - 1 || j == 0 || j == columnas - 1) {
                    matriz[i][j] = '1';
                }
            }
        }


        int centroFila = filas / 2;
        int centroColumna = columnas / 2;

        // Llamar a las funciones recursivas para llenar la parte superior e inferior.
        llenarArribaRecursivo(matriz, centroFila - 1, centroColumna, 0, 1, 1);
        llenarAbajoRecursivo(matriz, centroFila - 2, centroColumna, centroFila - 2, centroFila + 1, 1);

        // Imprimir la matriz resultante.
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
               		System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public ArrayList<Integer> listarNumerosHambrientos(int n){
    	ArrayList<Integer> listadoH = new ArrayList<>();
    	int k = 1;
    	String pi = ""+Math.PI;
    	pi= pi.replace(".", "");
    	
    	for (int i = 5; i <= n; i++) {
    		String potencia="";
            BigInteger resultadoBigInteger = new BigInteger("2");
            BigInteger resultado = resultadoBigInteger.pow(i);
    		potencia = ""+resultado;
    		if(potencia.contains(pi.substring(0, k))) {
    			listadoH.add(i);
    			k++;
    			if(potencia.contains(pi.substring(0, k))) {
        			listadoH.add(i);
        			k++;
        		}
    		}
			
		}
    	
    	return listadoH;
    }
    
    public ArrayList<Integer> listarNumerosHambrientos2(int n) {
        ArrayList<Integer> listadoH = new ArrayList<>();
        int k = 1;
        String pi = "" + Math.PI;
        pi = pi.replace(".", "");
        int i = 5;
        return listarNumerosHambrientosRecursiva(i,n, k, pi, listadoH);
    }

    private ArrayList<Integer> listarNumerosHambrientosRecursiva(int i,int n, int k, String pi, ArrayList<Integer> listadoH) {
        if (i > n) {
            return listadoH;
        }
        
        String potencia = "";
        BigInteger resultadoBigInteger = new BigInteger("2");
        BigInteger resultado = resultadoBigInteger.pow(i);
        potencia = "" + resultado;
        
        if (potencia.contains(pi.substring(0, k))) {
            listadoH.add(i);
            k++;
            if (potencia.contains(pi.substring(0, k))) {
                listadoH.add(i);
                k++;
            }
        }
        
        return listarNumerosHambrientosRecursiva(i+1,n, k, pi, listadoH);
    }

}
