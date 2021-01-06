package net.timarac.sandbox.validation.demo.invalid;

import lombok.Getter;
import net.timarac.sandbox.validation.demo.VendQueue;

@Getter
public class VendInvalid extends VendQueue {

    private String errorMessage;

    public VendInvalid(String paramStr, Integer paramInt, Long paramLong, String errorMessage) {
        super(paramStr, paramInt, paramLong);
        this.errorMessage = errorMessage;
    }
}
