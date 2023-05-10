package br.ueg.prog.webi.api.controller;

import br.ueg.prog.webi.api.mapper.BaseMapper;
import br.ueg.prog.webi.api.model.IEntidade;
import br.ueg.prog.webi.api.service.CrudService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class CrudController<
        ENTIDADE extends IEntidade<PK_TYPE>,
        DTO,
        PK_TYPE,
        MAPPER extends BaseMapper<ENTIDADE, DTO>,
        SERVICE extends CrudService<ENTIDADE, PK_TYPE>
        > {

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    protected MAPPER mapper;

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    protected SERVICE service;

    @GetMapping()
    @Operation(description = "Listagem Geral")
    public List<DTO> listAll(){
        List<ENTIDADE> modelo = service.listarTodos();
        return mapper.toDTO(modelo);
    }

    @PostMapping
    @Operation(description = "Método utilizado para realizar a inclusão de um entidade")
    public DTO incluir(@RequestBody DTO modeloDTO){
        //prepração para entrada.
        ENTIDADE modeloIncluir = this.mapper.toModelo(modeloDTO);
        modeloIncluir.setId(null);
        //chamada do serviço
        System.out.println(modeloIncluir);
        modeloIncluir = this.service.incluir(modeloIncluir);

        //preparação para o retorno
        return this.mapper.toDTO(modeloIncluir);
    }

    @PutMapping(path = "/{id}")
    @Operation(description = "Método utilizado para altlerar os dados de uma entidiade")
    public DTO alterar(@RequestBody() DTO modeloDTO, @PathVariable(name = "id") PK_TYPE id
    ){
        ENTIDADE pModelo = mapper.toModelo(modeloDTO);
        ENTIDADE alterar = service.alterar(pModelo, id);
        return mapper.toDTO(alterar);
    }
    @DeleteMapping(path ="/{id}")
    @Operation(description = "Método utilizado para remover uma entidiade pela id informado")
    public DTO remover(@PathVariable(name = "id") PK_TYPE id){
        ENTIDADE modeloExcluido = this.service.excluir(id);
        return mapper.toDTO(modeloExcluido);
    }

    @GetMapping(path = "/{id}")
    @Operation(description = "Obter os dados completos de uma entidiade pelo id informado!")
    public DTO ObterPorId(@PathVariable(name = "id") PK_TYPE id){
        ENTIDADE entidade = this.service.obterPeloId(id);
        return this.mapper.toDTO(entidade);
    }

}
