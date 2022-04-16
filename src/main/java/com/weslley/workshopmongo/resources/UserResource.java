package com.weslley.workshopmongo.resources;

import com.weslley.workshopmongo.domain.User;
import com.weslley.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResponseEntity<List<User>> findAll() {

        // lista de usuarios, busca todo os usuarios no bd (service.findAll()) e add a list
        List<User> list = service.findAll();

        // .ok() -> instanciar responseEntity
        // .body() -> corpo da mensagem
        return ResponseEntity.ok().body(list);
    }


}
