package br.com.guifroes1984.jwt.service;

import br.com.guifroes1984.jwt.dao.RoleDao;
import br.com.guifroes1984.jwt.dao.UserDao;
import br.com.guifroes1984.jwt.entity.Role;
import br.com.guifroes1984.jwt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(User user) {

        Role role = roleDao.findById("User").get();

        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRole(roles);

        user.setUserPassword(getEncondePassword(user.getUserPassword()));
        return userDao.save(user);
    }

    public void initRolesAndUser() {
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Padrão role para registro recém-criado");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(getEncondePassword("admin@pass"));
        adminUser.setUserLastName("admin");
        adminUser.setUserFirstName("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        User user = new User();
        user.setUserName("raj123");
        user.setUserPassword(getEncondePassword("raj@123"));
        user.setUserFirstName("raj");
        user.setUserLastName("sharma");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
       userDao.save(user);
    }

    public String getEncondePassword(String password) {
        return  passwordEncoder.encode(password);
    }
}
