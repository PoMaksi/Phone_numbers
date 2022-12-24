package ru.codemika.number.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;


import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;


@Validated
@Getter
@Setter
public class NumberRequest {
    @NotBlank
    @Size(min = 7, max = 12)
    private String number;

    @NotBlank
    private String  url;
}
