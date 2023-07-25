package es.cic.prueba;

import java.awt.*;

public class Cuadrado extends Figura {

    double lado;

    public Cuadrado() {
    }

    public Cuadrado(Posicion puntoAplicacion, Color color, double lado) {
        super(puntoAplicacion, color);
        this.lado = lado;
    }
}
