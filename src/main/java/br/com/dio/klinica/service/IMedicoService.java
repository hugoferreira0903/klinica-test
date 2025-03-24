package br.com.dio.klinica.service;

import br.com.dio.klinica.entity.MedicoEntity;

public interface IMedicoService {

    MedicoEntity save(final MedicoEntity entity);

    MedicoEntity update(final MedicoEntity entity);

    void delete(final long id);
}
