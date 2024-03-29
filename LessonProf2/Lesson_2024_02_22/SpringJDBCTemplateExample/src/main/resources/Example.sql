-- Database: postgres

CREATE TABLE users(
                      id BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
                      first_name VARCHAR(100) NOT NULL CHECK (first_name <> ''),
                      last_name VARCHAR(100) NOT NULL CHECK (last_name <> ''),
                      birth_date DATE,
                      email VARCHAR(50)
);

INSERT INTO users (first_name, last_name, birth_date, email) values ('Joel', 'Edgerton', '1974-06-23', NULL);
INSERT INTO users (first_name, last_name, birth_date, email) values ('Tom', 'Hardy', '1979-09-15', 'joelEd@gmail.com');
INSERT INTO users (first_name, last_name, birth_date, email) values ('Nicholas', 'Nolte', '1941-02-08', NULL);


-- CREATE TABLE client_app_statistics(
--                                       id BIGINT NOT NULL,
--                                       client_app_name VARCHAR(100) NOT NULL CHECK (client_app_name <> ''),
--                                       client_app_count INT NOT NULL
-- );
--
-- INSERT INTO client_app_statistics (client_app_name, client_app_count) values ('Chrome browser', 10);
-- UPDATE client_app_statistics SET client_app_count = client_app_count + 1 WHERE client_app_name = 'Chrome browser';