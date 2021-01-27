package net.timarac.sandbox.validation.demo.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CloudDbResultset {

    private String paramStr;

    private String paramInt;

    private String paramLong;
}
