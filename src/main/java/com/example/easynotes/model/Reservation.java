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
import com.example.easynotes.model.Hotel;
import com.example.easynotes.model.HotelRoom;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "reservation")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservation_id;
    //Long

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "reservationRoomIsUnder")
    private HotelRoom roomReserved;

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account personReserving;

    @NotNull
    private Date whenArriving;

    private int phoneNumber;

    /*
    //Id referencing Car class
    @Id
    private Long carId;

    //Ids referencing Pet class
    @Id
    private Long pet1Id;

    @Id
    private Long pet2Id;

    @Id
    private Long pet3Id;
    */

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

}
