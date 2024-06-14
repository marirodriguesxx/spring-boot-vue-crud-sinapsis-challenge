package com.example.sinapsis_crud.rede;

import com.example.sinapsis_crud.subestacao.Subestacao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="TB_REDE_MT")
@Setter
@Getter
public class Rede {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
//
    @ManyToOne
    @JoinColumn(name = "subestacao_id")
    private Subestacao subestacao;

    @Column(name="codigo", nullable=false, length=100)
    private String codigo;

    @Column(name="nome", nullable=false, length=100)
    private String nome;

    @Column(name="tensao_nominal")
    private Double tensaoNominal;
}
