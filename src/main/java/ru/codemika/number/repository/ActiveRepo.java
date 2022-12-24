package ru.codemika.number.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.codemika.number.model.Active;

import java.util.Optional;

public interface ActiveRepo extends JpaRepository<Active, Integer> {


    Optional<Number> findByUrl(String url);
}
