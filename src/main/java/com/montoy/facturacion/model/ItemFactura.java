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
@Table(name = "itemsfacturas",uniqueConstraints = @UniqueConstraint(columnNames = {"producto_id","factura_id"}))
public class ItemFactura implements ItemMovimientoStock
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItemFactura;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    private String nombreProducto;
    private Double precio;
    private Double cantidad;
    @ManyToOne
    @JoinColumn(name = "factura_id",nullable = false)
    @JsonBackReference
    private Factura factura;

    public Double getSubTotal(){
        return getPrecio()*getCantidad();
    }

    @Override
    public Long getIdProducto() {
        return getProducto().getIdProducto();
    }

    @Override
    public String getTipoMovimiento() {
        return "Venta";
    }

    @Override
    public Long getIdDocumento() {
        return getFactura().getIdFactura();
    }

    @Override
    public LocalDateTime getFechaDocumento() {
        return getFactura().getFecha();
    }

    @Override
    public Double getCantidadMovimiento() {
        return getCantidad();
    }

    @Override
    public Double getPrecioCompraVenta() {
        return getPrecio();
    }

    @Override
    public Double getTotalMovimiento() {
        return getSubTotal();
    }
}
