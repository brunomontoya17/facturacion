package com.montoy.facturacion.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode
public class ProdXProvKey implements Serializable {
    private Producto producto;
    private Proveedor proveedor;
}
