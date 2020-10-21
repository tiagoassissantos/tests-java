package br.com.tiagosantos.carstore.controllers;

import br.com.tiagosantos.carstore.forms.VehicleForm;
import br.com.tiagosantos.carstore.models.Vehicle;
import br.com.tiagosantos.carstore.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VehiclesController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("")
    public @ResponseBody List<Vehicle> index() {
        List<Vehicle> vehicles = vehicleService.listAll();
        return vehicles;
    }

    @GetMapping("/{id}")
    public Vehicle show(@PathVariable Long id) {
        Vehicle vehicle = vehicleService.get(id);
        return vehicle;
    }

    @PostMapping("")
    public Vehicle create( @RequestBody VehicleForm vehicleForm ) {
        Vehicle vehicle = vehicleService.create(vehicleForm);
        return vehicle;
    }

    @PutMapping("/{id}")
    public Vehicle updateAll( @PathVariable Long id, @RequestBody VehicleForm vehicleForm ) {
        Vehicle vehicle = vehicleService.update(id, vehicleForm);
        return vehicle;
    }

    @PatchMapping("/{id}")
    public Vehicle update( @PathVariable Long id, @RequestBody VehicleForm vehicleForm ) {
        Vehicle vehicle = vehicleService.update(id, vehicleForm);
        return vehicle;
    }

    @DeleteMapping("")
    public String delete( @PathVariable Long id  ) {
        vehicleService.delete(id);
        return "ok";
    }

    @GetMapping("/find")
    public String find() {
        return "teste";
    }
}