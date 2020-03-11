package com.wpp.param;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author wangpp
 */
@Getter
@Setter
public class TestVo {
    @NotBlank
    private String msg;

    @NotNull
    @Max( value = 100, message = "最大为100" )
    @Min( value = 0, message = "最小为0" )
    private Integer id;

    @NotEmpty
    private List<String> str;
}
