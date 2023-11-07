package de.telran.bankapp.dto;

import de.telran.bankapp.entity.enums.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ClientDto {

    private Long id;
    private String managerId;
    private Status status;
    private String taxCode;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
//    private List<Account> accounts;
}
