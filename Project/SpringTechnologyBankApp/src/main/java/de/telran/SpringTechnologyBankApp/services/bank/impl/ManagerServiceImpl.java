package de.telran.SpringTechnologyBankApp.services.bank.impl;

import de.telran.SpringTechnologyBankApp.dtos.bank.manager.ManagerDto;
import de.telran.SpringTechnologyBankApp.entities.bank.Client;
import de.telran.SpringTechnologyBankApp.entities.bank.Manager;
import de.telran.SpringTechnologyBankApp.entities.bank.Product;
import de.telran.SpringTechnologyBankApp.entities.enums.RoleType;
import de.telran.SpringTechnologyBankApp.entities.enums.StatusType;
import de.telran.SpringTechnologyBankApp.exceptions.*;
import de.telran.SpringTechnologyBankApp.mappers.bank.ManagerMapper;
import de.telran.SpringTechnologyBankApp.repositories.bank.ClientRepository;
import de.telran.SpringTechnologyBankApp.repositories.bank.ManagerRepository;
import de.telran.SpringTechnologyBankApp.repositories.bank.ProductRepository;
import de.telran.SpringTechnologyBankApp.services.bank.interf.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;
    private final ProductRepository productRepository;
    private final ClientRepository clientRepository;
    private final ManagerMapper managerMapper;


    @Override
    public ManagerDto createManager(ManagerDto managerDto) {
//        Manager manager = managerMapper.managerDtoToManager(managerDto);
        return Optional.of(managerDto)
                .map(managerMapper::managerDtoToManager)
                .map(managerRepository::save)
                .map(managerMapper::managerToManagerDto)
                .orElseThrow(() -> new NotCreationEntityException("Не удалось создать менеджера"));
    }

    @Override
    public ManagerDto getManagerById(Long id) {
        return managerRepository.findById(id).map(managerMapper::managerToManagerDto)
                .orElseThrow(() -> new NotFoundEntityException("Не найден менеджер с id: " + id));
    }

    @Override
    @Transactional
    public ManagerDto updateManagerById(Long id, ManagerDto manager) {
        Manager existingManager = managerRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityException("Менеджер с id: " + id + " не найден"));
        updateFieldIfNotNull(manager.getFirstName(), existingManager::setFirstName);
        updateFieldIfNotNull(manager.getLastName(), existingManager::setLastName);
        updateFieldIfNotNull(manager.getLogin(), existingManager::setLogin);
        updateFieldIfNotNull(manager.getPassword(), existingManager::setPassword);
        updateFieldIfNotNull(manager.getEmail(), existingManager::setEmail);
        updateFieldIfNotNull(manager.getDescription(), existingManager::setDescription);
        updateFieldIfNotNull(manager.getStatusType(), existingManager::setStatusType);
        try {
            Manager updatedManager = managerRepository.save(existingManager);
            return managerMapper.managerToManagerDto(updatedManager);
        } catch (Exception exception) {
            throw new NotUpdatedEntityException("Не удалось обновить менеджера с id: " + id);
        }
    }

    @Override
    public void deleteManagerById(Long id) {
        Manager managerToDelete = managerRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityException("Менеджер с id: " + id + " не найден"));
        managerToDelete.setStatusType(StatusType.REMOVED);
        managerRepository.save(managerToDelete);

        ManagerDto transitManagerDto = new ManagerDto();
        transitManagerDto.setStatusType(StatusType.INACTIVE);
        transitManagerDto.setRoleType(RoleType.ROLE_MANAGER);
        transitManagerDto.setFirstName("Transit_Manager");
        transitManagerDto.setLastName("Transit_Manager");
        Manager transitManager = managerMapper.managerDtoToManager(transitManagerDto);
        managerRepository.save(transitManager);

        List<Client> clientsToTransfer = clientRepository.findAllByManagerId(id);
        List<Product> productsToTransfer = productRepository.findAllByManagerId(id);

        clientsToTransfer.forEach(client -> client.setManager(transitManager));
        productsToTransfer.forEach(product -> product.setManager(transitManager));

        clientRepository.saveAll(clientsToTransfer);
        productRepository.saveAll(productsToTransfer);
        managerRepository.delete(managerToDelete);
    }

    @Override
    public List<ManagerDto> getAllManagersWhereStatusTypeIs(StatusType status) {
        return null;
    }

    @Override
    public List<ManagerDto> findAllManagersCreatedAfterDate(LocalDateTime createdAt) {
        return null;
    }

    private <T> void updateFieldIfNotNull(T newValue, Consumer<T> setter) {
        if (newValue != null) {
            setter.accept(newValue);
        }
    }


    

}