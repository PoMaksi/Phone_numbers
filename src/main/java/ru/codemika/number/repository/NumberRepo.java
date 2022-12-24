package ru.codemika.number.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.codemika.number.model.Number;


import java.util.List;

public interface NumberRepo extends JpaRepository<Number,  Number> {
    List<Number> findAllByNumberOrUrl(String number, String url);
}
