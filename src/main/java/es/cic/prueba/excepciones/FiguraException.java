package es.cic.prueba.excepciones;

import es.cic.prueba.Figura;

public class LienzoException extends RuntimeException {

    private Figura figura;

    public LienzoException() {
    }

    public LienzoException(String message) {
        super(message);
    }

    public LienzoException(String message, Figura figura) {
        super(message);
        this.figura = figura;
    }

    public LienzoException(String message, Throwable cause, Figura figura) {
        super(message, cause);
        this.figura = figura;
    }
}
