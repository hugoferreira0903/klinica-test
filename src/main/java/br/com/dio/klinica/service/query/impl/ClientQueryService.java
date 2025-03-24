package br.com.dio.klinica.service.query.impl;


import br.com.dio.klinica.entity.ClientEntity;
import br.com.dio.klinica.exception.CpfInUseException;
import br.com.dio.klinica.exception.EmailInUseException;
import br.com.dio.klinica.exception.NotFoundException;
import br.com.dio.klinica.repository.IClientRepository;
import br.com.dio.klinica.service.query.IClientQueryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClientQueryService implements IClientQueryService {

    private final IClientRepository repository;

    public ClientQueryService(IClientRepository repository) {
        this.repository = repository;
    }


    @Override
    public ClientEntity findById(long id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException("Não foi encontrado o cliente de id " + id));
    }

    @Override
    public List<ClientEntity> list() {
        return repository.findAll();
    }

    @Override
    public void verifyCpf(String cpf) {
        if(repository.existsByCpf(cpf)){
            var message = "O cpf " + cpf + " já está em uso";
            throw new CpfInUseException(message);
        }

    }

    @Override
    public void verifyCpf(long id, String cpf) {
        var optional = repository.findByCpf(cpf);
        if(optional.isPresent() && !Objects.equals(optional.get().getCpf(), cpf)){
            var message = "O cpf " + cpf + " já está em uso";
            throw new CpfInUseException(message);
        }
    }

    @Override
    public void verifyEmail(String email) {
        if (repository.existsByEmail(email)) {
            var message = "O e-mail " + email + " já está em uso";
            throw new EmailInUseException(message);
        }
    }

    @Override
    public void verifyEmail(long id, String email) {
        var optional = repository.findByEmail(email);
        if (optional.isPresent() && !Objects.equals(optional.get().getEmail(), email)) {
            var message = "O e-mail " + email + " já está em uso";
            throw new EmailInUseException(message);
        }
    }
}
