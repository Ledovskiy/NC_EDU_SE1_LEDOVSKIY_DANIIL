package backend.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RoleDto {
    @ApiModelProperty(hidden = true)
    private Long id;

    private String role;
}
