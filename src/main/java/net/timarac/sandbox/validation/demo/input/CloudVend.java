package net.timarac.sandbox.validation.demo.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter @ToString
@AllArgsConstructor
public class CloudVend {

    private String myParamStr;

    @NotNull
    @Min(17) @Max(999)
    private Integer myParamInt;

    @NotNull
    @PositiveOrZero
    private Long myParamLong;
}
