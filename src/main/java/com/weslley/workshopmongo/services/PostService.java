package com.weslley.workshopmongo.services;

import com.weslley.workshopmongo.domain.Post;
import com.weslley.workshopmongo.repository.PostRepository;
import com.weslley.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Classe service conversa com repository
 */
@Service
public class PostService {

    // Instanciar objeto automaticamente - injecao de dependencia do spring
    @Autowired
    private PostRepository repo;

    /**
     * Retornar post por id
     * @param id
     * @return obj
     */
    public Post findById(String id) {
        // findOne() -> retornar id
        Optional<Post> obj = this.repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}