package net.timarac.sandbox.validation.demo.input;

import net.timarac.sandbox.validation.demo.VendImporterService;
import net.timarac.sandbox.validation.demo.invalid.VendAlreadyExistsException;
import net.timarac.sandbox.validation.demo.invalid.VendInvalid;
import net.timarac.sandbox.validation.demo.invalid.VendInvalidHandler;
import net.timarac.sandbox.validation.demo.VendQueue;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;

@RestController
@RequestMapping("/abc")
public class MyController {

    private final VendImporterService vendImporterService;
    private final VendInvalidHandler vendInvalidHandler;

    public MyController(VendImporterService vendImporterService, VendInvalidHandler vendInvalidHandler) {
        this.vendImporterService = vendImporterService;
        this.vendInvalidHandler = vendInvalidHandler;
    }

    @GetMapping
    public VendQueue processRequest(CloudDbResultset cloudDbResultset) {

        CloudVend cloudVend = createVendCommand(cloudDbResultset);
        try {
            VendQueue vendQueue = vendImporterService.createVendQueue(cloudVend);
            return vendQueue;
        } catch (ConstraintViolationException e) {
            VendInvalid vendInvalid = vendInvalidHandler.createVendInvalid(cloudVend, e);
            System.out.println("Vend validation error. vendInvalid.errorMessage: " + vendInvalid.getErrorMessage());
            throw e;
        } catch (VendAlreadyExistsException e) {
            VendInvalid vendInvalid = vendInvalidHandler.createVendInvalid(cloudVend, e.getMessage());
            System.out.println("Vend already exists. vendInvalid.errorMessage: " + vendInvalid.getErrorMessage());
            throw e;
        }
    }

    private CloudVend createVendCommand(CloudDbResultset cloudDbResultset) {
        return new CloudVend(
                cloudDbResultset.getParamStr(),
                cloudDbResultset.getParamInt() != null ? NumberUtils.parseNumber(cloudDbResultset.getParamInt(), Integer.class) : null,
                cloudDbResultset.getParamLong() != null ? NumberUtils.parseNumber(cloudDbResultset.getParamLong(), Long.class) : null
        );
    }
}
