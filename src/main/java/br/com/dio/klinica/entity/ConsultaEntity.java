package br.com.dio.klinica.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "CONSULTAS")
public class ConsultaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(nullable = false, length = 150)
    private String atendimento;

    @Column(nullable = false, name = "data_consulta")
    private OffsetDateTime dataConsulta;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private ClientEntity cliente = new ClientEntity();

    @ManyToOne
    @JoinColumn(name = "id_medico")
    private MedicoEntity medico = new MedicoEntity();

    public MedicoEntity getMedico() {
        return medico;
    }

    public void setMedico(MedicoEntity medico) {
        this.medico = medico;
    }

    public ClientEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClientEntity cliente) {
        this.cliente = cliente;
    }


    public OffsetDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(OffsetDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }


    public String getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(String atendimento) {
        this.atendimento = atendimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsultaEntity that = (ConsultaEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(preco, that.preco) && Objects.equals(atendimento, that.atendimento) && Objects.equals(dataConsulta, that.dataConsulta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, preco, atendimento, dataConsulta);
    }

    @Override
    public String toString() {
        return "ConsultaEntity{" +
                "id=" + id +
                ", preco=" + preco +
                ", atendimento='" + atendimento + '\'' +
                ", dataConsulta=" + dataConsulta +
                '}';
    }
}