package com.montoy.facturacion.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DecimalFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@DiscriminatorValue("fisica")
@Table(name = "clientes_pers_fis")
@PrimaryKeyJoinColumn(name = "clienteId")
@JsonTypeName("fisica")
public class ClientePersFisica extends Cliente {

    private String nombre;
    private String apellido;
    @Column(unique = true,nullable = false)
    private Integer DNI;

    @Override
    public String getNombreCompleto() {
        return getNombre() + " " + getApellido();
    }

    @Override
    public String getCuilDNI() {
        return DNI.toString();
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0000");
        return df.format(getIdCliente()) + " - " + getNombreCompleto() + " - " + getCuilDNI();
    }
}
