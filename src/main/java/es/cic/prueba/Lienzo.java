package es.cic.prueba;

import java.util.ArrayList;
import java.util.List;

public class Lienzo {

    private final Posicion limites = new Posicion(1000, 1000);
    private final List<Figura> figuras = new ArrayList<>();

    public Lienzo() {
    }

    public void pintar(Figura figura) {
        //TODO
    }

    public void eliminar(Figura figura) {
        //TODO
    }

    public void mover(Figura figura, Posicion nuevaPosicion) {
        //TODO
    }

    public void cambiarTamano(Figura figura, double nuevaLongitud) {
        //TODO
    }

    public Posicion getLimites() {
        return limites;
    }

    public List<Figura> getFiguras() {
        return figuras;
    }
}
