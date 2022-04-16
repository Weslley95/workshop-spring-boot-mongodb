package com.weslley.workshopmongo.services;

import com.weslley.workshopmongo.domain.User;
import com.weslley.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return repo.findAll();
    }
}
