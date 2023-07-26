package es.cic.prueba;

import es.cic.prueba.excepciones.FiguraException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LienzoIntegrationTest {

    private Lienzo cut;

    @BeforeEach
    void setUp() {
        this.cut = new Lienzo();
    }

    @Test
    void cambiarTamanoValidoTest() {
        Linea linea = new Linea(1, new Posicion(0, 0), Color.BLUE, new Posicion(50, 50));
        Posicion nuevaPosicion = new Posicion(30, 20.5);
        cut.cambiarTamano(linea, nuevaPosicion);
        assertThat(linea.getPuntoAplicacion(), is(nuevaPosicion));

        Cuadrado cuadrado = new Cuadrado(1, new Posicion(0, 0), Color.BLUE, 10);
        double nuevoTamano = 50;
        cut.cambiarTamano(cuadrado, nuevoTamano);
        assertThat(cuadrado.getLado(), is(nuevoTamano));

        Circulo circulo = new Circulo(1, new Posicion(0, 0), Color.BLUE, 3);
        cut.cambiarTamano(circulo, nuevoTamano);
        assertThat(circulo.getRadio(), is(nuevoTamano));
    }

    @Test
    void cambiarTamanoNoValidoTest() {
        Linea linea = new Linea(1, new Posicion(0, 0), Color.BLUE, new Posicion(50, 50));
        Posicion nuevaPosicion = new Posicion(-30, 20.5);

        assertThrows(FiguraException.class, () -> cut.cambiarTamano(linea, nuevaPosicion));

        Cuadrado cuadrado = new Cuadrado(1, new Posicion(100000, 0), Color.BLUE, 10);
        double nuevoTamano = -50;
        assertThrows(FiguraException.class, () -> cut.cambiarTamano(cuadrado, nuevoTamano));

        Circulo circulo = new Circulo(1, new Posicion(0, 0), Color.BLUE, 3);
        assertThrows(FiguraException.class, () -> cut.cambiarTamano(circulo, nuevoTamano));
    }


}