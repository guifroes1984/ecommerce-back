package br.com.guifroes1984.jwt.service;

import br.com.guifroes1984.jwt.dao.RoleDao;
import br.com.guifroes1984.jwt.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}
