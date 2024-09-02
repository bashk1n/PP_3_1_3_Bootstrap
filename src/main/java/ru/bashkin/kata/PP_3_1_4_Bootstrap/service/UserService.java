package ru.bashkin.kata.PP_3_1_4_Bootstrap.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import ru.bashkin.kata.PP_3_1_4_Bootstrap.entity.Role;
import ru.bashkin.kata.PP_3_1_4_Bootstrap.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService extends UserDetailsService {
    List<User> getAll();
    void save(User user);
    User getUserById(long id);
    void delete(long id);
    Optional <User> findUserByEmail(String email);
    List<Role> getAllRoles();
}
