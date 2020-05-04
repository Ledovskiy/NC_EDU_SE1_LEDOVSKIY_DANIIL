package fapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerDto {
    @ApiModelProperty(hidden = true)
    private Long id;

    private String login;
    private String password;
    private String email;

    private String roleName;
    private String status;
}
