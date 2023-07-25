package es.cic.prueba;

import java.awt.*;

public class Circulo extends Figura {
    double radio;

    public Circulo() {
    }

    public Circulo(long id, Posicion puntoAplicacion, Color color, double radio) {
        super(id, puntoAplicacion, color);
        this.radio = radio;
    }
}
