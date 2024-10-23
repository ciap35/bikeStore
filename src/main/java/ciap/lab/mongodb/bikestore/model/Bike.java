package ciap.lab.mongodb.bikestore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bikes")
public class Bike {

    @Id
    private String id;
    private String model;
    private String brand;
    private double price;
    private Engine engine;

    // Clase embebida Engine
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Engine {
        private String type;
        private int horsepower;
        private double displacement;
    }
}