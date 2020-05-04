package backend.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ServicesDto {
    @ApiModelProperty(hidden = true)
    private Long id;

    private String serviceName;

    private String information;

    private Integer price;
}
