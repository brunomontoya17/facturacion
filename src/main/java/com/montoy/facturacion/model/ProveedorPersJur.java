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
@PrimaryKeyJoinColumn(name = "proveedorId")
@Table(name = "proveedores_pers_jur")
@JsonTypeName("juridica")
public class ProveedorPersJur extends Proveedor
{
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
        return df.format(getIdProveedor()) + " - " + getNombreCompleto() + " - " + getCuilDNI();
    }
}
