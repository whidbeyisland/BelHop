package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.HotelRoom;
import com.example.easynotes.repository.HotelRoomRepository;
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
public class HotelRoomController {

    @Autowired
    HotelRoomRepository hotelRoomRepository;

    @GetMapping("/hotelRooms")
    public List<HotelRoom> getAllHotelRooms() {
        return hotelRoomRepository.findAll();
    }

    @PostMapping("/hotelRooms")
    public HotelRoom createHotelRoom(@Valid @RequestBody HotelRoom hotelRoom) {
        return hotelRoomRepository.save(hotelRoom);
    }

    @GetMapping("/hotelRooms/{id}")
    public HotelRoom getHotelRoomById(@PathVariable(value = "id") Long hotelRoomId) {
        return hotelRoomRepository.findById(hotelRoomId)
                .orElseThrow(() -> new ResourceNotFoundException("HotelRoom", "id", hotelRoomId));
    }

    @PutMapping("/hotelRooms/{id}")
    public HotelRoom updateHotelRoom(@PathVariable(value = "id") Long hotelRoomId,
                                           @Valid @RequestBody HotelRoom hotelRoomDetails) {

        HotelRoom hotelRoom = hotelRoomRepository.findById(hotelRoomId)
                .orElseThrow(() -> new ResourceNotFoundException("HotelRoom", "id", hotelRoomId));

        /*
        hotelRoom.setTitle(hotelRoomDetails.getTitle());
        hotelRoom.setContent(hotelRoomDetails.getContent());
        */

        HotelRoom updatedHotelRoom = hotelRoomRepository.save(hotelRoom);
        return updatedHotelRoom;
    }

    @DeleteMapping("/hotelRooms/{id}")
    public ResponseEntity<?> deleteHotelRoom(@PathVariable(value = "id") Long hotelRoomId) {
        HotelRoom hotelRoom = hotelRoomRepository.findById(hotelRoomId)
                .orElseThrow(() -> new ResourceNotFoundException("HotelRoom", "id", hotelRoomId));

        hotelRoomRepository.delete(hotelRoom);

        return ResponseEntity.ok().build();
    }
}
