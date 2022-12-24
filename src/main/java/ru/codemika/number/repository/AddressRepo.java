package ru.codemika.number.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.codemika.number.model.Address;

public interface AddressRepo extends JpaRepository<Address, Address> {

}
