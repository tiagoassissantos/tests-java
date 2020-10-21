package br.com.tiagosantos.carstore.services;

import br.com.tiagosantos.carstore.forms.VehicleForm;
import br.com.tiagosantos.carstore.models.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> listAll();
    Vehicle get(long id);
    Vehicle create(VehicleForm vehicleForm);
    Vehicle update(long id, VehicleForm vehicleForm);
    boolean delete(long id);
}
