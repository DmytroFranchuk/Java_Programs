package org.example.mapper;

import org.example.dto.UserDto;
import org.example.entity.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toUser(UserDto userDto) {
        return new User(userDto.id(), userDto.firstName(), userDto.lastName(), userDto.birthDate(), userDto.email());
    }

    public UserDto toUserDto(User user) {
        return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getBirthDate(), user.getEmail());
    }
}
