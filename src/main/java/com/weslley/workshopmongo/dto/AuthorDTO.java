package com.weslley.workshopmongo.dto;

import com.weslley.workshopmongo.domain.User;

import java.io.Serializable;

/**
 * Projetar dados do autor com DTO, armazenar apenas id e name, evitando salvar todos os dados
 */
public class AuthorDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String name;

    /**
     * Construtor para receber o usuario como argumento
     * @param obj
     */
    public AuthorDTO(User obj) {
        // Instanciar um AuthorDTO a partir de um User
        this.id = obj.getId();
        this.name = obj.getName();
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
