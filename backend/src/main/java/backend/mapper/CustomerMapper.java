package backend.mapper;

import backend.dto.CustomerDto;
import backend.dto.RoleDto;
import backend.entity.Customer;
import backend.entity.Role;
import backend.entity.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class CustomerMapper {

    private final ModelMapper mapper;

    @Autowired
    public CustomerMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Customer toEntity(CustomerDto customerDto) {

        if (Objects.isNull(customerDto)){
            return null;
        }
        Customer customer = mapper.map(customerDto, Customer.class);
        Role role = new Role();
        role.setRoleName(customerDto.getRoleName());
        Status status = new Status();
        status.setStatus(customerDto.getStatus());
        customer.setRole(role);
        customer.setStatus(status);
        return customer;
    }

    public CustomerDto toDto(Customer entity) {
        if (Objects.isNull(entity)){
            return null;
        }
        return mapper.map(entity, CustomerDto.class);
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Role.class, RoleDto.class)
                .addMappings(m -> m.map(Role::getRoleName, RoleDto::setRole));

        mapper.createTypeMap(RoleDto.class, Role.class)
                .addMappings(m -> m.map(RoleDto::getRole, Role::setRoleName));
    }

}

