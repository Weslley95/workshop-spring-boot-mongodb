package com.weslley.workshopmongo.resources;

import com.weslley.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

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
        var maria = new User("1", "Maria Silva", "mariasival@gmail.com");
        var alex = new User("2", "Alex Silva", "alexsival@gmail.com");

        // lista de usuarios
        List<User> list = new ArrayList<User>();
        list.addAll(Arrays.asList(maria, alex));

        // .ok() -> instanciar responseEntity
        // .body() -> corpo da mensagem
        return ResponseEntity.ok().body(list);
    }


}
