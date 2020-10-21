package br.com.tiagosantos.carstore.services;

import br.com.tiagosantos.carstore.converters.VehicleFormToVehicle;
import br.com.tiagosantos.carstore.forms.VehicleForm;
import br.com.tiagosantos.carstore.models.Vehicle;
import br.com.tiagosantos.carstore.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleFormToVehicle vehicleFormToVehicle;

    @Override
    public List<Vehicle> listAll() {
        List<Vehicle> vehicles = (List<Vehicle>) vehicleRepository.findAll();
        return vehicles;
    }

    @Override
    public Vehicle get(long id) {
        Vehicle vehicle = vehicleRepository.findById(id).get();
        return vehicle;
    }

    @Override
    public Vehicle create(VehicleForm vehicleForm) {
        Vehicle vehicle = vehicleFormToVehicle.convert(vehicleForm);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return savedVehicle;
    }

    @Override
    public Vehicle update(long id, VehicleForm vehicleForm) {
        Vehicle vehicle = vehicleRepository.findById(id).get();
        vehicleFormToVehicle.convert(vehicle, vehicleForm);
        Vehicle vehicleSaved = vehicleRepository.save(vehicle);
        return vehicleSaved;
    }

    @Override
    public boolean delete(long id) {
        Vehicle vehicle = vehicleRepository.findById(id).get();
        vehicleRepository.delete(vehicle);
        return true;
    }
}
