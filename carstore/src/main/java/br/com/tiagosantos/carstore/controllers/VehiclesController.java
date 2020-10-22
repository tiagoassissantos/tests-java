package br.com.tiagosantos.carstore.controllers;

import br.com.tiagosantos.carstore.forms.VehicleForm;
import br.com.tiagosantos.carstore.models.Vehicle;
import br.com.tiagosantos.carstore.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Vehicle> create(@RequestBody VehicleForm vehicleForm ) {
        Vehicle vehicle = vehicleService.create(vehicleForm);
        return new ResponseEntity<Vehicle>( vehicle, HttpStatus.CREATED);
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
    public Map<String, Boolean> delete(@PathVariable Long id  ) {
        vehicleService.delete(id);
        Map<String, Boolean> result = new HashMap<String, Boolean>();
        result.put("deleted", true);
        return result;
    }

    @GetMapping("/find")
    public <T> List<T> find(@RequestParam String q) throws Exception {
        List<T> result = vehicleService.find(q);
        return result;
    }
}
