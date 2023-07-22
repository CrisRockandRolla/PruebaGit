package es.cic;

import es.cic.prueba.Prueba;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PruebaTest {
    Prueba prueba;

    @BeforeEach
    void setUp() {
        prueba = new Prueba("1", "Cris", "Ajj", 22);

    }

    @Test
    void pt() {
        prueba.getNombre();
    }

}