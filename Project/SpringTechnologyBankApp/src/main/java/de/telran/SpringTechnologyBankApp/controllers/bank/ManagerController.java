package de.telran.SpringTechnologyBankApp.controllers.bank;

import de.telran.SpringTechnologyBankApp.dtos.bank.manager.ManagerDto;
import de.telran.SpringTechnologyBankApp.services.bank.interf.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/managers")
@RequiredArgsConstructor
public class ManagerController {
    private final ManagerService managerService;

    @PostMapping("/add")
    public ResponseEntity<ManagerDto> createManager(@RequestBody ManagerDto managerDto) {
        ManagerDto createdManager = managerService.createManager(managerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdManager);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getManagerById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(managerService.getManagerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManagerDto> updateManagerById(
            @PathVariable("id") Long id, @RequestBody ManagerDto managerDto) {
        ManagerDto updatedManager = managerService.updateManagerById(id, managerDto);
        return ResponseEntity.ok(updatedManager);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ManagerDto> updateManagerByIdPatch(
            @PathVariable("id") Long id, @RequestBody ManagerDto managerDto) {
        return updateManagerById(id, managerDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteManagerById(@PathVariable("id") Long id) {
        managerService.deleteManagerById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", String.format("Менеджер с id %d успешно удален", id));
        return ResponseEntity.ok(response);
    }
}
