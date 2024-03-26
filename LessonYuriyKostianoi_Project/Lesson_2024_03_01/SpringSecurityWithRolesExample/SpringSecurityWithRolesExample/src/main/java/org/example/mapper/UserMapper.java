package org.example.mapper;

import org.example.dto.auth.UserRegistrationFormData;
import org.example.dto.order.OrderResponseDto;
import org.example.dto.user.ExtendedUserResponseDto;
import org.example.dto.user.UserCreateRequestDto;
import org.example.dto.user.UserFormData;
import org.example.dto.user.UserResponseDto;
import org.example.dto.user.registration.RegistrationDto;
import org.example.dto.user.settings.SettingsDto;
import org.example.entity.user.User;
import org.example.entity.user.credentials.Credentials;
import org.example.entity.user.registration.ConfirmationMethod;
import org.example.entity.user.registration.Registration;
import org.example.entity.user.settings.Settings;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

@Component
public class UserMapper {
    public User toUser(UserCreateRequestDto userResponseDto) {
        return User.builder()
                .firstName(userResponseDto.firstName())
                .lastName(userResponseDto.lastName())
                .birthDate(userResponseDto.birthDate())
                .email(userResponseDto.email())
                .build();
    }

    public UserResponseDto toUserResponseDto(User user) {
        return new UserResponseDto(user.getId(), user.getFirstName(), user.getLastName(), user.getBirthDate(), user.getEmail());
    }

    public UserCreateRequestDto toUserCreateRequestDto(UserFormData userForm) {
        return new UserCreateRequestDto(
                userForm.getFirstName(),
                userForm.getLastName(),
                userForm.getBirthDate(),
                userForm.getEmail()
        );
    }

    public ExtendedUserResponseDto toExtendedUserResponseDto(User user, List<OrderResponseDto> orders) {
        return new ExtendedUserResponseDto(
                toUserResponseDto(user),
                toRegistrationDto(user.getRegistration()),
                toSettingsDto(user.getSettings()),
                orders
        );
    }

    public RegistrationDto toRegistrationDto(Registration registration) {
        return registration == null ? null : new RegistrationDto(
                registration.getUserId(),
                registration.getRegistrationDate(),
                registration.getConfirmationMethod()
        );
    }

    public SettingsDto toSettingsDto(Settings settings) {
        return settings == null ? null : new SettingsDto(settings.isDarkTheme(), settings.isSaveHistory(), settings.getNickname());
    }

    public User toUser(UserRegistrationFormData userForm) {
        String email = userForm.getEmail();
        String login = email.substring(0, email.indexOf("@"));
        User user = User.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .birthDate(userForm.getBirthDate())
                .email(userForm.getEmail())
                .credentials(new Credentials(login, userForm.getPassword()))
                .orders(new HashSet<>())
                .build();
        user.setRegistration(new Registration(null, LocalDate.now(), ConfirmationMethod.EMAIL, user));
        return user;
    }
}
