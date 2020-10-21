package br.com.tiagosantos.carstore.converters;

import br.com.tiagosantos.carstore.forms.VehicleForm;
import br.com.tiagosantos.carstore.models.Vehicle;
import br.com.tiagosantos.carstore.services.VehicleServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VehicleFormToVehicleTests {
    private VehicleFormToVehicle vehicleFormToVehicle = new VehicleFormToVehicle();
    @Test
    public void shouldReturnVehicleObjectFromVehicleForm() throws Exception {
        VehicleForm vehicleForm = new VehicleForm();
        vehicleForm.setBrand("Honda");
        vehicleForm.setVehicle("Fit");
        vehicleForm.setManufactureYear(2007);
        vehicleForm.setDescription("Test create vehicle");
        Vehicle vehicle = new Vehicle();
        vehicleFormToVehicle.convert(vehicle, vehicleForm);

        assertEquals(vehicle.getBrand(), vehicleForm.getBrand());
    }
}
