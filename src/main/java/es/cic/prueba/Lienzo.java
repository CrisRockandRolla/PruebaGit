package es.cic.prueba;

import es.cic.prueba.excepciones.LienzoException;

import java.util.ArrayList;
import java.util.List;

public class Lienzo {

    private final Posicion limiteInferior = new Posicion(0, 0);
    private final Posicion limiteSuperior = new Posicion(1000, 1000);
    private final List<Figura> figuras = new ArrayList<>();

    public Lienzo() {
    }

    public void pintar(Figura figura) {
        if (existeId(figura.getId())) throw new LienzoException("Ya existe una figura con ese id: " + figura);
        if (noEstaDentroLimites(figura.getPuntoAplicacion()))
            throw new LienzoException("Punto de aplicacion de la figura fuera de rango del lienzo", figura);

        figuras.add(figura);
    }

    public void eliminarFigura(long id) {
        figuras.remove(
                figuras.stream()
                        .filter(figura -> figura.getId() == id)
                        .findFirst()
                        .orElseThrow(() -> new LienzoException("No se puede eliminar la figura porque no existe"))
        );
    }

    public void mover(Figura fig, Posicion nuevaPosicion) {
        if (noEstaDentroLimites(nuevaPosicion))
            throw new LienzoException("Nuevo punto de aplicacion " + nuevaPosicion + "fuera de rango del lienzo" + limiteInferior + "," + limiteSuperior);
        Figura figura1 = figuras.stream()
                .filter(figura -> figura.getId() == fig.getId())
                .findFirst()
                .orElseThrow(() -> new LienzoException("No se puede mover la figura porque no existe"));

        figura1.setPuntoAplicacion(nuevaPosicion);
    }

    public void cambiarTamano(Figura figura, double nuevaLongitud) {
        //TODO
        //Comprobar id
        //Comprobar nuevaLongitud
        //CambiarTamano/lanzar excepcion
    }

    /*
    ========================================================================
                              VALIDACIONES
    ========================================================================
    */
    public boolean existeId(long id) {
        return figuras.stream().anyMatch(figura -> figura.getId() == id);
    }

    public boolean noEstaDentroLimites(Posicion posicion) {
        return !(posicion.getCoordenadaX() >= limiteInferior.getCoordenadaX()) || !(posicion.getCoordenadaX() <= limiteSuperior.getCoordenadaX())
                || !(posicion.getCoordenadaY() >= limiteInferior.getCoordenadaY()) || !(posicion.getCoordenadaY() <= limiteSuperior.getCoordenadaY());
    }

    public boolean esPositivo() {
        return false;
    }

    /*
    ============================================================================
    */
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
