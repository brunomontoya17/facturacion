package com.montoy.facturacion.exceptions;

public class ReachLevelLimitException extends Exception{
    public ReachLevelLimitException() {
        super("No se puede asignar un rubro padre de Nivel 5");
    }
}
