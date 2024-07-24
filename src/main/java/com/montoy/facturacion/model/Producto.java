package com.montoy.facturacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productos")
public class Producto
{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
    @Column(name="codigo",unique = true,nullable = false)
    private String codigoDeBarras;
    @Column(name = "nombre",nullable = false)
    private String nombreProducto;
    @Column(columnDefinition = "varchar(1024)")
    private String descripcion;
    @Column(columnDefinition = "decimal unsigned")
    private Double precio;
    @ManyToOne
    @JoinColumn(name = "rubro_id")
    private Rubro rubro;
    @ManyToOne
    @JoinColumn(name="marca_id")
    private Marca marca;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "producto_stock",
            joinColumns = {@JoinColumn(name = "producto_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn( name = "planilla_id", referencedColumnName = "id")})
    @JsonManagedReference
    private PlanillaStock planillaStock;

    @Column(name="fecha_creacion")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fecha_creacion;

    @Column(name="fecha_modificacion")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fecha_modificacion;

    @Column(name="fecha_modificacion_precio")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fecha_modificacion_precio;

    public Boolean sonProductosIguales (Producto compare)
    {
        return (Objects.equals(this.getNombreProducto(), compare.getNombreProducto()) &&
                Objects.equals(this.getDescripcion(), compare.getDescripcion()) &&
                (!Objects.isNull(this.getMarca()) && !Objects.isNull(compare.getMarca()) &&
                        Objects.equals(this.getMarca().getIdMarca(), compare.getMarca().getIdMarca())) &&
                Objects.equals(this.getRubro().getIdRubro(),compare.getRubro().getIdRubro()));
    }
}
