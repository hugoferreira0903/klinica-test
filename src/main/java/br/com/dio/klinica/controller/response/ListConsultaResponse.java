package br.com.dio.klinica.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.OffsetDateTime;


@JsonInclude(JsonInclude.Include.NON_NULL)
public record ListConsultaResponse(

        @JsonProperty("id")
        Long id,
        @JsonProperty("day")
        Integer day,
        @JsonProperty("preco")
        BigDecimal preco,
        @JsonProperty("atendimento")
        String atendimento,
        @JsonProperty("dataConsulta")
        OffsetDateTime dataConsulta,
        @JsonProperty("clientId")
        Long clientId,
        @JsonProperty("clientName")
        String clientName,
        @JsonProperty("medicoId")
        Long medicoId,
        @JsonProperty("medicoName")
        String medicoName

) {
}
