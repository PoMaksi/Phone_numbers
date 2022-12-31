package ru.codemika.number.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.bytebuddy.utility.RandomString;

import javax.persistence.*;

@Entity
@Table(name = "Number")
@Getter
@Setter
@RequiredArgsConstructor

public class Number {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private String number;
    @OneToOne
    private RandomString url;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "activated_id")
    private Active active;

    public int hashCode() {
        return getClass().hashCode();
    }
}

