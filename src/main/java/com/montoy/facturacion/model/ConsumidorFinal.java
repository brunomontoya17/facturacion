package com.montoy.facturacion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class ConsumidorFinal extends Cliente{

    private static ConsumidorFinal instance=null;
    private ConsumidorFinal (){

    }
    @Override
    public String getNombreCompleto() {
        return "Consumidor Final";
    }

    @Override
    public String getCuilDNI() {
        return "xx-XXXXXXXX-x";
    }

    @Override
    public Long getIdCliente() {
        return -1L;
    }

    @Override
    public String getTelefono() {
        return "XX-YYYY-ZZZZ";
    }

    @Override
    public String getEmail() {
        return "consumidor@final.net";
    }

    @Override
    public String getDireccion() {
        return "Calle Sin Nombre S/N";
    }

    @Override
    public boolean isDeAlta() {
        return true;
    }

    @JsonIgnore
    public static ConsumidorFinal getInstance(){
        if (Objects.isNull(instance))
            instance = new ConsumidorFinal();
        return instance;
    }
}
