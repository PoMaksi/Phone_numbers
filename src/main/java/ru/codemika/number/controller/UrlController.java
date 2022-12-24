package ru.codemika.number.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.codemika.number.service.UrlService;

@RestController
@RequestMapping("/api/url")
@RequiredArgsConstructor


public class UrlController {
    private final UrlService service;



    @GetMapping("{url}")
    public String goToURL(@PathVariable String url){return service.goToUrl(url);
    }


}
