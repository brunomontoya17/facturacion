package com.montoy.facturacion.exceptions;

public class IncorrectClassCreatorException extends Exception{
    public IncorrectClassCreatorException() {
        super("No se puede usar este metodo para crear un objeto en esta Factory");
    }
}
