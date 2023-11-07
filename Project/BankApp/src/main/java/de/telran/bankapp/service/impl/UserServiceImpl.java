package de.telran.bankapp.service.impl;

import de.telran.bankapp.entity.auth.Role;
import de.telran.bankapp.entity.auth.User;
import de.telran.bankapp.entity.enums.RoleType;
import de.telran.bankapp.repository.auth.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found!");
        }
        return user;
    }

    public User saveUser(User user) {
        User foundUser = userRepository.findByLogin(user.getUsername());
        if (foundUser != null) {
            return null;
        }
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(3L, "ROLE_CLIENT"));
        user.setRoles(roles);
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
