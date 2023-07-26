package es.cic.prueba;

import es.cic.prueba.excepciones.FiguraException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CirculoTest {

    private Circulo cut;

    @BeforeEach
    void setUp() {
        cut = new Circulo(1, new Posicion(10, 10), Color.BLUE, 10);
    }

    @Test
    void crearCirculoConRadiNoValidoTest() {
        double radioInvalido = -10;
        assertThrows(FiguraException.class, () -> new Circulo(1L, new Posicion(0, 0), Color.RED, radioInvalido));
    }

    @Test
    void cambiarTamanoValidoTest() {
        cut.cambiarTamano(4.5);
        assertThat(cut.getRadio(), is(4.5d));
    }

    @Test
    void cambiarTamanoNoValidoTest() {
        assertThrows(FiguraException.class, () -> cut.cambiarTamano(-4.5));
    }
}