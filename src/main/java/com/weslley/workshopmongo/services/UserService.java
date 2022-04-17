package com.weslley.workshopmongo.services;

import com.weslley.workshopmongo.domain.User;
import com.weslley.workshopmongo.repository.UserRepository;
import com.weslley.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Classe service conversa com repository
 */
@Service
public class UserService {

    // Instanciar objeto automaticamente - injecao de dependencia do spring
    @Autowired
    private UserRepository repo;

    /**
     * Retornar todos os usuarios
     * @return repo.findAll();
     */
    public List<User> findAll() {
        return this.repo.findAll();
    }

    /**
     * Retornar usuario por id
     * @param id
     * @return
     */
    public User findById(String id) {
        // findOne() -> retornar id
        Optional<User> obj = this.repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
