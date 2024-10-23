package ciap.lab.mongodb.bikestore.controller;

import ciap.lab.mongodb.bikestore.model.Bike;
import ciap.lab.mongodb.bikestore.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bikes")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @PostMapping
    public ResponseEntity<Bike> createBike(@RequestBody Bike bike) {
        Bike createdBike = bikeService.saveBike(bike);
        return ResponseEntity.ok(createdBike);
    }


    @GetMapping
    public ResponseEntity<List<Bike>> getAllBikes() {
        List<Bike> bikes = bikeService.getAllBikes();
        return ResponseEntity.ok(bikes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bike> getBikeById(@PathVariable String id) {
        Optional<Bike> bike = bikeService.getBikeById(id);
        return bike.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bike> updateBike(@PathVariable String id, @RequestBody Bike bikeDetails) {
        bikeDetails.setId(id);
        Bike updatedBike = bikeService.saveBike(bikeDetails);
        return ResponseEntity.ok(updatedBike);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Bike> updateBikePartially(@PathVariable String id, @RequestBody Bike bikeDetails) {
        Optional<Bike> updatedBike = bikeService.updateBikePartially(id, bikeDetails);
        return updatedBike.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBike(@PathVariable String id) {
        bikeService.deleteBikeById(id);
        return ResponseEntity.noContent().build();
    }
}
