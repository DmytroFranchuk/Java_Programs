package org.example.service;

import org.example.dto.auth.UserRegistrationFormData;
import org.example.dto.order.OrderResponseDto;
import org.example.dto.user.ExtendedUserResponseDto;
import org.example.dto.user.UserCreateRequestDto;
import org.example.dto.user.UserResponseDto;
import org.example.entity.user.User;
import org.example.mapper.GoodsMapper;
import org.example.mapper.OrderMapper;
import org.example.mapper.UserMapper;
import org.example.repository.UserRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final OrderMapper orderMapper;
    private final GoodsMapper goodsMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, OrderMapper orderMapper, GoodsMapper goodsMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.orderMapper = orderMapper;
        this.goodsMapper = goodsMapper;
    }

    public List<UserResponseDto> getUsers(String lastNameStartsWith) {
        return (lastNameStartsWith == null || lastNameStartsWith.isBlank() ?
                userRepository.findAll() :
                userRepository.findByLastNameStartsWith(lastNameStartsWith)
        ).stream().map(userMapper::toUserResponseDto).toList();
    }

    public UserResponseDto getUser(long id) {
        return userMapper.toUserResponseDto(userRepository.getReferenceById(id));
    }

    @Transactional
    public ExtendedUserResponseDto getExtendedUser(long id) {
        User user = userRepository.getReferenceById(id);
        Hibernate.initialize(user.getOrders()); // помогает дозагрузить то, что проинициализировано лениво
        List<OrderResponseDto> orders = user.getOrders().stream()
                .map(o -> orderMapper.toOrderGetResponseDto(o, goodsMapper.toGoodsItemDtoList(o.getItems())))
                .toList();
        return userMapper.toExtendedUserResponseDto(user, orders);
    }

    @Transactional
    public UserResponseDto updateUser(long id, UserCreateRequestDto userResponseDto) {
        User updated = userMapper.toUser(userResponseDto);
        updated.setId(id);
        return userMapper.toUserResponseDto(userRepository.save(updated));
    }

    @Transactional
    public UserResponseDto createUser(UserCreateRequestDto candidate) {
        List<User> users = userRepository.findAllByLastNameAndFirstNameAndEmail(
                candidate.lastName(),
                candidate.firstName(),
                candidate.email()
        );
        if (!users.isEmpty())
            throw new IllegalStateException("Пользователь с указанными фамилией, именем и email уже существует");
        return userMapper.toUserResponseDto(userRepository.save(userMapper.toUser(candidate)));
    }

    @Transactional
    public UserResponseDto createUser(UserRegistrationFormData candidate) {
        return userMapper.toUserResponseDto(userRepository.save(userMapper.toUser(candidate)));
    }

    @Transactional
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
