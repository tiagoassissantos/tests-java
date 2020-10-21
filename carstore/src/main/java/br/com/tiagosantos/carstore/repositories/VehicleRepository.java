package br.com.tiagosantos.carstore.repositories;

import br.com.tiagosantos.carstore.models.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
}
