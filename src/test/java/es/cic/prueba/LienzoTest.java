package es.cic.prueba;

import es.cic.prueba.excepciones.LienzoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class LienzoTest {


    Lienzo cut;

    @BeforeEach
    void setUp() {
        cut = new Lienzo();
    }

    @Test
    void pintarValidaTest() {
        Figura circulo = new Circulo(1, new Posicion(1, 1), Color.BLUE, 4);
        cut.pintar(circulo);
        assertThat(cut.getFiguras().contains(circulo), is(true));

        Figura cuadrado = new Cuadrado(2, new Posicion(10, 10), Color.PINK, 12);
        cut.pintar(cuadrado);
        assertThat(cut.getFiguras().contains(cuadrado), is(true));

        Figura linea = new Linea(3, new Posicion(100, 100), Color.PINK, new Posicion(200, 200));
        cut.pintar(linea);
        assertThat(cut.getFiguras().contains(linea), is(true));

        Figura punto = new Punto(4, new Posicion(1000, 1000), Color.BLUE);
        cut.pintar(punto);
        assertThat(cut.getFiguras().contains(punto), is(true));
    }

    @Test
    void pintarIdNoValidoTest() {
        Figura circulo = new Circulo(1, new Posicion(1, 1), Color.BLUE, 4);
        cut.pintar(circulo);
        Figura punto = new Punto(1, new Posicion(10, 10), Color.BLUE);
        assertThrows(LienzoException.class, () -> cut.pintar(punto));
    }

    @Test
    void pintarPosicionNoValidaTest() {
        Figura circulo = new Circulo(1, new Posicion(-1, 1), Color.BLUE, 4);
        assertThrows(LienzoException.class, () -> cut.pintar(circulo));
        Figura cuadrado = new Cuadrado(1, new Posicion(1, -1), Color.BLUE, 4);
        assertThrows(LienzoException.class, () -> cut.pintar(cuadrado));
        Figura linea = new Linea(1, new Posicion(10000, 1), Color.BLUE, new Posicion(10, 10));
        assertThrows(LienzoException.class, () -> cut.pintar(linea));
        Figura punto = new Punto(1, new Posicion(0, 100000), Color.BLUE);
        assertThrows(LienzoException.class, () -> cut.pintar(punto));
    }

    @Test
    void eliminarFiguraExisteTest() {
        Figura circulo = new Circulo(1, new Posicion(1, 1), Color.BLUE, 4);
        cut.pintar(circulo);
        cut.eliminarFigura(1);
        assertThat(cut.getFiguras().contains(circulo), is(false));
    }

    @Test
    void eliminarFiguraNoExisteTest() {
        assertThrows(LienzoException.class, () -> cut.eliminarFigura(1));
    }

    @Test
    void moverPosicionValidaTest() {
        Figura circulo = new Circulo(1, new Posicion(1, 1), Color.BLUE, 4);
        cut.pintar(circulo);

        Posicion nuevaPosicion = new Posicion(56, 12);
        cut.mover(circulo, nuevaPosicion);
        assertThat(circulo.getPuntoAplicacion(), is(nuevaPosicion));
    }

    @Test
    void moverIdNoValidoTest() {
        Figura circulo = new Circulo(1, new Posicion(1, 1), Color.BLUE, 4);
        cut.pintar(circulo);
        cut.eliminarFigura(1);

        Posicion nuevaPosicion = new Posicion(56, 12);
        assertThrows(LienzoException.class, () -> cut.mover(circulo, nuevaPosicion));
    }


    @Test
    void moverPosicionNoValida() {
        Figura circulo = new Circulo(1, new Posicion(1, 1), Color.BLUE, 4);
        cut.pintar(circulo);

        Posicion nuevaPosicion = new Posicion(-56, 12);
        assertThrows(LienzoException.class, () -> cut.mover(circulo, nuevaPosicion));
    }


    @Test
    void cambiarTamanoTest() {
        Linea linea = mock(Linea.class);
        Posicion nuevaPosicion = new Posicion(120, 0);
        cut.cambiarTamano(linea, nuevaPosicion);
        verify(linea, times(1)).cambiarTamano(nuevaPosicion);


        Cuadrado cuadrado = mock(Cuadrado.class);
        cut.cambiarTamano(cuadrado, 50.0);
        verify(cuadrado, times(1)).cambiarTamano(50.0);

        Circulo circulo = mock(Circulo.class);
        cut.cambiarTamano(circulo, 50.0);
        verify(circulo, times(1)).cambiarTamano(50.0);
    }

}