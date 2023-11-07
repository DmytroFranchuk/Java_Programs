package de.telran.bankapp.controller;

import de.telran.bankapp.dto.ClientDto;
import de.telran.bankapp.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientDto>> getAll() {
        List<ClientDto> clientDtoList = clientService.getAll();
        return new ResponseEntity<>(clientDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        ClientDto clientDto = clientService.getById(id);
        if (clientDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client is id " + id + " not find");
        }
        return ResponseEntity.ok(clientDto);
    }
}
