package com.example.easynotes.repository;

import com.example.easynotes.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Note, Long> {

}
