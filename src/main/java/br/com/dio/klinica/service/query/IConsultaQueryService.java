package br.com.dio.klinica.service.query;


import br.com.dio.klinica.entity.ConsultaEntity;

import java.time.OffsetDateTime;
import java.util.List;

public interface IConsultaQueryService {

    ConsultaEntity findById(final long id);

    List<ConsultaEntity> findInMonth(final OffsetDateTime startOfMonth, final OffsetDateTime endOfMonth);

    List<ConsultaEntity> list();

}
