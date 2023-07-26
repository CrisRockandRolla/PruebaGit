package es.cic.prueba;

import es.cic.prueba.excepciones.FiguraException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineaTest {

    private Linea cut;

    @BeforeEach
    void setUp() {
        cut = new Linea(1, new Posicion(10, 10), Color.BLUE, new Posicion(20, 20));
    }

    @Test
    void cambiarTamanoValidoTest() {
        Posicion nuevaPosicion = new Posicion(20, 20);
        cut.cambiarTamano(nuevaPosicion);
        assertThat(cut.getPuntoAplicacion(), is(nuevaPosicion));
    }

    @Test
    void cambiarTamanoNoValidoTest() {
        assertThrows(FiguraException.class, () -> cut.cambiarTamano(new Posicion(100000, 110)));
    }
}
