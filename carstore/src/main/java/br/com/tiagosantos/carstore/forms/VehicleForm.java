package br.com.tiagosantos.carstore.forms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.Date;

public class VehicleForm {
    public String vehicle;
    public String brand;
    public Integer manufactureYear;
    public String description;
    public Boolean sold;

    public VehicleForm(String vehicle, String brand, Integer manufactureYear, String description, Boolean sold) {
        this.vehicle = vehicle;
        this.brand = brand;
        this.manufactureYear = manufactureYear;
        this.description = description;
        this.sold = sold;
    }

    public VehicleForm() {

    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(Integer manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getSold() {
        return sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }

}
