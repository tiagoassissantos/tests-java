package br.com.tiagosantos.carstore.converters;

import br.com.tiagosantos.carstore.forms.VehicleForm;
import br.com.tiagosantos.carstore.models.Vehicle;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

@Component
public class VehicleFormToVehicle implements Converter<VehicleForm, Vehicle> {
    @Override
    public Vehicle convert(VehicleForm vehicleForm) {
        Vehicle vehicle = new Vehicle();
        vehicle = convert(vehicle, vehicleForm);
        return vehicle;
    }

    public Vehicle convert(Vehicle vehicle, VehicleForm vehicleForm) {
        if (vehicleForm.getDescription() != null) vehicle.setDescription( vehicleForm.getDescription() );
        if (vehicleForm.getBrand() != null) vehicle.setBrand( vehicleForm.getBrand() );
        if (vehicleForm.getVehicle() != null) vehicle.setVehicle( vehicleForm.getVehicle() );
        if (vehicleForm.getManufactureYear() != null) vehicle.setManufactureYear( vehicleForm.getManufactureYear() );
        if (vehicleForm.getSold() != null) vehicle.setSold( vehicleForm.getSold() );
        return vehicle;
    }
}
