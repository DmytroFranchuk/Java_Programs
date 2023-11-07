package de.telran.bankapp.controller;

import de.telran.bankapp.dto.ManagerDto;
import de.telran.bankapp.dto.ManagerInfoDto;
import de.telran.bankapp.dto.ManagerWithClientsDto;
import de.telran.bankapp.entity.bank.Manager;
import de.telran.bankapp.service.ClientService;
import de.telran.bankapp.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/managers")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;
    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ManagerDto>> getAll() {
        List<ManagerDto> managers = managerService.getAll();
        return new ResponseEntity<>(managers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manager> getById(@PathVariable("id") Long id) {
        Manager manager = managerService.getById(id);
        if (manager == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(manager);
    }

    @GetMapping("/clients")
    public ResponseEntity<List<ManagerWithClientsDto>> getManagersWithClients() {
        List<ManagerWithClientsDto> managerWithClients = clientService.getManagersWithClients();
        return new ResponseEntity<>(managerWithClients, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Manager> create(@RequestBody Manager manager) {
        Manager addNew = managerService.createManager(manager);
        return new ResponseEntity<>(addNew, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manager> updateById(@PathVariable("id") Long id, @RequestBody Manager updatedManager) {
        Manager updated = managerService.updateById(id, updatedManager);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        boolean deleted = managerService.deleteById(id);
        if (deleted) {
            String message = "Removing id: " + id + " was successful";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } else {
            String errorMessage = "Uninstallation could not be completed";
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errorMessage);
        }
    }

    @GetMapping("/{id}/clients")
    public ResponseEntity<List<ManagerInfoDto>> getClientsByManagerId(@PathVariable Long id) {
        List<ManagerInfoDto> clients = managerService.getClientsByManagerId(id);
        return ResponseEntity.ok(clients);
    }
}
