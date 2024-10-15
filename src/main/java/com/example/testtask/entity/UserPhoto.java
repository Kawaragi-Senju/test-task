package com.example.testtask.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_photos", schema = "user_service")
public class UserPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "UserId")
    private Integer userId;
    @Column(name = "photoPath")
    private String photoPath;
}
