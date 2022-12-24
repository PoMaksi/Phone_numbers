package ru.codemika.number.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Active")
@Getter
@Setter
@RequiredArgsConstructor

public class Active {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne (mappedBy = "active", cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
    })
    private Number number;
    @OneToOne
    private Number url;
    @ManyToOne
    private Address RealUrl;
    private String Act;
}
