package net.timarac.sandbox.validation.demo.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import net.timarac.sandbox.validation.demo.validation.NotDuplicateVend;

import javax.validation.constraints.*;

@Getter @ToString
@AllArgsConstructor
public class CloudVend {

    private String myParamStr;

    @NotNull
    @Min(17) @Max(999)
    private Integer myParamInt;

    @NotNull
    @NotDuplicateVend
    private Long myParamLong;

    @AssertTrue (message = "Param long is zero, this is not okay my friend")
    public boolean isParamLongNonZero() {
        return myParamLong != 0;
    }
}
