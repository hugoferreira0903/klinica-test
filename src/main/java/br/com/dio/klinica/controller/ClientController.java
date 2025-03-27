package br.com.dio.klinica.controller;


import br.com.dio.klinica.controller.request.SaveClientRequest;
import br.com.dio.klinica.controller.request.UpdateClientRequest;
import br.com.dio.klinica.controller.request.UpdateMedicoRequest;
import br.com.dio.klinica.controller.response.ClientDetailResponse;
import br.com.dio.klinica.controller.response.ListClientResponse;
import br.com.dio.klinica.controller.response.SaveClientResponse;
import br.com.dio.klinica.controller.response.UpdateClientResponse;
import br.com.dio.klinica.mapper.IClientMapper;
import br.com.dio.klinica.service.IClientService;
import br.com.dio.klinica.service.query.IClientQueryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("clients")
public class ClientController {

    private final IClientService service;
    private final IClientQueryService queryService;
    private final IClientMapper mapper;

    public ClientController(IClientService service, IClientQueryService queryService, IClientMapper mapper) {
        this.service = service;
        this.queryService = queryService;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    SaveClientResponse save(@RequestBody @Valid final SaveClientRequest request){

        var entity = mapper.toEntity(request);
        service.save(entity);
        return mapper.toSaveResponse(entity);
    }

    @PutMapping("{id}")
    UpdateClientResponse update(@PathVariable final long id, @RequestBody @Valid final UpdateClientRequest request){
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
    ClientDetailResponse findById(@PathVariable final long id){
        var entity = queryService.findById(id);
        return mapper.toDetailResponse(entity);
    }


    @GetMapping
    List<ListClientResponse> list(){
        var entities = queryService.list();
        return mapper.toListResponse(entities);
    }

}
