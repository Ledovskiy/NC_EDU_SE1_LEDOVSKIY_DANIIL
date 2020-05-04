package backend.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SubscriptionsDto {
    @ApiModelProperty(hidden = true)
    private Long id;

    private Integer subscribeDays;
}
