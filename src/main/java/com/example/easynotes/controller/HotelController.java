package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Hotel;
import com.example.easynotes.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@RestController
@RequestMapping("/api")
public class HotelController {

    @Autowired
    HotelRepository hotelRepository;

    @GetMapping("/hotels")
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @PostMapping("/hotels")
    public Hotel createHotel(@Valid @RequestBody Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @GetMapping("/hotels/{id}")
    public Hotel getHotelById(@PathVariable(value = "id") Long hotelId) {
        return hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel", "id", hotelId));
    }

    @PutMapping("/hotels/{id}")
    public Hotel updateHotel(@PathVariable(value = "id") Long hotelId,
                                           @Valid @RequestBody Hotel hotelDetails) {

        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel", "id", hotelId));

        hotel.setTitle(hotelDetails.getTitle());
        hotel.setContent(hotelDetails.getContent());

        Hotel updatedHotel = hotelRepository.save(hotel);
        return updatedHotel;
    }

    @DeleteMapping("/hotels/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable(value = "id") Long hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel", "id", hotelId));

        hotelRepository.delete(hotel);

        return ResponseEntity.ok().build();
    }
}
