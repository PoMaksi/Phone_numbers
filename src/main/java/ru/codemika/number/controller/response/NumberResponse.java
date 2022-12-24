package ru.codemika.number.controller.response;

import lombok.Getter;
import lombok.Setter;
import ru.codemika.number.model.Number;

import java.util.List;

@Getter
@Setter
public class NumberResponse {
    String search;
    List<Number> numbers;


    public NumberResponse(String search, List<Number> numbers) {
        this.search = search;
        this.numbers = numbers;
    }
}
