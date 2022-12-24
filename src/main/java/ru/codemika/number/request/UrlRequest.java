package ru.codemika.number.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;


@Validated
@Getter
@Setter
public class UrlRequest {

    @NotBlank
    private String number;

    @NotBlank
    private String act;
}
