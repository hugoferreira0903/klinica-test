package br.com.dio.klinica.repository;

import br.com.dio.klinica.entity.ConsultaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.List;

public interface IConsultaRepository extends JpaRepository<ConsultaEntity, Long> {

    List<ConsultaEntity> findByDataConsultaBetween(final OffsetDateTime startAt, final OffsetDateTime endAt);

}
