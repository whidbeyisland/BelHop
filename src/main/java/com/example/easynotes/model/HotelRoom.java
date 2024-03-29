package com.example.easynotes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
import com.example.easynotes.model.Reservation;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "hotelroom")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"/*, "roomsInHotel", "roomReserved", "hotelLocatedIn", "reservationRoomIsUnder"*/},
        allowGetters = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "hotelRoom_id")
public class HotelRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotelRoom_id;

    /*
    @JsonManagedReference
    */
    @ManyToOne
    @JoinColumn(name="hotel_id")
    private Hotel hotelLocatedIn;

    //@ManyToOne
    /*
    @JsonManagedReference
    */
    @OneToOne
    @JoinColumn(name="reservation_id")
    private Reservation reservationRoomIsUnder;

    @NotNull
    private int roomNumber;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

}
