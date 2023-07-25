package es.cic.prueba;

import java.awt.*;

public class Cuadrado extends Figura {

    double lado;

    public Cuadrado() {
    }

    public Cuadrado(long id, Posicion puntoAplicacion, Color color, double lado) {
        super(id, puntoAplicacion, color);
        this.lado = lado;
    }
}
