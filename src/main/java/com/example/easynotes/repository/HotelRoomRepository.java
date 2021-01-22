package com.example.easynotes.repository;

import com.example.easynotes.model.HotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<HotelRoom, Long> {

}
