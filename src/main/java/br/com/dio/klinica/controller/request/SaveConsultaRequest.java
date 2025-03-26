package br.com.dio.klinica.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record SaveConsultaRequest(

        @NotNull
        @JsonProperty("preco")
        BigDecimal preco,
        @NotNull
        @JsonProperty("atendimento")
        String atendimento,
        @NotNull
        @JsonProperty("dataConsulta")
        OffsetDateTime dataConsulta,
        @NotNull
        @JsonProperty("clientId")
        Long clientId,
        @NotNull
        @JsonProperty("medicoId")
        Long medicoId

) {
}
