package ru.codemika.number.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "urls")
@Getter
@Setter
@RequiredArgsConstructor

public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Number number;
    @OneToOne
    private Number url;
    @ManyToOne
    private Address RealUrl;
    private String Act;
}
