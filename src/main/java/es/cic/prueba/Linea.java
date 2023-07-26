package es.cic.prueba;

import es.cic.prueba.excepciones.FiguraException;

import java.awt.*;

public class Linea extends Figura implements Redimensionable<Posicion> {

    Posicion puntoFinal;

    public Linea() {
    }

    public Linea(long id, Posicion puntoAplicacion, Color color, Posicion puntoFinal) {
        super(id, puntoAplicacion, color);
        this.puntoFinal = puntoFinal;
    }

    @Override
    public void cambiarTamano(Posicion nuevaPosicion) {
        if (noEsValido(nuevaPosicion)) throw new FiguraException("Posicion no válida");
        else this.setPuntoAplicacion(nuevaPosicion);
    }

    @Override
    public boolean noEsValido(Posicion nuevaPosicion) {
        return Lienzo.noEstaDentroLimites(nuevaPosicion);
    }


    public Posicion getPuntoFinal() {
        return puntoFinal;
    }

    public void setPuntoFinal(Posicion puntoFinal) {
        this.puntoFinal = puntoFinal;
    }

}
