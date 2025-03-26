package br.com.dio.klinica.service;

import br.com.dio.klinica.entity.ConsultaEntity;

public interface IConsultaService {

    ConsultaEntity save(final ConsultaEntity entity);

    void delete(final long id);

}
