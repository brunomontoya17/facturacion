package com.montoy.facturacion.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "planillas_stock")
public class PlanillaStock
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlanillaStock;

    @Column (columnDefinition = "decimal default 0.0")
    private Double cantidad_stock;
    @Column (columnDefinition = "decimal default 0.0")
    private Double cantidad_critica;

    @Column(name="fecha_ultima_entrada",columnDefinition = "datetime default LOCALTIME()")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fecha_ultima_entrada;
    @Column (columnDefinition = "decimal default 0.0")
    private Double cantidad_ultima_entrada;

    @Column(name="fecha_ultima_salida")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fecha_ultima_salida;
    @Column (columnDefinition = "decimal default 0.0")
    private Double cantidad_ultima_salida;

    @Column(name="fecha_ultimo_ajuste",columnDefinition = "datetime default LOCALTIME()")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fecha_ultimo_ajuste;
    @Column (columnDefinition = "decimal default 0.0")
    private Double diferencia_ajuste;

    @OneToOne(mappedBy = "planillaStock")
    @JsonBackReference
    private Producto producto;

    public Boolean isStockCritico()
    {
        return getCantidad_stock()<=getCantidad_critica();
    }
}
