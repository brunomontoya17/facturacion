package com.montoy.facturacion.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.montoy.facturacion.exceptions.ReachLevelLimitException;
import jakarta.persistence.*;
import lombok.*;

import java.text.DecimalFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rubros")
public class Rubro
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRubro;
    @Column(name = "nombre", unique = true,nullable = false)
    private String nombreRubro;
    @Column(columnDefinition = "varchar(1024)")
    private String descripcion;

    @Column(nullable = false)
    @Setter(AccessLevel.PRIVATE)
    private Integer nivelRubro;


    @ManyToOne
    @JoinColumn(name = "rubro_id")
    private Rubro rubroPadre = null;


    public void setterLevel() throws ReachLevelLimitException {
        Integer level = 1;
        Rubro next = this;
        while (next.getRubroPadre()!=null){
            level++;
            next = next.getRubroPadre();
        }
        if (level>5)
            throw new ReachLevelLimitException();
        setNivelRubro(level);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("00000");
        return df.format(getIdRubro()) + " - " + getNombreRubro();
    }
}
