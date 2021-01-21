package com.example.easyhotels.controller;

import com.example.easyhotels.exception.ResourceNotFoundException;
import com.example.easyhotels.model.hotel;
import com.example.easyhotels.repository.hotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class hotelController {

    @Autowired
    hotelRepository hotelRepository;

    @GetMapping("/hotels")
    public List<hotel> getAllhotels() {
        return hotelRepository.findAll();
    }

    @PostMapping("/hotels")
    public hotel createhotel(@Valid @RequestBody hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @GetMapping("/hotels/{id}")
    public hotel gethotelById(@PathVariable(value = "id") Long hotelId) {
        return hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("hotel", "id", hotelId));
    }

    @PutMapping("/hotels/{id}")
    public hotel updatehotel(@PathVariable(value = "id") Long hotelId,
                                           @Valid @RequestBody hotel hotelDetails) {

        hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("hotel", "id", hotelId));

        hotel.setTitle(hotelDetails.getTitle());
        hotel.setContent(hotelDetails.getContent());

        hotel updatedhotel = hotelRepository.save(hotel);
        return updatedhotel;
    }

    @DeleteMapping("/hotels/{id}")
    public ResponseEntity<?> deletehotel(@PathVariable(value = "id") Long hotelId) {
        hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("hotel", "id", hotelId));

        hotelRepository.delete(hotel);

        return ResponseEntity.ok().build();
    }
}
