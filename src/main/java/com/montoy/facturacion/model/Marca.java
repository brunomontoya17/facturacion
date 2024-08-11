package com.montoy.facturacion.model;

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
@Table(name = "marcas")
public class Marca
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMarca;
    @Column(name = "nombre", unique = true, nullable = false)
    private String nombreMarca;
    private String descripcion;

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("00000");
        return df.format(getIdMarca()) + " - "  + getNombreMarca();
    }
}
