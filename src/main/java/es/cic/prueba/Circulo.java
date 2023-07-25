package es.cic.prueba;

import es.cic.prueba.excepciones.FiguraException;
import es.cic.prueba.excepciones.LienzoException;
import es.cic.prueba.util.ValidacionesLienzo;

import java.awt.*;

public class Circulo extends Figura implements Redimensionable<Double> {
    double radio;

    public Circulo() {
    }

    public Circulo(long id, Posicion puntoAplicacion, Color color, double radio) {
        super(id, puntoAplicacion, color);
        if (!noEsValido(radio)) this.radio = radio;
        else throw new FiguraException("El radio de la figura " + getTipo() + " tiene que ser positivo");
    }

    @Override
    public void cambiarTamano(Double nuevoTamano) {
        if (noEsValido(nuevoTamano)) throw new LienzoException("Nueva longitud no válida");
        setRadio(nuevoTamano);
    }

    @Override
    public boolean noEsValido(Double nuevoTamano) {
        return ValidacionesLienzo.noEsPositivo(nuevoTamano);
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public String toString() {
        return super.toString() + ", radio =" + radio + " ]";
    }
}
