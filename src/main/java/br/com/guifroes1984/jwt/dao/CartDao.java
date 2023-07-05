package br.com.guifroes1984.jwt.dao;

import br.com.guifroes1984.jwt.entity.Cart;
import br.com.guifroes1984.jwt.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDao extends CrudRepository<Cart, Integer> {
    public List<Cart> findByUser(User user);
}
