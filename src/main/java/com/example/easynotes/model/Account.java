package com.example.easynotes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

import com.example.easynotes.model.Hotel;
import com.example.easynotes.model.HotelRoom;
import com.example.easynotes.model.Reservation;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "account")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Hotel> hotels;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Reservation> reservations;
    */

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @org.hibernate.annotations.Type(type="true_false")
    @NotNull
    boolean owner;

    @NotBlank
    private String firstName;

    private String middleName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String address;

    private String addressPart2;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotNull
    private int zip;

    private int zipPlus4;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

}
