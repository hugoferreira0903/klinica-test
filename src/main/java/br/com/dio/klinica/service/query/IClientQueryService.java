package br.com.dio.klinica.service.query;

import br.com.dio.klinica.entity.ClientEntity;

import java.util.List;

public interface IClientQueryService {

    ClientEntity findById(final long id);

    List<ClientEntity> list();

    void verifyCpf(final String cpf);

    void verifyCpf(final long id,final String cpf);

    void verifyEmail(final String email);

    void verifyEmail(final long id,final String email);

}
