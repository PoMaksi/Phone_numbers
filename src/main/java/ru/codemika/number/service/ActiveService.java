package ru.codemika.number.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.codemika.number.model.Active;
import ru.codemika.number.repository.ActiveRepo;
import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor


public class ActiveService {


    private final ActiveRepo repo;

    public Object goToUrl(String url) {
        Active active = repo.findByUrl(url).orElse(null);
        if (active == null) return "error";

        active.setAct(LocalDateTime.now());
        return repo.save(active).getAddress();
    }
}