package br.com.dio.klinica.controller;


import br.com.dio.klinica.controller.request.SaveConsultaRequest;
import br.com.dio.klinica.controller.response.ConsultaAppointmentMonthResponse;
import br.com.dio.klinica.controller.response.ListConsultaResponse;
import br.com.dio.klinica.controller.response.SaveConsultaResponse;
import br.com.dio.klinica.mapper.IConsultaMapper;
import br.com.dio.klinica.service.IConsultaService;
import br.com.dio.klinica.service.query.IConsultaQueryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.util.List;

import static java.time.ZoneOffset.UTC;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    private final IConsultaService service;
    private final IConsultaQueryService queryService;
    private final IConsultaMapper mapper;

    public ConsultaController(IConsultaService service, IConsultaQueryService queryService, IConsultaMapper mapper) {
        this.service = service;
        this.queryService = queryService;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    SaveConsultaResponse save(@RequestBody @Valid SaveConsultaRequest request){
        var entity = mapper.toEntity(request);
        service.save(entity);
        return mapper.toSaveResponse(entity);
    }


    @GetMapping("{year}/{month}")
    ConsultaAppointmentMonthResponse listMonth(@PathVariable final int year, @PathVariable final int month){
        var yearMonth = YearMonth.of(year, month);
        var startOfMonth = yearMonth.atDay(1).atTime(0, 0, 0, 0).atOffset(UTC);
        var endOfMonth = yearMonth.atEndOfMonth().atTime(23, 59, 59, 999999999).atOffset(UTC);
        var entities = queryService.findInMonth(startOfMonth, endOfMonth);
        return mapper.toMonthResponse(year, month, entities);
    }

    @GetMapping
    List<ListConsultaResponse> toList(){
        var entities = queryService.list();
        return mapper.toListResponse(entities);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("consulta deletado com sucesso!");
    }

}
