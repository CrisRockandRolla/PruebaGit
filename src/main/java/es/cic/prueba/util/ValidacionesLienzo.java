package es.cic.prueba.util;public class Validacoines{private final es.cic.prueba.Lienzo lienzo;	public Validacoines(es.cic.prueba.Lienzo lienzo)	{		this.lienzo = lienzo;	}/*
    ========================================================================
                              VALIDACIONES
    ========================================================================
    */
    public boolean existeId(long id) {
        return lienzo.getFiguras().stream().anyMatch(figura -> figura.getId() == id);
    }public boolean noEstaDentroLimites(es.cic.prueba.Posicion posicion) {
        return !(posicion.getCoordenadaX() >= lienzo.getLimiteInferior().getCoordenadaX()) || !(posicion.getCoordenadaX() <= lienzo.getLimiteSuperior().getCoordenadaX())
                || !(posicion.getCoordenadaY() >= lienzo.getLimiteInferior().getCoordenadaY()) || !(posicion.getCoordenadaY() <= lienzo.getLimiteSuperior().getCoordenadaY());
    }public boolean esPositivo() {
        return false;
    }}