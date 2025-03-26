package br.com.dio.klinica.service.query.impl;


import br.com.dio.klinica.entity.ConsultaEntity;
import br.com.dio.klinica.exception.NotFoundException;
import br.com.dio.klinica.repository.IConsultaRepository;
import br.com.dio.klinica.service.query.IConsultaQueryService;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public class ConsultaQueryService implements IConsultaQueryService {

    private final IConsultaRepository repository;

    public ConsultaQueryService(IConsultaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ConsultaEntity findById(long id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException("Agendamento não encontrado")
        );
    }

    @Override
    public List<ConsultaEntity> findInMonth(OffsetDateTime startOfMonth, OffsetDateTime endOfMonth) {
        return repository.findByDataConsultaBetween(startOfMonth, endOfMonth);
    }

    @Override
    public List<ConsultaEntity> list() {
        return repository.findAll();
    }


}
