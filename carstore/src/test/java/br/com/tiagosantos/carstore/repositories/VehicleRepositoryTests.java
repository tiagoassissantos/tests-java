package br.com.tiagosantos.carstore.repositories;

import br.com.tiagosantos.carstore.models.Vehicle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;

@DataJpaTest
public class VehicleRepositoryTests {

    @Autowired
    public VehicleRepository vehicleRepository;

    @Test()
    public void createVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand("Honda");
        vehicle.setVehicle("Fit");
        vehicle.setManufactureYear(2007);
        vehicle.setDescription("Test create vehicle");
        vehicleRepository.save(vehicle);

        ArrayList<Vehicle> vehicles = (ArrayList<Vehicle>) vehicleRepository.findAll();
        assertEquals(1, vehicles.size());
        assertEquals("Honda", vehicles.get(0).getBrand());
    }
}
