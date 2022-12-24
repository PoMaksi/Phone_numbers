package ru.codemika.number.service;


import lombok.RequiredArgsConstructor;

import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;
import ru.codemika.number.request.NumberRequest;
import ru.codemika.number.model.Number;
import ru.codemika.number.repository.NumberRepo;

import java.util.List;


@Service
@RequiredArgsConstructor


public class NumberService {

    private final NumberRepo repo;

    public Number create(NumberRequest numberRequest) {
        Number number = new Number();
        number.setNumber(numberRequest.getNumber());
        number.setUrl(new RandomString());
        return repo.save(number);
    }



    public List<Number> getList(){
        return repo.findAll();
    }

    public List<Number> getNumberByNumberOrUrl(String number, String url){
        return repo.findAllByNumberOrUrl(number, url);
    }

}