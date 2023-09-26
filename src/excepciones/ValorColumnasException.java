package excepciones;

public class ValorColumnasException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Excepcion para controlar que el numero de las columnas sea menor al de las
	 * filas
	 * 
	 * @param message
	 */
	public ValorColumnasException(String message) {
		super(message);
	}

}
