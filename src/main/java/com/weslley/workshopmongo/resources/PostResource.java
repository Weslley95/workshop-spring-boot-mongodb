package com.weslley.workshopmongo.resources;

import com.weslley.workshopmongo.domain.Post;
import com.weslley.workshopmongo.resources.util.URL;
import com.weslley.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
     * Retornar buscar por post
     * End point
     *
     * ResponseEntity -> Retornar objeto sofisticado, encapsular e retornar respostas HTTP, com cabecalhos, erros, etc
     *
     * @return list
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

    /**
     * Retornar buscar por post
     * End point
     *
     * ResponseEntity -> Retornar objeto sofisticado, encapsular e retornar respostas HTTP, com cabecalhos, erros, etc
     *
     * @return list
     */
    @RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value="text", defaultValue="") String text,
            @RequestParam(value="minDate", defaultValue="") String minDate,
            @RequestParam(value="maxDate", defaultValue="") String maxDate
            ) {

        // Pegar o parametro e decodificar
        text = URL.decodeParam(text);

        // Trata data minima e maxima
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());

        List<Post> list = this.service.fullSearch(text, min, max);

        // .ok() -> instanciar responseEntity
        // .body() -> corpo da mensagem
        return ResponseEntity.ok().body(list);
    }
}
