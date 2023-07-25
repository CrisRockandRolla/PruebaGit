package es.cic.prueba;

import java.awt.*;

public class Linea extends Figura {

    Posicion puntoFinal;

    public Linea() {
    }

    public Linea(long id, Posicion puntoAplicacion, Color color, Posicion puntoFinal) {
        super(id, puntoAplicacion, color);
        this.puntoFinal = puntoFinal;
    }
}
