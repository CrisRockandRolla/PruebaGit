package es.cic.prueba;

import es.cic.prueba.excepciones.FiguraException;
import es.cic.prueba.util.ValidacionesLienzo;

import java.awt.*;

public class Cuadrado extends Figura implements Redimensionable<Double> {

    private double lado;

    public Cuadrado() {
    }

    public Cuadrado(long id, Posicion puntoAplicacion, Color color, double lado) {
        super(id, puntoAplicacion, color);
        if (!noEsValido(lado)) this.lado = lado;
        else throw new FiguraException("El lado de la figura " + getTipo() + " tiene que ser positivo");
    }

    @Override
    public void cambiarTamano(Double nuevoTamano) {
        if (noEsValido(nuevoTamano))
            throw new FiguraException("El lado de la figura " + getTipo() + " tiene que ser positivo");
        setLado(nuevoTamano);
    }

    @Override
    public boolean noEsValido(Double nuevoTamano) {
        return ValidacionesLienzo.noEsPositivo(nuevoTamano);
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
}
