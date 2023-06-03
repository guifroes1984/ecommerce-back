package br.com.guifroes1984.jwt.dao;

import br.com.guifroes1984.jwt.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends CrudRepository<Role, String> {

}