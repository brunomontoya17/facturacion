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
@Table(name = "itemsajustes")
public class ItemAjusteStock implements ItemMovimientoStock
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItemAjuste;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    private String nombreProducto;
    private Double cantidad_ajuste;
    private Double diferencia_ajuste;

    @ManyToOne
    @JoinColumn(name = "ajuste_id")
    @JsonBackReference
    private AjusteStock ajusteStock;

    @Override
    public Long getIdProducto() {
        return getProducto().getIdProducto();
    }

    @Override
    public String getTipoMovimiento() {
        return "Ajuste de Stock";
    }

    @Override
    public Long getIdDocumento() {
        return getAjusteStock().getIdAjusteStock();
    }

    @Override
    public LocalDateTime getFechaDocumento() {
        return getAjusteStock().getFecha_ajuste();
    }

    @Override
    public Double getCantidadMovimiento() {
        return getDiferencia_ajuste();
    }

    @Override
    public Double getPrecioCompraVenta() {
        return 0D;
    }

    @Override
    public Double getTotalMovimiento() {
        return 0D;
    }
}
