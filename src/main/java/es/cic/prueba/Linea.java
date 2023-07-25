package es.cic.prueba;

import java.awt.*;

public class Linea extends Figura {

    Posicion puntoFinal;

    public Linea() {
    }

    public Linea(Posicion puntoAplicacion, Color color, Posicion puntoFinal) {
        super(puntoAplicacion, color);
        this.puntoFinal = puntoFinal;
    }
}
