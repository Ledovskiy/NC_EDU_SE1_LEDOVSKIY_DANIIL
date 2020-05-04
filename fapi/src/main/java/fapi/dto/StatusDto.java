package fapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StatusDto {
    @ApiModelProperty(hidden = true)
    private Long id;

    private String status;
}
