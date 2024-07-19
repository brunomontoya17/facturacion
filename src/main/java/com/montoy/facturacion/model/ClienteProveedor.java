package com.montoy.facturacion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class ClienteProveedor
{
    protected String email;
    protected String telefono;
    protected String direccion;
    protected boolean deAlta;
}
