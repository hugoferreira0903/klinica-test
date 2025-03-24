package br.com.dio.klinica.repository;
import br.com.dio.klinica.entity.MedicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IMedicoRepository extends JpaRepository<MedicoEntity, Long> {

    boolean existsByCpf(String cpf);

    boolean existsByEmail(final String email);

    Optional<MedicoEntity> findByEmail(final String phone);

    Optional<MedicoEntity> findByCpf(final String cpf);
}
