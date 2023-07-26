package es.cic.prueba;

import es.cic.prueba.excepciones.FiguraException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CuadradoTest {

    private Cuadrado cut;

    @BeforeEach
    void setUp() {
        cut = new Cuadrado(1, new Posicion(10, 10), Color.BLUE, 15);
    }

    @Test
    void crearCuadradoLadoNoValidoTest() {
        double ladoInvalido = -10;
        assertThrows(FiguraException.class, () -> new Circulo(1L, new Posicion(0, 0), Color.RED, ladoInvalido));
    }

    @Test
    void cambiarTamanoValidoTest() {
        cut.cambiarTamano(100.0);
        assertThat(cut.getLado(), is(100.0));
    }

    @Test
    void cambiarTamanoNoValidoTest() {
        assertThrows(FiguraException.class, () -> cut.cambiarTamano(-10.0));
    }
}