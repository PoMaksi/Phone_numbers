package ru.codemika.number.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.codemika.number.repository.AddressRepo;

import javax.persistence.*;
import java.util.Set;


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
    private String RealUrl;
    private Set<Active> actives;
    @OneToMany

    private final AddressRepo repo;

    public Address create(Address address) {
    address.setRealUrl("https://yes");
        return repo.save(address);
    }
}

