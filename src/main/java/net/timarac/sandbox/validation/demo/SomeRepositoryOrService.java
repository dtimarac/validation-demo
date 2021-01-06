package net.timarac.sandbox.validation.demo;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SomeRepositoryOrService {

    public Optional<Long> findById(Long value) {
        return value < 100 ?  Optional.of(value) : Optional.empty();
    }
}
