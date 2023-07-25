package es.cic.prueba;

import java.awt.*;

public abstract class Figura {

    private long id;
    private Posicion puntoAplicacion;
    private Color color;

    public Figura() {
    }

    public Figura(long id, Posicion puntoAplicacion, Color color) {
        this.id = id;
        this.puntoAplicacion = puntoAplicacion;
        this.color = color;
    }

    String getTipo() {
        return getClass().getSimpleName();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "[ id=" + id +
                ", puntoAplicacion=" + puntoAplicacion +
                ", color=" + color;
    }
}
