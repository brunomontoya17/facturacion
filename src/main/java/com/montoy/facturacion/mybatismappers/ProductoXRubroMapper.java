package com.montoy.facturacion.mybatismappers;

import com.montoy.facturacion.model.Producto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductoXRubroMapper
{
    @Select("SELECT prod.* " +
            "FROM productos as prod " +
            "LEFT JOIN rubros as R2 " +
            "ON prod.rubro_id=R2.id " +
            "LEFT JOIN rubros as R3 " +
            "ON R2.rubro_id=R3.id " +
            "LEFT JOIN rubros as R4 " +
            "ON R3.rubro_id=R4.id " +
            "LEFT JOIN rubros as R5 " +
            "ON R4.rubro_id=R5.id " +
            "WHERE prod.rubro_id=#{rubro_id} OR " +
            "R2.id=#{rubro_id} OR " +
            "R3.id=#{rubro_id} OR " +
            "R4.id=#{rubro_id} OR " +
            "R5.id=#{rubro_id}")
    List<Producto> findByRubro(@Param("rubro_id") Long rubro_id);
}
