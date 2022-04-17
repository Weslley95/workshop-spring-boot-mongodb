package com.weslley.workshopmongo.resources;

import com.weslley.workshopmongo.domain.User;
import com.weslley.workshopmongo.dto.UserDTO;
import com.weslley.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    // @GetMapping or @RequestMapping(method = RequestMethod.GET)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {

        // Instancia metodo da classe UserService
        User obj = this.service.findById(id);

        // .ok() -> instanciar responseEntity
        // .body() -> corpo da mensagem
        // obj convertido para UserDTO
        return ResponseEntity.ok().body(new UserDTO(obj));
    }
}
