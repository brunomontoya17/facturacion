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
@Table(name = "itemsentradas")
public class ItemEntradaStock implements ItemMovimientoStock
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItemEntrada;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    private String nombreProducto;
    private Double precio_costo;
    private Double cantidad;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumns({
            @JoinColumn(name = "productocode_id",referencedColumnName = "producto_id",nullable = false),
            @JoinColumn(name = "proveedor_id",referencedColumnName = "proveedor_id",nullable = false)
    })
    private CodigoProdProv codigoProdProv;

    @ManyToOne
    @JoinColumn(name = "entrada_id",nullable = false)
    @JsonBackReference
    private EntradaStock entradaStock;

    public Double getSubtotal() {
        return getPrecio_costo()*getCantidad();
    }

    @Override
    public Long getIdProducto() {
        return getProducto().getIdProducto();
    }

    @Override
    public String getTipoMovimiento() {
        return "Entrada de Stock";
    }

    @Override
    public Long getIdDocumento() {
        return getEntradaStock().getIdEntradaStock();
    }

    @Override
    public LocalDateTime getFechaDocumento() {
        return getEntradaStock().getFecha_entrada();
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
        return getSubtotal();
    }
}
