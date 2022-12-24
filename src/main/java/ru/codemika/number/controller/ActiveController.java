package ru.codemika.number.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.codemika.number.service.ActiveService;

@RestController
@RequestMapping("/api/url")
@RequiredArgsConstructor


public class ActiveController {
    private final ActiveService service;
    @GetMapping("{url}")
    public String goToURL(@PathVariable String url){return service.goToUrl(url);
    }
}
