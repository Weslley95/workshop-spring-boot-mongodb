package com.weslley.workshopmongo.resources;

import com.weslley.workshopmongo.domain.Post;
import com.weslley.workshopmongo.resources.util.URL;
import com.weslley.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

    // Injetar servico
    @Autowired
    private PostService service;

    /**
     * Retornar usuario por id
     * End point
     *
     * ResponseEntity -> Retornar objeto sofisticado, encapsular e retornar respostas HTTP, com cabecalhos, erros, etc
     *
     * @return obj
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {

        // Instancia metodo da classe UserService
        Post obj = this.service.findById(id);

        // .ok() -> instanciar responseEntity
        // .body() -> corpo da mensagem
        return ResponseEntity.ok().body(obj);
    }

    /**
     * Retornar usuario por id
     * End point
     *
     * ResponseEntity -> Retornar objeto sofisticado, encapsular e retornar respostas HTTP, com cabecalhos, erros, etc
     *
     * @return obj
     */
    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {

        // Pegar o parametro e decodificar
        text = URL.decodeParam(text);

        List<Post> list = this.service.findByTitle(text);

        // .ok() -> instanciar responseEntity
        // .body() -> corpo da mensagem
        return ResponseEntity.ok().body(list);
    }


}
