package de.telran.bankapp.mapper;

import de.telran.bankapp.dto.ManagerDto;
import de.telran.bankapp.entity.bank.Manager;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManagerMapper {

//    @Mapping(source = "products", target = "products")
//    @Mapping(source = "clients", target = "clients")
    ManagerDto fromManagerToManagerDto(Manager manager);

    Manager fromManagerDtoToManager(ManagerDto managerDto);

//    ManagerInfoDto managerInfoToDto(Manager manager);

//    List<ManagerDetailsDto> managersToManagerDetailsDtos(List<Manager> managers);

}
