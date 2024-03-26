package org.example.entity.user.credentials;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.entity.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@AllArgsConstructor
@Getter
public class UserWithCredentials implements UserDetails {

    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // метод для авторизации
        return null;
    }

    @Override
    public String getPassword() {
        return user.getCredentials().getPassword();
    }

    @Override
    public String getUsername() {
        return user.getCredentials().getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // заглушка
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // заглушка
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // заглушка
    }

    @Override
    public boolean isEnabled() {
        return true; // заглушка
    }
}
