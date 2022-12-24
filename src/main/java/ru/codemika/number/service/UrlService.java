package ru.codemika.number.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.codemika.number.model.Url;
import ru.codemika.number.repository.UrlRepo;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor


public class UrlService {


    private final UrlRepo repo;

    public String goToUrl(String url) {
        Url url = repo.findByUrl(url).orElse(null);
        if (url == null) return "error";
        if (url.getAct() != null) return "go out";

        url.setAct(LocalDateTime.now());
        return repo.save(url).getRealUrl();
    }

}