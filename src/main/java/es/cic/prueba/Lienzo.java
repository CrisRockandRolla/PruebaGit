package es.cic.prueba;

import es.cic.prueba.excepciones.LienzoException;
import es.cic.prueba.util.ValidacionesLienzo;

import java.util.ArrayList;
import java.util.List;

public class Lienzo {

    private static final Posicion limiteInferior = new Posicion(0, 0);
    private static final Posicion limiteSuperior = new Posicion(1000, 1000);
    private final List<Figura> figuras = new ArrayList<>();


    public Lienzo() {
    }

    public void pintar(Figura figura) {
        if (ValidacionesLienzo.existeId(figura.getId(), this))
            throw new LienzoException("Ya existe una figura con ese id: " + figura.getId());
        if (noEstaDentroLimites(figura.getPuntoAplicacion()))
            throw new LienzoException("Punto de aplicacion " + figura.getPuntoAplicacion() + "fuera de rango del lienzo" + limiteInferior + "," + limiteSuperior);
        if (figura.getTipo().equalsIgnoreCase("linea") && noEstaDentroLimites(((Linea) figura).getPuntoFinal()))
            throw new LienzoException("Punto final de la linea fuera de limites");
        figuras.add(figura);
    }

    public void eliminarFigura(long id) {
        if (!ValidacionesLienzo.existeId(id, this))
            throw new LienzoException("No existe la figura con id " + id);
        figuras.removeIf(figura -> figura.getId() == id);
    }

    public void mover(Figura fig, Posicion nuevaPosicion) {
        if (noEstaDentroLimites(nuevaPosicion))
            throw new LienzoException("Nuevo punto de aplicacion " + nuevaPosicion + "fuera de rango del lienzo" + limiteInferior + "," + limiteSuperior);

        figuras.stream()
                .filter(figura -> figura.getId() == fig.getId())
                .findFirst()
                .orElseThrow(() -> new LienzoException("No se puede mover la figura porque no existe"))
                .setPuntoAplicacion(nuevaPosicion);
    }

    public void cambiarTamano(long id, Redimensionable<Object> figura, Object nuevoTamano) {
        for (Figura value : figuras) {
            if (value.getId() == id) {
                figura.cambiarTamano(nuevoTamano);
            }
        }
    }

    public boolean esRedimensionable(Figura figura) {
        return Redimensionable.class.isAssignableFrom(figura.getClass());
    }

    public static boolean noEstaDentroLimites(Posicion posicion) {
        return !(posicion.getCoordenadaX() >= limiteInferior.getCoordenadaX()) || !(posicion.getCoordenadaX() <= limiteSuperior.getCoordenadaX())
                || !(posicion.getCoordenadaY() >= limiteInferior.getCoordenadaY()) || !(posicion.getCoordenadaY() <= limiteSuperior.getCoordenadaY());
    }

    public Posicion getLimiteInferior() {
        return limiteInferior;
    }

    public Posicion getLimiteSuperior() {
        return limiteSuperior;
    }

    public List<Figura> getFiguras() {
        return figuras;
    }
}
