package com.montoy.facturacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.montoy.facturacion.entitiesLists.ItemFacturaList;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="facturas")
public class Factura
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;

    @Column(name="fecha_emision",nullable = false)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "clienteId")
    @Getter(AccessLevel.NONE)
    private Cliente cliente;

    @OneToMany(mappedBy = "factura",cascade = CascadeType.ALL,targetEntity = ItemFactura.class)
    @JsonManagedReference
    private List<ItemFactura> items;

    public Cliente getCliente(){
        return cliente != null ? cliente : ConsumidorFinal.getInstance();
    }

    public Double getTotal()
    {
        return items.stream().mapToDouble(ItemFactura::getSubTotal).sum();
    }
}
