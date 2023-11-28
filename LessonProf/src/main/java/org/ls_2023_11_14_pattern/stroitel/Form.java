package org.ls_2023_11_14_pattern.stroitel;

import java.time.LocalDate;

public class Form {
    //1 Создайте класс Форма регистрации с 10 полями. Пользователь заполняет в форме только те поля, которые хочет.
    // 2 Реализуйте паттерн Строитель с помощью внутреннего класса, позволяющий создавать объект формы.
    // https://refactoring.guru/ru/design-patterns/builder

    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String email;

    public Form(String firstName, String lastName, String login, String password, LocalDate dateOfBirth, Gender gender, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
    }

    public class Builder {
        private String firstname;
        private String lastName;
        private String login;
        private String password;
        private LocalDate dateOfBirth;
        private Gender gender;
        private String email;

        public Builder firstName(String firstname) {
            this.firstname = firstname;
            return this;
        }
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder login(String login) {
            this.login = login;
            return this;
        }
        public Builder password(String password) {
            this.password = password;
            return this;
        }
        public Builder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }
        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }
        public Builder email(String email) {
            this.email = email;
            return this;
        }

//        public Form build() {
//            return new(firstname, lastName, login, password, dateOfBirth, gender, email);
//        }



    }


}
