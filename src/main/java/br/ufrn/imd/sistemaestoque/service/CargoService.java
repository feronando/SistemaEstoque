package br.ufrn.imd.sistemaestoque.service;

import br.ufrn.imd.sistemaestoque.domain.Cargo;
import br.ufrn.imd.sistemaestoque.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {
    @Autowired
    private CargoRepository cargoRepository;

    public List<Cargo> getCargos() {
        return (List<Cargo>) cargoRepository.findAll();
    }

    public Cargo getCargoById(Long id) {
        return cargoRepository.findById(id).orElse(null);
    }

    public Cargo createCargo(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    public Cargo updateCargo(Long id, Cargo updatedCargo) {
        return cargoRepository.findById(id).map(cargo -> {
            cargo.setNomeCargo(updatedCargo.getNomeCargo());
            cargo.setPermissoes(updatedCargo.getPermissoes());
            cargo.setUsuarios(updatedCargo.getUsuarios());
            return cargoRepository.save(cargo);
        }).orElseGet(() -> {
            return createCargo(updatedCargo);
        });
    }

    public void deleteCargo(Long id) {
        Cargo cargo = getCargoById(id);
        cargoRepository.delete(cargo);
    }
}
