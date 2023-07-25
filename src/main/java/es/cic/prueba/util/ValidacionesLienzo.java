package es.cic.prueba.util;

import es.cic.prueba.Lienzo;

public class ValidacionesLienzo {


    public static boolean existeId(long id, Lienzo lienzo) {
        return lienzo.getFiguras().stream().anyMatch(figura -> figura.getId() == id);
    }


    public static boolean noEsPositivo(double numero) {
        return numero <= 0;
    }
}