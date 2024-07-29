package com.montoy.facturacion.Factories;

import com.montoy.facturacion.exceptions.ReachLevelLimitException;
import com.montoy.facturacion.model.Rubro;

import java.util.Objects;

public class RubroFactory
{
    public static Rubro createRubro()
    {
        return new Rubro();
    }

    public static Rubro createRubro(Long ID,String nombreRubro,String descripcion,Rubro rubroPadre) throws ReachLevelLimitException {
        Rubro create = new Rubro();
        create.setIdRubro(ID);
        create.setNombreRubro(nombreRubro);
        create.setDescripcion(descripcion);
        create.setRubroPadre(rubroPadre);
        create.setterLevel();
        return create;
    }

    public static Rubro createRubro(Rubro copy) throws ReachLevelLimitException {
        if (!Objects.isNull(copy)) {
            Rubro create = new Rubro();
            create.setIdRubro(copy.getIdRubro());
            create.setNombreRubro(copy.getNombreRubro());
            create.setDescripcion(copy.getDescripcion());
            create.setRubroPadre(createRubro(copy.getRubroPadre()));
            create.setterLevel();
            return create;
        }
        else
            return null;
    }
}
