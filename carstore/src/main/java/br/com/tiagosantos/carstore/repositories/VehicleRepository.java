package br.com.tiagosantos.carstore.repositories;

import br.com.tiagosantos.carstore.forms.GroupByBrand;
import br.com.tiagosantos.carstore.models.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
    List<Vehicle> findBySoldFalse();

    List<Vehicle> findByCreatedBetween(Date startDate, Date endDate);

    @Query("SELECT new br.com.tiagosantos.carstore.forms.GroupByBrand( brand, count(id) ) FROM Vehicle GROUP BY brand ORDER BY brand ASC")
    List<GroupByBrand> countByBrand();

    @Query(value = "select decade, count(*) from (" +
            "select floor(manufacture_year / 10) * 10 as decade from Vehicle" +
            ") t group by decade", nativeQuery = true)
    List<Object[]> countByDecade();
}
