package com.example.sinapsis_crud;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Subestacao {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String codigo;
    private String nome;
    private Double latitude;
    private Double longitude;
}
