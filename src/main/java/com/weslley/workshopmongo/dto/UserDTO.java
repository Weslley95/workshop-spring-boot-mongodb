package com.weslley.workshopmongo.dto;

import com.weslley.workshopmongo.domain.User;

import java.io.Serializable;

/**
 * Data transfer object, carregar dados das entidades de forma simples
 */
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;

    /**
     * Contrutor para instanciar a partir do objeto
     */
    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    /**
     * Contrutor para instanciar a partir do objeto
     */
    public UserDTO() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
