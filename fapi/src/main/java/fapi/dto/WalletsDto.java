package fapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class WalletsDto {
    @ApiModelProperty(hidden = true)
    private Long id;

    private Integer balance;

    private String wallet;

}
