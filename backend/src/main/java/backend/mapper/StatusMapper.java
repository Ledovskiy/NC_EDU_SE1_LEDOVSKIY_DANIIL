package backend.mapper;

import backend.dto.StatusDto;
import backend.entity.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StatusMapper {

    private final ModelMapper mapper;

    @Autowired
    public StatusMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Status toEntity(StatusDto statusDto) {
        return Objects.isNull(statusDto) ? null : mapper.map(statusDto,Status.class);
    }

    public StatusDto toDto(Status entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity,StatusDto.class);
    }
}

