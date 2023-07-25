package es.cic.prueba.excepciones;

import es.cic.prueba.Figura;

public class FiguraException extends RuntimeException {

    private Figura figura;

    public FiguraException() {
    }

    public FiguraException(String message) {
        super(message);
    }

    public FiguraException(String message, Figura figura) {
        super(message);
        this.figura = figura;
    }

    public FiguraException(String message, Throwable cause, Figura figura) {
        super(message, cause);
        this.figura = figura;
    }
}
