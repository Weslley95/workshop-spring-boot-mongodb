package com.weslley.workshopmongo.config;

import com.weslley.workshopmongo.domain.Post;
import com.weslley.workshopmongo.domain.User;
import com.weslley.workshopmongo.dto.AuthorDTO;
import com.weslley.workshopmongo.repository.PostRepository;
import com.weslley.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

@Configurable
@Component
public class Instantiation implements CommandLineRunner {

    // Injecao de repository
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        // Instanciar data
        var sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Timezone GMT
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        // Deletar dados no mongoDB
        userRepository.deleteAll();
        postRepository.deleteAll();

        // Gerar carga inicial de usuarios no BD
        var maria = new User(null, "Maria Brown", "maria@gmail.com");
        var alex = new User(null, "Alex Green", "alex@gmail.com");
        var bob = new User(null, "Bob Grey", "bob@gmail.com");

        // Salvar objetos na colecao de usuarios (salvar usuarios para ter ids proprios gerador pelo BD
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        // Gerar carga inicial de posts
        var post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        var post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        // Salvar post fazendo copia do usuario para o post (aninhado)
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
