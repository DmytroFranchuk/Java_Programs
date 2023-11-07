package de.telran.bankapp.repository.auth;

import de.telran.bankapp.entity.auth.Role;
import de.telran.bankapp.entity.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {

//    List<User> findAll();

    User findByLogin(String login);

}
