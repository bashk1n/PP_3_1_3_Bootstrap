package ru.bashkin.kata.PP_3_1_4_Bootstrap.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bashkin.kata.PP_3_1_4_Bootstrap.entity.User;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);
}
