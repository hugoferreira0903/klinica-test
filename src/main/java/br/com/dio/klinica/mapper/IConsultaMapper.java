package br.com.dio.klinica.mapper;

import br.com.dio.klinica.controller.request.SaveConsultaRequest;
import br.com.dio.klinica.controller.response.ClientMedicoConsultaAppointmentResponse;
import br.com.dio.klinica.controller.response.ConsultaAppointmentMonthResponse;
import br.com.dio.klinica.controller.response.ListConsultaResponse;
import br.com.dio.klinica.controller.response.SaveConsultaResponse;
import br.com.dio.klinica.entity.ConsultaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IConsultaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cliente.id", source = "clientId")
    @Mapping(target = "medico.id", source = "medicoId")
    ConsultaEntity toEntity(final SaveConsultaRequest request);

    @Mapping(target = "clientId", source = "cliente.id")
    @Mapping(target = "medicoId", source = "medico.id")
    SaveConsultaResponse toSaveResponse(final ConsultaEntity entity);

    @Mapping(target = "consultaAppointment", expression = "java(toClientMedicoMonthResponse(entities))")
    ConsultaAppointmentMonthResponse toMonthResponse(final int year, final int month, final List<ConsultaEntity> entities);

    List<ClientMedicoConsultaAppointmentResponse> toClientMedicoMonthResponse(final List<ConsultaEntity> entities);

    @Mapping(target = "clientId", source = "cliente.id")
    @Mapping(target = "clientName", source = "cliente.name")
    @Mapping(target = "medicoId", source = "medico.id")
    @Mapping(target = "medicoName", source = "medico.name")
    @Mapping(target = "day", expression = "java(entity.getDataConsulta().getDayOfMonth())")
    ClientMedicoConsultaAppointmentResponse toClientMedicoMonthResponse(final ConsultaEntity entity);

    List<ListConsultaResponse> toListResponse(List<ConsultaEntity> entities);
}
