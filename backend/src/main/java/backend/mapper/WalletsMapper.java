package backend.mapper;

import backend.dto.WalletsDto;
import backend.entity.Wallets;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class WalletsMapper {

    private final ModelMapper mapper;

    @Autowired
    public WalletsMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Wallets toEntity(WalletsDto walletsDto) {
        return Objects.isNull(walletsDto) ? null : mapper.map(walletsDto,Wallets.class);
    }

    public WalletsDto toDto(Wallets entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity,WalletsDto.class);
    }
}

