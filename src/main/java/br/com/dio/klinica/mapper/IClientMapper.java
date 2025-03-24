package br.com.dio.klinica.mapper;

import br.com.dio.klinica.controller.request.SaveClientRequest;
import br.com.dio.klinica.controller.request.UpdateMedicoRequest;
import br.com.dio.klinica.controller.response.ClientDetailResponse;
import br.com.dio.klinica.controller.response.ListClientResponse;
import br.com.dio.klinica.controller.response.SaveClientResponse;
import br.com.dio.klinica.controller.response.UpdateClientResponse;
import br.com.dio.klinica.entity.ClientEntity;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IClientMapper {

    ClientEntity toEntity(final SaveClientRequest request);

    SaveClientResponse toSaveResponse(final ClientEntity entity);

    ClientEntity toEntity(final long id, final @Valid UpdateMedicoRequest request);

    UpdateClientResponse toUpdateResponse(final ClientEntity entity);

    ClientDetailResponse toDetailResponse(final ClientEntity entity);

    List<ListClientResponse> toListResponse(final List<ClientEntity> entities);

}
