package com.montoy.facturacion.model;

import java.time.LocalDateTime;

public interface ItemMovimientoStock
{
    public Long getIdProducto();
    public String getTipoMovimiento();
    public Long getIdDocumento();
    public LocalDateTime getFechaDocumento();
    public Double getCantidadMovimiento();
    public Double getPrecioCompraVenta();
    public Double getTotalMovimiento();
}
