package br.com.dio.klinica.mapper;


import br.com.dio.klinica.controller.request.SaveMedicoRequest;
import br.com.dio.klinica.controller.request.UpdateMedicoRequest;
import br.com.dio.klinica.controller.response.ListMedicoResponse;
import br.com.dio.klinica.controller.response.MedicoDetailResponse;
import br.com.dio.klinica.controller.response.SaveMedicoResponse;
import br.com.dio.klinica.controller.response.UpdateMedicoResponse;
import br.com.dio.klinica.entity.MedicoEntity;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IMedicoMapper {

    MedicoEntity toEntity(final SaveMedicoRequest request);

    SaveMedicoResponse toSaveResponse(final MedicoEntity entity);

    MedicoEntity toEntity(final long id, final @Valid UpdateMedicoRequest request);

    UpdateMedicoResponse toUpdateResponse(final MedicoEntity entity);

    MedicoDetailResponse toDetailResponse(final MedicoEntity entity);

    List<ListMedicoResponse> toListResponse(final List<MedicoEntity> entities);

}
