package com.example.easynotes.repository;

import com.example.easynotes.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Note, Long> {

}