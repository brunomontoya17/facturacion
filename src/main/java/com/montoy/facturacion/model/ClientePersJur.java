package com.montoy.facturacion.model;

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
//@DiscriminatorValue("juridica")
@Table(name = "clientes_pers_jur")
@PrimaryKeyJoinColumn(name = "clienteId")
@JsonTypeName("juridica")
public class ClientePersJur extends Cliente {

    private String razonSocial;
    @Column(unique = true,nullable = false)
    private String cuit_cuil;
    @Override
    public String getNombreCompleto() {
        return getRazonSocial();
    }

    @Override
    public String getCuilDNI() {
        return getCuit_cuil();
    }


    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0000");
        return df.format(getIdCliente()) + " - " + getNombreCompleto() + " - " + getCuilDNI();
    }
}
