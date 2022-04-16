package com.weslley.workshopmongo.config;

import com.weslley.workshopmongo.domain.User;
import com.weslley.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Configurable
@Component
public class Instantiation implements CommandLineRunner {

    // Injecao UserRepository
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        // Deletar dados no mongoDB
        userRepository.deleteAll();

        var maria = new User(null, "Maria Brown", "maria@gmail.com");
        var alex = new User(null, "Alex Green", "alex@gmail.com");
        var bob = new User(null, "Bob Grey", "bob@gmail.com");

        // Salvar objetos na colecao de usuarios
        userRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
}
