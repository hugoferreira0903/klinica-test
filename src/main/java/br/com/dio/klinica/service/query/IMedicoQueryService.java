package br.com.dio.klinica.service.query;


import br.com.dio.klinica.entity.MedicoEntity;

import java.util.List;

public interface IMedicoQueryService {

    MedicoEntity findById(final long id);

    List<MedicoEntity> list();

    void verifyCpf(final String cpf);

    void verifyCpf(final long id,final String cpf);

    void verifyEmail(final String email);

    void verifyEmail(final long id,final String email);
}
