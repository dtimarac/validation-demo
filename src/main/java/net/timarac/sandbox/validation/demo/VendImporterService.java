package net.timarac.sandbox.validation.demo;

import net.timarac.sandbox.validation.demo.input.CloudVend;
import net.timarac.sandbox.validation.demo.invalid.VendAlreadyExistsException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
public class VendImporterService {

    public VendQueue createVendQueue(@Valid CloudVend cloudVend) {
        //syntactic validation done - here the cloudVend object is syntactically 100% valid!
        System.out.println(cloudVend);

        //here we can do some semantic validation if required...
        doSomeSemanticValidation(cloudVend);

        //syntactic and semantic validation done - here the cloudVend objec it 100% valid!
        return new VendQueue(cloudVend.getMyParamStr(), cloudVend.getMyParamInt(), cloudVend.getMyParamLong());
    }

    private void doSomeSemanticValidation(CloudVend cloudVend) {
        if (cloudVend.getMyParamInt() == 20) {
            throw new VendAlreadyExistsException("Vend with param 20 already exists");
        }
    }
}
