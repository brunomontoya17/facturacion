package com.montoy.facturacion.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "proveedores")
@Inheritance(strategy = InheritanceType.JOINED)

@JsonTypeInfo(use= JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ProveedorPersFisica.class, name = "fisica"),
        @JsonSubTypes.Type(value = ProveedorPersJur.class, name = "juridica")
})
public abstract class Proveedor extends ClienteProveedor
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idProveedor;

    public abstract String getNombreCompleto();

    public abstract String getCuilDNI();
}
