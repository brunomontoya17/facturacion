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
//@DiscriminatorValue("fisica")
@PrimaryKeyJoinColumn(name = "proveedorId")
@Table(name = "proveedores_pers_fis")
@JsonTypeName("fisica")
public class ProveedorPersFisica extends Proveedor {

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
        return getDNI().toString();
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0000");
        return df.format(getIdProveedor()) + " - " + getNombreCompleto() + " - " + getCuilDNI();
    }
}
