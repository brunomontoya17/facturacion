package com.montoy.facturacion.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "itemssalidas")
public class ItemSalidaStock implements ItemMovimientoStock
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItemSalida;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    private String nombreProducto;
    private Double precio_costo;
    private Double cantidad;

    @ManyToOne
    @JoinColumn(name = "salida_id",nullable = false)
    @JsonBackReference
    private SalidaStock salidaStock;

    public Double getSubTotal() {
        return getPrecio_costo()*getCantidad();
    }

    @Override
    public Long getIdProducto() {
        return getProducto().getIdProducto();
    }

    @Override
    public String getTipoMovimiento() {
        return "Salida de Stock";
    }

    @Override
    public Long getIdDocumento() {
        return getSalidaStock().getIdSalidaStock();
    }

    @Override
    public LocalDateTime getFechaDocumento() {
        return getSalidaStock().getFecha_salida();
    }

    @Override
    public Double getCantidadMovimiento() {
        return getCantidad();
    }

    @Override
    public Double getPrecioCompraVenta() {
        return getPrecio_costo();
    }

    @Override
    public Double getTotalMovimiento() {
        return getSubTotal();
    }
}
