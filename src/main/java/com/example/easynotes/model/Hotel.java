package com.example.easynotes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "hotel")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id")
    private Account ownerAccount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
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

    @NotBlank
    private int[] rooms;

    @NotBlank
    private int[] roomPrices;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

}
