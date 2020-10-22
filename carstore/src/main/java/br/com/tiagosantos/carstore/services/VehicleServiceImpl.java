package br.com.tiagosantos.carstore.services;

import br.com.tiagosantos.carstore.exceptions.BadRequestException;
import br.com.tiagosantos.carstore.converters.VehicleFormToVehicle;
import br.com.tiagosantos.carstore.exceptions.BrandNotExistsException;
import br.com.tiagosantos.carstore.forms.VehicleForm;
import br.com.tiagosantos.carstore.models.Vehicle;
import br.com.tiagosantos.carstore.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.*;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleFormToVehicle vehicleFormToVehicle;

    @Autowired
    private BrandsService brandsService;

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
        if ( !brandsService.validate(vehicleForm.getBrand()) ) throw new BrandNotExistsException();
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

    @Override
    public <T> List<T> find(String param) throws BadRequestException {
        switch (param) {
            case "unsold":
                return (List<T>) vehicleRepository.findBySoldFalse();

            case "byDecade":
                 List<Object[]> decades = vehicleRepository.countByDecade();
                 List<Map<String, Integer>> result = new ArrayList<Map<String, Integer>>();

                 for (Object[] decade : decades) {
                     Map<String, Integer> item = new HashMap<String, Integer>();
                     item.put( "decade", Double.valueOf((Double) decade[0]).intValue() );
                     item.put("quantity", (Integer) decade[1] );
                     result.add(item);
                 }

                 return (List<T>) result;

            case "byBrand":
                return (List<T>) vehicleRepository.countByBrand();

            case "lastWeek":
                LocalDate ld = LocalDate.now().minusDays(7);
                LocalDateTime sd = ld.with(WeekFields.of(Locale.US).dayOfWeek(), 1L).atStartOfDay();
                LocalDateTime ed = ld.with( WeekFields.of(Locale.US).dayOfWeek(), 7L).plusDays(1).atStartOfDay();

                Calendar calStart = Calendar.getInstance();
                calStart.set( sd.getYear(), sd.getMonthValue()-1, sd.getDayOfMonth(), sd.getHour(), sd.getMinute(), sd.getSecond() );

                Calendar calEnd = Calendar.getInstance();
                calEnd.set( ed.getYear(), ed.getMonthValue()-1, ed.getDayOfMonth(), ed.getHour(), ed.getMinute(), ed.getSecond() );

                return (List<T>) vehicleRepository.findByCreatedBetween( calStart.getTime(), calEnd.getTime() );

            default:
                throw new BadRequestException();
        }
    }
}
