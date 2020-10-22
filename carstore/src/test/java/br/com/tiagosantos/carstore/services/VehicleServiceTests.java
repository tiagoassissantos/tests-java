package br.com.tiagosantos.carstore.services;

import br.com.tiagosantos.carstore.forms.VehicleForm;
import br.com.tiagosantos.carstore.models.Vehicle;
import br.com.tiagosantos.carstore.repositories.VehicleRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.transaction.Transactional;
import java.util.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class VehicleServiceTests {
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private VehicleRepository vehicleRepository;

    @Test
    public void shouldCreateVehicle() throws Exception {
        VehicleForm vehicleForm = new VehicleForm();
        vehicleForm.setBrand("Honda");
        vehicleForm.setVehicle("Civic");
        vehicleForm.setDescription("Teste");
        vehicleForm.setManufactureYear(2008);
        vehicleForm.setSold(false);

        Vehicle vehicle = vehicleService.create(vehicleForm);
        assertEquals( "Civic", vehicle.getVehicle() );
    }

    @Test
    public void shouldUpdateAllFields() throws Exception {
        long vehicleId = createVehicle(null).getId();

        VehicleForm vehicleForm = new VehicleForm();
        vehicleForm.setBrand("Honda");
        vehicleForm.setVehicle("Civic");
        vehicleForm.setDescription("Teste");
        vehicleForm.setManufactureYear(2003);
        vehicleForm.setSold(false);

        Vehicle vehicle = vehicleService.update(vehicleId, vehicleForm);
        assertEquals( vehicleForm.getVehicle(), vehicle.getVehicle() );
        assertEquals( vehicleForm.getBrand(), vehicle.getBrand() );
        assertEquals( vehicleForm.getDescription(), vehicle.getDescription() );
        assertEquals( vehicleForm.getManufactureYear(), vehicle.getManufactureYear() );
        assertEquals( vehicleForm.getSold(), vehicle.getSold() );
    }

    @Test
    public void shouldUpdateSomeFields() throws Exception {
        long vehicleId = createVehicle(null).getId();

        VehicleForm vehicleForm = new VehicleForm();
        vehicleForm.setVehicle("Civic");
        vehicleForm.setManufactureYear(2009);

        Vehicle vehicle = vehicleService.update(vehicleId, vehicleForm);
        assertEquals( vehicleForm.getVehicle(), vehicle.getVehicle() );
        assertNotEquals( vehicleForm.getBrand(), vehicle.getBrand() );
        assertNotEquals( vehicleForm.getDescription(), vehicle.getDescription() );
        assertEquals( vehicleForm.getManufactureYear(), vehicle.getManufactureYear() );
        assertNotEquals( vehicleForm.getSold(), vehicle.getSold() );
    }

    @Test
    public void shouldDelete() throws Exception {
        long vehicleId = createVehicle(null).getId();
        vehicleService.delete(vehicleId);
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
        assertTrue( vehicle.isEmpty() );
    }

    @Test
    public void shouldGetVehiclesCreatedLastWeek() throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -7);
        Vehicle vehicle = createVehicle(cal.getTime());

        List<Vehicle> vehicles = vehicleService.find("lastWeek");

        assertEquals(1, vehicles.size());
        assertEquals("Fit", vehicles.get(0).getVehicle());
    }


    protected Vehicle createVehicle(Date created) {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand("Honda");
        vehicle.setVehicle("Fit");
        vehicle.setManufactureYear(2007);
        vehicle.setDescription("Test create vehicle");
        vehicle.setSold(false);
        if (created != null) vehicle.setCreated(created);
        vehicleRepository.save(vehicle);
        return vehicle;
    }
}
