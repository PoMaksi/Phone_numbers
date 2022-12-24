package ru.codemika.number.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.bytebuddy.utility.RandomString;

import javax.persistence.*;
import java.util.Set;


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

//    @OneToOne (mappedBy = "number")
//    @OneToOne (mappedBy = "url")



    public int hashCode() {
        return getClass().hashCode();
    }


}

