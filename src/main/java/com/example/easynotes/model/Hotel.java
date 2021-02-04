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

import com.example.easynotes.model.Account;
import com.example.easynotes.model.HotelRoom;
import com.example.easynotes.model.Reservation;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "hotel")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotel_id;
    //Long

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account ownerAccount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hotelLocatedIn")
    private List<HotelRoom> rooms;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotBlank
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
