package br.com.tiagosantos.carstore.repositories;

import br.com.tiagosantos.carstore.forms.GroupByBrand;
import br.com.tiagosantos.carstore.models.Vehicle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
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
        vehicle.setSold(false);
        vehicleRepository.save(vehicle);

        ArrayList<Vehicle> vehicles = (ArrayList<Vehicle>) vehicleRepository.findAll();
        assertEquals(1, vehicles.size());
        assertEquals("Honda", vehicles.get(0).getBrand());
    }


    @Test()
    public void shouldFindAllUnsoldVehicles() {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand("Honda");
        vehicle.setVehicle("Fit");
        vehicle.setManufactureYear(2007);
        vehicle.setDescription("Test create vehicle");
        vehicle.setSold(true);
        vehicleRepository.save(vehicle);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setBrand("Honda");
        vehicle2.setVehicle("Fit");
        vehicle2.setManufactureYear(2007);
        vehicle2.setDescription("Test create vehicle");
        vehicle2.setSold(false);
        vehicleRepository.save(vehicle2);

        ArrayList<Vehicle> vehicles = (ArrayList<Vehicle>) vehicleRepository.findBySoldFalse();
        assertEquals(1, vehicles.size());
        assertEquals("Honda", vehicles.get(0).getBrand());
    }

    @Test()
    public void shouldFindBetweenDates() {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand("Honda");
        vehicle.setVehicle("Fit");
        vehicle.setManufactureYear(2007);
        vehicle.setDescription("Test create vehicle");
        vehicle.setSold(true);

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -15);
        Date createdAt = cal.getTime();
        vehicle.setCreated( createdAt );
        vehicleRepository.save(vehicle);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setBrand("Ford");
        vehicle2.setVehicle("Fiesta");
        vehicle2.setManufactureYear(2007);
        vehicle2.setDescription("Test create vehicle");
        vehicle2.setSold(false);
        vehicleRepository.save(vehicle2);

        cal.setTime(new Date());
        cal.add(Calendar.DATE, -20);
        Date startDate = cal.getTime();

        cal.setTime(new Date());
        cal.add(Calendar.DATE, -12);
        Date endDate = cal.getTime();

        ArrayList<Vehicle> vehicles = (ArrayList<Vehicle>) vehicleRepository.findByCreatedBetween( startDate, endDate );
        assertEquals(1, vehicles.size());
    }

    @Test()
    public void CountByBrand() {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand("Honda");
        vehicle.setVehicle("Fit");
        vehicle.setManufactureYear(2007);
        vehicle.setDescription("Test create vehicle");
        vehicle.setSold(true);

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -15);
        Date createdAt = cal.getTime();
        vehicle.setCreated( createdAt );
        vehicleRepository.save(vehicle);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setBrand("Ford");
        vehicle2.setVehicle("Fiesta");
        vehicle2.setManufactureYear(2007);
        vehicle2.setDescription("Test create vehicle");
        vehicle2.setSold(false);
        vehicleRepository.save(vehicle2);

        cal.setTime(new Date());
        cal.add(Calendar.DATE, -20);
        Date startDate = cal.getTime();

        cal.setTime(new Date());
        cal.add(Calendar.DATE, -12);
        Date endDate = cal.getTime();

        List<GroupByBrand> vehicles = vehicleRepository.countByBrand();
        assertEquals(2, vehicles.size());
        assertEquals( "Ford", vehicles.get(0).getBrand() );
    }

    @Test()
    public void CountByYear() {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand("Honda");
        vehicle.setVehicle("Fit");
        vehicle.setManufactureYear(1998);
        vehicle.setDescription("Test create vehicle");
        vehicle.setSold(true);

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -15);
        Date createdAt = cal.getTime();
        vehicle.setCreated( createdAt );
        vehicleRepository.save(vehicle);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setBrand("Ford");
        vehicle2.setVehicle("Fiesta");
        vehicle2.setManufactureYear(2019);
        vehicle2.setDescription("Test create vehicle");
        vehicle2.setSold(false);
        vehicleRepository.save(vehicle2);

        cal.setTime(new Date());
        cal.add(Calendar.DATE, -20);
        Date startDate = cal.getTime();

        cal.setTime(new Date());
        cal.add(Calendar.DATE, -12);
        Date endDate = cal.getTime();

        List<Object[]> vehicles = vehicleRepository.countByDecade();
        assertEquals(2, vehicles.size());
        assertEquals( 1990, Double.valueOf((Double) vehicles.get(0)[0]).intValue() );
        assertEquals( 2010, Double.valueOf((Double) vehicles.get(1)[0]).intValue() );
    }
}
