package es.cic.prueba;

import java.awt.*;

public class Circulo extends Figura {
    double radio;

    public Circulo() {
    }

    public Circulo(Posicion puntoAplicacion, Color color, double radio) {
        super(puntoAplicacion, color);
        this.radio = radio;
    }
}
