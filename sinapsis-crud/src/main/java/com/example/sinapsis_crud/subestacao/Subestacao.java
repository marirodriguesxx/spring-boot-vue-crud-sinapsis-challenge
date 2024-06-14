package com.example.sinapsis_crud.subestacao;

import com.example.sinapsis_crud.rede.Rede;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="TB_SUBESTACAO")
@Setter
@Getter
public class Subestacao {
    @Id
    @Column(name="subestacao_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name="codigo", nullable=false, length=100)
    private String codigo;

    @Column(name="nome", nullable=false, length=100)
    private String nome;

    @Column(name="latitude")
    private Double latitude;

    @Column(name="longitude")
    private Double longitude;

//    @ManyToOne
//    @JoinColumn(name = "subestacao_id")
//    List<Rede> redes;
}
