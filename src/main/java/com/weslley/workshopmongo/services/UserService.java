package com.weslley.workshopmongo.services;

import com.weslley.workshopmongo.domain.User;
import com.weslley.workshopmongo.dto.UserDTO;
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

    /**
     * Inserir user no BD
     * @param obj
     * @return obj
     */
    public User insert(User obj) {
        return this.repo.insert(obj);
    }

    /**
     * Delete user
     * @param id
     */
    public void delete(String id) {
        // Realizar busca do id, caso nao encontrar lanca excecao
        findById(id);
        this.repo.deleteById(id);
    }

    /**
     * Update user
     * @param obj
     * @return newObj
     */
    public User update(User obj) {
        // Instanciar obj usuario e recuperar no BD o usuario passado por id
        User newObj = findById(obj.getId());

        // Metodo para copiar os dados do obj para o newObj
        updateData(newObj, obj);

        return this.repo.save(newObj);
    }

    /**
     * Passar dados do obj para newObj, metodo auxiliar para atualizar dados
     *
     * @param newObj
     * @param obj
     */
    private void updateData(User newObj, User obj) {
        // Passar dados do obj para newObj
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    /**
     * Metodo que ira pegar um DTO e instaciar um usuario
     *
     * OBS: Adquado seria gerar o metodo na class UserDTO, porem, para instanciar um usuario
     * necessita acessar o BD, e esta classe UserService ja tem a dependencia para o BD
     *
     * @param objDto
     * @return new User()
     */
    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
