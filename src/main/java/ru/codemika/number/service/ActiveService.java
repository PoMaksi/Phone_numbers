package ru.codemika.number.service;

import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.codemika.number.model.Active;
import ru.codemika.number.repository.ActiveRepo;
import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor


public class ActiveService {


    private final ActiveRepo repo;

    public String goToUrl(String url) {
        Active active = repo.findByUrl(url).orElse(null);
        if (active == null) return "error";
        if (active.getAct() != null) return "go out";

        active.setAct(LocalDateTime.now());
        return repo.save(active).toString().getReal();

    }
}