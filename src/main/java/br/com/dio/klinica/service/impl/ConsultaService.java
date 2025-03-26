package br.com.dio.klinica.service.impl;


import br.com.dio.klinica.entity.ConsultaEntity;
import br.com.dio.klinica.repository.IConsultaRepository;
import br.com.dio.klinica.service.IConsultaService;
import br.com.dio.klinica.service.query.IConsultaQueryService;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService implements IConsultaService {

    private final IConsultaRepository repository;
    private final IConsultaQueryService queryService;

    public ConsultaService(IConsultaRepository repository, IConsultaQueryService queryService) {
        this.repository = repository;
        this.queryService = queryService;
    }


    @Override
    public ConsultaEntity save(ConsultaEntity entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(long id) {
        queryService.findById(id);
        repository.deleteById(id);
    }
}
