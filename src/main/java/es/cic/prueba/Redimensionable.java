package es.cic.prueba;

public interface Redimensionable<X> {
    void cambiarTamano(X nuevoTamano);

    boolean noEsValido(X nuevoTamano);
}
