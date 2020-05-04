package backend.mapper;

import backend.dto.SubscriptionsDto;
import backend.entity.Subscriptions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SubscriptionsMapper {

    private final ModelMapper mapper;

    @Autowired
    public SubscriptionsMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Subscriptions toEntity(SubscriptionsDto subscriptionsDto) {
        return Objects.isNull(subscriptionsDto) ? null : mapper.map(subscriptionsDto,Subscriptions.class);
    }

    public SubscriptionsDto toDto(Subscriptions entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity,SubscriptionsDto.class);
    }
}

