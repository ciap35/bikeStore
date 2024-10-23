package ciap.lab.mongodb.bikestore.service;

import ciap.lab.mongodb.bikestore.model.Bike;
import ciap.lab.mongodb.bikestore.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;


    public Bike saveBike(Bike bike) {
        return bikeRepository.save(bike);
    }


    public List<Bike> getAllBikes() {
        return bikeRepository.findAll();
    }


    public Optional<Bike> getBikeById(String id) {
        return bikeRepository.findById(id);
    }


    public void deleteBikeById(String id) {
        bikeRepository.deleteById(id);
    }


    public Optional<Bike> updateBikePartially(String id, Bike bikeDetails) {
        Optional<Bike> bikeOpt = bikeRepository.findById(id);
        if (bikeOpt.isPresent()) {
            Bike existingBike = bikeOpt.get();
            if (bikeDetails.getModel() != null) {
                existingBike.setModel(bikeDetails.getModel());
            }
            if (bikeDetails.getBrand() != null) {
                existingBike.setBrand(bikeDetails.getBrand());
            }
            if (bikeDetails.getPrice() > 0) {
                existingBike.setPrice(bikeDetails.getPrice());
            }
            if (bikeDetails.getEngine() != null) {
                existingBike.setEngine(bikeDetails.getEngine());
            }
            return Optional.of(bikeRepository.save(existingBike));
        } else {
            return Optional.empty();
        }
    }
}
