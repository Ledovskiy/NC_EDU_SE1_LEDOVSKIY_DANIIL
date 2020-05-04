package backend.mapper;

import backend.dto.RoleDto;
import backend.entity.Role;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class RoleMapper {

    private final ModelMapper mapper;

    @Autowired
    public RoleMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Role toEntity(RoleDto roleDto) {
        return Objects.isNull(roleDto) ? null : mapper.map(roleDto, Role.class);
    }

    public RoleDto toDto(Role entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, RoleDto.class);
    }
}

