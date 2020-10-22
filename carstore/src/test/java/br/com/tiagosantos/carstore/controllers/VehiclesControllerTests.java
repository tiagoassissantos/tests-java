package br.com.tiagosantos.carstore.controllers;

import br.com.tiagosantos.carstore.forms.VehicleForm;
import br.com.tiagosantos.carstore.models.Vehicle;
import br.com.tiagosantos.carstore.repositories.VehicleRepository;
import br.com.tiagosantos.carstore.services.VehicleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class VehiclesControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private VehicleService service;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Test
    void listVehicles() throws Exception {
        Vehicle vehicle = createVehiccle();
        Vehicle vehicle2 = createVehiccle();

        mockMvc.perform( MockMvcRequestBuilders
                .get("/veiculos")
                .accept("application/json")
                .content(objectMapper.writeValueAsString(vehicle)))
                .andExpect(status().isOk())
                .andExpect( MockMvcResultMatchers.jsonPath("$.[0].vehicle").value("Fit") );
    }

    @Test
    public void createVehicle() throws Exception {
        VehicleForm vehicle = new VehicleForm( "Celta", "Chevrolet", 2005, "Chevrolet Celta 2005", false );

        mockMvc.perform( MockMvcRequestBuilders
                .post("/veiculos")
                .content(asJsonString( vehicle ))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Vehicle createVehiccle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand("Honda");
        vehicle.setVehicle("Fit");
        vehicle.setManufactureYear(1998);
        vehicle.setDescription("Test create vehicle");
        vehicle.setSold(true);
        return vehicleRepository.save(vehicle);
    }
}
