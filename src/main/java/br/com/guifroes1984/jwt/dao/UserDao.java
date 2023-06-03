package br.com.guifroes1984.jwt.dao;

import br.com.guifroes1984.jwt.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, String> {
}
