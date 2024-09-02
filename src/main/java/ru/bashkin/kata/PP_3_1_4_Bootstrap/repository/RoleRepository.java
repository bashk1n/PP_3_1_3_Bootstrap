package ru.bashkin.kata.PP_3_1_4_Bootstrap.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bashkin.kata.PP_3_1_4_Bootstrap.entity.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
