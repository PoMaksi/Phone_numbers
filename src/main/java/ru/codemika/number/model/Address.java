package ru.codemika.number.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.codemika.number.repository.AddressRepo;
import javax.persistence.*;


@Entity
@Table(name = "Address")
@Getter
@Setter
@RequiredArgsConstructor

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private String RealUrl = "https://yes";
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="address")
    private Active Real;
    @OneToMany

    private final AddressRepo repo;
}

