package com.weslley.workshopmongo.resources;

import com.weslley.workshopmongo.domain.User;
import com.weslley.workshopmongo.dto.UserDTO;
import com.weslley.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    // Injetar servico
    @Autowired
    private UserService service;

    /**
     * Retornar lista de usuarios
     * End point
     *
     * ResponseEntity -> Retornar objeto sofisticado, encapsular e retornar respostas HTTP, com cabecalhos, erros, etc
     *
     * @return list
     */
    // @GetMapping or @RequestMapping(method = RequestMethod.GET)
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        // lista de usuarios, busca todo os usuarios no bd (service.findAll()) e add a list
        List<User> list = this.service.findAll();

        // Converter para uma lista DTO, utilizando expressao lambda
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

        // .ok() -> instanciar responseEntity
        // .body() -> corpo da mensagem
        return ResponseEntity.ok().body(listDto);
    }

    /**
     * Retornar usuario por id
     * End point
     *
     * ResponseEntity -> Retornar objeto sofisticado, encapsular e retornar respostas HTTP, com cabecalhos, erros, etc
     *
     * @return obj
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {

        // Instancia metodo da classe UserService
        User obj = this.service.findById(id);

        // .ok() -> instanciar responseEntity
        // .body() -> corpo da mensagem
        // obj convertido para UserDTO
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    /**
     * Inserir usuario
     * End point
     *
     * ResponseEntity -> Retornar objeto sofisticado, encapsular e retornar respostas HTTP, com cabecalhos, erros, etc
     *
     * @return uri
     */
    // @RequestMapping(method = RequestMethod.POST) or @PostMapping
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {

        // Converter objDto para usuario
        User obj = this.service.fromDTO(objDto);

        obj = this.service.insert(obj);

        // Retornar URL com novo recurco criado, uri pegar o endereco do novo objeto inserido
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();

        // created() -> retorna 201
        return ResponseEntity.created(uri).build();
    }

    /**
     * Deleter usuario
     * End point
     *
     * ResponseEntity -> Retornar objeto sofisticado, encapsular e retornar respostas HTTP, com cabecalhos, erros, etc
     *
     * @return noContent() -> 204
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {

        // Instancia metodo da classe UserService
        this.service.delete(id);

        // noContent() -> Resposta com 204, realizar uma operacao e nao retornar nada
        return ResponseEntity.noContent().build();
    }

    /**
     * Update usuario
     * End point
     *
     * ResponseEntity -> Retornar objeto sofisticado, encapsular e retornar respostas HTTP, com cabecalhos, erros, etc
     *
     * @return noContent() -> 204
     */
    //
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {

        // Converter objDto para usuario
        User obj = this.service.fromDTO(objDto);

        // Id da requisicao
        obj.setId(id);
        obj = this.service.update(obj);

        // created() -> retorna 201
        return ResponseEntity.noContent().build();
    }
}
