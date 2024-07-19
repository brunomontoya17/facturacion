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
@Table(name = "clientes")
@Inheritance(strategy = InheritanceType.JOINED)

@JsonTypeInfo(use= JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ClientePersFisica.class, name = "fisica"),
        @JsonSubTypes.Type(value = ClientePersJur.class, name = "juridica")
})

public abstract class Cliente extends ClienteProveedor
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idCliente;



    public abstract String getNombreCompleto();

    public abstract String getCuilDNI();

}
