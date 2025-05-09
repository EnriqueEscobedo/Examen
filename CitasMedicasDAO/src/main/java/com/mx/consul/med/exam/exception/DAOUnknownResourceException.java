package com.mx.consul.med.exam.exception;

/**
 * Excepción de lógica de negocios simulada que indica que no se puede encontrar una entidad comercial o un registro deseado.
 */
/**
 * @author JM997909
 *
 */
public class DAOUnknownResourceException extends RuntimeException {

  

    /**
	 * 
	 */
	private static final long serialVersionUID = 4972391076265392678L;

	/**
     * @param msg
     */
    public DAOUnknownResourceException(String msg) {
        super(msg);
    }
    
    /**
     * @param mensaje
     * @param exception
     */
    public DAOUnknownResourceException(String mensaje, Throwable exception) {
        super(mensaje);
    }
}