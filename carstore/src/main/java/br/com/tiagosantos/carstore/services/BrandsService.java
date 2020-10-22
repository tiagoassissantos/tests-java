package br.com.tiagosantos.carstore.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BrandsService {
    private final List<String> brands = Arrays.asList(
        "Audi",
        "BMW",
        "BYD",
        "CAOA Chery",
        "Changan",
        "Chevrolet",
        "Chrysler",
        "Citroën",
        "Dodge",
        "Dongfeng",
        "Effa",
        "Ferrari",
        "Fiat",
        "Ford",
        "Foton",
        "Hafei",
        "Honda",
        "Hyundai",
        "JAC",
        "Jaguar",
        "Jeep",
        "Kia",
        "Lamborghini",
        "Land Rover",
        "Lexus",
        "Lifan",
        "Maserati",
        "McLaren",
        "Mercedes-AMG",
        "Mercedes-Benz",
        "Mini",
        "Mitsubishi",
        "Nissan",
        "Peugeot",
        "Porsche",
        "RAM",
        "Renault",
        "Rolls-Royce",
        "Shineray",
        "SsangYong",
        "Subaru",
        "Suzuki",
        "TAC",
        "Tesla",
        "Toyota",
        "Troller",
        "Volkswagen",
        "Volvo"
    );

    public boolean validate(String brand) {
        return brands.stream().anyMatch(x-> x.equalsIgnoreCase(brand));
    }
}
