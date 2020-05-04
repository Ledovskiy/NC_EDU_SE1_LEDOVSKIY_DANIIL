package backend.mapper;

import backend.dto.ServicesDto;
import backend.entity.Services;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ServicesMapper {

    private final ModelMapper mapper;

    @Autowired
    public ServicesMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Services toEntity(ServicesDto servicesDto) {
        return Objects.isNull(servicesDto) ? null : mapper.map(servicesDto, Services.class);
    }

    public ServicesDto toDto(Services entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, ServicesDto.class);
    }
}

