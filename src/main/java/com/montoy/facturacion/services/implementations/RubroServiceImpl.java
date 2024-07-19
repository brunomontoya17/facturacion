package com.montoy.facturacion.services.implementations;

import com.montoy.facturacion.entitiesLists.RubroLists;
import com.montoy.facturacion.model.Rubro;
import com.montoy.facturacion.repositories.RubroRepository;
import com.montoy.facturacion.services.RubroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubroServiceImpl implements RubroService {

    @Autowired
    RubroRepository rubroRepo;
    @Override
    public RubroLists retrieveRubros() {
        RubroLists lists = new RubroLists();
        lists.addAll(rubroRepo.findAll());
        return lists;
    }

    @Override
    public Rubro retrieveByID(Long ID) {
        return rubroRepo.findById(ID).orElse(null);
    }

    @Override
    public void addRubro(Rubro rubro) {
        rubroRepo.save(rubro);
    }

    @Override
    public void updateRubro(Rubro rubro) {
        rubroRepo.save(rubro);
    }
}
