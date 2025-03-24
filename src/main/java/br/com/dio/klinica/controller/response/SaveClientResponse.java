package br.com.dio.klinica.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SaveClientResponse(

        @JsonProperty("id")
        Long id,
        @JsonProperty("name")
        String name,
        @JsonProperty("cpf")
        String cpf,
        @JsonProperty("phone")
        String phone,
        @JsonProperty("email")
        String email

) {
}
