package org.example.service;

import org.example.dao.user.UserDao;
import org.example.dto.UserDto;
import org.example.entity.User;
import org.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserDao userDao;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserDao userDao, UserMapper userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

    public List<UserDto> getUsers(String lastNameStartsWith) {
        return userDao.readAll().stream()
                .filter(u -> lastNameStartsWith.isBlank() || u.getLastName().startsWith(lastNameStartsWith))
                .map(userMapper::toUserDto)
                .toList();
    }

    public UserDto getUser(long id) {
        return userMapper.toUserDto(userDao.read(id));
    }
    public UserDto updateUser(long id, UserDto userDto) {
        return userMapper.toUserDto(userDao.update(userMapper.toUser(userDto), id));
    }

    public UserDto createUser(UserDto candidate) {
        if (candidate.id() != null) throw new IllegalStateException("Пользователь не создан, т.к. id не равен null");
        Optional<User> user = userDao.findByCredentials(candidate.firstName(), candidate.lastName(), candidate.email());
        if (user.isPresent())
            throw new IllegalStateException("Пользователь с указанными фамилией, именем и email уже существует");
        return userMapper.toUserDto(userDao.create(userMapper.toUser(candidate)));
    }

    public void deleteUser(long id) {
        userDao.delete(id);
    }
}
