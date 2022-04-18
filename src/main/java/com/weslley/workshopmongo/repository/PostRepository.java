package com.weslley.workshopmongo.repository;

import com.weslley.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);

    // Estrutura para o spting data montar a consulta no DB
    List<Post> findByTitleContainingIgnoreCase(String text);
}
