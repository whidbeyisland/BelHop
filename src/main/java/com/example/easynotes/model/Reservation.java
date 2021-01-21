package com.example.easynotes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "reservation")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "id")
    private HotelRoom roomReserved;

    @ManyToOne
    @JoinColumn(name="id")
    private Account personReserving;

    @NotBlank
    private Date whenArriving;

    //Id referencing Hotel class
    @Id
    private Long hotelId;

    @NotBlank
    private int roomNumber;

    private int phoneNumber;

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

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

}
