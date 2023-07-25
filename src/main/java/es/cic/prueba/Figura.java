package es.cic.prueba;

import java.awt.*;

public abstract class Figura {

    private Posicion puntoAplicacion;
    private Color color;

    public Figura() {
    }

    public Figura(Posicion puntoAplicacion, Color color) {
        this.puntoAplicacion = puntoAplicacion;
        this.color = color;
    }

    public Posicion getPuntoAplicacion() {
        return puntoAplicacion;
    }

    public void setPuntoAplicacion(Posicion puntoAplicacion) {
        this.puntoAplicacion = puntoAplicacion;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
