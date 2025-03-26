package br.com.dio.klinica.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record ClientMedicoConsultaAppointmentResponse(

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
