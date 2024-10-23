package ciap.lab.mongodb.bikestore.repository;

import ciap.lab.mongodb.bikestore.model.Bike;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BikeRepository extends MongoRepository<Bike, String> {
}
