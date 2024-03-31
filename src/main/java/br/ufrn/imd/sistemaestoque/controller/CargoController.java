package br.ufrn.imd.sistemaestoque.controller;

import br.ufrn.imd.sistemaestoque.domain.Cargo;
import br.ufrn.imd.sistemaestoque.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargos")
public class CargoController {
    @Autowired
    private CargoService cargoService;

    @GetMapping
    public List<Cargo> getCargos() {
        return cargoService.getCargos();
    }

    @GetMapping("/{id}")
    public Cargo getCargoById(@PathVariable Long id) {
        return cargoService.getCargoById(id);
    }

    @PostMapping
    public Cargo createCargo(@RequestBody Cargo cargo) {
        return cargoService.createCargo(cargo);
    }

    @PutMapping("/{id}")
    public Cargo updateCargo(@PathVariable Long id, @RequestBody Cargo updatedCargo) {
        return cargoService.updateCargo(id, updatedCargo);
    }

    @DeleteMapping("/{id}")
    public void deleteCargo(@PathVariable Long id) {
        cargoService.deleteCargo(id);
    }
}
