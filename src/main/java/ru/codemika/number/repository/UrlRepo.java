package ru.codemika.number.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.codemika.number.model.Url;

import java.util.Optional;

public interface UrlRepo extends JpaRepository<Url,  Url> {


    Optional<Number> findByUrl(String url);
}
