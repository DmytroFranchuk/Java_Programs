package testcontainers.org.example.service;

import org.example.Application;
import org.example.dto.user.UserResponseDto;
import org.example.entity.athorities.Authority;
import org.example.entity.user.User;
import org.example.entity.user.credentials.Credentials;
import org.example.entity.user.registration.ConfirmationMethod;
import org.example.entity.user.registration.Registration;
import org.example.entity.user.settings.Settings;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Application.class)
@Testcontainers
class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:latest");

//    Вместо @ServiceConnection можно использовать такую настройку
//    @DynamicPropertySource
//    static void configureProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", postgres::getJdbcUrl);
//        registry.add("spring.datasource.username", postgres::getUsername);
//        registry.add("spring.datasource.password", postgres::getPassword);
//    }

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @Test
    void shouldGetAllUser() {
        List<User> users = List.of(generateUser(1L), generateUser(2L), generateUser(3L));
        userRepository.saveAll(users);

        Set<UserResponseDto> actual = new HashSet<>(userService.getUsers(null));
        assertEquals(
                users.stream().map(User::getId).collect(Collectors.toSet()),
                actual.stream().map(UserResponseDto::id).collect(Collectors.toSet())
        );
    }

    private User generateUser(Long id) {
        User user = User.builder().id(1L)
                .firstName("Aname" + id)
                .lastName("Asurname" + id)
                .birthDate(LocalDate.now().minusYears(1))
                .email("aname" + id + "@gmil.com")
                .credentials(new Credentials("aname" + id, "1"))
                .authorities(Set.of(Authority.ROLE_READ, Authority.ROLE_WRITE))
                .settings(new Settings(true, true, "AnAme" + id))
                .build();
        user.setRegistration(new Registration(1L, LocalDate.now(), ConfirmationMethod.EMAIL, user));
        return user;
    }
}

