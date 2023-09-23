package excepciones;

public class NumeroImparException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Excepcion para controlar que los numero ingresados sena impares
	 * 
	 * @param message
	 */
	public NumeroImparException(String message) {
		super(message);
	}

}
