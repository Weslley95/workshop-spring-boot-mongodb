package com.weslley.workshopmongo.repository;

import com.weslley.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    // Estrutura para o spting data montar a consulta no DB
    List<Post> findByTitleContainingIgnoreCase(String text);
}
