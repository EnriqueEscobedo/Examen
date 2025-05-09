package com.mx.consul.med.exam.exception;

/**
 * @author JM997909
 *
 */
public class DAOException extends RuntimeException {



    /**
	 * 
	 */
	private static final long serialVersionUID = 2660773176040836134L;

	/**
     * @param msg
     */
    public DAOException(String msg) {
        super(msg);
    }
    
    /**
     * @param mensaje
     * @param exception
     */
    public DAOException(String mensaje, Throwable exception) {
        super(mensaje);
    }

}
