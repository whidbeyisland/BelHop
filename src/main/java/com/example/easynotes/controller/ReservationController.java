package com.example.easyReservations.controller;

import com.example.easyReservations.exception.ResourceNotFoundException;
import com.example.easyReservations.model.Reservation;
import com.example.easyReservations.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    ReservationRepository ReservationRepository;

    @GetMapping("/Reservations")
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @PostMapping("/Reservations")
    public Reservation createReservation(@Valid @RequestBody Reservation Reservation) {
        return reservationRepository.save(Reservation);
    }

    @GetMapping("/Reservations/{id}")
    public Reservation getReservationById(@PathVariable(value = "id") Long ReservationId) {
        return ReservationRepository.findById(ReservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation", "id", ReservationId));
    }

    @PutMapping("/Reservations/{id}")
    public Reservation updateReservation(@PathVariable(value = "id") Long ReservationId,
                                           @Valid @RequestBody Reservation ReservationDetails) {

        Reservation Reservation = ReservationRepository.findById(ReservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation", "id", ReservationId));

        Reservation.setTitle(ReservationDetails.getTitle());
        Reservation.setContent(ReservationDetails.getContent());

        Reservation updatedReservation = ReservationRepository.save(Reservation);
        return updatedReservation;
    }

    @DeleteMapping("/Reservations/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable(value = "id") Long ReservationId) {
        Reservation Reservation = ReservationRepository.findById(ReservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation", "id", ReservationId));

        ReservationRepository.delete(Reservation);

        return ResponseEntity.ok().build();
    }
}
