package com.montoy.facturacion.Factories;

import com.montoy.facturacion.model.Marca;

public class MarcaFactory
{
    public static Marca createMarca() {
        return new Marca();
    }

    public static Marca createMarca(Long ID,String nombreMarca,String descripcion) {
        Marca create = new Marca(ID,nombreMarca,descripcion);
        return create;
    }

    public static Marca createMarca(Marca copy) {
        Marca create = new Marca();
        create.setIdMarca(copy.getIdMarca());
        create.setNombreMarca(copy.getNombreMarca());
        create.setDescripcion(copy.getDescripcion());
        return create;
    }
}
