package com.example.testtask.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_details", schema = "user_service")
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "UserId")
    private Integer userId;
    @Column(name = "address")
    private String address;
    @Column(name = "additionalInfo")
    private String additionalInfo;
}
