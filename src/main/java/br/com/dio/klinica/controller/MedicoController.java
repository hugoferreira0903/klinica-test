package br.com.dio.klinica.controller;


import br.com.dio.klinica.controller.request.SaveMedicoRequest;
import br.com.dio.klinica.controller.request.UpdateMedicoRequest;
import br.com.dio.klinica.controller.response.ListMedicoResponse;
import br.com.dio.klinica.controller.response.MedicoDetailResponse;
import br.com.dio.klinica.controller.response.SaveMedicoResponse;
import br.com.dio.klinica.controller.response.UpdateMedicoResponse;
import br.com.dio.klinica.mapper.IMedicoMapper;
import br.com.dio.klinica.service.IMedicoService;
import br.com.dio.klinica.service.query.IMedicoQueryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    private final IMedicoService service;
    private final IMedicoQueryService queryService;
    private final IMedicoMapper mapper;

    public MedicoController(IMedicoService service, IMedicoQueryService queryService, IMedicoMapper mapper) {
        this.service = service;
        this.queryService = queryService;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    SaveMedicoResponse save(@RequestBody @Valid SaveMedicoRequest request){

        var entity = mapper.toEntity(request);
        service.save(entity);
        return mapper.toSaveResponse(entity);
    }

    @PutMapping("{id}")
    UpdateMedicoResponse update(@PathVariable final long id, @RequestBody @Valid final UpdateMedicoRequest request){
        var entity = mapper.toEntity(id, request);
        service.update(entity);
        return mapper.toUpdateResponse(entity);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    ResponseEntity<String> delete(@PathVariable final long id){
        service.delete(id);
        return ResponseEntity.ok("usuario deletado com sucesso!");
    }

    @GetMapping("{id}")
    MedicoDetailResponse findById(@PathVariable final long id){
        var entity = queryService.findById(id);
        return mapper.toDetailResponse(entity);
    }

    @GetMapping
    List<ListMedicoResponse> list(){
        var entities = queryService.list();
        return mapper.toListResponse(entities);
    }

}
