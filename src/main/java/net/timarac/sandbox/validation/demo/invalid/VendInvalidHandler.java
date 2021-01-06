package net.timarac.sandbox.validation.demo.invalid;

import net.timarac.sandbox.validation.demo.input.CloudVend;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@Service
public class VendInvalidHandler {

    public VendInvalid createVendInvalid(CloudVend cloudVend, ConstraintViolationException e) {

        String errorMessage = e.getConstraintViolations()
                .stream()
                .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                .collect(Collectors.joining(", "));

        return createVendInvalid(cloudVend, errorMessage);
    }

    public VendInvalid createVendInvalid(CloudVend cloudVend, String errorMessage) {
        return new VendInvalid(cloudVend.getMyParamStr(), cloudVend.getMyParamInt(), cloudVend.getMyParamLong(), errorMessage);
    }
}
