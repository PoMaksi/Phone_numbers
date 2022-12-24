package ru.codemika.number.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.codemika.number.request.NumberRequest;
import ru.codemika.number.controller.response.NumberResponse;
import ru.codemika.number.model.Number;
import ru.codemika.number.service.NumberService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/numbers")
@RequiredArgsConstructor


public class NumberController {
    private final NumberService service;

    @PostMapping
    public Number create(@Valid @RequestBody NumberRequest numberRequest) {
        return service.create(numberRequest);
    }

    @GetMapping
    public List<Number> list(){
        return service.getList();
    }


    @GetMapping("search")
    public NumberResponse getNumberByNumberOrUrl(@RequestBody NumberSearchRequest  numberSearchRequest) {
        String text = numberSearchRequest.getText();
        return new NumberResponse(
                text,
                service.getNumberByNumberOrUrl(text, text));
    }

//    @GetMapping("{url}")
//    public String goToURL(@PathVariable String url){
//        return service.goToURL(url);
//    }


//    @PutMapping
//    public Number active(Principal principal, @RequestBody Number url){
//        return service.active(principal, url);
//    }
//TODO//

//    public static class NumberResponse {
//        String search;
//        List<Number> number;
//
//        public NumberResponse(String search, List<Number> number){
//            this.search = search;
//            this.number = number;
//        }
//    }
    public static class NumberSearchRequest {
        String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }


}
