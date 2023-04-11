package com.example.caproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import javax.persistence.FetchType;

@Entity
@Table(name = "DINING_REVIEWS")
public class DiningReview{

    private enum Status {
        APPROVED, PENDING, DENIED
    };
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBMITTED_BY")
    @Getter
    @Setter
    private User user;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurantId")
    @Getter
    @Setter
    private Restaurant restaurant;

    @Column(name = "STATUS")
    @Enumerated(EnumType.ORDINAL)
    @Getter
    @Setter
    private Status status;

    @Column(name = "PEANUT_SCORE")
    @Getter
    @Setter
    private int peanutScore;

    @Column(name = "EGG_SCORE")
    @Getter
    @Setter
    private int eggScore;

    @Column(name = "DAIRY_SCORE")
    @Getter
    @Setter
    private int dairyScore;

    @Column(name = "COMMENTARY")
    @Getter
    @Setter
    private String commentary;

}

