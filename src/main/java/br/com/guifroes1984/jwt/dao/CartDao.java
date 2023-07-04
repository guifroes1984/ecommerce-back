package br.com.guifroes1984.jwt.dao;

import br.com.guifroes1984.jwt.entity.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDao extends CrudRepository<Cart, Integer> {
}
